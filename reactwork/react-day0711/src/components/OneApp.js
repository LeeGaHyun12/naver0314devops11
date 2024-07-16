import React, {useState} from 'react';
import {Alert, Button} from "@mui/material";
import OneSubApp from "./OneSubApp";

const OneApp = () => {
    const [inputArray,setInputArray]=useState([
        {
            sname:'의사누피',scolor:'orange',sprice:23000,sphoto:'의사누피.jpg'
        }
    ]);
    const [inputs,setInputs]=useState({ //묶인 변수를 주고 싶을 땐 이렇게
        sname:'',
        sphoto:'',
        sprice:0,
        scolor:'#ffccff'
    });

    //각 입력태그에서 호출할 이벤트
    const changeDataEvent=(e)=>{
        let {name,value}=e.target;
        setInputs(
            {
                ...inputs, //나머지 값들은 그대로 유지 그룹으로 묶을 때 ...inputs 형식 필요
                [name]:value //같은 name을 찾아서 value값 넣기
            }
        )
    }

    const addSangpumEvent=()=>{
        setInputArray(inputArray.concat(inputs));
    }

    const initDataEvent=()=>{
        setInputs({ //묶인 변수를 주고 싶을 땐 이렇게
            sname:'',
            sphoto:'의사누피.jpg',
            sprice:0,
            scolor:'#ffccff'
        });
    }
    //삭제 함수
    const deleteSangpum=(idx)=>{

        let a = window.confirm("삭제?");
        if(a) {
            setInputArray(inputArray.filter((d, i) =>
                i !== idx
            ));
        }
    }

    return (
        <div>
            <Alert>OneApp-모든 입력값 하나의 변수에 넣기</Alert>
            <table className='table table-bordered' style={{width:'300px'}}>
                <tbody>
                <tr>
                    <th style={{backgroundColor: '#ccf', width: '100px'}}>캐릭터명</th>
                    <td>
                        <input type='text' className='form-control'
                               value={inputs.sname} name="sname" onChange={changeDataEvent}/>
                        {/*여기 있는 name이 위 변수와 같게 해서 확인해야함*/}
                    </td>
                </tr>
                <tr>
                    <th style={{backgroundColor: '#ccf', width: '100px'}}>색상</th>
                    <td>
                        <input type='color' className='form-control'
                               value={inputs.scolor} name="scolor" onChange={changeDataEvent}/>
                    </td>
                </tr>
                <tr>
                    <th style={{backgroundColor: '#ccf', width: '100px'}}>가격</th>
                    <td>
                        <input type='text' className='form-control'
                               value={inputs.sprice} name="sprice" onChange={changeDataEvent}/>
                    </td>
                </tr>
                <tr>
                    <th style={{backgroundColor: '#ccf', width: '100px'}}>사진</th>
                    <td>
                        <select className='form-select' name="sphoto" onChange={changeDataEvent}>
                            <option value={'기타누피.jpg'}>기타누피</option>
                            <option value={'빡친루시.jpg'}>빡친루시</option>
                            <option value={'애기누피.jpg'}>애기누피</option>
                            <option value={'의사누피.jpg'}>의사누피</option>
                            <option value={'누피에몽.jpg'}>누피에몽</option>

                        </select>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} align='center'>
                        <Button variant='contained' color='success' size="small"
                        onClick={addSangpumEvent}>상품 추가</Button>
                        &nbsp;
                        <Button variant='contained' color='info' size="small"
                        onClick={initDataEvent}>입력값초기화</Button>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} align='center'>
                        <h4>
                            상품명 : {inputs.sname} <br/>
                            색 상 : {inputs.scolor} <br/>
                            가 격 : {inputs.sprice} <br/>
                            사 진 : {inputs.sphoto}
                        </h4>
                    </td>
                </tr>
                </tbody>
            </table>
            <h4>총 {inputArray.length}개의 배열 데이터가 있습니다</h4>
            <table className='table table-bordered' style={{width:'400px'}}>
                <tbody>
                {
                    inputArray.map((item,idx)=>
                    <OneSubApp key={idx} idx={idx} item={item} deleteSangpum={deleteSangpum}/>)

                }
                </tbody>

            </table>
        </div>
    );
};

export default OneApp;