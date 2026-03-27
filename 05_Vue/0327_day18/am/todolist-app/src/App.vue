<script setup>
import { reactive, onMounted } from 'vue';
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';

const ts = new Date().getTime();
const state = reactive({ todoList: [] });

// state.todoList로 접근하지 않고 바로 todoList로 접근할 수 있게
// const todoList = reactive([])
// 라고 선언해서 사용한다면?
//
// 배열을 교체해야 할 때 (서버에서 새로운 데이터를 전달받았을 때 등) : newArr
// todoList = newArr;
// 라고 하면 반응성 사라지기 때문에 const로 선언해서 불가능
// => 배열을 clear한 다음 newArr의 데이터를 하나하나 push해야함
//
// const state = reactive({ todoList: [] });
// 라고 선언하면 todoList는 state의 멤버이기 때문에
// state.todoList = newArr;
// 를 통해 배열 교체가 가능 - 페이지 이동 등의 작업에서 편리하게 작업하기 위해!
//
// 아니면 ref()로 선언한다면
// const todoList = ref({ todoList: [] });
// todoList.value = newArr;
// 를 통해 교체 가능

onMounted(() => {
  state.todoList.push({ id: ts, todo: '할 일1', completed: false });
  state.todoList.push({ id: ts + 1, todo: '할 일2', completed: true });
  state.todoList.push({ id: ts + 2, todo: '할 일3', completed: false });
  state.todoList.push({ id: ts + 3, todo: '할 일4', completed: false });
});

const addTodo = (todo) => {
  if (todo.length >= 2) {
    state.todoList.push({
      id: new Date().getTime(),
      todo: todo,
      completed: false,
    });
  }
};

const deleteTodo = (id) => {
  let index = state.todoList.findIndex((item) => id === item.id);
  state.todoList.splice(index, 1);
};

const toggleCompleted = (id) => {
  let index = state.todoList.findIndex((item) => id === item.id);
  state.todoList[index].completed = !state.todoList[index].completed;
};
</script>

<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div class="title">:: Todolist App ::</div>
    </div>
    <div class="card card-default card-borderless">
      <div class="card-body">
        <InputTodo @add-todo="addTodo" />
        <TodoList
          :todoList="state.todoList"
          @delete-todo="deleteTodo"
          @toggle-completed="toggleCompleted"
        />
      </div>
    </div>
  </div>
</template>
