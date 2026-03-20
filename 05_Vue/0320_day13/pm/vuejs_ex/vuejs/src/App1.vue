<script setup>
  import FrontWheel from "./components/FrontWheel.vue";
  import RearWheel from "./components/RearWheel.vue";
</script>

<template>
  <div class="container">
    <FrontWheel />
    <RearWheel />
  </div>
</template>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  gap: 5rem;
}
</style>