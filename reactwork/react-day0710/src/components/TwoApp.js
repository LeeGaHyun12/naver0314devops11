import React, {useState} from 'react';
import {Alert, Button} from "@mui/material";
import {DeleteForeverOutlined} from "@mui/icons-material";
import {elGR} from "@mui/material/locale";

const TwoApp = () => {
    const [names,setNames]=useState(["이가현","박민지","박주용"]);
    const [irum,setIrum]=useState('');

    //추가 이벤트
    const addNameEvent=(e)=>{
        if(irum.length===0){
            alert("추가할 이름을 입력해주세요");
            return;
        }

        //입력한 이름을 배열변수 names에 추가
        setNames(names.concat(irum));
        setIrum('');
    }
    //삭제하는 함수
    const deleteNames=(idx)=>{
        let a=window.confirm(`${idx+1}`+"번쨰 이름을 삭제하시겠습니까?");

        if(a) {
            setNames((names.filter((n, i) => i != idx))); //i가 넘어온 idx와 같이 앉은것만 필터링해서 names에 다시 담아라
        }
    }

    return (
        <div>
            <Alert>TwoApp-배열추가,삭제 문제</Alert>
            <div className='input-group' style={{width:'300px'}}>
                <h5>이름:</h5>
                <input type='text' className='form-control'
                       style={{width: '13ㅇ0px'}} value={irum}
                onChange={(e)=>setIrum(e.target.value)}/>
                <Button variant='contained' color='success'
                onClick={addNameEvent}>추가</Button>
                <hr/>

                {
                    /*msg 값이 널값이 아닐 경우에만 출력*/
                    names &&
                    names.map((myname, idx) =>
                        <h4 key={idx}>{myname}
                            &nbsp;&nbsp;
                            <Button variant='outlined' color='info' style={{cursor: 'pointer'}}
                                                   onClick={() => deleteNames(idx)}>삭제</Button>
                        </h4>)
                }
            </div>
        </div>
    );
};

export default TwoApp;