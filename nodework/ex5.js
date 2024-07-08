//펼침 연산자 : ...
let arr=[3,5,7];
let f1=(a,b)=>console.log(a,b);

//f1함수 호출 
f1(arr[0],arr[1]);
f1(...arr);

let arr1=[4,6];
let arr2=[10,20,30];
let arr3=[3,4,...arr1,15,...arr2];
console.log(arr3.length);
console.dir(arr3);

//arr3 배열의 함계 구하기 
let sum=0;
for(let su of arr3){
    sum+=su;
}
console.log(sum)

//변수에 펼침 연산자 적용하기
let [a,...b]=[1,2,3,4,5,6,7,8];
console.log(a);
console.dir(b);

let [x,y,z]=[23,25];
console.log(x);
console.log(y);
console.log(z);