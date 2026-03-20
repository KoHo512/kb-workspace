let obj = { result: 0 };

obj.add = function (x, y) {
  function inner() {
    this.result = x + y;
  }

  inner();
};

obj.add(3, 4);

console.log(obj);
console.log(result);

// { result: 7 }
// 오류 발생?

// 실제 실행결과
// { result: 0, add: [Function (anonymous)] }
// 7
// this 바인딩 때문 - inner()는 일반 함수로 호출됐기 때문에 this는 전역 객체를 가리킴
