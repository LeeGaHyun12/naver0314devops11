import React, {useState} from 'react';
import {Alert} from "@mui/material";
import {DeleteForeverOutlined} from "@mui/icons-material";

const OneApp = () => {
    const [msg,setMsg]=useState(["Happy","안녕","Bitcamp"]);

    //메세지 입력후 엔터시 이벤트
    const addMessageEvent=(e)=>{
        if(e.key==='Enter'){
            //리액트에서는 배열에 데이터 추가시 반드시 concat으로 추가해야함
            //setMsg(msg.push(e.target.value));//오류 발생
            setMsg(msg.concat(e.target.value));
            e.target.value="";
        }
    }
    //i번지의 메세지 삭제하는 함수
    const deleteMessage=(i)=>{
        //alert(i);
        //1. slice를 이용해서 i번지만 빼고 다시 배열에 담기
        // setMsg(
        //     [
        //         ...msg.slice(0,i),
        //         ...msg.slice(i+1,msg.length)
        //     ]
        // )
        //2. filter를 이용해서 i번지만 제외하고 담기
        setMsg((msg.filter((m,n)=>n!=i))); //m이 i와 같지 않은 경우에만 msg에 담아라
    }

    return (
        <div>
            <Alert>OneApp-배열에 데이터 추가, 삭제하기</Alert>
            <hr/>
            <input type='text' className='form-control'
                   style={{width:'300px'}} placeholder='메세지입력 후 엔터'
            onKeyUp={addMessageEvent}/>
            <hr/>

            <h3 style={{color:'red'}}>배열 데이터 출력</h3>
            <Alert severity='info'>총 {msg.length}개의 메세지가 있어요</Alert>
            {
                /*msg 값이 널값이 아닐 경우에만 출력*/
                msg &&
                msg.map((m,i)=>
                <h4 key={i}>{m}
                    &nbsp;&nbsp;

                    <DeleteForeverOutlined style={{cursor:'pointer'}}
                                           onClick={()=>deleteMessage(i)}/>
                </h4>)
            }
        </div>
    );
};

export default OneApp;