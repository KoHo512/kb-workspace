// // 즉시 실행 함수 - 익명 함수를 사용하는 게 일반적
// (function () {
//   let a = 3;
//   let b = 3;

//   console.log(a * b);
// })();

// //
// //
// // 기명 즉시 실행 함수
// (function foo() {
//   let a = 3;
//   let b = 3;

//   console.log(a * b);
// })();

// // foo(); // ReferenceError: foo is not defined

//
//
// 즉시 실행 함수도 일반 함수처럼 값 반환 가능
let result = (function () {
  let a = 3;
  let b = 5;
  return a * b;
})();

console.log(result);

//
//
// 즉시 실행 함수에서 일반 함수처럼 인수 전달 가능
result = (function (a, b) {
  return a + b;
})(3, 5);

console.log(result);
