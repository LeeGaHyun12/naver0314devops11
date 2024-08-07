import {useState} from "react";

const ThreeApp = () => {
    const [number,setNumber]=useState(0);

    const numberStyle={
        fontSize:'40px',
        marginLeft:'100px',
        color:'red',
        textShadow:'3px 3px 3px gray',
        marginBottom:'10px'
    }

    return (
        <div>
            <h1 className="alert alert-success">
                ThreeApp - 숫자 증가/감소 이벤트
            </h1>
            <div style={numberStyle}>{number}</div>
            <button type="button" className="btn btn-danger btn-sm"
            style={{marginLeft:'60px'}}
            onClick={()=>{
                setNumber(number-1);
            }}>
                감소
            </button>
            <button type="button" className="btn btn-success btn-sm"
            style={{marginLeft:'10px'}}
            onClick={()=>{
                //number 변수값 1 증가
                setNumber(number+1);
            }}>
                증가
            </button>
            {/*변수로 스타일을 지정해주기 때문에 무조건 중괄호 하나*/}
        </div>
    );
};

export default ThreeApp;