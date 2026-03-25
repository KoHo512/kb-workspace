<!-- @print-hello 이벤트 발신할 때
     문자열 값이 '영희', 숫자형 값인 15를 매개변수로 전달하는 코드 작성 -->

<script>
import UserProfile from './components/UserProfile.vue';
export default {
  components: { UserProfile },
  methods: {
    printHello(name, age) {
      alert(`안녕하세요, 저는 ${name}이고 나이는 ${age}살입니다.`);
    },
  },
};
</script>

<template>
  <UserProfile
    @print-hello="
      (name, age) => {
        printHello(name, age);
      }
    "
  />
</template>
