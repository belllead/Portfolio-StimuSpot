<template>
  <div class="container">
    <header-nav></header-nav>

    <div class="text-center">
      <h1>{{ message }}</h1>
      <router-link to="/user">시작하기</router-link>
    </div>
    <br />
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue";

export default {
  name: "HomeView",
  data() {
    return {
      message: "종서의 러브러브 다이어리",
    };
  },
  components: { HeaderNav },
};
</script>
<style>
.text-center {
  text-align: center;
}
</style>
