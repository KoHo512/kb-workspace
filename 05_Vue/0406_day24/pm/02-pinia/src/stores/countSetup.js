// 셋업 스토어
import { defineStore } from 'pinia';
import { computed, ref } from 'vue';

export const useCountSetupStore = defineStore('countSetup', () => {
  const num = ref(10);
  const json = ref(null);

  const increment = () => num.value++;

  const getJson = (url) => {
    // 다른 action 호출
    increment();

    fetch(url)
      .then((response) => response.json())
      .then((data) => {
        json.value = data;
      })
      .catch((error) => console.log('getJson error : ', error));
  };

  const doubleNum = computed(() => num.value * 2);

  const doubleNumPlusOne = computed(() => doubleNum.value + 1);

  return { num, doubleNum, doubleNumPlusOne, json, increment, getJson };
});
