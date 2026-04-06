<script setup>
import { useTodoListStore } from '@/stores/todoList';
import { computed, ref } from 'vue';

const todo = ref('');

const todoListStore = useTodoListStore();
// todoList가 참조이기 때문에 분해할당해도 반응성을 잃지 않음
const { todoList, addTodo, deleteTodo, toggleDone } = todoListStore;

// 기본 타입에 대해서는 계산된 속성 다시 작성
const doneCount = computed(() => todoListStore.doneCount);

const addTodoHandler = () => {
  addTodo(todo.value);
  todo.value = '';
};
</script>

<template>
  <div>
    <h2>TodoList 테스트 (Composition API)</h2>
    <hr />
    할 일 추가 :
    <input type="text" v-model="todo" />
    <button @click="addTodoHandler">추가</button>
    <hr />
    <ul>
      <li v-for="todoItem in todoList">
        <span style="cursor: pointer" @click="toggleDone(todoItem.id)"
          >{{ todoItem.todo }}{{ todoItem.done ? ' (완료)' : '' }}</span
        >
        &nbsp;
        <button @click="deleteTodo(todoItem.id)">삭제</button>
      </li>
    </ul>
    <div>완료된 할 일 수 : {{ doneCount }}</div>
  </div>
</template>
