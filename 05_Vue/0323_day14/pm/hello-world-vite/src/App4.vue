<!-- 데이터 결합을 통한 사용자 입력 처리 예제 -->
<!-- v-model, v-vind 컴포넌트에서 선언한 변수와 HTML 태그의 속성을 결합 -->
<!-- v-vind 디렉티브는 템플릿 통해 변수값 변경 불가능
    v-model은 템플릿을 통해 변수값 변경 가능 -->

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
    const abbr = ref('WWW');
    const normal = ref('Word Wide Web');
    return {
      abbr,
      normal,
    };
  },
};
</script>
