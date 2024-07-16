import React, {useEffect, useState} from 'react';
import axios from "axios";
import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';
import ImageListItemBar from '@mui/material/ImageListItemBar';

const MyCarPhoto = () => {
    const [list,setList]=useState([]);
    const storage="https://kr.object.ncloudstorage.com/bitcamp-lgh-143/mycar";
    const dataList=()=>{
        axios.get("/mycar/list")
            .then(res=>{
                setList(res.data);
            })
    }

    useEffect(() => {
        dataList();
    }, []);

    return (
        <div>
            <ImageList sx={{ width: 600, height: 600 }}>
                {list.map((item,idx) => (
                    <ImageListItem key={idx}>
                        <img
                            srcSet={`${storage}/${item.carphoto}?w=248&fit=crop&auto=format&dpr=2 2x`}
                            src={`${storage}/${item.carphoto}?w=248&fit=crop&auto=format`}
                            alt={item.carname}
                            loading="lazy"
                        />
                        <ImageListItemBar
                            style={{backgroundColor:'skyblue',color:'navy'}}
                            title={item.carname}
                            subtitle={<span style={{fontSize:'13px'}}>Price: {item.carprice}만</span>}
                            position="below"
                        />
                    </ImageListItem>
                ))}
            </ImageList>
            
        </div>
    );
};

export default MyCarPhoto;