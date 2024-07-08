//컬렉션 : set, map
//set : 중복허용안함, 비순차적
let set1=new Set("abcdabcdabcdabcd");
console.log("set1의 갯수:"+set1.size); //4
set1.add(12);
console.log("set1의 갯수:"+set1.size); //5
//펼침 연산자를 이용해서 값들 확인하기
console.log(...set1);
set1.delete('b');//삭제
console.log("set1의 갯수:"+set1.size);//4
console.log(...set1);
set1.clear();
console.log("set1의 갯수:"+set1.size);//0 

//map: key,value의 쌍으로 저장되는 형태
let map1=new Map();
let a={n:1};
map1.set(a,"A");//key값이 json 형태가 될 수도 있다
map1.set("name","김태희");
console.log(map1.size);
//map1 전체 출력
console.log(...map1);
console.log(map1.has("name")); //true, key값에 name이 있느냐
console.log(map1.has("blood")); //true, key값에 blood이 있느냐

//name이라는 key값에 해당하는 데이터를 제거
map1.delete("name");
console.log(map1.has("name"));//false,key 값에 name이 있느냐

//전체 제거 clear
map1.clear();
console.log("전체 제거 후 갯수:"+map1.size);