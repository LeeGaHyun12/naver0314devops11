import React, {useEffect, useState} from 'react';
import {Button} from "@mui/material";
import food1 from '../food/1.jpg';
import photo1 from '../image/12.jpg';

const FiveApp = () => {
    const [number, setNumber] = useState(1);
    const [count, setCount] = useState(100);
    const [show,setShow]=useState(false);
    const [show2,setShow2]=useState(false);

    // useEffect(() => {
    //     console.log("1. 처음 또는 값 변경시 항상 호출");
    //
    // }); //얘는 시도때도 없이 호출이 되어서
    useEffect(() => {
        console.log("2. 처음 딱 한번만 호출");

    },[]);
    useEffect(() => {
        console.log("3.처음 그리고 number가 변경될 때만 호출");
        if(number%3===0)
            setShow(true);
        else
            setShow(false);
    },[number]);
    useEffect(() => {
        console.log("4.처음 그리고 count가 변경될 때만 호출");
        if(count%30===0)
            setShow2(true);
        else
            setShow2(false);
    },[count]);
    return (
        <div>
            <h3 className='alert alert-danger'>FiveApp</h3>
            <b style={{fontSize: '30px', color: 'red'}}>Number : {number}</b>
            &nbsp;&nbsp;&nbsp;
            <Button variant='contained' color='success'
                    onClick={() => setNumber(number - 1)}>Number감소</Button>
            &nbsp;
            <Button variant='contained' color='success'
                    onClick={() => setNumber(number + 1)}>Number증가</Button>
            <hr/>
            <b style={{fontSize: '30px', color: 'red'}}>Count : {count}</b>
            &nbsp;&nbsp;&nbsp;
            <Button variant='contained' color='info'
                    onClick={() => setCount(count - 1)}>Count감소</Button>
            &nbsp;
            <Button variant='contained' color='info'
                    onClick={() => setCount(count + 1)}>Count증가</Button>
            <hr/>
            &nbsp;
            <Button variant='contained' color='secondary'
                    onClick={() => {
                        setCount(count - 1)
                        setNumber(number - 1)
                    }}>모두감소</Button>
            &nbsp;
            <Button variant='contained' color='secondary'
                    onClick={() => {
                        setCount(count + 1)
                        setNumber(number + 1)
                    }}>모두증가</Button>
            <hr/>
            <b>number가 3의 배수일때만 보이는 이미지</b>
            {
                show &&
                <img alt="" src={food1} style={{width:'150px'}}/>
            }
            <br/>
            <b>count가 30의 배수일때만 보이는 이미지</b>
            {
                show2 &&
                <img alt="" src={photo1} style={{width:'150px'}}/>
            }
        </div>
    );
};

export default FiveApp;