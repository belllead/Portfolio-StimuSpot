<template>
  <div>
    <header-nav></header-nav>

    <div class="card">
      <div class="left">
        <div class="cal-card"><calender-ui /></div>
        <div class="achv-card"><achievements-ui /></div>
      </div>
      <div class="center">
        <div class="part-card"><parts-ui /></div>
      </div>
      <div class="right">
        <div class="rank-card"><part-ranking-ui /></div>
        <div class="luck-card"><today-luck-ui /></div>
      </div>
    </div>
    <!-- <div>
      <streak-ui></streak-ui>
    </div> -->
    <footer-info-2 />
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue";
import AchievementsUi from "@/components/main/Achievements.vue";
import CalenderUi from "@/components/main/Calender.vue";
import PartRankingUi from "@/components/main/PartRanking.vue";
import PartsUi from "@/components/main/Parts.vue";
// import StreakUi from "@/components/main/Streak.vue";
import TodayLuckUi from "@/components/main/TodayLuck.vue";
import FooterInfo2 from "../../components/common/FooterInfo2.vue";

export default {
  name: "MainView",
  components: {
    HeaderNav,
    AchievementsUi,
    CalenderUi,
    PartRankingUi,
    PartsUi,
    // StreakUi,
    TodayLuckUi,
    FooterInfo2,
  },
};
</script>

<style scoped>
.card {
  display: flex;
  width: 1470px;
  justify-content: space-between;
  position: absolute;
  top: 30px;
  left: 320px;
}
.left {
  width: 430px;
  height: 790px;
  /* background-color: aqua; */
}

.cal-card {
  height: 520px;
  width: 430px;
  background-color: #fff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
}

.achv-card {
  height: 250px;
  background-color: #fff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
  margin-top: 20px;
}

.center {
  width: 680px;
  height: 790px;
}

.part-card {
  width: 680px;
  height: 790px;
  background-color: white;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
}

.right {
  width: 320px;
  height: 790px;
  /* background-color: aqua; */
}

.rank-card {
  width: 320px;
  height: 400px;
  background-color: #fff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
}

.luck-card {
  width: 320px;
  height: 370px;
  background-color: #fff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
  margin-top: 20px;
}
</style>
