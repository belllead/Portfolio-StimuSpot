<template>
  <div>
    <fieldset>
      <div>나만의 부위별 운동 다이어리를 <br />가지기 위해 가입하세요.</div>
      <label for="profileImg">프사</label>
      <input type="file" id="profileImg" /><br />
      <label for="id">아이디</label>
      <input type="text" id="id" v-model="id" /><br />
      <label for="password">비밀번호</label>
      <input type="password" id="password" v-model="password" /><br />
      <label for="name">이름</label>
      <input type="text" id="name" v-model="name" /><br />
      <label for="email">이메일</label>
      <input type="email" id="email" v-model="email" /><br />
      <label for="age">나이</label>
      <input type="number" id="age" v-model="age" /><br />
      <label for="nickname">닉네임</label>
      <input type="text" id="nickname" v-model="nickname" /><br />
      <button>가입하기</button>
      <button>
        <router-link :to="{ name: 'UserLogin' }">로그인하기</router-link>
      </button>
    </fieldset>
  </div>
</template>

<script>
export default {
  name: "UserList",
  data() {
    return {
      id: "",
      password: "",
      name: "",
      email: "",
      age: 0,
      nickname: "",
    };
  },
};
</script>
