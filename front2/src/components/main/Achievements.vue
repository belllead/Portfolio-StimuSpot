<template>
  <div class="main-achieve">
    <h2>업적</h2>
    <br />
    <br />
    <div>
      <div class="main-achieve-list">
        <div>
          <div v-if="achievements[0] != null">
            <div class="main-achieve-container"></div>
            <h4>*{{ achievements[0].achv_title }}*</h4>
          </div>
          <div v-else>
            <div class="main-achieve-container-grey"></div>
            <p class="word-grey">업적을 얻어보세요</p>
          </div>
        </div>
        <div>
          <div v-if="achievements[1] != null">
            <div class="main-achieve-container"></div>
            <h4>*{{ achievements[1].achv_title }}*</h4>
          </div>
          <div v-else>
            <div class="main-achieve-container-grey"></div>
            <p class="word-grey">업적을 얻어보세요</p>
          </div>
        </div>
        <div>
          <div v-if="achievements[2] != null">
            <div class="main-achieve-container"></div>
            <h4>*{{ achievements[2].achv_title }}*</h4>
          </div>
          <div v-else>
            <div class="main-achieve-container-grey"></div>
            <p class="word-grey">업적을 얻어보세요</p>
          </div>
        </div>
      </div>
    </div>
    <router-link to="/achievement" class="btn">전체보기</router-link>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "AchievementUi",
  data() {
    return {};
  },
  components: {},
  computed: {
    ...mapState(["achievements"]),
  },
  created() {
    // this.$store.dispatch("getAchievements");
  },
};
</script>

<style>
.main-achieve-list {
  display: inline-flex;
  height: 200px;
}

.main-achieve-container {
  background-image: url(@/assets/medal.png);
  background-size: contain;
  width: 100px;
  height: 100px;
  margin-left: 10px;
  margin-right: 10px;
}

.main-achieve-container-grey {
  background-image: url(@/assets/medal_grey.png);
  background-size: contain;
  width: 100px;
  height: 100px;
  margin-left: 10px;
  margin-right: 10px;
}

.word-grey {
  color: grey;
}
</style>
