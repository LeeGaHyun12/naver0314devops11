import React, {useEffect, useState} from 'react';
import axios from "axios";

const MyCarList = () => {
    const [list,setList]=useState([]);
    const dataList=()=>{
        axios.get("/mycar/list")
            .then(res=>{
                setList(res.data);
            })
    }

    useEffect(() => {
        dataList();
    }, []);

    return (
        <table className='table table-bordered'>
            <thead>
            <tr className='table-info'>
                <th style={{width: '120px'}}>자동차명</th>
                <th style={{width: '120px'}}>가격</th>
                <th style={{width: '80px'}}>색상</th>
                <th style={{width: '120px'}}>구입일</th>
            </tr>
            </thead>
            <tbody>
            {
                list.map((item,idx)=>
                    <tr key={idx}>
                        <td>{item.carname}</td>
                        <td>{item.carprice}</td>
                        <td style={{backgroundColor: item.carcolor}}>{item.carcolor}</td>
                        <td>{item.carguip}</td>
                    </tr>)
            }
                    </tbody>
                </table>
                );
};

export default MyCarList;