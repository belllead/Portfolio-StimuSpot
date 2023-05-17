<template>
  <div>
    <header-nav></header-nav>
    <h2>유저</h2>
    <router-link :to="{ name: 'UserLogin' }">로그인</router-link> |
    <router-link :to="{ name: 'UserRegist' }">회원가입</router-link> |
    <router-link :to="{ name: 'UserDetail' }">상세</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue";

export default {
  name: "UserView",
  components: { HeaderNav },
};
</script>

<style></style>
