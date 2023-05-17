<template>
  <div>
    <h2>로그인</h2>
    <fieldset>
      <input
        type="text"
        id="id"
        v-model="id"
        placeholder="아이디 또는 이메일"
      /><br />
      <input
        type="password"
        id="password"
        v-model="password"
        placeholder="비밀번호"
      /><br />
      <button>로그인</button>
      <h3>계정이 없으신가요?</h3>
      <router-link :to="{ name: 'UserRegist' }">가입하기</router-link>
    </fieldset>
  </div>
</template>

<script>
export default {
  name: "LoginForm",
  data() {
    return {
      id: "",
      password: "",
    };
  },
};
</script>

<style></style>
