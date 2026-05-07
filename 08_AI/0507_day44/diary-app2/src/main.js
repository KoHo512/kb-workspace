import { createApp } from 'vue';
import { createPinia } from 'pinia';
import App from './App.vue'; // src/App.vue 를 올바르게 임포트
import router from './router'; // src/router/index.js 를 올바르게 임포트

// Import Bootstrap CSS and JS
// Ensure you have installed bootstrap: npm install bootstrap
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

const app = createApp(App);

app.use(createPinia());
app.use(router);

// If you're using FontAwesome 5, ensure it's loaded globally
// e.g., by including its CDN link in your index.html or importing it here
// import '@fortawesome/fontawesome-free/css/all.css'; // Example if using npm package

app.mount('#app');
