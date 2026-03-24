<script>
export default {
  data() {
    return {
      output: '',
      cur: '',
      prev: '',
      operator: '',
      error: '',
    };
  },
  methods: {
    operation(e) {
      this.clearError();

      const n = e.currentTarget.value;

      if (this.isOperator(n)) this.handleOperator(n);
      else this.handleNumberInput(n);

      this.output = this.prev + this.operator + this.cur;
    },
    clear() {
      this.output = '';
      this.cur = '';
      this.prev = '';
      this.operator = '';
      this.clearError();
    },
    isOperator(n) {
      return ['+', '-', '*', '/'].includes(n);
    },
    setError(message) {
      this.clear();
      this.error = message;
    },
    clearError() {
      this.error = '';
    },
    handleNumberInput(n) {
      if (n === '.' && this.cur.includes('.')) {
        return;
      }
      this.cur += n;
    },
    handleOperator(n) {
      if (this.prev !== '') {
        this.calculate();
      }
      this.operator = n;
      this.prev = this.cur;
      this.cur = '';
    },
    calculate() {
      let result = 0;
      let left = Number(this.prev);
      let right = Number(this.cur);

      if (this.operator === '+') {
        result = left + right;
      } else if (this.operator === '-') {
        result = left - right;
      } else if (this.operator === '*') {
        result = left * right;
      } else if (this.operator === '/') {
        if (right == 0) {
          this.setError('0으로 나눌 수 없음');
          return;
        } else {
          result = left / right;
        }
      }

      this.clear();
      this.output = String(result);
      this.cur = String(result);
    },
  },
};
</script>

<template>
  <div class="calculator">
    <form name="forms">
      <input type="text" :value="error || output" name="output" readonly />
      <input type="button" @click="clear" class="clear" value="C" />
      <input type="button" @click="operation" class="operator" value="/" />
      <input type="button" @click="operation" value="1" />
      <input type="button" @click="operation" value="2" />
      <input type="button" @click="operation" value="3" />
      <input type="button" @click="operation" class="operator" value="*" />
      <input type="button" @click="operation" value="4" />
      <input type="button" @click="operation" value="5" />
      <input type="button" @click="operation" value="6" />
      <input type="button" @click="operation" class="operator" value="+" />
      <input type="button" @click="operation" value="7" />
      <input type="button" @click="operation" value="8" />
      <input type="button" @click="operation" value="9" />
      <input type="button" @click="operation" class="operator" value="-" />
      <input type="button" @click="operation" class="dot" value="." />
      <input type="button" @click="operation" value="0" />
      <input
        type="button"
        @click="calculate"
        class="operator result"
        value="="
      />
    </form>
  </div>
</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  background-color: #ffffff;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.calculator {
  width: 287px;
  border: 1px solid #333;
  background-color: #ccc;
  padding: 5px;
}

.calculator form {
  display: grid;
  grid-template-columns: repeat(4, 65px);
  grid-auto-rows: 65px;
  grid-gap: 5px;
}

.calculator form input {
  border: 2px solid #333;
  cursor: pointer;
  font-size: 19px;
}

.calculator form input:hover {
  box-shadow: 1px 1px 2px #333;
}

.calculator form .clear {
  background-color: #ed4848;
}

.calculator form .operator {
  background-color: orange;
}

.calculator form .dot {
  background-color: green;
}

.calculator form input[type='text'] {
  grid-column: span 4;
  text-align: right;
  padding: 0 10px;
}

.calculator form .clear {
  grid-column: span 3;
}

.calculator form .result {
  grid-column: span 2;
}
</style>
