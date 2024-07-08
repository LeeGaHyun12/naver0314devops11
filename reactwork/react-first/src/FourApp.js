import {useState} from "react";
import car1 from './mycar/mycar2.png';
import car2 from './mycar/mycar4.png';
import car3 from './mycar/mycar12.png';


const FourApp=()=>{
    const [name,setName]=useState('이영자');
    const [age,setAge]=useState(19);
    const [addr,setAddr]=useState('서울시');
    const [photo,setPhoto]=useState(car1);

    return(
        <div>
            <h1 className="alert alert-info">FourApp-개인정보변경</h1>
            <table className="table table-bordered" style={{width:'300px'}}>
                <caption align="top">개인정보출력</caption>
                <tbody>
                <tr>
                    <th width={100} className="table-success">이름</th>
                    <td width={150}>{name}</td>
                    <td rowSpan={3}>
                        <img alt="자동차" src={photo} style={{width:'150px'}}/>
                    </td>
                </tr>
                <tr>
                    <th width={100} className="table-success">나이</th>
                    <td>{age}세</td>
                </tr>
                <tr>
                    <th width={100} className="table-success">주소</th>
                    <td>{addr}</td>
                </tr>
                </tbody>
            </table>
            <div className="input-group" style={{width: '400px'}}>
                <input type="text" className="form-control"
                       style={{width: '100px'}} placeholder="이름"
                value={name}
                onChange={(e)=>setName(e.target.value)}/>
                {/*age가 20세 미만은 car1,50세 미만은 car2 나머지는 car3 */}
                {/*value 를 넣으려면 이벤트를 꼭 넣어줘야 입력이 가능하다*/}
                <input type="text" className="form-control"
                       style={{width: '60px'}} placeholder="나이"
                       value={age} onChange={(e)=>setAge(e.target.value)}
                       onKeyUp={()=>{
                       if(Number(age)<20){
                           setPhoto(car1);
                       }else if(Number(age)<50){
                           setPhoto(car2);
                       }else{
                           setPhoto(car3);
                       }
                       }}/>
                <input type="text" className="form-control"
                       style={{width: '200px'}} placeholder="주소"
                       value={addr}
                       onChange={(e)=>setAddr(e.target.value)}/>
            </div>
        </div>
    )
}

export default FourApp;