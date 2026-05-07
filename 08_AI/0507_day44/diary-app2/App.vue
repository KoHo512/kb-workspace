<template>
  <div id="app" class="d-flex flex-column min-vh-100">
    <nav class="navbar navbar-expand-md navbar-dark bg-success">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">
          <i class="fas fa-book-open me-2"></i>일기장
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav me-auto mb-2 mb-md-0">
            <li class="nav-item">
              <router-link to="/" class="nav-link active" aria-current="page">
                <i class="fas fa-list me-2"></i>목록
              </router-link>
            </li>
            <li class="nav-item">
              <router-link to="/create" class="nav-link">
                <i class="fas fa-plus me-2"></i>작성
              </router-link>
            </li>
            <!-- Add links for View/Edit if needed in main nav, or keep in context -->
          </ul>
        </div>
      </div>
    </nav>

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
