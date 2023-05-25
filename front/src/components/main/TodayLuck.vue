<template>
  <div class="container">
    <h2 class="title">오늘의 한마디</h2>
    <div>
      <div class="content">{{ todayLuck }}</div>
      <button-basic-5
        class="click"
        :refreshChance="refreshChance"
        @rerun="setTodayLuck"
      ></button-basic-5>
    </div>
  </div>
</template>

<script>
import dayjs from "dayjs";
import ButtonBasic5 from "../ui-element/ButtonBasic5.vue";
import { mapState } from "vuex";

export default {
  components: { ButtonBasic5 },
  name: "TodayLuckUi",
  data() {
    return {
      refreshChance: null,
    };
  },
  computed: {
    ...mapState(["todayLuck"]),
  },
  created() {
    const now = dayjs();
    const newDate = now.$D;
    const newMonth = now.$M;

    let curDate = null;
    let curMonth = null;

    const todayLuck = JSON.parse(sessionStorage.getItem("todayLuck")); // api에서 가져오기
    if (todayLuck) {
      curDate = todayLuck.date;
      curMonth = todayLuck.month;
    }

    if (newDate === curDate && newMonth === curMonth) {
      // this.todayLuck = JSON.parse(sessionStorage.getItem("todayLuck")).content;
    } else {
      // const content = Math.random() * 100; // api로 변경 필요
      this.$store.dispatch("setTodayLuck");

      const newLuck = {
        date: newDate,
        month: newMonth,
        content: this.todayLuck,
      };
      sessionStorage.setItem("todayLuck", JSON.stringify(newLuck));
      sessionStorage.setItem("refreshChance", 10);
    }

    const refreshChance = JSON.parse(sessionStorage.getItem("refreshChance"));
    this.refreshChance = refreshChance;
  },
  methods: {
    setTodayLuck() {
      let refreshChance = JSON.parse(sessionStorage.getItem("refreshChance"));
      if (refreshChance <= 0) return;

      refreshChance--;
      this.refreshChance = refreshChance;

      let todayLuck = JSON.parse(sessionStorage.getItem("todayLuck"));

      // const content = Math.random() * 100; // api로 변경 필요
      this.$store.dispatch("setTodayLuck");

      sessionStorage.setItem("todayLuck", JSON.stringify(todayLuck));
      sessionStorage.setItem("refreshChance", JSON.stringify(refreshChance));
    },
  },
};
</script>

<style scoped>
.container {
  position: relative;
}

.title {
  position: absolute;
  left: 56px;
  top: 40px;
  font-size: 1.2em;
  font-weight: 600;
}

.content {
  position: absolute;
  left: 56px;
  top: 120px;
  text-align: left;
  width: 200px;
  font-size: 1em;
}
</style>
