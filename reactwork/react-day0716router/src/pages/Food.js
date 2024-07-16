import React from 'react';
import {Alert, Button} from "@mui/material";
import nofood from '../image/프로필.jpg'
import {useParams} from "react-router-dom";
const Food = () => {
    //path 의 파라미터값 읽기
    const {food1,food2}=useParams();
    console.log({food1},{food2});

    return (
        <div>
            <Alert severity='error'>Food</Alert>
            <div style={{marginTop:'20px'}}>
                {
                    food1 == null && food2 == null ?
                        <div>
                            <h3>오늘은 점심을 안 먹고 공부를 왜하죠 먹고살자고 하는 짓인데</h3>
                            <img alt='' src={nofood}/>
                        </div> :
                    food1 != null & food2 == null ?
                        <div>
                            <h2>머리가 아푸군</h2>
                            <img alt='' src={require(`../image/${food1}.jpg`)} style={{width:'200px'}}/>
                        </div> :
                        <div>
                            <h2>얘네 둘이 커플이어써 ?</h2>
                            <img alt='' src={require(`../image/${food1}.jpg`)}
                                 style={{width: '200px'}}/>
                            &nbsp;&nbsp;
                            <img alt='' src={require(`../image/${food2}.jpg`)}
                                 style={{width: '200px'}}/>
                        </div>
                }
            </div>

        </div>
    );
};

export default Food;