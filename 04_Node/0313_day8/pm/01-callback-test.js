// 시나리오 : 회원가입 3단계
// 1. 회원가입 API 호출되면 회원 정보를 DB에 저장
// 2. 회원에게 이메일 발송
// 3. 성공 메시지 전달
// 해당 시나리오를 콜백 방식으로 작성

// 회원 정보 저장할 DB
const DB = [];

// 회원가입 API 함수
function register(user) {
  return saveDB(user, function (user) {
    return sendEmail(user, function (user) {
      return getResult(user);
    });
  });
}

// 가입 요청한 회원의 정보를 저장
function saveDB(user, callback) {
  DB.push(user);
  console.log(`save ${user.name} to DB`);

  return callback(user);
}

// 회원에게 이메일 발송
function sendEmail(user, callback) {
  console.log(`email to ${user.email}`);

  return callback(user);
}

// 회원에게 가입 성공 메세지 출력
function getResult(user) {
  return `welcome ${user.name}`;
}

const result = register({
  email: 'koho@kb.com',
  password: '1234',
  name: 'koho',
});

console.log(result);

// register() -> saveDB() -> sendEmail() -> getResult() 차례로 함수 실행
// 여기서 보장하는 것은 함수의 실행 순서
