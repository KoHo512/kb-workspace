<template>
  <div :class="this.$style.child">
    <h2>Child3</h2>
  </div>
</template>

<script>
export default {
  name: 'Child3',
  created() {
    console.log(this.$style); // {child: '_child_1gqjj_3'}
  },
};
</script>

<style module>
.child {
  background-color: orange;
  border: solid 1px black;
  margin: 1.5rem;
  padding: 1rem;
}
</style>
