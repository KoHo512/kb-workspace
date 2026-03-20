<script setup>
  import Wheel from './components/NewWheel.vue';
</script>

<template>
  <div class="car">
    <Wheel position="Front" color="Green" />
    <Wheel position="Rear" />
  </div>
</template>

<style scoped>
.car {
  width: 500px;
  background-color: yellow;
  padding: 10px;
  margin: 0 auto;
  display: flex;
  justify-content: space-around;
  align-items: center;
  gap: 100px;
}
</style>