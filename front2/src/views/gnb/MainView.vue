<template>
  <div>
    <header-nav></header-nav>
    <div class="main-body">
      <div class="left">
        <calender-ui></calender-ui>
        <achievements-ui></achievements-ui>
      </div>
      <div class="center">
        <parts-ui></parts-ui>
      </div>
      <div class="right">
        <part-ranking-ui></part-ranking-ui>
        <today-luck-ui></today-luck-ui>
      </div>
    </div>
    <div>
      <streak-ui></streak-ui>
    </div>
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue";
import AchievementsUi from "@/components/main/Achievements.vue";
import CalenderUi from "@/components/main/Calender.vue";
import PartRankingUi from "@/components/main/PartRanking.vue";
import PartsUi from "@/components/main/Parts.vue";
import StreakUi from "@/components/main/Streak.vue";
import TodayLuckUi from "@/components/main/TodayLuck.vue";

export default {
  name: "MainView",
  components: {
    HeaderNav,
    AchievementsUi,
    CalenderUi,
    PartRankingUi,
    PartsUi,
    StreakUi,
    TodayLuckUi,
  },
};
</script>

<style>
.main-body {
  display: inline-flex;
}
.main-calendar {
  border: solid black;
}
.main-achieve {
  height: 350px;
  width: 400px;
  border: solid black;
}
.main-partranking {
  height: 350px;
  width: 400px;
  border: solid black;
}
.main-todayluck {
  height: 350px;
  width: 400px;
  border: solid black;
}
.main-streak {
  margin: auto;
  height: 50px;
  width: 1350px;
  border: solid black;
}
</style>
