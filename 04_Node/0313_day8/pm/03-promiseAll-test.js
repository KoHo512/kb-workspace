// 시나리오 : 회원가입 3단계
// 1. 회원가입 API 호출되면 회원 정보를 DB에 저장
// 2. 회원에게 이메일 발송
// 3. 성공 메시지 전달
// 해당 시나리오를 콜백 방식으로 작성

const DB = [];

function saveDB(user) {
  // 변경 전 사용자 수
  const oldDBSize = DB.length;
  // 전달 받은 회원 정보 DB에 저장
  DB.push(user);
  console.log(`save ${user.name} to DB`);

  // 콜백 대신 Promise 객체 반환
  return new Promise((resolve, reject) => {
    if (DB.length > oldDBSize) {
      // 성공 시 회원 정보 반환
      resolve(user);
    } else {
      // 실패 시 에러 발생
      reject(new Error('Save DB Error!'));
    }
  });
}

function sendEmail(user) {
  console.log(`email to ${user.email}`);

  return new Promise((resolve) => {
    resolve(user);
  });
}

function getResult(user) {
  return new Promise((resolve, reject) => {
    resolve(`success register ${user.name}`);
  });
}

function registerByPromise(user) {
  // 비동기 호출이지만 순서를 지켜 실행
  const result = saveDB(user).then(sendEmail).then(getResult);

  // 아직 완료되지 않았으므로 지연(pending) 상태
  // 이 메세지 출력으로 Promise가 아직 실행 중임을 알 수 있음
  console.log(result); // Promise { <pending> }

  return result;
}

const myUser = {
  email: 'koho@kb.com',
  password: '1234',
  name: 'koho',
};

// const result = registerByPromise(myUser);

// // 결과가 Promise 객체이므로 then() 메서드에 함수를 넣어 결과 출력
// result.then(console.log); // success register koho

allResult = Promise.all([saveDB(myUser), sendEmail(myUser), getResult(myUser)]);
allResult.then(console.log);
