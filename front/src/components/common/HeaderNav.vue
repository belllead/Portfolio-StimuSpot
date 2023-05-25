<template>
  <div class="container">
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Exo&family=Noto+Sans+KR:wght@100;400;600;800&display=swap"
      rel="stylesheet"
    />
    <header>
      <logo-static-stroke class="logo" />
      <!-- <router-link to="/" class="nav-btn">Home</router-link>
    <router-link to="/user" class="nav-btn">User</router-link> -->

      <router-link to="/main" class="nav-btn">Dashboard</router-link>
      <router-link to="/calendar" class="nav-btn">Diary</router-link>
      <router-link to="/board" class="nav-btn">Board</router-link>
      <router-link to="/achievement" class="nav-btn">Achievement</router-link>
      <router-link to="/part-ranking" class="nav-btn">Part Ranking</router-link>
    </header>
    <footer>
      <div class="profile-img"></div>
      <span class="text-btn" @click="logout">OOO님 안녕하세요!</span>
    </footer>
  </div>
</template>

<script>
import LogoStaticStroke from "../ui-element/LogoStaticStroke.vue";

export default {
  name: "HeaderNav",
  components: { LogoStaticStroke },
  methods: {
    logout() {
      sessionStorage.removeItem("access-token");
      this.$store.commit("USER_LOGOUT");
      this.$router.push("/");
    },
  },
};
</script>

<style scoped>
.container {
  position: absolute;
  left: 0px;
  top: 0px;
  background-color: #373737;
  height: 100vh;
  width: 370px;
  z-index: -1;
}

header {
  display: flex;
  flex-direction: column;
  text-align: left;

  margin-left: 5em;
  margin-top: 2.5em;
  font-size: 1.2em;
}

.logo {
  width: 160px;
  height: 30px;
  margin-left: -1.5em;
  margin-bottom: 2em;
}

.nav-btn {
  text-decoration: none;
  color: white;
  font-size: 1em;
  font-family: "Exo", sans-serif;
  margin: 3em 0 0;
}

.nav-btn:hover {
  font-weight: 600;
}

footer {
  position: absolute;
  bottom: 2em;
  display: flex;
  align-items: center;
  margin-left: 3.5em;
}

.profile-img {
  width: 2em;
  height: 2em;
  background-color: #e86666;
  border-radius: 0.5em;
}

.text-btn {
  margin-left: 0.5em;
  text-decoration: none;
  color: #a0a0a0;
}
</style>
