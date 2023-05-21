<template>
  <div :class="['cell', ...allClass]" @click="click">
    <div class="cell__day">{{ number }}</div>
    <div class="cell__body">
      <slot></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: "CalendarCell",
  props: {
    day: Object,
    active: Boolean,
    date: Object,
  },
  computed: {
    allClass() {
      return [
        { "cell--saturday": this.isSaturday && this.isMonth },
        { "cell--sunday": this.isSunday && this.isMonth },
        { "cell--other-month": !this.isMonth },
        { "cell--now": this.isNow },
        { "cell--month": this.isMonth && !this.isBefore },
        { "cell--active": this.active },
      ];
    },
    now() {
      return this.$moment().clone();
    },
    isSaturday() {
      return this.day.day() == 6;
    },
    isSunday() {
      return this.day.day() == 0;
    },
    isNow() {
      return this.day.isSame(this.now, "day");
    },
    isMonth() {
      return this.day.isSame(this.date, "month");
    },
    isBefore() {
      return this.day.isBefore(this.now, "day");
    },
    number() {
      return this.day.format("D");
    },
  },
  methods: {
    click() {
      this.$emit("select", this.day);
    },
  },
};
</script>

<style scoped>
.cell {
  height: 90px;
  width: 100%;
  background-color: #fff;
  border-radius: 5px;
  border: 1px solid #fff;
  transition: all 0.1s ease-in;
  z-index: 1;
}
.cell--month {
  color: #434141;
  background-color: #fff;
}

.cell--other-month {
  color: #b7b4b4;
  background-color: #f5f5f5;
}
.cell--saturday .cell__day {
  color: #7676f4;
}
.cell--sunday .cell__day {
  color: red;
}
.cell--now {
  background-color: #08e200;
  /* border: 1px solid #8080808c; */
}
.cell--active {
  /* border: 1px solid #08e200; */
  background-color: aqua;
}
/* .cell--now .cell__day {
  color: #08e200;
} */
.cell__day {
  text-align: end;
  padding: 0 5px 0 0;
  font-weight: bold;
}
.cell__body {
  padding: 0 5px;
  width: 100px;
  position: relative;
}
.cell:hover {
  z-index: 2;
  background-color: aqua;
}
</style>
