import React from 'react';
import {Button} from "@mui/material";

const Light = ({room,on,toggle}) => {
    console.log({room,on});
    return (
        <div>
            <Button onClick={toggle}
                    variant='contained' color='error'>
                {room}
                {on ? "💡" : "⬛"}
            </Button>
        </div>
    );
};

// export default Light;
export default React.memo(Light);