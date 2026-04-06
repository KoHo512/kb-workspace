<template>
  <li>
    <span>{{ item.name }}</span>
    <span>{{ item.price }}원</span>
    <span>({{ cartItem.key }}개)</span>
    <button @click="outCart(cartItem.id)">삭제</button>
  </li>
</template>

<script setup>
import { useCartStore } from '@/stores/cart';
import { computed } from 'vue';

defineProps({
  cartItem: { Type: Object, required: true },
});

const cartStore = useCartStore();
const itemList = computed(() => cartStore.itemList);

const { outCart } = cartStore;
</script>

<style scoped>
span {
  padding-right: 5px;
}
</style>
