<template>
  <div>
    <header-nav></header-nav>
    <!-- <h2>업적</h2> -->
    <div class="achvcontainer">
      <div  class="achvbox">
        <div class="achv" v-for="(achievement, index) in achievements" :key="index">
          <div class="achvtitle">
            {{achievement.achvTitle}}
          </div>
          <div class="achvimage">
            <div v-if="hasUserAchievement(achievement.achvTitle)">
              <img src="@/assets/medal.png" alt="">
            </div>
            <div v-else>
              <img src="@/assets/medal_grey.png" alt="">
            </div>
          </div>
          <div class="achvcontent">
            <div>
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
    this.$store.dispatch("setUserAchieves")
  },
  methods:{
    hasUserAchievement(title) {
      return this.userAchievements.some(
        (achievement) => achievement.achvTitle === title
      );
    },
  },
};
</script>

<style scoped>
.achvcontainer {
  border: solid black;
  position: absolute;
  width: 1470px;
  height: 880px;
  top: calc(50% - 880px / 2 - 12px);
  left: 320px;
  background: #ffffff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
}

.achvbox{
  display : flex;
  flex-direction: row;
  flex-wrap: wrap;
  height: 850px;
  overflow-y: scroll;
}

.achv{
  width: 430px;
  height: 430px;
  border: solid black;
  border-radius: 8px;
  margin: 10px; 
  box-sizing: border-box;
}

.achvtitle{
  background: #D9D9D9;
  border-radius: 8px;
  margin: auto;
  width:200px; 
  margin-top: 5px;
  margin-bottom: 5px;
}

.achvimage{
  background: #D9D9D9; 
  border-radius: 8px;
  margin: auto;
  width: 300px;
  width: 300px;
}

.achvcontent{
  background: #D9D9D9; 
  border-radius: 8px;
  margin: auto;
  width: 400px;
  height: 60px;
  margin-top: 5px;
  line-height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}

img {
  width: 300x;
  height: 300px;
}
</style>
