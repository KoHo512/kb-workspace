<template>
  <li>
    <span>{{ item.name }}</span>
    <span>{{ item.price }}원</span>
    <button @click="addCart(item.id)">담기</button>
  </li>
</template>

<script setup>
import { useCartStore } from '@/stores/cart';

defineProps({
  item: { Type: Object, required: true },
});

const cartStore = useCartStore();
const { addCart } = cartStore;
</script>

<style scoped>
span {
  padding-right: 5px;
}
</style>
