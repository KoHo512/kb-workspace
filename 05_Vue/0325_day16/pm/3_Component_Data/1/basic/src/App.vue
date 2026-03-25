<!-- 컴포넌트에 속성과 이벤트 정의 방법 -->
<!-- 컴포넌트에 속성 정의 => 사용자 정의 속성 -->
<!-- 컴포넌트에 이벤트 정의 => 사용자 정의 이벤트 -->
<!-- 사용자 정의 속성을 이용해 해당 컴포넌트에 원하는 값 전달 가능 -->
<!-- UserProfile 컴포넌트의 name, age 속성을 정의하고
      UserProfile 컴포넌트로 사용자 정의 속성(name, age)의 값 전달 -->

<script>
import UserProfile from './components/UserProfile.vue';
export default {
  components: {
    UserProfile,
  },
  data() {
    return {
      name: '김철수',
      age: 30,
    };
  },
};
</script>

<template>
  <!-- 사용자 정의 속성 값 name, age를 UserProfile에게 전달 -->
  <!-- <UserProfile name="김나박" age="20" />  -->
  <!-- <UserProfile :name="`김나박`" :age="20" /> -->
  <UserProfile :name="name" :age="age" />
</template>
