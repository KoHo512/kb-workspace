import { createRouter, createWebHistory } from 'vue-router'
import DiaryListPage from '../views/DiaryListPage.vue'
import CreateDiaryPage from '../views/CreateDiaryPage.vue'
import EditDiaryPage from '../views/EditDiaryPage.vue'
import ViewDiaryPage from '../views/ViewDiaryPage.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'diaryList',
      component: DiaryListPage,
      meta: { requiresAuth: true } // Example meta field if authentication is needed
    },
    {
      path: '/create',
      name: 'createDiary',
      component: CreateDiaryPage,
      meta: { requiresAuth: true }
    },
    {
      path: '/edit/:id',
      name: 'editDiary',
      component: EditDiaryPage,
      props: true, // Pass route params as props
      meta: { requiresAuth: true }
    },
    {
      path: '/view/:id',
      name: 'viewDiary',
      component: ViewDiaryPage,
      props: true, // Pass route params as props
      meta: { requiresAuth: true }
    },
    // Add a catch-all for 404 or redirect if needed
    // { path: '/:pathMatch(.*)*', name: 'NotFound', component: NotFoundPage }
  ],
})

export default router
