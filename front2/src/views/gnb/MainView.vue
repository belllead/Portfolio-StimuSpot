<template>
  <div>
    <header-nav></header-nav>
    <calender-ui></calender-ui>
    <parts-ui></parts-ui>
    <part-ranking-ui></part-ranking-ui>
    <achievements-ui></achievements-ui>
    <today-luck-ui></today-luck-ui>
    <streak-ui></streak-ui>
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

<style></style>
