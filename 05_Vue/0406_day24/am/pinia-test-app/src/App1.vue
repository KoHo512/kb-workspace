<script setup>
import { useCounterStore } from '@/stores/counter.js';

const store = useCounterStore();
console.log(store);
console.log(store.count); // 0
store.count = 10;
</script>

<template>
  <div>
    <p>count : {{ store.count }}</p>
    <p>doubleCount : {{ store.doubleCount }}</p>
    <button @click="store.increment">increment</button>
  </div>
</template>
