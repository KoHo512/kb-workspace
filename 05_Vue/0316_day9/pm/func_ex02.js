// 1. 함수 선언문으로 함수 호출
function foo() {
  console.log('foo'); // foo
}

foo();

// // 2. 함수 리터럴 표현식으로 함수 호출
// (function bar() {
//   console.log('bar'); // ReferenceError: bar is not defined
// });

// bar();

// 호출하려면 즉시 실행해야 함 - IIFE 구조(Immediately Invoked Function Expression)
// 매크로 만들 때 사용함
(function bar() {
  console.log('bar'); // bar
})();
