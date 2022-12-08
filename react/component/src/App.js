import MyComponent from './MyComponent';
import StateComponent from './StateComponent';
import EventPractice from './EventPractice';
import ValidationSample from './ValidationSample';
import ScrollBox from './ScrollBox';
import React, {Component} from 'react';

class App extends Component {
  render(){
    let a = 10; //숫자라서 b에 대입하면 복제 작업이 발생
    //bool도 마찬가지
    let b = a; //let b = 10; 와 유사하게 동작

    console.log(`a:${a}`);
    console.log(`b:${b}`);

    b = 20;
    console.log(`a:${a}`);
    console.log(`b:${b}`);

    let original = {
      num:1000
    }
    //객체나 배열은 = 로 복사를 하면 참조가 복사
    //동일한 데이터를 가리키게 됨
    //let refcopy = original;
    //하나의 객체가 내부 속성을 변경하면
    //다른 객체에게도 영향을 줌
    // console.log(original);
    // console.log(refcopy);
    // refcopy.num = 2000;
    // console.log(original);
    // console.log(refcopy);
    //얕은 복사: 가장 바깥쪽 데이터를 복제
    //Object.assign 함수 이용하는 방법
    //{...객체} - spread operator를 이용하는 방법

   // let weakcopy = {...original};
    let weakcopy = Object.assign({}, original);
    weakcopy.num = 3000;
    //console.log(original);
    //console.log(weakcopy);

    original = {
      num:1000,
      ar:["A", "B"]
    }
    //스프레드 연산자는 얕은 복사 - 가장 바깥쪽만 복제
    //weakcopy = {...original};
    //객체 안에 존재하는 객체의 속성이나 배열 내부의 데이터를 
    //변경하면 같이 변경됨
    // weakcopy.ar[0]="이런";
    // console.log(original);
    // console.log(weakcopy);

    //깊은 복사(deep copy): 재귀적으로 복제하는 것
    //데이터만 깊은 복제 - JSON은 함수가 없음
    //JSON 문자열로 변환한 후 JSON 파싱을 수행
    let deepCopy = JSON.parse(JSON.stringify(original));
    deepCopy.ar[0]="이런";
    console.log(original);
    console.log(deepCopy);
    //함수 마저도 깊은 복제를 하고자 하는 경우
    //함수를 직접 구현하거나 외부 라이브러리의 도움을 받음
    //immer 나 lodash같은 라이브러리가 이러한 역할을 수행


    return (
      <>
        <MyComponent name={3}>태그 안의 내용</MyComponent>
        <StateComponent/>
        <EventPractice/>
        <ValidationSample/>
        <ScrollBox ref={(ref)=>this.scrollbox = ref}/>
        <button onClick={(e)=>{this.scrollbox.scrollToBottom()}}>맨 아래로</button>
      </>
    );
  }
  
}

export default App;