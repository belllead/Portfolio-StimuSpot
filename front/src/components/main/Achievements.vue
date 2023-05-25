<template>
  <div class="main-achieve">
    <div class="title">업적</div>
    <div>
      <div class="main-achieve-list">
        <div class="achv">
          <div v-if="userAchievements[0] != null">
            <div class="main-achieve-container"></div>
            <h4>*{{ userAchievements[0].achvTitle }}*</h4>
          </div>
          <div v-else>
            <div class="main-achieve-container-grey"></div>
            <p class="word-grey">업적을 얻어보세요</p>
          </div>
        </div>
        <div class="achv">
          <div v-if="userAchievements[1] != null">
            <div class="main-achieve-container"></div>
            <h4>*{{ userAchievements[1].achvTitle }}*</h4>
          </div>
          <div v-else>
            <div class="main-achieve-container-grey"></div>
            <p class="word-grey">업적을 얻어보세요</p>
          </div>
        </div>
        <div class="achv">
          <div v-if="userAchievements[2] != null">
            <div class="main-achieve-container"></div>
            <h4>*{{ userAchievements[2].achvTitle }}*</h4>
          </div>
          <div v-else>
            <div class="main-achieve-container-grey"></div>
            <p class="word-grey">업적을 얻어보세요</p>
          </div>
        </div>
      </div>
    </div>
    <div class="btns">
      <router-link :to="{ name: 'AchievementView' }"
        ><button-basic-1 class="basic-btn"></button-basic-1>
      </router-link>
    </div>
  </div>
</template>

<script>
import ButtonBasic1 from "../ui-element/ButtonBasic1.vue";
import { mapState } from "vuex";

export default {
  name: "AchievementUi",
  data() {
    return {};
  },
  components: { ButtonBasic1 },
  computed: {
    ...mapState(["userAchievements"]),
  },
  created() {
    this.$store.dispatch("setUserAchieves");
  },
};
</script>

<style scoped>
.title {
  position: absolute;
  left: 80px;
  top: 570px;
  font-size: 1em;
  font-weight: 600;
}

.basic-btn {
  position: absolute;
  left: 80px;
  bottom: 5px;
  width: 80px;
  height: 40px;
  color: #a0a0a0;
}
h4 {
  margin-top: 15px;
}

.achv:hover {
  transform: scale(1.05);
}

.main-achieve-list {
  left: 40px;
  bottom: -10px;
  position: absolute;
  display: inline-flex;
  height: 200px;
}

.main-achieve-container {
  background-image: url(@/assets/achv_icon.png.png);
  background-size: contain;
  width: 80px;
  height: 80px;
  margin-left: 15px;
  margin-right: 15px;
}

.main-achieve-container-grey {
  background-image: url(@/assets/achv_icon_grey.png);
  background-size: contain;
  width: 80px;
  height: 80px;
  margin-left: 15px;
  margin-right: 15px;
}

.word-grey {
  color: grey;
}
</style>
