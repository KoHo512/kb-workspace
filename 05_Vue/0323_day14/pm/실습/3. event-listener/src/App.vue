<!--  이벤트 리스너를 이용한 사용자 입력 처리 
  HTML 태그가 발생시키는 이벤트를 캡쳐하여 지정된 스크립트를 수행하거나
  함수를 호출위해서 v-on 디렉티브를 사용한다. 
  사용자가 버튼을 클릭했들때 click 이벤트를 발생한다. 
  발생한 이벤트를 캡쳐하기 위해 두가지 방식으로 가능하다

  1) v-on:click = "스크립트 코드 또는 함수 호출"
  2) @click = "스크립트 코드 또는 함수 호출"
  -->

<template>
  <p>{{ counter + counter2 }}</p>
  <!-- counter변수를 직접 참조하여 숫자를 증가 -->
  <button @click="counter++">클릭하면 숫자가 올라갑니다.</button>
  <!-- onClick함수를 호출 -->
  <button @click="onClick2">클릭하면 숫자가 올라갑니다.</button>
</template>

<script>
import { ref } from 'vue';

export default {
  data() {
    return {
      counter2: 0,
    };
  },
  setup() {
    // ref함수를 통해 선언된 변수는 프록시객체로 변환되어 관리된다.
    let counter = ref(0);

    const onClick = (evt) => {
      if (evt) {
        evt.preventDefault();
        counter.value++;
      }
    };
    return {
      counter,
      onClick,
    };
  },
  methods: {
    onClick2: function (evt) {
      if (evt) {
        evt.preventDefault();
      }
      this.counter2++;
    },
  },
};
</script>
