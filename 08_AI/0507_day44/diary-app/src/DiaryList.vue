<script setup>
import { useDiaryStore } from '@/stores/diary';

const diaryStore = useDiaryStore();
const diaries = diaryStore.diaries; // Get the reactive ref from the store

function deleteDiary(id) {
  diaryStore.deleteDiary(id);
}
</script>

<template>
  <div>
    <h2 class="h4 mb-4">
      <i class="fas fa-th-list text-secondary me-2"></i>My Diaries
    </h2>
    <div v-if="diaries.length > 0">
      <div v-for="diary in diaries" :key="diary.id" class="card mb-3 shadow-sm border-0 bg-light">
        <div class="card-body">
          <p class="card-text">{{ diary.content }}</p>
          <div class="d-flex justify-content-between align-items-center mt-3">
            <small class="text-muted">
              <i class="far fa-calendar-alt me-1"></i>{{ new Date(diary.createdAt).toLocaleString() }}
            </small>
            <button class="btn btn-outline-danger btn-sm" @click="deleteDiary(diary.id)">
              <i class="fas fa-trash-alt me-1"></i>Delete
            </button>
          </div>
        </div>
      </div>
    </div>
    <div v-else class="alert alert-info text-center py-4">
      <i class="fas fa-info-circle me-2"></i>No diaries yet. Add one!
    </div>
  </div>
</template>

<style scoped>
/* Removed custom styles to prefer Bootstrap */
</style>
