<script>
export default {
  // Composition API 방식
  setup() {
    const date1 = Date().toString();
    return {
      date1,
    };
  },

  // Options API 방식 - 이제 잘 사용하지 않음
  data() {
    return {
      date2: Date().toString(),
    };
  },
};
</script>

<template>
  <div id="date1">
    <p>{{ date1 }}</p>
  </div>
  <div id="date1">
    <p>{{ date2 }}</p>
  </div>
</template>
