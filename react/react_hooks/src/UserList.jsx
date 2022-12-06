import React, {useEffect} from "react";

function User({user, onRemove, onToggle}){
    //마운트 될 때 그리고 state가 변경될 때 모두 호출
    useEffect(()=>{
        console.log('컴포넌트가 화면에 나타남');
        //삽입과 수정 시 호출
        //이 데이터의 id가 존재하면 수정이고 id가 존재하지 않으면 삽입
        console.log(user);
        //함수를 리턴하면 컴포넌트가 사라질 때 호출
        return () => {
            //데이터를 삭제한 경우 호출
            console.log("컴포넌트가 사라짐");
            console.log(user);
        }
    },[user])
    return(
        <div>
            <b onClick={(e)=>onToggle(user.id)}
            style={{
                cursor:'pointer', color:user.active?'orange':'blue'//커서를 pointer로 바꾸고 active가 true이면 orange
            }}>{user.username}</b>
            <span>({user.email})</span>
            <button onClick={(e)=> onRemove(user.id)}>삭제</button>
        </div>
    )
}

function UserList({users, onRemove, onToggle}){
    //users, onRemove, onToggle 받아서 넘겨줌
    return (
        <div>
            {users.map(user => <User user={user} key={user.id}
            onRemove={onRemove} onToggle={onToggle}/>)}
        </div>
    )
}

export default UserList;
