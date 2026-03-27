<template>
  <div>
    X : <input type="text" v-model.number="x" /><br />
    Y : <input type="text" v-model.number="y" /><br />
    <button @click="calcAdd">계산</button>
    <div>결과 : {{ result }}</div>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  name: 'Calc2',
  setup() {
    // x = 20 처럼 대입하면 반응성 사라짐 - 이런 대입을 막기 위해 const 선언 (권장)
    const x = ref(10);
    const y = ref(20);
    const result = ref(30);

    const calcAdd = () => {
      // .value 를 통해 접근해야함
      result.value = x.value + y.value;
    };

    return { x, y, result, calcAdd };
  },
};
</script>
