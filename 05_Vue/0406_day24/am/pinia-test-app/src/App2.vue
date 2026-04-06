<script setup>
import { useCounterStore } from '@/stores/counter.js';

const { count, doubleCount, increment } = useCounterStore();
// actions 함수는 분해할당으로 받을 수 있음
// 하지만 state 데이터는 반응성을 잃어버림
</script>

<template>
  <div>
    <p>count : {{ count }}</p>
    <p>doubleCount : {{ doubleCount }}</p>
    <button @click="increment">increment</button>
    <!-- incrememt 버튼을 누르면 vue 확장프로그램의 pinia store에서 값이 변경되는 게 보이지만 화면에 렌더링되지 X -->
  </div>
</template>
