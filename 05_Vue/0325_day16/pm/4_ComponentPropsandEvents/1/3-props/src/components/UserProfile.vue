<script>
export default {
  // methods: {
  //   parentEventCall() {
  //     this.$emit('print-hello', '영희', 15);
  //   },
  // },
};
</script>

<template>
  <!-- <button @click="parentEventCall">클릭</button> -->
  <button @click="$emit('print-hello', '영희', 15)">클릭</button>
</template>
