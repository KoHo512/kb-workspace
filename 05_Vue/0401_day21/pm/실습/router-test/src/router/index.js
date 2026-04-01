import { createRouter, createWebHistory } from 'vue-router';

import Home from '../pages/Home.vue';
import About from '../pages/About.vue';
import Members from '../pages/Members.vue';
import Videos from '../pages/Videos.vue';

// 라우터 객체 생성
const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/', // URL
      name: 'home', // 라우터 이름
      component: Home, // 연결할 Vue 컴포넌트
    },
    {
      path: '/about',
      name: 'about',
      component: About,
    },
    {
      path: '/members',
      name: 'members',
      component: Members,
    },
    {
      path: '/videos',
      name: 'videos',
      component: Videos,
    },
  ],
});

export default router;
