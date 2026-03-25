<!-- Vue에서는 HTML에서 지원하지 않는 ref 속성 지원 -->
<!-- ref 속성은 문서 객체(DOM)를 참조할 때와 컴포넌트를 참조할 때 사용 -->

<script>
// // JavaScript에서는 이렇게 접근 - Vue에서는 이렇게 접근할 수 X
// const doc = document.querySelector('h1');
// const txt = doc.innerText;
// console.log(txt);

export default {
  data() {
    return {
      num: 5,
    };
  },
  computed: {
    doubleNum() {
      return this.num * 2;
    },
  },
  methods: {
    increment() {
      this.num++;
    },
  },
  // // Vue에서는 이렇게 접근
  // mounted() {
  //   const doc = document.querySelector('h1');
  //   const txt = doc.innerText;
  //   console.log(txt);
  // },
};
</script>

<template>
  <h1>{{ num }}</h1>
</template>
