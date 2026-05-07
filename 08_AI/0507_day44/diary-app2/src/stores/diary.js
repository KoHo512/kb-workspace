import { defineStore } from 'pinia'
import {
  getDiaries as apiGetDiaries,
  getDiaryById as apiGetDiaryById,
  createDiary as apiCreateDiary,
  updateDiary as apiUpdateDiary,
  deleteDiary as apiDeleteDiary,
} from '../api/diaryApi'

export const useDiaryStore = defineStore('diary', {
  state: () => ({
    diaries: [],
    currentDiary: null,
    loading: false,
    error: null,
  }),
  actions: {
    async loadDiaries() {
      this.loading = true
      this.error = null
      try {
        const data = await apiGetDiaries()
        this.diaries = data
      } catch (err) {
        this.error = 'Failed to load diaries'
        console.error(err)
      } finally {
        this.loading = false
      }
    },
    async loadDiary(id) {
      this.loading = true
      this.error = null
      try {
        const data = await apiGetDiaryById(id)
        this.currentDiary = data
      } catch (err) {
        this.error = 'Failed to load diary'
        console.error(err)
      } finally {
        this.loading = false
      }
    },
    async addDiary(diaryData) {
      this.loading = true
      this.error = null
      try {
        const newDiary = await apiCreateDiary(diaryData)
        // Option 1: Refetch all diaries
        // await this.loadDiaries()
        // Option 2: Add new diary to existing list (more efficient if list is large)
        this.diaries.push(newDiary)
        return newDiary // Return the created diary if needed by the component
      } catch (err) {
        this.error = 'Failed to add diary'
        console.error(err)
      } finally {
        this.loading = false
      }
    },
    async editDiary(diaryData) {
      this.loading = true
      this.error = null
      try {
        const updatedDiary = await apiUpdateDiary(diaryData.id, diaryData)
        const index = this.diaries.findIndex(d => d.id === updatedDiary.id)
        if (index !== -1) {
          this.diaries[index] = updatedDiary
        }
        if (this.currentDiary && this.currentDiary.id === updatedDiary.id) {
          this.currentDiary = updatedDiary
        }
        return updatedDiary // Return the updated diary if needed by the component
      } catch (err) {
        this.error = 'Failed to update diary'
        console.error(err)
      } finally {
        this.loading = false
      }
    },
    async removeDiary(id) {
      this.loading = true
      this.error = null
      try {
        await apiDeleteDiary(id)
        this.diaries = this.diaries.filter(d => d.id !== id)
        if (this.currentDiary && this.currentDiary.id === id) {
          this.currentDiary = null
        }
      } catch (err) {
        this.error = 'Failed to delete diary'
        console.error(err)
      } finally {
        this.loading = false
      }
    },
  },
  getters: {
    getDiariesList: (state) => state.diaries,
    getCurrentDiary: (state) => state.currentDiary,
    getLoadingStatus: (state) => state.loading,
    getErrorStatus: (state) => state.error,
  },
})
