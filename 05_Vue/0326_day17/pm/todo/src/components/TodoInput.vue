<!-- 필요한 기능 -->
<!-- 입력창에 할 일을 입력한 후 enter를 누르거나 등록 버튼을 클릭하면 입력한 내용이 저장되어야 함 -->
<!-- 1. 사용자가 어떤 값을 입력했는지 알기 위해서는 데이터 정의해야 함 -->
<!-- 2. v-model 디렉티브 입력창과 양방향 데이터 바인딩 처리해야 함 -->
<!-- 3. 입력창에서 enter나 등록 버튼을 클릭하면 사용자가 어떤 값을 입력했는지 확인할 수 있도록 이벤트 등록 -->

<script>
export default {
  name: 'TodoInput',
  data() {
    return {
      inputMsg: '', // 입력 todo 데이터 정의
    };
  },
  emits: ['add-todo'],
  methods: {
    addTodo() {
      this.$emit('add-todo', this.inputMsg);
      this.inputMsg = '';
    },
  },
};
</script>

<template>
  <div class="todo__input">
    <!-- 정의한 inputMsg를 양방향 데이터 바인딩 -->
    <input
      v-model="inputMsg"
      type="text"
      class="todo__input-text"
      placeholder="할 일을 입력하세요."
      @keydown.enter="addTodo"
    />
    <button class="todo__input-btn" @click="addTodo">등록</button>
  </div>
</template>
