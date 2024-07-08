import './MyStyle.css';
const TwoApp=()=>{
    let message="Have a Good Day!!";

    return(
        <div>
            <h1 className="alert alert-info">TwoApp-function형태</h1>
            {/*3개의 div에 class msg를 적용하시오
            첫번째 div는 배경색은 'orange',border를 '10px solid gray'
            두번째 div는 배경색을 pink, 글자색을 blue,box-shadow 넣기
            세번째 div는 border를 '10px groove gold' border-radius 값을 30px*/}
            <div className='msg' style={{backgroundColor: 'orange',border:'10px solid gray'}}>{message}</div>
            <div className='msg' style={{backgroundColor:'pink',color:'blue',boxShadow:'5px 5px 5px gray'}}>{message}</div>
            <div className='msg' style={{border:'10px groove gold',borderRadius:'30px'}}>{message}</div>
            {/*변수출력은 중괄호 하나로*/}
        </div>
    )
}

export default TwoApp;
