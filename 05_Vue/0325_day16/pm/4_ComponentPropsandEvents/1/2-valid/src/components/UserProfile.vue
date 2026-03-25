<script>
export default {
  // 호출 가능한 이벤트 명시 (제한)
  emits: ['print-hello'],
  methods: {
    parentEventCall() {
      // this.$emit('print-hello');
      this.$emit('on-print-hello'); // 에러 메세지 발생
    },
  },
};
</script>

<template>
  <button @click="parentEventCall">클릭</button>
</template>
