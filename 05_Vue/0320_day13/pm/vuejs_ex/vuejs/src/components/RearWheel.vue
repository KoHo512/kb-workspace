<script setup>
  import Tire from "./Tire.vue"

  const message = "Hello";
  const welcome = () => {
    window.alert(message);
  }
</script>

<template>
  <div class="rear-wheel">
    <span>Rear Wheel</span>
    <Tire color="Red" />
  </div>
</template>

<style scoped>
  .rear-wheel {
    border: 1px solid black;
    border-radius: 50%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 150px;
    height: 150px;
  }
</style>