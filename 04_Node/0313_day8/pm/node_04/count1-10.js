// 1초 대기 후 전달받은 메세지 출력
function waitOneSecond(message) {
  return new Promise((resolve, _) => {
    setTimeout(() => {
      resolve(`${message}`);
    }, 1000);
  });
}

// 10초 동안 1초마다 숫자 메세지를 출력
async function countOneToTen() {
  // [...Array(10).keys()] = [0, 1, 2, ..., 9]
  for (let number of [...Array(10).keys()]) {
    let result = await waitOneSecond(`${number + 1}초 대기 중...`);
    console.log(result);
  }

  console.log('카운트 완료');
}

countOneToTen();

// Promise와 async/await를 사용해서 비동기 함수를 동기 방식 코드처럼 직관화해서 작성
