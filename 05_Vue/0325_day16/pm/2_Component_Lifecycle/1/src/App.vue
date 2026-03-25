<script>
import FirstChild from './components/FirstChild.vue';
export default {
  components: {
    FirstChild,
  },
  data() {
    return {
      visible: true,
    };
  },

  // Options API
  beforeCreate() {
    console.log('1 beforeCreate');
  },
  created() {
    console.log('2 created');

    setTimeout(() => {
      this.visible = false;
    }, 3000);
  },
  beforeMount() {
    console.log('3 beforeMount');
  },
  mounted() {
    console.log('4 mounted');
  },
  beforeUpdate() {
    console.log('5 beforeUpdate');
  },
  updated() {
    console.log('6 updated');
  },
};
</script>

<template>
  <FirstChild v-if="visible" />
</template>

<!-- 
1 beforeCreate - App.vue
2 created - App.vue
3 beforeMount - App.vue
4 mounted - App.vue
(3초 뒤)
5 beforeUpdate - App.vue
beforeUnmount - FirstChild.vue
unmounted - FirstChild.vue
6 updated - App.vue
-->
