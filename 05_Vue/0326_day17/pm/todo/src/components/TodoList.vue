<script>
export default {
  name: 'TodoList',
  props: ['computedTodo'],
  emits: ['update-completed', 'delete-todo'],
  methods: {
    updateCompleted(id) {
      this.$emit('update-completed', id);
    },
    deleteTodo(id) {
      this.$emit('delete-todo', id);
    },
  },
};
</script>

<template>
  <div class="todo__list">
    <!-- 할 일 목록이 있을 때 (완료 시 .todo__item--completed 클래스 추가 )-->
    <div
      class="todo__item"
      v-for="todo in computedTodo"
      :class="{ 'todo__item--completed': todo.completed }"
    >
      <input
        type="checkbox"
        :id="todo.id"
        @change="updateCompleted(todo.id)"
        :checked="todo.completed"
      />
      <label :for="todo.id" class="todo__checkbox-label">
        <span class="todo__item-text">{{ todo.msg }}</span>
      </label>
      <span
        class="material-symbols-outlined todo__delete-icon"
        @click="deleteTodo(todo.id)"
      >
        delete
      </span>
    </div>
    <!-- 할 일 목록이 없을 때 -->
    <div class="todo__item--no" v-if="computedTodo.length === 0">
      <p>할일 목록이 없습니다.</p>
    </div>
  </div>
</template>
