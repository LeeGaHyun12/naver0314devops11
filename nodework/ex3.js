//ES6은 ECMA에서 2015년에 채택한 자바스크립트 표준입니다
// ES6 에서 추가된 기능

// 1. 블록법위 변수 let과 const
// 2. 함수에서 기본 매개변수
// 3. 템플릿 리터럴(Multi=line Literal)
// 4. 화살표함수
// 5. 프로미스 (Promise): 프로미스는 비동기 작업을 조금 더 편하게 처리할 수 있도록 ES6에 도입된 기능입니다
// 6. 클래스,상속 등등
// 7. 모듈개념추가

const PI=3.141592;
//PI=2.12341; // 오류발생 이유는 const가 final역할로 수정 불가
let r=3;
let area=r*r*PI;
console.log("반지름이 %d 인 원의 넓이 : %f",r,area);


//const로 객체를 선언한 경우 주의할것
const pp={
        "name":"홍길동",
        "addr":"서울시"
        }
console.log("이름 : "+pp.name);
console.log("주소 : "+pp.addr);

//이름을 수정해보자
pp.name="이수정"
console.log("이름 : "+pp.name);