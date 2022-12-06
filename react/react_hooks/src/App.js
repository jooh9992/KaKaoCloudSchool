/*import Iteration from "./Iteration";
import ErrorBoundary from './ErrorBoundary';

function App() {
  return (
    <div>
      <ErrorBoundary> //오류확인
      <Iteration/>    
      </ErrorBoundary>
    </div>
    
  );
}

export default App;*/

/*import React, {Component, useState} from "react";
import InputSample from "./InputSample";

//클래스 컴포넌트
class ClassState extends Component{
  /*
  //생성자를 만들지 않고 이렇게 state를 초기화해도 됨
  state = {
    count:0
  }*/

  /*constructor(props){
    super(props);
    this.state = {
      count:0
    }
  }
  render(){
    return(
      <div>
        <p>클릭을 {this.state.count} 번 수행</p>
        <button onClick={
          (e)=>this.setState({count: this.state.count+1})}>+1</button>
      </div>
    )
  }
}

//함수형 컴포넌트에서 state 사용
//함수형 컴포넌트는 인스턴스가 아니므로 this 사용 불가
const FunctionState = () =>{
  const [count, setCount] = useState(0);

  return(
    <div>
        <p>클릭을 {count} 번 수행</p>
        <button onClick={
          (e)=> setCount(count+1)}>+1</button>
      </div>
  )
}

function App() {
  return (
    <div>
      <ClassState/>
      <FunctionState/>
      <InputSample/>
    </div>
    
  );
}
export default App;*/

/*import React from "react";

class ClassEffect extends React.Component{
  //생성자
  constructor(props){
    super(props);
    console.log("생성자 - 가장 먼저 호출되는 메서드");
    this.state = {
      count:0
    };
  }
  //Component 가 Mount 된 후 호출되는 메서드
  componentDidMount(){
    console.log("마운트 된 후 호출되는 메서드");
    document.title = `You clicked ${this.state.count} times`;
  }

  //Component 가 Update된 후 호출되는 메서드
  componentDidUpdate(){
    console.log("업데이트 된 후 호출되는 메서드");
    document.title = `You clicked ${this.state.count} times`;
  }
  render(){
    return(
      <div>
        <p>You clicked {this.state.count} times </p>
        <button onClick={
          (e) => this.setState({count:this.state.count+1})}>+1</button>
      </div>
    )
  }
}

const App = () =>{
  return (
    <div>
      <ClassEffect/>
    </div>
  )
}

export default App;*/

/*//함수형
import React, {useState, useEffect} from "react";

const ClassEffect = () =>{
  const [count, setCount] = useState(0);
  
  useEffect(()=>{
    console.log("마운트와 업데이트가 끝나면 호출");
    document.title = `You clicked ${count} times`;
  }, [count])

  return(
    <div>
      <p>You clicked {count} times </p>
      <button onClick={
        (e) => setCount(count+1)}>+1</button>
    </div>
  )
}

const App = () =>{
  return (
    <div>
      <ClassEffect/>
    </div>
  )
}

export default App;*/

import React from "react";
import { useRef, useState, useMemo} from "react";
import CreateUser from "./CreateUser";
import UserList from "./UserList";

//active 가 true 인 데이터의 개수를 세는 함수
const countActiveUser = (users) => {
  console.log("사용자 수를 세기");
  return users.filter(user => user.active).length;
}

//username이나 email이 수정되면 App이 리랜더링됨
const App = () =>{
  const [inputs, setInputs] = useState({
    username:'',
    email:''
  });
  
  const {username, email} = inputs;

  const onChange = (e) =>{
    setInputs({
      //state를 수정할 때는 원본을 복제한 후 수정
      ...inputs,
      [e.target.name] : e.target.value
    });
  }

  //배열의 데이터를 수정하면 컴포넌트가 리랜더링 될 수 있도록
  //state로 생성
  const [users, setUsers] = useState([
      {id:1, username:'adam', email:'it@kakao.com', active:false},
      {id:2, username:'lee', email:'lee@kakao.com', active:true}
  ]);

  //users를 복제하고 가져온데이터를 추가
  //setUsers([...users, 가져온데이터])

  //변수를 생성
  const nextId = useRef(3);

  //데이터 삽입 메서드
  const onCreate = () => {
    //하나의 객체 생성
    const user = {
      id:nextId.current,
      username,
      email
    }

    //users에 user를 추가
    setUsers([...users, user]);

    //입력 요소 초기화
    setInputs({
      username:'',
      email:''
    })
    //다음 id를 위해서 id를 1증가
    nextId.current += 1;
  }

  //삭제하는 함수
  //users state에서 id가 id인 데이터 삭제
  //id가 일치하지 않는 데이터만 삭제
  //실제로는 id가 일치하지 않는 데이터만 가지고 배열을 만들어서
  //수정함
  const onRemove = id=> setUsers(users.filter(user=>user.id !== id));
  
  //수정하는 메서드
  //id에 해당하는 데이터의 active 속성의 값을 반전
  const onToggle = id => setUsers(users.map(user => user.id === id ? {...user, active:!user.active}:user))

  //활성화된 user 개수를 세는 함수 호출
  //users 에 변화가 생긴 경우만 함수를 호출하고
  //그 이외의 경우는 결과를 복사하도록 수정
  const count = useMemo(()=>countActiveUser(users), [users]);

  return (
    <div>
      <CreateUser username={username} email={email} onChange={onChange} onCreate={onCreate}/>
      <UserList users={users} onRemove={onRemove} onToggle={onToggle}/>
      <div>활성화된 유저 수: {count}</div>
    </div>
  )
}
export default App;