<template>
  <div class="card">
    <fieldset class="input" v-if="!loginUser">
      <h2 class="title">나만의 다이어리</h2>
      <input
        type="text"
        id="id"
        v-model="user.userId"
        placeholder="아이디"
        class="input-window"
      />
      <input
        type="password"
        id="password"
        v-model="user.userPw"
        placeholder="패스워드"
        class="input-window"
      />
      <!-- <div class="checkbox">
        <input type="checkbox" id="keep-logged-in" />
        <label for="keep-logged-in" class="checkbox-text"
          >로그인 유지하기</label
        >
      </div> -->
      <div style="height: 35px"></div>
      <button class="btn" @click="login">로그인</button>
      <div class="regist">
        <h3>계정이 없으신가요?</h3>
        <router-link :to="{ name: 'UserRegist' }" class="text-btn"
          >가입하기</router-link
        >
      </div>
    </fieldset>
    <fieldset class="input" v-else>
      <h2 class="title" style="margin-top: 160px">내 다이어리 열기</h2>
      <div style="height: 40px"></div>
      <router-link to="/main">
        <button class="btn">다이어리</button></router-link
      >
      <button class="btn2" @click="logout">로그아웃</button>
    </fieldset>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "UserLogin",
  data() {
    return {
      user: {
        userId: "",
        userPw: "",
      },
    };
  },
  computed: {
    ...mapState(["loginUser"]),
  },
  methods: {
    async login() {
      if (!this.user.userId || !this.user.userPw) {
        alert("로그인 정보를 입력하세요.");
        return;
      }
      await this.$store.dispatch("userLogin", this.user);

      this.user.userId = "";
      this.user.userPw = "";
    },
    logout() {
      sessionStorage.removeItem("access-token");
      this.$store.commit("USER_LOGOUT");
      this.$router.push("/");
    },
  },
};
</script>

<style scoped>
.card {
  width: 50vw;
  height: 100vh;
  background-color: red;
  border-radius: 8px 0 0 8px;
  background: #eff5f5;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  display: flex;
  align-items: center;
  justify-content: center;
}

.input {
  border: none;
  width: 480px;
  height: 520px;
  background: #ffffff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.title {
  font-weight: 600;
  font-size: 1.5em;
  margin-top: 4em;
  margin-bottom: 1.5em;
}
.input-window {
  width: 264px;
  height: 48px;
  background: #eeeeee;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border: none;
  border-radius: 4px;
  vertical-align: middle;
  font-size: 1em;
  padding-left: 1em;
  margin-top: 1.2em;
}

.input-window::placeholder {
  color: #c0c0c0;
}

.input-window:focus {
  outline: none;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04) inset;
}

.checkbox {
  width: 110px;
  height: auto;
  display: flex;
  align-items: center;
  margin-top: 1em;
}

.checkbox-text {
  margin-left: 0.5em;
  font-size: 0.75em;
}

.btn {
  width: 280px;
  height: 48px;
  background: #e86666;
  border-radius: 4px;
  font-weight: 600;
  border: none;
  font-size: 1em;
  color: #fff;
  margin-top: 1em;
}
.btn:hover {
  outline: none;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.12);
}
.btn:active {
  outline: none;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.12) inset;
}

.btn2 {
  width: 280px;
  height: 48px;
  background-color: #a0a0a0;
  border-radius: 4px;
  border: none;
  font-size: 1em;
  color: #fff;
  margin-top: 1em;
}
.btn2:hover {
  outline: none;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.12);
}
.btn2:active {
  outline: none;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.12) inset;
}

.regist {
  display: flex;
  align-items: center;
  margin-top: 1em;
}

h3 {
  font-size: 1em;
  font-weight: 400;
  color: #000000;
}

.text-btn {
  margin-left: 1em;
  text-decoration: none;
  color: #000000;
}
</style>
