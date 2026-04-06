import { defineStore } from 'pinia';
import { computed, reactive } from 'vue';
import axios from 'axios';

export const useTodoListStore = defineStore('todoList', () => {
  const BASEURI = '/api/todos';
  const state = reactive({ todoList: [], isLoading: false });

  const fetchTodoList = async () => {
    state.isLoading = true;

    try {
      const response = await axios.get(BASEURI);

      if (response.status === 200) {
        state.todoList = response.data;
      } else {
        alert('데이터 조회 실패');
      }
    } catch (error) {
      alert('에러 발생 : ' + error);
    }

    state.isLoading = false;
  };

  const addTodo = async ({ todo, desc }, successCallback) => {
    state.isLoading = true;

    try {
      const payload = { todo, desc, done: false };
      const response = await axios.post(BASEURI, payload);

      if (response.status === 201) {
        state.todoList.push(response.data);
        successCallback();
      } else {
        alert('할 일 추가 실패');
      }
    } catch (error) {
      alert('에러 발생 : ' + error);
    }

    state.isLoading = false;
  };

  const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
    state.isLoading = true;

    try {
      const payload = { id, todo, desc, done };
      const response = await axios.post(BASEURI + `/${id}`, payload);

      if (response.status === 200) {
        let index = state.todoList.findIndex((todo) => todo.id === id);
        state.todoList[index] = payload;
        successCallback();
      } else {
        alert('할 일 변경 실패');
      }
    } catch (error) {
      alert('에러 발생 : ' + error);
    }

    state.isLoading = false;
  };

  const deleteTodo = async (id) => {
    state.isLoading = true;

    try {
      const response = await axios.delete(BASEURI + `/${id}`);

      if (response.status === 200) {
        let index = state.todoList.findIndex((todo) => todo.id === id);
        state.todoList.splice(index, 1);
      } else {
        alert('할 일 삭제 실패');
      }
    } catch (error) {
      alert('에러 발생 : ' + error);
    }

    state.isLoading = false;
  };

  const toggleDone = async (id) => {
    state.isLoading = true;

    try {
      let todo = state.todoList.find((todo) => todo.id === id);
      let payload = { ...todo, done: !todo.done };
      const response = await axios.put(BASEURI + `/${id}`, payload);

      if (response.status === 200) {
        todo.done = payload.done;
      } else {
        alert('할 일 완료 변경 실패');
      }
    } catch (error) {
      alert('에러 발생 : ' + error);
    }

    state.isLoading = false;
  };

  const todoList = computed(() => state.todoList);
  const isLoading = computed(() => state.isLoading);
  const doneCount = computed(() => {
    return state.todoList.filter((todo) => todo.done === true).length;
  });

  return {
    // state 정보
    todoList,
    isLoading,
    doneCount,

    // actions 함수
    fetchTodoList,
    addTodo,
    deleteTodo,
    updateTodo,
    toggleDone,
  };
});
