<template>
  <div>
    <fieldset>
      <div>나만의 부위별 운동 다이어리를 <br />가지기 위해 가입하세요.</div>
      <label
        for="profileImg"
        class="profileImg"
        :style="`background-image : url(${profileImg})`"
      ></label>
      <input
        type="file"
        id="profileImg"
        @change="uploadImg"
        accept="image/*"
        style="display: none"
      /><br />
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
    <div></div>
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
      profileImg: "",
    };
  },
  methods: {
    uploadImg(e) {
      let file = e.target.files;
      let url = URL.createObjectURL(file[0]);
      this.profileImg = url;
    },
  },
};
</script>

<style scoped>
.profileImg {
  width: 100px;
  height: 100px;
  background-color: aqua;
  background-size: cover;
  display: inline-block;
}
</style>
