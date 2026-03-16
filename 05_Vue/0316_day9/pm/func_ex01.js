// 함수 선언문
function add(x, y) {
  return x + y;
}

// 함수 표현식
let add = function add(x, y) {
  return x + y;
};

// 화살표 함수
let add2 = (x, y) => x + y;

function multiply(x, y) {
  console.log(x * y);
}

let result = add(10, 20);
console.log(result);

multiply(2, 3);
