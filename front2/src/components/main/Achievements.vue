<template>
  <div class="main-achieve">
    <h2>업적</h2>
    <br />
    <br />
    <div class="main-achieve-list">
      <div>
        <div class="main-achieve-container"></div>
        <h4>1번 업적</h4>
      </div>
      <div>
        <div class="main-achieve-container"></div>
        <h4>2번 업적</h4>
      </div>
      <div>
        <div class="main-achieve-container"></div>
        <h4>3번 업적</h4>
      </div>
      <div>
        <div class="main-achieve-container"></div>
        <h4>4번 업적</h4>
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
}
</style>
