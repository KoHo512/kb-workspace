function changeValue(primitive, obj) {
  primitive += 100;
  obj.name = 'lee';
}

let num = 100;
let person = { name: 'kim' };

// 준비된 데이터셋과 changeValue() 함수를 이용해 값을 변경하고 변경한 값 출력
console.log(num); // 100
console.log(person.name); // kim

changeValue(num, person);

console.log(num); // 100
console.log(person.name); // lee
