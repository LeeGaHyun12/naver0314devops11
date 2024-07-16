import React from "react";
import {Button} from "@mui/material";

const TwoRowItem = (props) =>{
    let {idx,row,deleteData}=props;
    return(
        <tr>
            <td>{idx + 1}</td>
            <td>{row.irum}</td>
            <td>{row.age}</td>
            <td>{row.blood}</td>
            <td>{row.today.toLocaleDateString('ko-KR')}</td>
            {/*<td>{row.today.toLocaleString('ko-KR')}</td> */}
            {/*date를 빼면시간까지 나온다*/}
            <td><Button variant='contained' color='danger' size='small' onDelete={deleteData}/></td>
        </tr>
    );
};

export default TwoRowItem;