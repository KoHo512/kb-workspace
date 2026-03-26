<!-- 여러 개의 컴포넌트가 자신의 기능을 수행하도록 구조화 -->
<!-- 관리자 : App.vue -->

<!--  TodoInput -->
<!-- 1. App 컴포넌트는 methods 옵션을 이용해 addTodo라는 기능을 정의
      - 매개변수로 todo를 받는 기능 -->
<!-- 2. 입력 받은 텍스트를 사용해 할 일 목록 구성할 객체 데이터 생성
      - 할 일 목록 객체는 id(고유값), 입력된 할 일(msg), 할 일 완료 여부(completed)
        { id: 1, msg: '운동하기', completed: false } -->
<!-- 3. 할 일 목록 데이터를 관리하기 위한 자료구조 정의 => todos : [] -->
<!-- 4. 할 일 목록 객체 데이터를 todo 데이터 추가 => todos.push() -->
<!-- 5. methods 옵션 속성으로 정의한 addTodo() 함수를 
        v-on 디렉티브를 사용해 TodoInput 컴포넌트에 전달
        전달한 이벤트는 TodoInput 컴포넌트에서 $emit() 함수로 실행 -->

<!-- 할 일 목록 필터링 (TodoHeader) -->
<!-- 1. 현재 목록 상태를 관리할 수 있는 데이터 정의 : current
      - 전체가 기본값 - current 데이터의 초기값은 'all' -->

<script>
import TodoHeader from './components/TodoHeader.vue';
import TodoInput from './components/TodoInput.vue';
import TodoList from './components/TodoList.vue';

export default {
  components: {
    TodoHeader,
    TodoList,
    TodoInput,
  },
  data() {
    return {
      todos: [],
      current: 'all',
    };
  },
  methods: {
    addTodo(inputMsg) {
      const item = {
        id: Math.random(),
        msg: inputMsg,
        completed: false,
      };
      this.todos.push(item);
    },
    updateTab(tab) {
      this.current = tab;
    },
    updateCompleted(id) {
      const idx = this.todos.findIndex((todo) => todo.id === id);
      this.todos[idx].completed = !this.todos[idx].completed;
    },
    deleteTodo(id) {
      const idx = this.todos.findIndex((todo) => todo.id === id);
      this.todos.splice(idx, 1);
    },
  },
  computed: {
    computedTodo() {
      if (this.current === 'completed') {
        return this.todos.filter((todo) => todo.completed);
      } else {
        return this.todos;
      }
    },
  },
};
</script>

<template>
  <div class="todo">
    <TodoHeader :current="current" @update-tab="updateTab" />
    <TodoList
      :computed-todo="computedTodo"
      @update-completed="updateCompleted"
      @delete-todo="deleteTodo"
    />
    <TodoInput @add-todo="addTodo" />
  </div>
</template>
