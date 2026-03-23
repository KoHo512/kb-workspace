<script>
export default {
  data() {
    return {
      createdWidth: 0,
      mountedWidth: 0,
    };
  },
  created() {
    // TODO: box width 측정 시도
    console.log('created : ', this.$refs.box); // undefined
    this.createdWidth = this.$refs.box ? this.$refs.box.offsetWidth : 0;
  },
  mounted() {
    // TODO: box width 측정
    console.log('mounted : ', this.$refs.box); // <div style=​"width:​ 200px;​ height:​ 100px;​ background:​ yellowgreen;​ margin:​ 0px auto;​">​</div>​
    this.mountedWidth = this.$refs.box ? this.$refs.box.offsetWidth : 0;
  },
};
</script>

<template>
  <div>
    <h2>박스 너비 측정</h2>
    <div
      ref="box"
      style="
        width: 200px;
        height: 100px;
        background: yellowgreen;
        margin: 0 auto;
      "
    ></div>
    <p>created 결과: {{ createdWidth }}</p>
    <p>mounted 결과: {{ mountedWidth }}</p>
  </div>
</template>
