<template>
  <div class="container">
    <br />
    <div class="text-center">
      <h1>{{ message }}</h1>
      <router-link to="/login">시작하기</router-link>
    </div>
    <br />
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      message: "종서의 러브러브 다이어리",
    };
  },
  components: {},
};
</script>
<style>
.text-center {
  text-align: center;
}
</style>
