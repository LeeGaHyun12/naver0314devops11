import React, {useState} from 'react';
import {Alert, Button} from "@mui/material";
import DaumPostcode from 'react-daum-postcode';
import Dialog from "@mui/material/Dialog";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import DialogTitle from "@mui/material/DialogTitle";

const DaumPostApp = () => {
    const [openPostcode, setOpenPostcode] = useState(false);
    const [address, setAddress] = useState('');
    const [open, setOpen] = React.useState(false);

    const [openPostcode2, setOpenPostcode2] = useState(false);
    const [address2, setAddress2] = useState('');

    const addrhandle = {
        clickButton: () => {
            setOpenPostcode(current => !current);
            setOpen(true);
        },

        //주소 선택 이벤트
        selectAddress: (data) => {
            console.dir(data);
            setAddress(`
                우편번호 : ${data.zonecode},
                주소 : ${data.address},
                건물명 : ${data.buildingName}
                `);
            setOpenPostcode(false);
        },
        colorhandleClose: () => {
            setOpen(false);
        }
    }
    const handleClose = () => {
        setOpen(false);
    };

    const addrhandle2 = {
        clickButton: () => {
            setOpenPostcode2(current => !current);
            setOpen(true);
        },

        //주소 선택 이벤트
        selectAddress: (data) => {
            console.dir(data);

            setAddress2(`
                주소 : ${data.address} 
                ${data.buildingName},
                ${data.zonecode}`);
            setOpenPostcode2(false);
            //다이얼로그 닫기
            setOpen(false);
        }
    }

    return (
        <div>
            <Alert>카카오 주소 나타내기</Alert>
            <h4>카카오 주소 나타내기 #1</h4>
            <Button variant='contained' color='warning' size="small"
                    onClick={addrhandle.clickButton}>주소검색</Button>
            <h3>{address}</h3>
            {
                openPostcode &&
                <DaumPostcode
                    onComplete={addrhandle.selectAddress}
                    autoClose={false} //값을 선택할 경우 사용되는
                    defaultQuery='강남대로 94길 20' //팝업을 열때 기본적으로 입력되는 검색어
                />
            }
            <Dialog
                open={open}
                onClose={handleClose}
                aria-labelledby="alert-dialog-title"
                aria-describedby="alert-dialog-description"
            >
                <DialogTitle id="alert-dialog-title">
                    카카오 주소 검색
                </DialogTitle>
                <DialogContent>
                    {
                    openPostcode &&
                    <DaumPostcode
                        onComplete={addrhandle2.selectAddress} //값을 선택할 경우 실행되는 이벤트
                        autoClose={false} //값을 선택할 경우 사용되는 Dom을 제거하여 자동 닫힘 ㅅ걸정
                        defaultQuery='강남대로 94길 20' //팝업을 열때 기본적으로 입력되는 검색어
                    />
                    }
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose} autoFocus>닫기</Button>
                </DialogActions>
            </Dialog>
        </div>
    );
};

export default DaumPostApp;