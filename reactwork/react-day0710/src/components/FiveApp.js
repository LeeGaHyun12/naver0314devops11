import React from 'react';
import {Alert} from "@mui/material";
import FiveChildApp from "./FiveChildApp";
import FiveChild2App from "./FiveChild2App";
/*
* 1. 부모컴포넌트에서 자식 컴포넌트로 props를 통해서 값이나 이벤트 전달을 할 수 있다
* 2. 자식컴포넌트에서는 부모컴포넌트의 값을 props로 받아서 출력은 가능하지만 직접적으로 변경은 불가능하다
* 3. 만약 변경하려면 부모의 이벤트를 props를 통해서 호출을 해서 그 이벤트함수에서 변경을 하면 된다
*     props는 부모컴포넌트가 설정하며, 컴포넌트 자신은 해당 props를 읽기 전용으로만 사용할 수 있다
*     컴포넌트 내부에서 읽고 또 업데이트 하려면 state를 써야한다
* */

const FiveApp = () => {
    return (
        <div>
            <Alert>FiveApp-부모,자식 컴포넌트의 통신 #1</Alert>
            <h5>FiveChildApp 컴포넌트 호출</h5>
            <FiveChildApp irum={'이영자'} age={23} addr={'서울시'}/>
            <FiveChildApp irum={'강호동'} age={41} addr={'제주도'}/>
            <FiveChildApp irum={'손흥민'} age={33} addr={'부산시'}/>

            <h5>FiveChild2App 컴포넌트 호출</h5>
            <FiveChild2App irum="이미자" photo={"mycar11.png"} msg="노랑이차"/>
            <FiveChild2App irum="강미자" photo={"mycar13.png"} msg="분홍이차"/>
        </div>
    );
};

export default FiveApp;