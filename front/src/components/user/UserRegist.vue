<template>
  <div class="card">
    <fieldset class="input">
      <div class="title">
        나만의 부위별 운동 다이어리를 <br />가지기 위해 가입하세요.
      </div>
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
      <div class="text-left">
        <label for="id">아이디</label>
        <input
          type="text"
          id="id"
          v-model="id"
          class="input-window"
          placeholder="6~20자 영문, 숫자"
        /><br />
        <label for="password">비밀번호</label>
        <input
          type="password"
          id="password"
          v-model="password"
          class="input-window"
          placeholder="6~12자 영문, 숫자, 특수문자"
        /><br />
        <div class="horizontal">
          <div class="text-left2">
            <label for="name">이름</label>
            <input
              type="text"
              id="name"
              v-model="name"
              class="input-window-small"
            />
          </div>
          <div class="text-left2">
            <label for="age">나이</label>
            <input
              type="number"
              id="age"
              v-model.number="age"
              placeholder="0"
              class="input-window-small"
            /><br />
          </div>
        </div>
        <br />
        <div class="horizontal">
          <div class="text-left2">
            <label for="email">이메일</label>
            <input
              type="email"
              id="email"
              v-model="email"
              class="input-window"
            /><br />
          </div>
          <div class="text-left3">
            <div>성별</div>
            <div class="radio">
              <input type="radio" id="male" value="male" name="sex" />
              <label for="male">남성</label>
              <input type="radio" id="female" value="female" name="sex" />
              <label for="female">여성</label>
            </div>
          </div>
        </div>
        <br />
        <label for="nickname">닉네임</label>
        <input
          type="text"
          id="nickname"
          v-model="nickname"
          class="input-window"
        /><br />
      </div>
      <button class="btn">가입하기</button>
      <router-link :to="{ name: 'UserLogin' }" class="text-btn"
        >로그인하러 가기</router-link
      >
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
      age: null,
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
  width: 640px;
  height: 800px;
  background: #ffffff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
  display: flex;
  flex-direction: column;
  align-items: center;
  position: relative;
  flex-wrap: wrap;
}
.profileImg {
  background-size: cover;
  position: absolute;
  width: 160px;
  height: 160px;
  left: 420px;
  top: 140px;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  background-color: #eb9f9f;
  border-radius: 8px;
}
.title {
  font-weight: 600;
  font-size: 1.2 em;
  margin-top: 2em;
  margin-bottom: 0.2em;
}

.text-left {
  display: flex;
  flex-direction: column;
  text-align: left;
}
.text-left2 {
  display: flex;
  flex-direction: column;
  text-align: left;
  flex-wrap: wrap;
  height: 100px;
  margin-bottom: -0.5em;
}

.text-left3 {
  display: flex;
  flex-direction: column;
  text-align: left;
  margin-left: 40px;
}

.horizontal {
  display: flex;
}
.input-window {
  width: 264px;
  height: 48px;
  background: #eeeeee;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);

  border: none;
  border-radius: 4px;
  font-size: 1em;
  padding-left: 1em;
  margin-top: 0.8em;
}

.input-window-small {
  width: 184px;
  height: 48px;
  background: #eeeeee;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);

  border: none;
  border-radius: 4px;
  font-size: 1em;
  padding-left: 1em;

  margin-top: 0.8em;
  margin-right: 40px;
}

input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

.input-window::placeholder {
  color: #c0c0c0;
}

.input-window-small::placeholder {
  color: #c0c0c0;
}

.input-window:focus {
  outline: none;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04) inset;
}

.input-window-small:focus {
  outline: none;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04) inset;
}

.radio {
  width: 100%;
  height: auto;
  display: flex;
  align-items: center;
  margin-top: 1.3em;
  align-items: center;
}

.radio label {
  font-size: 1em;
  margin: 1px 12px 0 4px;
}

.btn {
  width: 280px;
  height: 48px;
  background: #e86666;
  border-radius: 4px;
  border: none;
  font-weight: 600;
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

.none {
  outline: none;
  border: none;
  background-color: #fff;
}

.text-btn {
  background-color: none;
  text-decoration: none;
  color: #000000;
  margin-top: 1em;
}
</style>
