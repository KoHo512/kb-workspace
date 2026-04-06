<script>
import { mapActions, mapState } from 'pinia';
import { useCountSetupStore } from '@/stores/countSetup';

export default {
  computed: {
    ...mapState(useCountSetupStore, {
      num: 'num',
      doubleNum: 'doubleNum',
    }),
  },
  methods: {
    ...mapActions(useCountSetupStore, ['increment', 'getJson']),
  },
};

// const setupStore = useCountSetupStore();

// console.log(setupStore.num);
// console.log(setupStore.doubleNum);
// console.log(setupStore.increment());
// setupStore.getJson('https://jsonplaceholder.typicode.com/posts');
</script>

<template>
  <h1>Home View</h1>
  <h2>num: {{ num }}</h2>
  <h2>doubleNum: {{ doubleNum }}</h2>

  <button @click="increment">increment</button>
  <button @click="getJson('https://jsonplaceholder.typicode.com/posts')">
    getJSON
  </button>
</template>
