<template>
  <h1>메인 페이지</h1>
  <RouterLink to="/cart">장바구니</RouterLink>
  <ul>
    <Item v-for="item in itemList" :key="item.id" :item="item" />
  </ul>
</template>

<script setup>
import { computed } from 'vue';
import { RouterLink } from 'vue-router';
import { useCartStore } from '@/stores/cart';
import Item from '@/components/Item.vue';

const cartStore = useCartStore();
const itemList = computed(() => cartStore.itemList);
</script>
