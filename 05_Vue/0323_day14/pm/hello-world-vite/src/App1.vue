<script>
export default {
  data() {
    return {
      username: '',
    };
  },
  methods: {
    fetchUser() {
      // 사용자 이름 설정 - this.fetchUser() 호출 위치
      this.username = '여원';
      console.log('데이터 로딩 완료');
    },
  },
  // created() : 데이터 초기화 시점 = API 호출 시점
  created() {
    console.log('컴포넌트 생성됨');
    this.fetchUser();
  },
  // mounted() : DOM 접근 가능 시점 - chart, DOM 제어
  mounted() {
    console.log('DOM 렌더링 완료');
  },
};
</script>

<template>
  <div>
    <h2>사용자 정보</h2>
    <p>{{ username }}</p>
    <button @click="fetchUser">다시 불러오기</button>
  </div>
</template>
