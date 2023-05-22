<template>
  <div class="calendar">
    <div>
      <div class="calendar__date">
        <span class="calendar__prev" @click="next(-1)">&#5176;</span>
        <h3 class="calendar__month">{{ nowMonth }}</h3>
        <span class="calendar__next" @click="next(1)">&#5171;</span>
      </div>
      <div class="calendar__btn" @click="$emit('add', $event)">+</div>
    </div>
    <div class="calendar__header">
      <div v-for="day of daysWeek" :key="day" class="calendar__day">
        {{ day }}
      </div>
    </div>
    <div class="calendar__body">
      <CalendarCell
        v-for="(day, i) of days"
        :key="'day_' + i"
        v-bind="day"
        @select="click"
      >
        <CalendarBadge
          v-for="(badge, i) of getBadges(day)"
          :key="`badge_${i}`"
          v-bind="badge"
        />
      </CalendarCell>
    </div>
  </div>
</template>

<script>
import CalendarCell from "./composition/CalendarCell.vue";
import CalendarBadge from "./composition/CalendarBadge.vue";

export default {
  name: "CalendarIndex",
  components: {
    CalendarCell,
    CalendarBadge,
  },
  props: {
    events: {
      type: Array,
      default: () => [],
    },
  },
  data() {
    return {
      // 선택된 날짜
      select: null,
      // 현재 기준인 날짜 (기본은 오늘, next()가 눌리면 한달 단위로 변경)
      date: null,
      month: 0,
      daysWeek: [
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
      ],
    };
  },
  computed: {
    // 달력 상단에 띄우는 지금 보고 있는 년월 정보
    // 현재 날짜 기준으로 렌더링
    nowMonth() {
      const year = this.date.year();
      const month = this.date.format("MMMM");
      return `${year} ${month}`;
    },
    // 표시할 날짜의 배열
    days() {
      // 이번 달의 시작 날짜
      const monthStart = this.date.clone().startOf("month");
      // 이번 달의 끝 날짜
      const monthEnd = this.date.clone().endOf("month");
      // 이번 달의 시작 날짜가 속한 주의 시작하는 날짜(일요일)
      const weekStart = monthStart.clone().startOf("week");
      // console.log(
      //   [...Array(monthEnd.diff(weekStart, "days") >= 35 ? 42 : 35)].map(
      //     (_, i) => {
      //       const day = weekStart.clone().add(i, "day");
      //       const active = this.active(day);
      //       return { day, active, date: this.date };
      //     }
      //   )
      // );
      // 이번 달의 끝 날짜와 시작 주의 첫 날짜 차이가 35보다 크거나 같으면
      // 42개의 원소를 가진 배열 반환 / 작으면 35개 원소 => 6주를 표기할지 5주를 표기할지
      // 해당 원소는 객체로 채움
      // day: 해당 원소가 나타내는 날짜 = 달력에 제일 처음 보이는 (시작 주의 시작일) 날짜 + 인덱스
      // active: 활성화된 날짜인지
      // date: 기준일
      return [...Array(monthEnd.diff(weekStart, "days") >= 35 ? 42 : 35)].map(
        (_, i) => {
          const day = weekStart.clone().add(i, "day");
          const active = this.active(day);
          return { day, active, date: this.date };
        }
      );
    },
  },
  methods: {
    // 오늘 날짜를 한 달 뒤(value = 1)나 한 달 앞(value = -1)으로 바꾸기
    next(value) {
      this.date = this.date.add(value, "month").clone();
    },
    // 매개변수로 주어진 day가
    // 1. select된 날짜와 같거나
    // 2. 현재(오늘) 날짜와 같은지
    // 판단해서 boolean 반환
    active(day) {
      const select = this.select || this.$moment().clone();
      return select.isSame(day, "day");
    },
    click(day) {
      // 눌린 날짜가 오늘보다 앞 월이면 앞 월로 달력 바꾸기 (뒷 월이면 뒤로)
      const before = this.date.isBefore(day, "month");
      const after = this.date.isAfter(day, "month");
      if (after || before) {
        this.next(after ? -1 : 1);
      }

      // select 날짜를 눌린 날짜로 설정
      this.select = day;

      let dd = this.select._d.getDate();
      let mm = this.select._d.getMonth() + 1;
      let yyyy = this.select._d.getFullYear();
      if (dd < 10) {
        dd = "0" + dd;
      }
      if (mm < 10) {
        mm = "0" + mm;
      }

      yyyy = yyyy.toString();
      mm = mm.toString();
      dd = dd.toString();

      let s1 = yyyy + "-" + mm + "-" + dd;

      this.$store.dispatch("selectDate", `${s1}`);
    },
    getBadges({ day }) {
      // props로 받은 event(일정) 배열에서 화면에 표시하는 날과 같은 날을 가진 이벤트면 표시
      return this.events.filter((item) => item.date.isSame(day, "day"));
    },
  },
  created() {
    this.date = this.$moment().clone();
  },
};
</script>

<style>
.calendar {
  width: 100%;
  min-height: 600px;
  border-radius: 20px;
  background-color: #ffffff;
  user-select: none;
  padding: 5px 5px 10px 5px;
  position: relative;
}
.calendar__date {
  display: flex;
  align-items: center;
  height: 50px;
  padding: 10px 20px;
}
.calendar__date span {
  height: 25px;
  width: 25px;
  cursor: pointer;
  text-align: center;
}
.calendar__month {
  margin: 0 5px;
  min-width: 110px;
  text-align: center;
  text-transform: uppercase;
  color: #3c32c9;
}
.calendar__header {
  padding: 0 10px;
  display: grid;
  grid-template-columns: repeat(7, 1fr);
}
.calendar__day {
  text-align: end;
}

.calendar__body {
  background-color: #efefef;
  padding: 2px;
  margin: 10px;
  border-radius: 5px;
  display: grid;
  grid-template-columns: repeat(7, 1fr);
  gap: 2px;
}
.calendar__btn {
  height: 30px;
  width: 30px;
  background-color: indigo;
  color: ivory;
  cursor: pointer;
  border-radius: 5px;
  display: flex;
  align-items: center;
  justify-content: center;
  position: absolute;
  font-size: 20px;
  top: 10px;
  right: 20px;
}
</style>
