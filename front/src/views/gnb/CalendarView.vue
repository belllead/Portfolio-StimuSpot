<template>
  <div>
    <header-nav></header-nav>

    <div class="card-group">
      <div class="calendar-card">
        <CalendarIndex :events="events" @add="add" @selectDate="selectDate" />
      </div>
      <div class="diary-card">
        <diary-detail style="transform: translateY(-60px)" />
      </div>
    </div>

    <footer-info-2 />
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue";
import CalendarIndex from "@/components/calendar/CalendarIndex.vue";
import DiaryDetail from "@/components/calendar/diary/DiaryDetail.vue";
import { dateFormat } from "@/util/dateFormat";
import FooterInfo2 from "../../components/common/FooterInfo2.vue";

export default {
  name: "CalendarView",
  components: {
    HeaderNav,
    CalendarIndex,
    DiaryDetail,
    FooterInfo2,
  },
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
    selectDate(day) {
      const date = day._d;
      if (!date) return;

      const selected = dateFormat(date);

      let flag = true;

      for (var d of this.$store.state.selectedDates) {
        if (selected == d) {
          flag = false;
          break;
        }
      }

      if (flag) {
        this.$store.commit("CLEAR_DIARY");
        this.$router.go(0);
        return;
      }

      this.$store.dispatch("selectDate", selected);
      this.$store.dispatch("getDiary", selected);

      this.modalType = "detail";
      this.modalShow = true;
    },
  },
};
</script>

<style scoped>
.card-group {
  position: absolute;
  display: flex;
  top: 30px;
  left: 320px;
}
.calendar-card {
  width: 730px;
  height: 800px;
  background: #ffffff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
}

.diary-card {
  width: 720px;
  height: 800px;
  background: #ffffff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
  margin-left: 20px;
}
</style>
