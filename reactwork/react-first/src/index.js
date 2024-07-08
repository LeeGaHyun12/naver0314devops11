import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {OneApp} from "./OneApp";
import Main from "./Main"; //export로 되어있는것
//import OneApp from "./OneApp"; //이게 export default로 되어있는것
//default로 export를 할 경우에는 Import시에 이름을 마음대로 정할 수 있음

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/*<App />*/}
    {/*<OneApp/>*/}
    {/*  <OneApp/>*/}
      <Main/>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
