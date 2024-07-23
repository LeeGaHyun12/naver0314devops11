import React, {useState} from 'react';
import {Button} from "@mui/material";
import {useNavigate} from "react-router-dom";
import axios from "axios";

const LoginForm = () => {
    const [userid, setUserid] = useState('');
    const [passwd, setPasswd] = useState('');

    const navi=useNavigate();
    const submitLoginEvent=(e)=>{
        e.preventDefault();
        let url=`/boot/member/login?userid=${userid}&passwd=${passwd}`;
        axios.get(url)
            .then(res=> {
                if(res.data.result==='noid'){
                    alert("회원 아이디가 아닙니다.\n가입후 로그인해주세요");
                    return;
                }else if(res.data.result==='fail'){
                    alert("비밀번호가 맞지 않습니다");
                    return;
                }else{
                    //토큰을 얻어서 세션스토리지에 저장
                    sessionStorage.token=res.data.token;
                    //새로고침
                    window.location.reload();
                }
            })
    }
    return (
        <div style={{margin:'30px 100px'}}>
            {
                sessionStorage.token != null ?
                    <h2>
                        <b>로그인 중입니다</b>
                    </h2>
                    :
            <form onSubmit={submitLoginEvent}>
                <table className='table table-bordered'
                       style={{width:'300px'}}>
                    <caption align="top"><h5><b>[회원로그인]</b></h5></caption>
                    <tbody>
                    <tr>
                        <th className='table-success' style={{width: '100px'}}>아이디</th>
                        <td>
                            <input type='text' className='form-control' required value={userid}
                            onChange={(e)=>setUserid(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <th className='table-success' style={{width: '100px'}}>비밀번호</th>
                        <td>
                            <input type='password' className='form-control' required value={passwd}
                             onChange={(e)=>setPasswd(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align='center'>
                           <Button type='submit' variant='contained' color='success' >
                               <a>로그인</a>
                           </Button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
            }

        </div>
    );
};

export default LoginForm;