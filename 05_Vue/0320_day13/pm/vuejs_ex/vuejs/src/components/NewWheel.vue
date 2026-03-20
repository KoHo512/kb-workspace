<script setup>
  import Tire from "./NewTire.vue"

  const props = defineProps({
    position: String,
    color: String
  });
</script>

<template>
  <div class="wheel" :style="{borderColor: props.color}">
    <span :style="{color: props.color}">{{ props.position }} Wheel</span>
    <Tire :color="props.color" />
  </div>
</template>

<style scoped>
.wheel {
  border: 3px solid black;
  border-radius: 50%;
  width: 150px;
  height: 150px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>