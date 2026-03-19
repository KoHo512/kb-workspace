// index.html 파일에서 main.js 파일을 불러오면 뷰 애플리케이션의 코드가 실행
// main.js는 뷰 애플리케이션을 초기화하고 구성하는 역할을 하는 파일

// vue 패키지에서 createApp 함수를 가져옴
// createApp 함수는 뷰 애플리케이션 인스턴스를 생성하는 역할 (하나의 인스턴스를 가지고 운영)
import { createApp } from 'vue';
import App from './App.vue';

createApp(App).mount('#app');
