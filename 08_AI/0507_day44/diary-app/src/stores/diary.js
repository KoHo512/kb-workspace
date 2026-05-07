import { ref, watch } from 'vue'
import { defineStore } from 'pinia'

export const useDiaryStore = defineStore('diary', () => {
  const diaries = ref([])

  // 로컬 스토리지에서 데이터 불러오기
  const savedDiaries = localStorage.getItem('diaries')
  if (savedDiaries) {
    diaries.value = JSON.parse(savedDiaries)
  }

  // 데이터가 변경될 때마다 로컬 스토리지에 저장
  watch(
    diaries,
    (newDiaries) => {
      localStorage.setItem('diaries', JSON.stringify(newDiaries))
    },
    { deep: true }
  )

  // 일기 추가
  function addDiary(content) {
    const newDiary = {
      id: Date.now(),
      content,
      createdAt: new Date().toISOString()
    }
    diaries.value.push(newDiary)
  }

  // 일기 삭제
  function deleteDiary(id) {
    diaries.value = diaries.value.filter((diary) => diary.id !== id)
  }

  return {
    diaries,
    addDiary,
    deleteDiary
  }
})
