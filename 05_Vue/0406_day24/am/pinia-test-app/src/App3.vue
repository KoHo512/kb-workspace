<script setup>
import { useCounterStore } from '@/stores/counter.js';
import { computed } from 'vue';

// 표현을 간소화하고 싶다면 이렇게 작성해야함
const { increment } = useCounterStore();
const store = useCounterStore();

const doubleCount = computed(() => store.doubleCount);
</script>

<template>
  <div>
    <p>count : {{ store.count }}</p>
    <p>doubleCount : {{ doubleCount }}</p>
    <button @click="increment">increment</button>
  </div>
</template>
