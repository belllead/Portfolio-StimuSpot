<template>
  <div>
    <h2>로그인</h2>
    <fieldset>
      <input
        type="text"
        id="id"
        v-model="user.id"
        placeholder="아이디 또는 이메일"
      /><br />
      <input
        type="password"
        id="password"
        v-model="user.password"
        placeholder="비밀번호"
      /><br />
      <button @click="login">로그인</button>
      <h3>계정이 없으신가요?</h3>
      <router-link :to="{ name: 'UserRegist' }">가입하기</router-link>
    </fieldset>
  </div>
</template>

<script>
export default {
  name: "UserLogin",
  data() {
    return {
      user: {
        id: "",
        password: "",
      },
    };
  },
  methods:{
    login(){
      this.$store.dispatch('userLogin',this.user);
    },
  },
};
</script>

<style></style>
