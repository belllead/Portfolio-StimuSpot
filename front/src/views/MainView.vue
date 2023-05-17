<template>
  <div>
    <achievement></achievement>
    <calender></calender>
    <parts></parts>
    <parts-ranking></parts-ranking>
    <streak></streak>
    <today-luck></today-luck>
  </div>
</template>

<script>
import Achievement from "../components/workout/Achievement.vue";
import Calender from "../components/workout/Calender.vue";
import Parts from "../components/workout/Parts.vue";
import PartsRanking from "../components/workout/PartsRanking.vue";
import Streak from "../components/workout/Streak.vue";
import TodayLuck from "../components/workout/TodayLuck.vue";

export default {
  components: {
    Achievement,
    Calender,
    Parts,
    PartsRanking,
    Streak,
    TodayLuck,
  },
};
</script>

<style></style>
