<template>
  <div class="main-streak">
    <h2>스트릭</h2>
    <div class="streak-bar">
      <div
        class="streak-el"
        v-for="(el, index) in streak"
        :key="index"
        :class="{ positive: el !== 0 }"
      ></div>
    </div>
    <div>최대 스트릭</div>
    <div>{{ longest }}</div>
    <div>현재 스트릭</div>
    <div>{{ current }}</div>
  </div>
</template>

<script>
Date.prototype.yyyymmdd = function () {
  let mm = this.getMonth() + 1;
  let dd = this.getDate();

  return [
    this.getFullYear(),
    (mm > 9 ? "" : "0") + mm,
    (dd > 9 ? "" : "0") + dd,
  ].join("");
};

export default {
  name: "StreakUi",
  data() {
    return {
      streak: [],
      longest: 0,
      current: 0,
    };
  },
  created() {
    let streakEl = [];
    const now = new Date();
    const streakDate = new Date();
    streakDate.setDate(now.getDate() - 30);

    // console.log(now.yyyymmdd());
    // console.log(streakDate.yyyymmdd());

    const elFromDB = [
      "20230416",
      "20230417",
      "20230418",
      "20230419",
      "20230424",
      "20230425",
      "20230426",
      "20230427",
      "20230502",
      "20230503",
      "20230504",
      "20230512",
      "20230513",
      "20230514",
      "20230515",
      "20230516",
      "20230517",
    ]; // API로 가져오기

    while (streakDate <= now) {
      if (elFromDB.includes(streakDate.yyyymmdd())) {
        streakEl.push(streakDate.yyyymmdd());
      } else streakEl.push(0);
      streakDate.setDate(streakDate.getDate() + 1);
    }

    // console.log(streakEl);
    // console.log(elFromDB);
    this.streak = streakEl;

    const longest = 6; // API로 가져오기
    const current = 0; // API로 가져오기
    this.longest = longest;
    this.current = current;
  },
};
</script>

<style scoped>
.streak-bar {
  background-color: black;
  height: 40px;
  display: flex;
}

.streak-el {
  background-color: red;
  height: 40px;
  border: 1px inset white;
  flex-grow: 1;
}

.positive {
  background-color: green;
}
</style>
