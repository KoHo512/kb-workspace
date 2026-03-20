<script setup>
// <script>
//   export default {
//     setup() {
//       const message = "Hello";
//       const welcome = () => {
//         window.aler(message);
//       }
//       return {message, welcome}
//     }
//   }
  import Tire from "./Tire.vue"

  const message = "Hello";
  const welcome = () => {
    window.alert(message);
  }
</script>

<template>
  <div class="front-wheel">
    <span>Front Wheel</span>
    <Tire color="Blue" />
  </div>
</template>

<style scoped>
  .front-wheel {
    border: 1px solid blue;
    border-radius: 50%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 150px;
    height: 150px;
  }
</style>