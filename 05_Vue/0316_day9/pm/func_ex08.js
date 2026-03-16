// 외부에서 전달받은 function을 n회 반복 호출하는 함수
// 외부에서 전달받은 func 를 n 만큼 반복 호출 - 고차 함수 repeat
function repeat(n, f) {
  for (var i = 0; i < n; i++) {
    f(i);
  }
}

// 콜백 함수 정의 - logAll
var logAll = function (i) {
  console.log(i);
};

// 반복 호출할 함수를 인수로 전달
repeat(5, logAll); // 0 1 2 3 4

// 콜백 함수 정의 - logOdd
var logOdd = function (i) {
  if (i % 2) console.log(i);
};

// 반복 호출할 함수를 인수로 전달
repeat(5, logOdd); // 1 3
