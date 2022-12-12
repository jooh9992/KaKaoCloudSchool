import CounterContainer from "./containers/CounterContainer";
import ToDosContainer from "./containers/ToDosContainer"

function App(){
  return(
    <div>
      <CounterContainer number={0}/>
      <hr/>
      <ToDosContainer/>
    </div>
  )
}

export default App;
