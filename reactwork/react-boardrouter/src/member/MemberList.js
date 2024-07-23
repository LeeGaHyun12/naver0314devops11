import React, {useEffect, useState} from 'react';
import axios from "axios";

const MemberList = () => {
    const [memberList,setMemberList]=useState([]);

    const getMemberList=()=>{
        axios.get("/boot/member/list")
            .then(res=>{
                setMemberList(res.data);
            })
    }
    useEffect(() => {
        getMemberList();
    }, []);

    return (
        <div style={{width:'500px'}}>
            <h3>&nbsp;[회원 목록]</h3>
            <table className='table table-striped' >
                <thead>
                <tr className='table-warning'>
                    <th style={{width:'30px'}}>번호</th>
                    <th style={{width:'50px'}}>아이디</th>
                    <th style={{width:'100px'}}>핸드폰</th>
                    <th style={{width:'100px'}}>가입일</th>
                </tr>
                </thead>
                <tbody>
                {
                    memberList && //이렇게 넣어주면 순간 이미지 불러오며 나는 에러가 안 남
                    memberList.map((row,idx) =>
                        <tr key={idx} style={{}}>
                            <td align='center' >{row.num}</td>
                            <td >{row.userid}</td>
                            <td >{row.hp}</td>
                            <td >{row.gaipday}</td>
                        </tr>)
                }
                </tbody>
            </table>
        </div>
    );
};

export default MemberList;