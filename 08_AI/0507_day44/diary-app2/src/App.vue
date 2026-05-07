<template>
  <div id="app" class="d-flex flex-column min-vh-100">
    <NavigationMenu />

    <main class="flex-grow-1 py-3">
      <div class="container">
        <router-view></router-view>
      </div>
    </main>

    <footer class="bg-success text-white text-center py-3 mt-auto">
      <div class="container">
        <small>&copy; 2026 일기장 앱. All rights reserved.</small>
      </div>
    </footer>
  </div>
</template>

<script setup>
import NavigationMenu from './components/NavigationMenu.vue';

// Optionally, import your store and load initial data here.
// For example, to load diaries when the app starts:
// import { onMounted } from 'vue';
// import { useDiaryStore } from './stores/diary';
//
// const diaryStore = useDiaryStore();
// onMounted(() => {
//   diaryStore.loadDiaries();
// });
</script>

<style>
/*
  Ensure Bootstrap CSS is loaded.
  If you installed Bootstrap via npm, you might need to import it in src/main.js:
  import 'bootstrap/dist/css/bootstrap.min.css';
  import 'bootstrap/dist/js/bootstrap.bundle.min.js'; // For JS components like collapse, modal

  If using SCSS:
  @import 'bootstrap/scss/bootstrap.scss';
*/

/* FontAwesome 5 should also be available globally if added to the project. */
</style>
