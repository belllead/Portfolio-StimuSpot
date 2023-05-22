<template>
  <header>
    <img src="@/assets/logo.png" alt="logo" height="20px" />
    <router-link to="/">Home</router-link> |
    <router-link to="/user">User</router-link> |
    <router-link to="/main">main</router-link> |
    <router-link to="/achievement">achievement</router-link> |
    <router-link to="/board">board</router-link> |
    <router-link to="/calendar">calendar</router-link> |
    <router-link to="/part-ranking">part-ranking</router-link> |||
    <button>로그아웃</button>
    <span>프사</span>
  </header>
</template>

<script>
export default {
  name: "HeaderNav",
};
</script>

<style></style>
