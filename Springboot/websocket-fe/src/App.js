import './App.css';
import React, {useState, useEffect} from 'react';

function App() {
  
  const [mid, setMid] = useState('noname');
  const [msg, setMsg] = useState('');
  const [ws, setWs] = useState();

  useEffect(() => {
    if(ws !== undefined){
      ws.onmessage = function(msg){
        let data = JSON.parse(msg.data);
        let css;

        if(data.mid === mid){
            css = 'class=me';
        }else{
            css = 'class=other';
        }
        let item = `<div ${css} >
        <span><b>${data.mid}</b></span> [ ${data.date} ]<br/>
          <span>${data.msg}</span>
        </div>`;
        
        let talk = document.getElementById("talk");
        talk.innerHTML += item;
        talk.scrollTop=talk.scrollHeight;
        
    }
    }
  }, [ws, mid])
  const onMidChange = (e) => {
    setMid(e.target.value);
  }

  const onMsgChange = (e) => {
    setMsg(e.target.value);
  }

  const onClick =  () => {
    setWs(new WebSocket("ws://192.168.0.20:9999/chat"));
  }

  const onSendClick = () => {
    send();
  }

  const handleKeyPress = (e) => {
    if(e.key === 'Enter'){
      send()
    }
  }
  const send = () => {
    let data = {}
    data.mid = mid
    data.msg = msg;
    data.date = new Date().toLocaleString();
    let temp = JSON.stringify(data);
    ws.send(temp);
    setMsg('')
  }
  return (
    <div className="App">
      <div id='chat'>
      <h1>WebSocket Chatting</h1>
      <input type='text' value={mid} onChange={onMidChange}/>
      <input type='button' value='로그인' onClick={onClick}/>
      <br/>
      <div id='talk'></div>
      <div id='sendZone'>
        <textarea id='msg' value={msg} onChange={onMsgChange} onKeyUp={handleKeyPress}></textarea>
        <input type='button' value='전송' id='btnSend' onClick={onSendClick} />
      </div>
      </div>
    </div>
  );
}

export default App;
