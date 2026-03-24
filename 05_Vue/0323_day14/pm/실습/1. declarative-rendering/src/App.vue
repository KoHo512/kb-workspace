<!-- Composition API와 Options API의 데이터 세팅 방식 차이 -->

<template>
  <div id="date">
    {{ date }}
  </div>
  <div id="date2">
    {{ date2 }}
  </div>
</template>

<script>
export default {
  // Composition API
  setup() {
    const date = Date().toString();
    return {
      date,
    };
  },

  // Options API
  data() {
    return {
      date2: Date().toString(),
    };
  },
};
</script>
