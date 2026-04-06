<script setup>
import { storeToRefs } from 'pinia';
import { useCountSetupStore } from '@/stores/countSetup';

const setupStore = useCountSetupStore();

const { num, doubleNum } = storeToRefs(setupStore);
const { increment, getJson } = setupStore;
</script>

<template>
  <h1>About View</h1>
  <h2>num: {{ num }}</h2>
  <h2>doubleNum: {{ doubleNum }}</h2>

  <button @click="increment">increment</button>
  <button @click="getJson('https://jsonplaceholder.typicode.com/posts')">
    getJSON
  </button>
</template>
