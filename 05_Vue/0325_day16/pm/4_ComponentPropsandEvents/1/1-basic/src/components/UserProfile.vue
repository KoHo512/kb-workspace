<script>
export default {
  methods: {
    parentEventCall() {
      this.$emit('print-hello');
    },
  },
};
</script>

<template>
  <!-- 인라인 핸들러 방식 -->
  <button @click="$emit('print-hello')">클릭</button>

  <!-- 메서드 핸들러 방식 -->
  <button @click="parentEventCall">클릭</button>
</template>
