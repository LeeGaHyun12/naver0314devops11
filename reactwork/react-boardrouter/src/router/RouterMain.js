import React from 'react';
import Menu from "../components/Menu";
import '../components/MyStyle.css';
import {Route, Routes} from "react-router-dom";
import Home from "../components/Home";
import BoardForm from "../components/BoardForm";
import BoardList from "../components/BoardList";
import BoardDetail from "../components/BoardDetail";
import UpdateForm from "../components/UpdateForm";
import UpdatePassForm from "../components/UpdatePassForm";
import DaumPostApp from "../components/DaumPostApp";
import SweetAlertApp from "../components/SweetAlertApp";

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
                    <Route path='detail/:boardnum' element={<BoardDetail/>}/>
                    <Route path='updatepass/:boardnum' element={<UpdatePassForm/>}/>
                    <Route path='updateform/:boardnum' element={<UpdateForm/>}/>
                </Route>

                <Route path='/post' element={<DaumPostApp/>}/>
                <Route path='/sweet' element={<SweetAlertApp/>}/>
            </Routes>
        </div>
    );
};

export default RouterMain;