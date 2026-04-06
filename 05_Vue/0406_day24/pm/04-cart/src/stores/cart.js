import { defineStore } from 'pinia';
import { computed, reactive } from 'vue';

export const useCartStore = defineStore('cart', () => {
  const state = reactive({
    itemList: [
      { id: 1, name: 'apple', price: 2000 },
      { id: 2, name: 'banana', price: 1000 },
      { id: 3, name: 'orange', price: 3000 },
    ],
    cartItemList: {},
  });

  const itemList = computed(() => state.itemList);
  const cartItemList = computed(() => state.cartItemList);

  const addCart = (id) => {
    state.cartItemList[id] = (state.cartItemList[id] ?? 0) + 1;
    // console.log(state.cartItemList);
  };

  const outCart = (id) => {
    let index = state.cartItemList.findIndex((itemList) => itemList.id === id);
    state.cartItemList.splice(index, 1);
  };

  const clearCart = () => {
    state.cartItemList = [];
  };

  return { itemList, cartItemList, addCart, outCart, clearCart };
});
