// URI 경로와 컴포넌트를 연결하는 라우터 설정 파일
// Vue 라우터는 사용자가 들어온 주소에 따라 어떤 페이지 컴포넌트를 RouterView에 보여줄지 결정

// 1. Vue 라우터 생성에 필요한 함수 가져오기
import HomeView from '@/views/HomeView.vue';
import { createRouter, createWebHistory } from 'vue-router';

// 2. Router 객체 생성
const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('@/views/AboutView.vue'),
    },
  ],
});

// 3. main.js에서 사용할 수 있도록 외부로 내보내기
export default router;
