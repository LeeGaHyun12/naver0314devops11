import React, {useReducer, useState} from 'react';
import {Alert, Button} from "@mui/material";

/*
useReducer : state 관리가 용이하며 유지,보수가 편리하다
호출 : 이벤트서 dispatch(type,action) 로 호출시 -> reducer(state,action) 함수
reducer : state를 업데이트하는 역할
dispatch-state 업데이트를 요구
action : 요구의 내용
 */

//상수 등록
const ACTION_TYPES={
    add:'addmoney',
    sub:'submoney'
}
//첫번째 예제는 간단하게 입출금하는 예제
const reducer=(state,action)=>{
    console.log("reducer(은행) 가 일을 합니다",state,action);

    switch (action.type){
        case ACTION_TYPES.add:
            return state+Number(action.payload); //현재 머니 값의 payload로 전달된 넘버값을 state에 더해서 반환
        case ACTION_TYPES.sub:
            return state-Number(action.payload);
        default:
            return state;
    }
}
const ReducerComp1 = () => {
    const [number,setNumber]=useState(0);
    const [money,dispatch]=useReducer(reducer,0);

    return (
        <div>
            <Alert>Reducer Component #1</Alert>
            <h3>useReducer 은행에 오신 것을 환영합니다</h3>
            <h3>잔고 : <b>{money}</b></h3>
            <hr/>
            <input type='number' value={number} step={1000} onChange={(e)=>setNumber(e.target.value)}
            className='form-control' style={{width:'200px'}}/>
            <Button variant='contained' size="small" color="info"
                    onClick={()=>dispatch({'type':ACTION_TYPES.add,payload:number})}><a>입금</a></Button>
            &nbsp;&nbsp;

            <Button variant='contained' size="small" color="error"
                    onClick={()=>dispatch({'type':ACTION_TYPES.add,payload:number})}><a>출금</a></Button>
        </div>
    );
};

export default ReducerComp1;