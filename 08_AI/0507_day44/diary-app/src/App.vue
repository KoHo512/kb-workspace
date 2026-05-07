<script setup>
import { ref } from 'vue';
import DiaryForm from './DiaryForm.vue'; // Import the DiaryForm component
import DiaryList from './DiaryList.vue'; // Import the DiaryList component

// You can manage any app-level state here if needed, e.g.,
// const appTitle = ref('My Diary App');
</script>

<template>
  <div class="app-wrapper min-vh-100 py-5">
    <div class="container">
      <header class="text-center mb-5">
        <h1 class="display-4 fw-bold title-text">
          <i class="fas fa-leaf me-2"></i>My Diary App
        </h1>
        <p class="text-muted small-text">Fresh thoughts for a fresh day.</p>
      </header>
      
      <div class="row justify-content-center">
        <div class="col-lg-7 col-md-9">
          <section class="mb-5">
            <DiaryForm />
          </section>
          
          <div class="divider mb-5">
            <span><i class="fas fa-seedling mx-2 text-green-main"></i></span>
          </div>
          
          <section>
            <DiaryList />
          </section>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
/* Global body styles for the fresh green theme */
body {
  margin: 0;
  background-color: #f0f7f4; /* Light mint background */
  font-family: 'Nanum Gothic', sans-serif;
  color: #34495e;
}

.app-wrapper {
  background: linear-gradient(135deg, #f0f7f4 0%, #dcf0e3 100%);
}

.title-text {
  color: #2d5a27; /* Forest green */
  text-shadow: 1px 1px 2px rgba(0,0,0,0.05);
}

.text-green-main {
  color: #51cf66;
}

.divider {
  display: flex;
  align-items: center;
  text-align: center;
  color: #ccdcd2;
}

.divider::before,
.divider::after {
  content: '';
  flex: 1;
  border-bottom: 1px dashed #ccdcd2;
}

.divider span {
  padding: 0 10px;
}

/* Card customization for a softer look */
.card {
  border: none !important;
  border-radius: 15px !important;
  background-color: rgba(255, 255, 255, 0.85) !important;
  backdrop-filter: blur(5px);
}

.btn-primary {
  background-color: #51cf66 !important; /* Fresh green */
  border-color: #51cf66 !important;
  color: white !important;
  font-weight: bold !important;
}

.btn-primary:hover {
  background-color: #40c057 !important;
  border-color: #40c057 !important;
}

.btn-outline-danger {
  color: #ff8787 !important;
  border-color: #ff8787 !important;
}

.btn-outline-danger:hover {
  background-color: #ff8787 !important;
  color: white !important;
}
</style>
