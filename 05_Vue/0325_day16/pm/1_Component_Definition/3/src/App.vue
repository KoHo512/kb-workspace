<!-- 컴포넌트 지역(local) 등록 : 컴포넌트를 등록한 곳에서만 사용 -->
<!-- Options API의 components 속성 -->

<script>
import FirstChild from './components/FirstChild.vue';
export default {
  components: {
    FirstChild, // App컴포넌트에서만 FirstChild 컴포넌트 사용
  },
};
</script>

<template>
  <h1>App.vue</h1>
  <FirstChild />
</template>

<!-- 부모 컴포넌트에서 작성한 코드가 자식 컴포넌트에 영향을 줌 -->
<!-- scoped 속성을 붙이면 해당 컴포넌트에만 적용 -->
<style scoped>
h1,
p {
  color: orange !important;
}
</style>
