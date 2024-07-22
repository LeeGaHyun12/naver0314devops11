import React, {useState} from 'react';
import {Alert, Button} from "@mui/material";
import Swal from "sweetalert2";
import xmas1 from '../image/신난트리누피.gif';
import tree1 from '../image/창밖눈.gif';
import house1 from '../image/루시누피눈.gif';
import tree2 from '../image/함박눈.gif';
import tree3 from '../image/눈찰리.jpg';
import bell1 from '../image/산타누피.jpg';

const SweetAlertApp = () => {
    const [sangpum,setSangpum]=useState("애플워치");
    const buttonEvent1=()=>{
        Swal.fire('안녕하세요');//기본
    }
    const buttonEvent2=()=>{
        Swal.fire({
            titl: "Swal Test #2",
            //text: "줄바꿈을 해볼까요 <br/>줄바꿈을 해볼까요 <br/>줄바꿈을 해볼까요 <br/>",
            html: "줄바꿈을 해볼까요 <br/>줄바꿈을 해볼까요 <br/>줄바꿈을 해볼까요 <br/>",
            icon:"success",
            confirmButtonColor:"skyblue",
            confirmButtonText:"확인",
            cancelButtonText:"취소",
            showCancelButton:true,
            cancelButtonColor:"gray"
        }).then(result=>{
            if(result.isConfirmed){
                Swal.fire("처리했습니다");
            }else{
                Swal.fire("취소했습니다");
            }
        });
    }
    const buttonEvent3=()=>{
        Swal.fire({
            title:'사진넣기',
            html:`<h5>사진을 넣어보세요</h5>
                <img alt='' src=${tree1} style="width: 300px;height: 200px;"/>`,
            imageUrl:xmas1,
            icon:'success'
        });
    }
    const buttonEvent4=()=>{
        Swal.fire({
           title:"Input Email Address",
           input:'email',
           inputLabel:"Your Email Address",
           showCancelButton:true,
           cancelButtonText:"Cancel"
        });
    }
    const buttonEvent5=()=>{
        Swal.fire({
            title:"상품구매",
            imageUrl:house1,
            text:`[${sangpum}] 상품을 구매하시겠습니까?`,
            showCancelButton:true,
            cancelButtonText:"Cancel"
        }).then(result=>{
            if (result.isConfirmed){
                Swal.fire(`[${sangpum}] 상품을 결제했습니다`);
            }
        });//기본
    }
    const buttonEvent6=()=>{
        let arr=[
            {photo:tree1,msg:"캔디"},
            {photo:tree2,msg:"마이클"},
            {photo:tree3,msg:"영자"},
            {photo:bell1,msg:"철수"}
        ];

        let s="";
        for (let a of arr){
            s+=`<img alt="" src=${a.photo} width=100/>&nbsp;&nbsp;
            <b>${a.msg}</b><br/>`;
        }

        Swal.fire({
            //icon:'success',
            title:'좋아요 누른사람',
            //imageUrl:xmas1,
            html:s
        });
    }
    return (
        <div>
            <Alert>SweetAlert 공부하기</Alert>
            <Button variant='contained' color='error' size='small' onClick={buttonEvent1}>
                <a>SweetAlert #1</a>
            </Button>
            <br/><br/>
            <Button variant='contained' color='error' size='small' onClick={buttonEvent2}>
                <a>SweetAlert #2</a>
            </Button>
            <br/><br/>
            <Button variant='contained' color='error' size='small' onClick={buttonEvent3}>
                <a>SweetAlert #3</a>
            </Button>
            <br/><br/>
            <Button variant='contained' color='error' size='small' onClick={buttonEvent4}>
                <a>SweetAlert #4</a>
            </Button>
            <br/><br/>
            <Button variant='contained' color='error' size='small' onClick={buttonEvent5}>
                <a>SweetAlert #5</a>
            </Button>
            <br/><br/>
            <Button variant='contained' color='error' size='small' onClick={buttonEvent6}>
                <a>SweetAlert #6</a>
            </Button>
            <br/><br/>

        </div>
    );
};

export default SweetAlertApp;