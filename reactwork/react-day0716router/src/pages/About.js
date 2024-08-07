import React from 'react';
import {Alert} from "@mui/material";
import nofood from "../image/프로필.jpg";
import {useParams} from "react-router-dom";
import Naver from "../image/기타누피.jpg";
const About = () => {
    const {emp}=useParams();
    return (
        <div>
            <Alert severity='info'>About</Alert>
            <div style={{marginTop: '20px'}}>
                {
                    emp==null?
                        <div>
                            <h1>저는 취업준비중입니다 </h1>
                        </div>
                        :
                        <div>
                            <h1>저는 {emp}에 다니고 있습니다</h1>
                        </div>
                }
            </div>
        </div>
    );
};

export default About;