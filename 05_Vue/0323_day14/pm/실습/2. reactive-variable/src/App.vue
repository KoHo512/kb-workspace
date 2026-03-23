<!-- 데이터 결합을 통한 사용자 입력 처리 예제
    v-model , v-bind 컴포넌트에서 선언한 변수와 HTML태그의 속성을 결합 
    v-bind디렉티브는 템플릿을 통해서 변수값을 변경시킬 수 없다
    v-model 템플릿을 통해 변수의 값을 변경시킬 수 있다. 
-->
<template>
  <p>줄임말과 원래말을 입력하세요.</p>
  <input type="text" v-bind:value="abbr" />
  <input type="text" v-model="normal" />
  <hr />
  <abbr v-bind:title="normal">{{ abbr }}</abbr>
</template>

<script>
import { ref } from 'vue';

export default {
  // Composition API
  setup() {
    const abbr = ref('KB');
    const normal = ref('World Wide Web');
    return {
      abbr,
      normal,
    };
  },
};
</script>
