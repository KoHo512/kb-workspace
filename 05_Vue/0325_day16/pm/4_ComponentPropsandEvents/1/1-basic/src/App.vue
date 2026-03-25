<!-- 부모 컴포넌트에서의 사용자 정의 이벤트 사용 여부와 상관 없이
    모든 컴포넌트에서 $emit() 내장 메서드를 사용하여 부모 컴포넌트로 이벤트 발신 가능 -->
<!-- 자식들의 무분별한 이벤트 발신을 제어하기 위해 발신 가능한 이벤트를 명시하도록 함 => 2-valid -->

<script>
import UserProfile from './components/UserProfile.vue';
export default {
  components: { UserProfile },
  methods: {
    printHello() {
      alert('Hello');
    },
  },
};
</script>

<template>
  <UserProfile @print-hello="printHello" />
</template>
