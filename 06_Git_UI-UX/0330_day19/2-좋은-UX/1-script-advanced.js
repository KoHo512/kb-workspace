// 좋은 UX로 직접 수정해보기

// 데이터베이스
const userInfo = [
  { id: 'admin', pwd: 'admin1234' },
  { id: 'user1', pwd: 'user1234' },
];

const userId = document.getElementById('userId');
const userPw = document.getElementById('userPw');

const loginBtn = document.getElementById('loginBtn');
const errorBox = document.getElementById('errorBox');
const helperLink = document.getElementById('helperLink');

// 메시지 초기화 함수
// 로그인 시도 전에 기존 메시지를 모두 숨기고 초기화
function resetMessages() {
  // 메시지 영역 숨기기
  errorBox.classList.add('hidden');
  successBox.classList.add('hidden');
  helperLink.classList.add('hidden');

  // 메시지 내용 초기화
  errorBox.textContent = '';
  successBox.textContent = '';
}

loginBtn.addEventListener('click', () => {
  resetMessages();

  const username = userId.value.trim();
  const password = userPw.value.trim();

  if (!username || !password) return;

  for (user of userInfo) {
    if (username === user.id) {
      if (password === user.pwd) {
        successBox.textContent = '로그인되었습니다.';
        successBox.classList.remove('hidden');
        return;
      } else {
        errorBox.textContent = '비밀번호가 올바르지 않습니다.';
        errorBox.classList.remove('hidden');
        helperLink.classList.remove('hidden');
        return;
      }
    }
  }

  errorBox.textContent = '로그인 정보가 올바르지 않습니다.';
  errorBox.classList.remove('hidden');
});
