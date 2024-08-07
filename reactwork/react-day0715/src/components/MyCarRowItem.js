import React, {useState} from 'react';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import Slide from '@mui/material/Slide';
import {DeleteForeverOutlined, EditNote} from "@mui/icons-material";

const Transition = React.forwardRef(function Transition(props, ref) {
    return <Slide direction="up" ref={ref} {...props} />;
});
const MyCarRowItem = ({idx,row,onDelete,onUpdate}) => {
    const  [carname,setCarname]=useState(row.carname);
    const  [carprice,setCarprice]=useState(row.carprice);
    const  [carcolor,setCarcolor]=useState(row.carcolor);

    const photopath1="https://kxmtps3d3768.edge.naverncp.com/Ecpk9tIoYE/mycar";
    const photopath2="?type=f&w=40&h=40&faceopt=true&ttype=jpg";
    const storagepath="https://kr.object.ncloudstorage.com/bitcamp-lgh-143/mycar";//스토리지 주소

    //다이얼로그 이벤트
    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    //수정다이얼로그 이벤트
    const [open2, setOpen2] = React.useState(false);

    const handleClickOpen2 = () => {
        setOpen2(true);
    };

    const handleClose2 = () => {
        setOpen2(false);
    };
    const deleteMycar=(num)=>{
        let a=window.confirm("해당 상품을 삭제할까요 ?");
        if(a){
            onDelete(num);
        }
    }
    //수정이벤트
    const updateMycarEvent=()=>{
        onUpdate({row.num,carname,carprice,carcolor});
    }

    return (

                    <tr style={{fontSize: '14px'}}>
                        <td>
                            <img alt='' src={`${photopath1}/${row.carphoto}${photopath2}`}
                                 border='1' hspace='3' style={{cursor:'pointer'}}
                            onClick={handleClickOpen}/>
                            <span style={{marginLeft: '5px'}}>{row.carname}</span>

                            {/*원본 사진 확인 다이얼로그*/}
                            <Dialog
                                open={open}
                                TransitionComponent={Transition}
                                keepMounted
                                onClose={handleClose}
                                aria-describedby="alert-dialog-slide-description"
                            >
                                <DialogTitle>{row.carname}</DialogTitle>
                                <DialogContent>
                                    <DialogContentText id="alert-dialog-slide-description">
                                        <img alt='' src={`${storagepath}/${row.carphoto}`}
                                             style={{maxWidth:'400px'}}/>
                                    </DialogContentText>
                                </DialogContent>
                                <DialogActions>
                                    <Button onClick={handleClose}>닫기</Button>
                                </DialogActions>
                            </Dialog>
                        </td>
                        <td align='right'>{row.carprice}만원</td>
                        <td align='center'>
                            <div style={{width: '40px', height: '40px', backgroundColor: row.carcolor}}></div>
                        </td>
                        <td>{row.carguip}</td>
                        <td>
                <span style={{color: 'gray', fontSize: '13px'}}>
                    {row.writeday}
                    &nbsp;
                    <DeleteForeverOutlined style={{cursor: 'pointer'}}
                                           onClick={() => deleteMycar(row.num)}/>
                    &nbsp;
                    <EditNote style={{cursor:'pointer'}}
                              onClick={handleClickOpen2}

                    />
                    {/*수정 다이얼로그*/}
                    <Dialog
                        open={open2}
                        TransitionComponent={Transition}
                        keepMounted
                        onClose={handleClose2}
                        aria-describedby="alert-dialog-slide-description"
                    >
                            <DialogTitle>자동차정보수정</DialogTitle>
                            <DialogContent>
                                <DialogContentText id="alert-dialog-slide-description">
                                    <table className='table talbe-bordered' style={{width:'300px'}}>
                                        <tbody>
                                            <tr className='table-success'/>
                                        <td className='table-success' style={{width: '100px'}}>자동차명</td>
                    <td style={{width: '200px'}}>
                        <input type='text' className='form-control'
                               style={{width: '200px'}} value={carname}
                               onChange={(e) => setCarname(e.target.value)}
                        />
                    </td>

    <tr>
        <td className='table-success' style={{width: '100px'}}>가격</td>
        <td>
            <input type='text' className='form-control'
                   style={{width: '200px'}} value={carprice}
                   onChange={(e) => setCarprice(e.target.value)}
            />
        </td>
    </tr>
    <tr>
        <td className='table-success' style={{width: '100px'}}>색상</td>
        <td>
            <input type='color' className='form-control'
                   style={{width: '200px'}} value={carcolor}
                   onChange={(e) => setCarcolor(e.target.value)}
            />
        </td>
    </tr>

                                        </tbody>
                                    </table>

                                </DialogContentText>
                            </DialogContent>
                            <DialogActions>
                                <Button onClick={handleClose2}>닫기</Button>
                            </DialogActions>
                        </Dialog>
                </span>
                        </td>
                    </tr>
    );
};

export default MyCarRowItem;