//함수 파라미터 기본값
/*
function func(x,y=100,z=200){
    console.log(x,y,z);
}
    */

//위 함수를 화살표 함수로 변환해보자
let func=(x,y=100,z=200)=>console.log(x,y,z);

//두 수의 합
let add=(a,b)=>a+b;//return 생략 가능

//두 수의 곱
let mul=(a,b)=>a*b;//return 생략 가능

//함수 호출
func(4);
func(5,6);
func(1,2,3);


console.log(add(1,2));
console.log(mul(5,7));