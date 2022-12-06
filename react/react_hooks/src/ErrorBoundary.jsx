import React, {Component} from "react";

class ErrorBoundary extends Component{
    state = {
        error:false
    }

    //컴포넌트에서 예외가 발생하면 호출되는 메서드
    componentDidCatch(error, info){
        this.setState({
            error:true
        })
        console.log({error, info});
    }
    render(){
        //error 가 true이면 출력
        if(this.state.error){
            return <div>에러가 빌생했습니다.</div>
        //errors 가 false이면 하위 컴포넌트 출력
        } else{
            return this.props.children;
        }
    }
}
export default ErrorBoundary;