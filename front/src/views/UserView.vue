<template>
  <div>
    <div class="container">
      <div class="home">
        <div class="text-center">
          <logo-static class="logo" />
          <div class="description">
            가장 최근에 운동한 부위는 어디인가요?<br />
            운동 부위를 체크하고 운동 일기를 써보세요.<br />
            내가 얼마나 자주 운동을 하고 있는지, 어느<br />
            부위를 중심적으로 운동하고 있는지 알려주는<br />
            서비스, ‘종서의 러브러브 다이어리'입니다.
          </div>
          <router-link to="/" class="btn"
            ><button-basic3 class="btn"></button-basic3
          ></router-link>
        </div>
        <footer>
          <footer-info />
        </footer>
      </div>

      <div class="form">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import ButtonBasic3 from "@/components/ui-element/ButtonBasic3.vue";
import LogoStatic from "../components/ui-element/LogoStatic.vue";
import FooterInfo from "@/components/common/Footer.vue";

export default {
  name: "UserView",
  components: { ButtonBasic3, LogoStatic, FooterInfo },
};
</script>

<style scoped>
.home {
  width: 50vw;
  position: relative;
}
.text-center {
  width: 500px;
  height: 500px;
  position: absolute;
  top: 40%;
  left: 50%;
  margin: -250px 0 0 -250px;
}

.container {
  margin: 0;
  height: 100vh;
  width: 100vw;
  /* background-image: url("C:/Users/SSAFY/Desktop/ssafit_final/StimuSpot/resources/img/Landing M Processed.png"); */
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
  overflow: hidden;
  display: flex;
}
.form {
  position: absolute;
  right: 0;
}

.logo {
  margin: 10em auto 0;
  width: 200px;
  height: 40px;
}

.description {
  margin: 5em auto 0;
  width: 300px;
  height: 160px;
  color: white;
  font-weight: 200;
  line-height: 2em;
}

.btn {
  margin: 3em auto 0;
  width: 80px;
  height: 40px;
  display: block;
  text-decoration: none;
  color: #a0a0a0;
}

.footer {
  width: 50vw;
}

.cls-1 {
  fill: white;
}
.cls-2 {
  fill: #e86666;
}
</style>
