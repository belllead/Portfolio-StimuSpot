<template>
  <div>
    <h2>오늘의 운세</h2>
    <div>
      <div>오늘의 운세</div>
      <div>{{ todayLuck }}</div>
      <button :disabled="refreshChance <= 0" @click="setTodayLuck">
        다른 운세 보기 {{ refreshChance }}번 가능
      </button>
    </div>
  </div>
</template>

<script>
import dayjs from "dayjs";

export default {
  name: "TodayLuckUi",
  data() {
    return {
      todayLuck: "",
      refreshChance: null,
    };
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
      this.todayLuck = JSON.parse(sessionStorage.getItem("todayLuck")).content;
    } else {
      const content = Math.random() * 100; // api로 변경 필요
      const newLuck = {
        date: newDate,
        month: newMonth,
        content: content,
      };
      sessionStorage.setItem("todayLuck", JSON.stringify(newLuck));
      sessionStorage.setItem("refreshChance", 3);
      this.todayLuck = content;
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

      const content = Math.random() * 100; // api로 변경 필요
      todayLuck.content = content;

      sessionStorage.setItem("todayLuck", JSON.stringify(todayLuck));
      sessionStorage.setItem("refreshChance", JSON.stringify(refreshChance));
      this.todayLuck = content;
    },
  },
};
</script>

<style scoped></style>
