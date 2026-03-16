//
// 1. 배열과 콜백 함수를 전달받아, 콜백의 조건을 만족하는 요소만 출력하는 filterLog 함수를 작성하세요.
console.log('\n문제 1');

function filterLog(arr, callback) {
  arr.forEach((i) => {
    if (callback(i)) console.log(i);
  });
}

filterLog([1, 2, 3, 4, 5], function (x) {
  return x % 2 === 0;
});
// 2
// 4

//
// 2. 배열과 콜백을 받아 새 배열을 반환하는 myMap 함수를 작성하세요.
console.log('\n문제 2');

function myMap(arr, callback) {
  return arr.map((i) => i * 2);
}

const result = myMap([1, 2, 3], function (x) {
  return x * 2;
});

console.log(result); // [2, 4, 6]

//
// 3. 배열과 콜백을 받아 각 요소에 대해 콜백을 실행하는 myForEach를 작성하세요.
console.log('\n문제 3');

function myForEach(arr, callback) {
  arr.forEach((a, idx) => callback(a, idx));
}

myForEach(['a', 'b', 'c'], function (item, index) {
  console.log(index, item);
});

//
// 4. 다음 코드의 실행 결과를 예측하고 이유를 설명하세요.
console.log('\n문제 4');

console.log('A');

setTimeout(function () {
  console.log('B');
}, 0);

console.log('C');

// A
// C
// B
// 콜 스택에 있는 동작이 모두 실행된 후 비동기 큐의 동작을 실행하기 때문

//
// 5. 다음 코드의 결과를 예측하고, 원하는 값이 나오도록 수정하세요.
// [포인트] let 또는 즉시 실행 함수(IIFE)로 해결 가능한지
console.log('\n문제 5');

// for (var i = 0; i < 3; i++) {
//   setTimeout(function () {
//     console.log(i);
//   }, 1000);
// }

// 3
// 3
// 3

for (let i = 0; i < 3; i++) {
  setTimeout(function () {
    console.log(i);
  }, 1000);
}
// 전역변수(var)로 선언하면 비동기 처리 후 돌아왔을 때 전역변수에 저장되어있는 값을 참조하기 때문

// IIFE
for (var i = 0; i < 3; i++) {
  (function (i) {
    setTimeout(function () {
      console.log(i);
    }, 1000);
  })(i);
}
