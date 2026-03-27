<template>
  <div>
    X : <input type="text" v-model.number="x" /><br />
    Y : <input type="text" v-model.number="y" /><br />
  </div>
</template>

<script>
// ref - 반응형 데이터를 만드는 함수
import { ref } from 'vue';

export default {
  name: 'Calc',
  setup() {
    // 매개변수로 초기값 설정
    const x = ref(10);
    const y = ref(20);

    console.log(x); // RefImpl {dep: Dep, __v_isRef: true, __v_isShallow: false, _rawValue: 10, _value: 10}
    // 콘솔에서 확인해 보면 Prototype 가지고 있음 - get, set

    // template에서 사용할 변수를 객체로 return
    return { x, y };
  },
};
</script>
