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
import ReducerComp1 from "../components/ReducerComp1";
import ReducerComp2 from "../components/ReducerComp2";
import MemoTest from "../components2/MemoTest";
import CallBackTest from "../components2/CallBackTest";
import MemberList from "../member/MemberList";
import LoginForm from "../member/LoginForm";
import MemberForm from "../member/MemberForm";

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

                <Route path='/reducer1' element={<ReducerComp1/>}/>
                <Route path='/reducer2' element={<ReducerComp2/>}/>

                <Route path='/memo' element={<MemoTest/>}/>

                <Route path='/callback' element={<CallBackTest/>}/>
                <Route path='/login' element={<LoginForm/>}/>
                <Route path='/member'>
                    <Route path='list' element={<MemberList/>}/>
                    <Route path='form' element={<MemberForm/>}/>
                </Route>
            </Routes>
        </div>
    );
};

export default RouterMain;