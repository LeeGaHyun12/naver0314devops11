import React from 'react';
import {CloseSharp} from "@mui/icons-material";

const OneSubApp = (asd) => {
    let {idx,item,deleteSangpum} = asd;
    return (
        <div>
            <>
                <tr>
                    <td style={{width: "200px", backgroundColor: "#ccf"}} rowSpan={4} align='center'>
                        <img src={require(`../peanuts/${item.sphoto}`)}
                             style={{width: "120px", height: "130px", border: "1px solid gray"}}></img>
                        <br/>
                        <CloseSharp style={{cursor:'pointer'}}
                        onClick={()=>{
                            let a=window.confirm("상품을 삭제할까요?");
                            if(a){
                                deleteSangpum(idx);
                            }
                        }}/>
                    </td>
                    <td>번호 : {idx + 1}번</td>
                </tr>
                <tr>
                    <td>캐릭터명 : {item.sname}</td>
                </tr>
                <tr>
                    <td>가격 : {item.sprice}</td>
                </tr>
                <tr>
                    <td>색상 :
                        <b style={{backgroundColor: item.scolor}}>{item.scolor}</b></td>
                </tr>

            </>
        </div>
    );
};

export default OneSubApp;