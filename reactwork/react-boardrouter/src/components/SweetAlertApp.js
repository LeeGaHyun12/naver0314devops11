import React from 'react';
import {Alert, Button} from "@mui/material";

const SweetAlertApp = () => {
    return (
        <div>
            <Alert>SweetAlert 공부하기</Alert>
            <Button variant='contained' color='error' size='small'>
               <a>SweetAlert #1</a>
            </Button>
            <br/><br/>
            <Button variant='contained' color='error' size='small'>
                <a>SweetAlert #2</a>
            </Button>
            <br/><br/>
            <Button variant='contained' color='error' size='small'>
                <a>SweetAlert #3</a>
            </Button>
            <br/><br/>
            <Button variant='contained' color='error' size='small'>
                <a>SweetAlert #4</a>
            </Button>
            <br/><br/>
            <Button variant='contained' color='error' size='small'>
                <a>SweetAlert #5</a>
            </Button>
            <br/><br/>

        </div>
    );
};

export default SweetAlertApp;