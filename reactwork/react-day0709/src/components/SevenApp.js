import React from 'react';
import {Alert} from "@mui/material";

const SevenApp = () => {
    let array1=new Array(12);
    let foodArray=[
        {fname:"샌드위치",price:12000,photo:"1.jpg"},
        {fname:"망고빙수",price:16000,photo:"11.jpg"},
        {fname:"육개장",price:9000,photo:"3.jpg"}
    ];

    return (
        <div>
            <Alert>SevenApp-map 반복문</Alert>
            {
                [...array1].map((item,idx)=>
                <img key={idx} alt="" src={require(`../food/${idx+1}.jpg`)}
                     className='smallphoto'
                />)
            }
            <hr/>
            <h5>image의 1.jpg~20.jpg 까지 이미지 출력</h5>
            {
                [...new Array(20)].map((item,idx)=>
                <img key={idx} alt="" src={require(`../image/${idx+1}.jpg`)}
                className='smallphoto'/>)
            }
            <hr/>
            <h5>foodArray 배열안의 객체값 출력</h5>
            {
                foodArray.map((item,idx)=>
                <figure key={idx} style={{float:'left',marginRight:'10px'}}>
                    <img alt="" src={require(`../food/${item.photo}`)}
                    style={{width:'100px',border:'1px solid gray'}}/>
                    <figcaption>
                        <h6>음식명:{item.fname}</h6>
                        <h6>가격: {item.price}원</h6>
                    </figcaption>
                </figure> )
            }
        </div>
    );
};

export default SevenApp;