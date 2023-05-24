<template>
  <div>
    <header-nav></header-nav>
    <!-- <h2>업적</h2> -->
    <div class="achvcontainer">
      <div class="achvbox">
        <div
          class="achv"
          v-for="(achievement, index) in achievements"
          :key="index"
        >
          <div v-if="hasUserAchievement(achievement.achvTitle) != null">
            <div
              class="achvtitle"
              style="background-color: rgba(255, 204, 91, 0.7)"
            >
              <p>{{ achievement.achvTitle }}</p>
            </div>
            <div
              class="achvimage"
              v-if="hasUserAchievement(achievement.achvTitle) != null"
            >
              <img src="@/assets/achv_icon.png.png" alt="" />
              <p>
                "{{ hasUserAchievement(achievement.achvTitle).achievedDate }}"에
                달성!
              </p>
            </div>
            <div
              class="achvcontent"
              style="background-color: rgba(255, 204, 91, 0.7)"
            >
              {{ achievement.achvContent }}
            </div>
          </div>
          <div v-else>
            <div class="achvtitle">
              <p>{{ achievement.achvTitle }}</p>
            </div>
            <div class="achvimage">
              <img src="@/assets/achv_icon_grey.png" alt="" />
              <p>업적을 달성해보세요</p>
            </div>
            <div class="achvcontent">
              {{ achievement.achvContent }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue";
import { mapState } from "vuex";

export default {
  name: "AchievementView",
  components: { HeaderNav },
  computed: {
    ...mapState(["achievements"]),
    ...mapState(["userAchievements"]),
  },
  created() {
    this.$store.dispatch("setAchieves");
    this.$store.dispatch("setUserAchieves");
  },
  methods: {
    hasUserAchievement(title) {
      return this.userAchievements.find(
        (achievement) => achievement.achvTitle === title
      );
    },
  },
};
</script>

<style scoped>
.achvcontainer {
  position: absolute;
  width: 1470px;
  height: 880px;
  top: calc(50% - 880px / 2 - 12px);
  left: 320px;
  /* border: solid black;
  background: #ffffff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px; */
}

.achvbox {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  height: 850px;
  overflow-y: scroll;
}
.achvbox::-webkit-scrollbar {
  display: none;
}
.achv {
  width: 450px;
  height: 400px;
  background: #ffffff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
  margin: 10px;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
}

.achvtitle {
  background: #d9d9d9;
  border-radius: 8px;
  margin: auto;
  width: 200px;
  margin-top: 15px;
  margin-bottom: 10px;
}

.achvimage {
  /* background: #d9d9d9; */
  border-radius: 8px;
  margin: auto;
  width: 300px;
  width: 300px;
}

.achvcontent {
  background: #d9d9d9;
  border-radius: 8px;
  margin: auto;
  width: 400px;
  height: 60px;
  margin-top: 15px;
  line-height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}

img {
  width: 200x;
  height: 200px;
}

p {
  margin: 0;
}
</style>
