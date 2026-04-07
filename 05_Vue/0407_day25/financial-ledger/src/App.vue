<script setup>
import { RouterLink, RouterView } from 'vue-router';
</script>

<template>
  <nav>
    <RouterLink to="/dashboard">대시보드</RouterLink>
    <RouterLink to="/transaction">거래 내역</RouterLink>
    <RouterLink to="/settings">설정</RouterLink>
  </nav>
  <RouterView />
</template>

<style scoped></style>
