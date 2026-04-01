import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';

// 라우트 구성 객체
const router = createRouter({
  // 뷰 라우터의 히스토리 관리 방식 정의
  history: createWebHistory(),

  // 어플리케이션의 경로와 해당 경로에 렌더링될 컴포넌트 매칭
  routes: [
    {
      path: '', // 필수
      name: 'home', // 선택 (권장)
      component: HomeView, // 필수
    },

    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue'),
    },
  ],
});
export default router;
