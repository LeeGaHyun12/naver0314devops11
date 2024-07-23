import React, {useEffect, useState} from 'react';
import {Alert} from "@mui/material";
import axios from "axios";
import {NavLink} from "react-router-dom";
import defaultImage from '../image/Hugme.jpg';
import Pagenation from './Pagenation';

const BoardList = () => {
    const [boardList,setBoardList]=useState([]);

    const [limit, setLimit] = useState(5);
    const [page, setPage] = useState(1);
    const offset = (page - 1) * limit;

    const getDataList=()=>{
        axios.get("/boot/board/list")
            .then(res=>{
                setBoardList(res.data);
            })
    }

    const handleError = (e) => {
        e.target.src = defaultImage; // 기본 이미지 경로로 변경
    };

    const storage=process.env.REACT_APP_STORAGE;

    //처음 딱 한번만 목록 가져오기
    useEffect(() => {
        getDataList();
    }, []);

    return (

        <div style={{width: '500px'}}>

            <Alert>
                <b>총 {boardList.length}개의 게시글이 있슴미당</b>
            </Alert>
            <table className='table table-striped'>
                <thead>
                <tr className='table-warning'>
                    <th style={{width: '50px'}}>번호</th>
                    <th style={{width: '250px'}}>제목</th>
                    <th style={{width: '70px'}}>작성자</th>
                    <th style={{width: '100px'}}>작성일</th>
                    <th style={{width: '50px'}}>조회</th>
                </tr>
                </thead>
                <tbody>
                {
                    boardList && //이렇게 넣어주면 순간 이미지 불러오며 나는 에러가 안 남
                    boardList.slice(offset, offset+limit).map((row,idx) =>
                        <tr key={idx}>
                            <td align='center'>{boardList.length - idx}</td>
                            <td>
                                {/*라우터메인에서 읽어오는 보드넘으로*/}
                                <NavLink to={`/board/detail/${row.boardnum}`}
                                         style={{textDecoration: 'none', color: 'black'}}>
                                    <img alt='' src={`${storage}/${row.photo}`}
                                         style={{width: '40px', height: '40px', marginRight: '5px'}}
                                         onError={handleError}/>
                                    {row.subject}
                                    &nbsp;
                                    {row.answercount > 0 ?
                                        <span style={{color: 'red'}}>
                                    [{row.answercount}]
                                </span> : ""}
                                </NavLink>
                            </td>
                            <td align='center'>
                                {row.writer}
                            </td>
                            <td align='center'>
                                <span style={{fontSize: '14px'}}>{row.writeday}</span>
                                {/*0부터 9까지 잘라내서 시간은 안나오게*/}
                            </td>
                            <td align='center'>
                                {row.readcount}
                            </td>
                        </tr>)
                }
                </tbody>

            </table>

            <footer>
                <Pagenation
                    total={boardList.length}
                    limit={limit}
                    page={page}
                    setPage={setPage}
                />
            </footer>
        </div>
    );
};

export default BoardList;