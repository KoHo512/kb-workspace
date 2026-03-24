<template>
  <div>
    <h2>관심있는 K-POP 가수</h2>
    <ul>
      <CheckboxItem v-for="idol in idols" :key="idol.id" :idol="idol" />
    </ul>
  </div>
</template>

<script>
import CheckboxItem from './components/CheckboxItem2.vue';

export default {
  name: 'App',
  components: { CheckboxItem }, // 지역 컴포넌트
  data() {
    return {
      idols: [
        { id: 1, name: 'NMIXX', checked: true },
        { id: 2, name: 'REDVELVET', checked: false },
        { id: 3, name: 'IVE', checked: false },
        { id: 4, name: 'WJSN', checked: false },
      ],
    };
  },
};
</script>
