//첫 컴포넌트는 클래스 형태로 만들어보자
//Hooks 문법이 추가된 이후는 class 형태 보다는 function 형태로 많이 만든다
//function 형태로 만힝 만든다

import {Component} from "react";
import car1 from './mycar/mycar11.png';
import car2 from './mycar/mycar13.png';
import car3 from './mycar/mycar15.png';
import './MyStyle.css';
class OneApp extends Component{
    render() { //렌더링 되는 부분이 return 부분
        return(
            <div>
                <h1 className="alert alert-danger">OneApp-class형태</h1>
                <h5>public의 사진 가져오기</h5>
                {/*public의 사진은 매핑주소에 따라서 안나올때도 있다 - 권장안함*/}
                <img src="./8.jpg" alt="사진1" width={200}/>
                <img src="./11.jpg" alt="사진2"
                     style={{
                         width: '200px', border: '5px solid green',
                         borderRadius: '50px 20px 100px 10px'
                     }}/>
                {/*직접 스타일을 지정해주려면 중괄호 두개를 사용*/}

                <h5>src 폴더의 사진 가져오기</h5>
                <img alt="자동차1" src={car1} className="photo line1"/>
                <img alt="자동차2" src={car2} className="photo line2"/>
                <img alt="자동차3" src={car3} className="photo line3"/>
            </div>
        )
    } //부모 태그는 하나만 주어야 한다 주로 div
}

//export가 반드시 들어가 있어야 한다
//방법 1 . export / 방법 2. export default
//위에 임포트에 정의된 이름 그대로 가져와야 한다.
//index.js 에서 지정해주면 된다

//export default OneApp; //default는 단 한번만 사용가능, import시에 마음대로 이름을 지정할 수 있다.
export {OneApp} //이경우에는 import시에 정확한 이름으로 import 해야한다
