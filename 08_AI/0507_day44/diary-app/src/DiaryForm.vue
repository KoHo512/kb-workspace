<script setup>
import { ref } from 'vue';
import { useDiaryStore } from '@/stores/diary';

const diaryStore = useDiaryStore();
const newDiaryContent = ref('');

function addDiary() {
  if (newDiaryContent.value.trim()) {
    diaryStore.addDiary(newDiaryContent.value.trim());
    newDiaryContent.value = ''; // Clear the input after adding
  }
}
</script>

<template>
  <div class="card shadow-sm">
    <div class="card-body">
      <h2 class="card-title h4 mb-4">
        <i class="fas fa-pen-nib text-secondary me-2"></i>New Diary Entry
      </h2>
      <div class="mb-3">
        <label for="diaryContent" class="form-label">
          <i class="fas fa-comment-dots me-1"></i>What's on your mind?
        </label>
        <textarea
          id="diaryContent"
          class="form-control"
          v-model="newDiaryContent"
          placeholder="Write your diary here..."
          rows="4"
        ></textarea>
      </div>
      <div class="text-end">
        <button class="btn btn-primary" @click="addDiary">
          <i class="fas fa-plus-circle me-1"></i>Add Diary
        </button>
      </div>
    </div>
  </div>
</template>

<style scoped>
/* Removed custom styles to prefer Bootstrap */
</style>
