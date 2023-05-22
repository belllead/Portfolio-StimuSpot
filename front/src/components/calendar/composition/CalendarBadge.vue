<template>
  <div class="badge">
    <span :class="['badge__title', `badge__title--${type}`]">{{
      `${dateString} ${name} ${type}`
    }}</span>
  </div>
</template>

<script>
export default {
  name: "CalendarBadge",
  props: {
    id: Number,
    type: String,
    name: String,
    date: Object,
  },
  computed: {
    dateString() {
      return `${this.date.format("H:MM")}`;
    },
  },
};
</script>

<style scoped>
.badge {
  font-size: 14px;
  margin: 0 0 3px 0;
  width: 100%;
  position: relative;
  line-height: 16px;
}
.badge__title {
  border-radius: 5px;
  padding: 0 3px;
  display: block;
  width: 90px;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}
.badge__title:hover {
  display: inline;
}
.badge__title--info {
  background-color: #eef5f1;
  color: #97bb9f;
}
.badge__title--error {
  background-color: #fceced;
  color: #c1868c;
}
.badge__title--warning {
  background-color: #faead0;
  color: #d2ae81;
}
</style>
