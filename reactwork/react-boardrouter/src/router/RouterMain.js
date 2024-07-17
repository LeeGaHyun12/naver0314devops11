import React from 'react';
import Menu from "../components/Menu";
import '../components/MyStyle.css';
import {Route, Routes} from "react-router-dom";
import Home from "../components/Home";
import BoardForm from "../components/BoardForm";
import BoardList from "../components/BoardList";

const RouterMain = () => {
    return (
        <div>
            <Menu/>
            <br style={{clear:'both'}}/>
            <Routes>
                <Route path='/' element={<Home/>}/>
                <Route path='/board'>
                    <Route path='form' element={<BoardForm/>}/>
                    <Route path='list' element={<BoardList/>}/>
                    <Route path='detail/:boardnum'/>
                </Route>
            </Routes>
        </div>
    );
};

export default RouterMain;