import React,{Component} from 'react';
import { BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import logo from './logo.svg';
import './App.css';
import SignIn from './SignIn';
import SignUp from './SignUp';

class App extends Component{


  constructor() {
   super();
   
  }

  render(){

    return (

      <Router>
        <div className="App">
        <Route path="/" render={()=>{ return(<SignIn/>) }}/>
        <Route path="/SignUp" render={()=>{ return(<SignUp/>) }}/>
        
        
   
        </div>

      </Router>
      
    );
  }

}



export default App;
