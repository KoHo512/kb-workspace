<script>
import UserProfile from './components/UserProfile.vue';
export default {
  components: { UserProfile },
  methods: {
    printHello() {
      alert('Hello');
    },
  },
};
</script>

<template>
  <UserProfile @print-hello="printHello" />
</template>
