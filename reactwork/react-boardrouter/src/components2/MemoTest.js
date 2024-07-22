import React, {useState} from 'react';
import {Button} from "@mui/material";
import ShowState from "./ShowState";
/*
    useMemo : memorization : 랜더링을 최적화하기 위한 기능입니다

 */
const MemoTest = () => {
    const [number,setNumber]=useState(0);
    const [text,setText]=useState('');

    const increNumber=()=>{
        setNumber(number+1);
    }
    const decreNumber=()=>{
        setNumber(number-1);
    }
    const onChangeTextHandler=(e)=>{
        setText(e.target.value);
    }

    return (
        <div style={{fontSize:'2em',margin:'100px 100px'}}>
            <div>
                <Button variant='contained' color='success'
                        onClick={increNumber}>+</Button>

                <Button variant='contained' color='success'
                        onClick={decreNumber}>-</Button>
                <br/>
                <input type='text' placeholder='Last Name?'
                       value={text}
                       onChange={onChangeTextHandler}/>
            </div>
            <ShowState number={number} text={text}/>
        </div>
    );
};

export default MemoTest;