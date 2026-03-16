// 문제에서 사용할 기본 함수
function repeat(n, f) {
  for (var i = 0; i < n; i++) {
    f(i);
  }
}

//
// 1. 0 ~ n-1 까지 모든 숫자를 출력하는 콜백 함수를 작성하시오.
console.log('\n문제 1');

var logAll = function (i) {
  console.log(i);
};

repeat(5, logAll);

//
// 2. 0 ~ n-1 중 짝수만 출력하는 콜백 함수를 작성하시오.
console.log('\n문제 2');

var logEven = function (i) {
  if (i % 2 == 0) console.log(i);
};

repeat(10, logEven);

//
// 3. 0 ~ n-1 중 홀수만 출력하는 콜백 함수를 작성하시오.
console.log('\n문제 3');

var logOdd = function (i) {
  if (i % 2) console.log(i);
};

repeat(10, logOdd);

//
// 4. 각 숫자의 제곱값을 출력하시오.
console.log('\n문제 4');

var logSquare = function (i) {
  console.log(i * i);
};

repeat(5, logSquare);

//
// 5. 다음과 같이 출력하는 콜백 함수를 작성하시오.
// index: 0
// index: 1
// index: 2
console.log('\n문제 5');

var logIndex = function (i) {
  console.log(`index: ${i}`);
};

repeat(3, logIndex);

//
// 6. 0 ~ n-1 중 3의 배수만 출력하시오.
console.log('\n문제 6');

var logMultipleOf3 = function (i) {
  if (i % 3 == 0) console.log(i);
};

repeat(10, logMultipleOf3);

//
// 7. 각 숫자의 2배 값을 출력하시오.
console.log('\n문제 7');

var logDouble = function (i) {
  console.log(i * 2);
};

repeat(5, logDouble);

//
// 8. 다음과 같이 별을 출력하시오.
// *
// **
// ***
// ****
console.log('\n문제 8');

var logStar = function (i) {
  console.log('*'.repeat(i + 1));
};

repeat(4, logStar);

//
// 9. 반복되는 숫자를 배열에 저장하시오.
console.log('\n문제 9');
var arr = [];

var saveNumber = function (i) {
  arr.push(i);
};

repeat(5, saveNumber);

console.log(arr);

//
// 10. 반복되는 숫자의 누적합을 계산하시오.
console.log('\n문제 10');

var sum = 0;

var add = function (i) {
  sum += i;
};

repeat(5, add);

console.log(sum);
