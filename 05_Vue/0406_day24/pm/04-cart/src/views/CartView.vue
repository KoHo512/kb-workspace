<template>
  <h1>장바구니 목록</h1>
  <RouterLink to="/">메인</RouterLink>
  <ul>
    <CartItem
      v-for="cartItem in cartItemList"
      :key="cartItem.id"
      :cartItem="cartItem"
    />
  </ul>
</template>

<script setup>
import CartItem from '@/components/CartItem.vue';
import { useCartStore } from '@/stores/cart';
import { computed } from 'vue';
import { RouterLink } from 'vue-router';

const cartStore = useCartStore();
const cartItemList = computed(() => cartStore.cartItemList);
</script>
