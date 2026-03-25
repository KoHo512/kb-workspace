<script>
export default {
  props: ['name', 'age'], // 사용자 정의 속성인 name, age 값을 받음
  created() {
    console.log(typeof this.name);
    console.log(typeof this.age); // 기본값으로 전달하면 string, v-vind 이용하면 number
  },
};
</script>

<template>
  <p>이름 : {{ name }}</p>
  <p>나이 : {{ age }}</p>
</template>
