/*import React, {Component} from 'react';

class EventPractice extends Component{
    state = {
        name:'',
        message:''
    }
    //babel이 인스턴스의 메서드로 변환을 자동으로 수행
    //this.handleChange로 이 메서드를 사용하는 것이 가능
    handleChange = (e)=>{
        //이벤트가 발생한 객체는 e.target
        //e.target.name은 이벤트가 발생한 객체의 name
        this.setState({
            [e.target.name]:e.target.value
        })
    }

    handleClick=(e)=>{
        alert(this.state.name + ":" + this.state.message);
        this.setState({
            name:'',
            message:''
        });
    }

    handleKeyPress = (e) =>{
        if(e.key === 'Enter'){
            this.handleClick();
        }
    }

    constructor(props){
        super(props);
        this.handleChange = this.handleChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    render(){
        return(
            <>
                <h1>이벤트 연습</h1>
                <input type='text'
                name = 'message'
                placeholder = '메시지를 입력하세요'
                value={this.state.message}
                onChange = {this.handleChange}
                onKeyPress = {this.handleKeyPress}/>

                <input type='text'
                name = 'name'
                placeholder = '이름을 입력하세요'
                value={this.state.name}
                onChange = {this.handleChange}
                onKeyPress = {this.handleKeyPress}/>

                <button onClick={this.handleClick}>확인</button>
            </>
        );
    }
}*/

//함수형 컴포넌트로 변환

/*import React, {Component} from 'react';

const EventPractice = () =>{
    return (
        <>
            <input 
                type="text"
                name="name"/>
            <input
                type="text"
                name="message"/>
            <button>확인</button>
        </>
    );
}

export default EventPractice;*/


//state를 만드는 방법?
import React, {useState} from 'react';

const EventPractice = () =>{
    /*
    const [name, setName] = useState('');
    const [message, setMessage] = useState('');
    */
   
    const [form, setForm] = useState({
        username:'',
        message:''
    });

    const {username, message} = form;

    const onChange = (e) =>{
        //[e.target.name] : e.target.value
        //form을 복제해서 e.target.name에 해당하는 속성만 e.target.value로 수정
        //react에서는 state를 수정할 때 복제해서 수정함
        //하나의 항목으로 만들어진 데이터는 바로 수정하면 되지만
        //여러 항목으로 구성된 객체 나 배열은 복제해서 수정함
        //자바스크립트에서 객체 와 배열을 복제한 후 작업하는 방법에
        //대해서 알아두어야 함
        const nextForm = {
            ...form,
            [e.target.name]:e.target.value
        };
        setForm(nextForm);
    }

    //버튼 클릭 이벤트 처리 함수
    const onClick = (e) =>{
        alert(username + ":" + message);
        setForm({
            username:'',
            message:''
        })
    }

    //input에서 enter쳤을 때 처리를 위한 함수
    const onKeyPress = (e) =>{
        if(e.key === 'Enter'){
            onClick();
        }
    }

    return (
        <>
            <input 
                type="text"
                name="username"
                value={username}
                placeholder="이름을 입력하세요"
                onChange={onChange}
                onKeyPress={onKeyPress}/>
            <input
                type="text"
                name="message"
                value={message}
                placeholder="메시지를 입력하세요"
                onChange={onChange}
                onKeyPress={onKeyPress}/>
            <button onClick={onClick}>확인</button>
        </>
    );
}

export default EventPractice;