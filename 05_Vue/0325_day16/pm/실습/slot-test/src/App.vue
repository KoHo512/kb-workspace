<script>
import NoSlotTest from './components/NoSlotTest.vue';
import SlotTest from './components/SlotTest.vue';

export default {
  name: 'App',
  components: { NoSlotTest, SlotTest },
};
</script>

<template>
  <div>
    <NoSlotTest />
    <SlotTest />
  </div>
</template>
