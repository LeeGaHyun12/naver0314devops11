import React, {useContext} from 'react';
import {Button} from "@mui/material";
import {ThemeContext} from "./ThemeContext";

const Footer = () => {
    const {isDark,setIsDark}=useContext(ThemeContext);
    return (
        <div>
            <footer className='footer' style={{backgroundColor:isDark?'pink':'cyan'}}>
                <Button variant='contained' color='error'
                onClick={()=>setIsDark(!isDark)}>Dark Mode</Button>
            </footer>
        </div>
    );
};

export default Footer;