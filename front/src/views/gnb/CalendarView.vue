<template>
  <div>
    <header-nav></header-nav>
    <h2>다이어리</h2>
    <div class="diary-body">
      <div class="diary-calendar">
        <div class="calendar__inner">
          <CalendarIndex :events="events" @add="add" />
        </div>
        <diary-detail></diary-detail>
      </div>
    </div>
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue";
import CalendarIndex from "@/components/calendar/calendarIndex.vue";
import DiaryDetail from "@/components/calendar/diary/DiaryDetail.vue";

export default {
  name: "CalendarView",
  components: { HeaderNav, CalendarIndex, DiaryDetail },
  data() {
    return {
      events: [],
      type: ["info", "warning", "error"],
    };
  },
  mounted() {
    const data = this.$moment().clone();
    this.events = [
      { id: 1, name: "Event 1", type: this.random(), date: data },
      { id: 2, name: "Event 2", type: this.random(), date: data },
      { id: 3, name: "Event 3", type: this.random(), date: data },
      {
        id: 4,
        name: "Event 4",
        type: this.random(),
        date: data.clone().add(3, "day"),
      },
      {
        id: 5,
        name: "Event 5",
        type: this.random(),
        date: data.clone().add(3, "day"),
      },
      {
        id: 6,
        name: "Event 6",
        type: this.random(),
        date: data.clone().add(6, "day"),
      },
      {
        id: 8,
        name: "Event 7",
        type: this.random(),
        date: data.clone().add(16, "day"),
      },
      {
        id: 9,
        name: "Event 7",
        type: this.random(),
        date: data.clone().add(19, "day"),
      },
      {
        id: 10,
        name: "Event 7",
        type: this.random(),
        date: data.clone().add(35, "day"),
      },
    ];
  },
  methods: {
    random() {
      return this.type[Math.floor(Math.random() * this.type.length)];
    },
    // 일정 추가하는 메소드
    // 지금은 추가 버튼으로 랜덤하게 생성함
    add() {
      const data = this.$moment().clone();
      const maxId = Math.max(...this.events.map((item) => item.id)) + 1;
      this.events.push({
        id: maxId,
        name: "Event " + maxId,
        type: this.random(),
        date: data.clone().add(maxId - 10, "day"),
      });
    },
  },
};
</script>

<style></style>
