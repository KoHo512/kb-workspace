<template>
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
</template>

<script setup>
// Composition API setup
// No specific script needed for this navigation component itself.
</script>

<style scoped>
/* Component-specific styles if any */
</style>
