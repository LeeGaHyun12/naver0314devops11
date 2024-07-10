import React from 'react';
import './MyStyle.css';
import {Button} from "@mui/material";
import {DeleteForeverOutlined} from "@mui/icons-material";

const SixChild2App = ({row,idx,onDelete}) => {
    return (
        //부모태그는 tr
        <tr style={{backgroundColor: row.color}}>
            <td>{row.cname}</td>
            <td><img alt="" src={require(`../mycar/${row.cphoto}`)}
                     className='small'/></td>
            <td align='right'>{row.cprice}만원</td>
            <td align='center'>
                <Button size="small" color="error" variant='contained'
                startIcon={<DeleteForeverOutlined/>}
                onClick={()=>onDelete(idx)}>Del</Button>
                {/*startIcon 앞에 들어가는 것, endIcon 뒤에 들어가는 것*/}
            </td>
        </tr>

    );
};

export default SixChild2App;