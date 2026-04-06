import { defineStore } from 'pinia';
import { computed, reactive } from 'vue';

export const useTodoListStore = defineStore('todoList', () => {
  // state
  const state = reactive({
    todoList: [
      { id: 1, todo: 'ES6 학습', done: false },
      { id: 2, todo: 'React 학습', done: false },
      { id: 3, todo: 'Context API 학습', done: true },
      { id: 4, todo: '야구 경기 관람', done: false },
    ],
  });

  // actions
  const addTodo = (todo) => {
    state.todoList.push({ id: new Date().getTime(), todo, done: false });
  };

  const deleteTodo = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList.splice(index, 1);
  };

  const toggleDone = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList[index].done = !state.todoList[index].done;
  };

  // computed data - 읽기 전용
  const doneCount = computed(() => {
    return state.todoList.filter((todo) => todo.done === true).length;
  });

  const todoList = computed(() => state.todoList); // state를 그대로 노출하면 X

  // 데이터는 반드시 읽기 전용으로 노출
  return { todoList, doneCount, addTodo, deleteTodo, toggleDone };
});
