<template>
  <div>
    <header-nav></header-nav>
    <h2>다이어리</h2>
    <div class="diary-body">
      <div class="diary-calendar">
        <div class="calendar__inner">
          <CalendarIndex :events="events" @add="add" />
        </div>
        <!--      *********************************      -->
      </div>
      <div class="diary-diary">
        <div class="regist_form">
          <label for="title">제목</label>
          <input
            type="text"
            id="title"
            class="view"
            name="diary_title"
            v-model="diary.diary_title"
            ref="diary_title"
          />
          <label for="regdate">날짜</label>
          <input
            type="text"
            id="regdate"
            class="view"
            name="diary_regdate"
            v-model="diary.diary_regdate"
            ref="diary_regdate"
          /><br />
          <label for="rating">성취도</label>
          <div class="starpoint_wrap" id="rating">
            <div class="starpoint_box">
              <label for="starpoint_1" class="label_star" title="0.5"
                ><span class="blind">0.5</span></label
              >
              <label for="starpoint_2" class="label_star" title="1"
                ><span class="blind">1</span></label
              >
              <label for="starpoint_3" class="label_star" title="1.5"
                ><span class="blind">1.5</span></label
              >
              <label for="starpoint_4" class="label_star" title="2"
                ><span class="blind">2</span></label
              >
              <label for="starpoint_5" class="label_star" title="2.5"
                ><span class="blind">2.5</span></label
              >
              <label for="starpoint_6" class="label_star" title="3"
                ><span class="blind">3</span></label
              >
              <label for="starpoint_7" class="label_star" title="3.5"
                ><span class="blind">3.5</span></label
              >
              <label for="starpoint_8" class="label_star" title="4"
                ><span class="blind">4</span></label
              >
              <label for="starpoint_9" class="label_star" title="4.5"
                ><span class="blind">4.5</span></label
              >
              <label for="starpoint_10" class="label_star" title="5"
                ><span class="blind">5</span></label
              >
              <input
                type="radio"
                name="starpoint"
                id="starpoint_1"
                class="star_radio"
                v-model="diary.diary_rating"
                value=0.5
              />
              <input
                type="radio"
                name="starpoint"
                id="starpoint_2"
                class="star_radio"
                v-model="diary.diary_rating"
                value=1
              />
              <input
                type="radio"
                name="starpoint"
                id="starpoint_3"
                class="star_radio"
                v-model="diary.diary_rating"
                value=1.5
              />
              <input
                type="radio"
                name="starpoint"
                id="starpoint_4"
                class="star_radio"
                v-model="diary.diary_rating"
                value=2
              />
              <input
                type="radio"
                name="starpoint"
                id="starpoint_5"
                class="star_radio"
                v-model="diary.diary_rating"
                value=2.5
              />
              <input
                type="radio"
                name="starpoint"
                id="starpoint_6"
                class="star_radio"
                v-model="diary.diary_rating"
                value=3
              />
              <input
                type="radio"
                name="starpoint"
                id="starpoint_7"
                class="star_radio"
                v-model="diary.diary_rating"
                value="3.5"
              />
              <input
                type="radio"
                name="starpoint"
                id="starpoint_8"
                class="star_radio"
                v-model="diary.diary_rating"
                value=4
              />
              <input
                type="radio"
                name="starpoint"
                id="starpoint_9"
                class="star_radio"
                v-model="diary.diary_rating"
                value=4.5
              />
              <input
                type="radio"
                name="starpoint"
                id="starpoint_10"
                class="star_radio"
                v-model="diary.diary_rating"
                value=5
              />
              <span class="starpoint_bg"></span>
            </div>
          </div>
          <br />
          <label for="parts">자극 부위</label>
          <div class ="parts">
            <input type="checkbox" id="check1" value="bicep" v-model="DiaryParts" />
            <label for="check1">이두</label>
            <input type="checkbox" id="check2" value="tricep" v-model="DiaryParts"/>
            <label for="check2">삼두</label>
            <input type="checkbox" id="check3" value="forearm" v-model="DiaryParts"/>
            <label for="check3">전완근</label>
            <input type="checkbox" id="check4" value="shoulder" v-model="DiaryParts"/>
            <label for="check4">어깨</label>
            <input type="checkbox" id="check5" value="chest" v-model="DiaryParts"/>
            <label for="check5">가슴</label>
            <input type="checkbox" id="check6" value="abs" v-model="DiaryParts" />
            <label for="check6">복근</label>
            <input type="checkbox" id="check7" value="back" v-model="DiaryParts"/>
            <label for="check7">등</label>
            <input type="checkbox" id="check8" value="glute" v-model="DiaryParts"/>
            <label for="check8">엉덩이</label>
            <input type="checkbox" id="check9" value="thigh" v-model="DiaryParts"/>
            <label for="check9">허벅지</label>
            <input type="checkbox" id="check10" value="calf" v-model="DiaryParts"/>
            <label for="check10">종아리</label>
          </div>
          <label for="content">내용</label>
          <textarea
            id="content"
            name="diary_content"
            v-model="diary.diary_content"
            ref="diary_content"
          ></textarea
          ><br />
          <button @click="registDiary">등록</button>
          <button @click="modifyDiary">수정</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import HeaderNav from "@/components/common/HeaderNav.vue";
import CalendarIndex from '@/components/calendar/calendarIndex.vue'

export default {
  name: "CalendarView",
  data() {
    return {
      Diary:{
        diary_id: 0,
        diary_title: "",
        diary_regdate: "",
        diary_rating: "",
        diary_content: "",
      },
      DiaryParts: [],
     events: [],
    type: ['info', 'warning', 'error'],
    };
  },
  components: { HeaderNav,CalendarIndex },
  computed: {
    ...mapState(["diary"]),
    ...mapState(["diaryParts"]),
  },
  ounted() {
    const data = this.$moment().clone();
    this.events = [
      { id: 1, name: 'Event 1', type: this.random(), date: data },
      { id: 2, name: 'Event 2', type: this.random(), date: data },
      { id: 3, name: 'Event 3', type: this.random(), date: data },
      { id: 4, name: 'Event 4', type: this.random(), date: data.clone().add(3, 'day') },
      { id: 5, name: 'Event 5', type: this.random(), date: data.clone().add(3, 'day') },
      { id: 6, name: 'Event 6', type: this.random(), date: data.clone().add(6, 'day') },
      { id: 8, name: 'Event 7', type: this.random(), date: data.clone().add(16, 'day') },
      { id: 9, name: 'Event 7', type: this.random(), date: data.clone().add(19, 'day') },
      { id: 10, name: 'Event 7', type: this.random(), date: data.clone().add(35, 'day') },
    ];
  },
  created() {
    this.Diary = this.diary;
    this.DiaryParts = this.diaryParts;
  },
  methods: {
    random() {
      return this.type[Math.floor(Math.random() * this.type.length)];
    },
    add() {
      const data = this.$moment().clone();
      const maxId = Math.max(...this.events.map(item => item.id)) + 1;
      this.events.push({ id: maxId, name: 'Event ' + maxId, type: this.random(), date: data.clone().add(maxId - 10, 'day') });

    },
    registDiary() {},
    modifyDiary() {},
  },
};
</script>

<style>
.diary-body {
  display: inline-flex;
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: center;
  padding: 50px 0 0 0;
  align-items: center;
  /* background-color: #f5f5f5; */
}

.diary-calendar{
  width: 1000px;
}

.calendar__inner {
  width: 900px;
  padding: 20px;
  border: solid 2px black;
}

.diary-diary{
  width:500px;
  height: 620px;
  border: solid 2px black;

}

.parts {
  border: solid 1px black;
}

label {
  display: inline-block;
  width: 95px;
}

textarea {
  width: 100%;
  height: 200px;
  padding: 10px;
  box-sizing: border-box;
  border: solid 1px black;
  border-radius: 5px;
  font-size: 16px;
  resize: both;
}

.view {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  font-size: medium;
}

.starpoint_wrap {
  display: inline-block;
}
.starpoint_box {
  position: relative;
  background: url(@/assets/stars.png) 0 0 no-repeat;
  font-size: 0;
}
.starpoint_box .starpoint_bg {
  display: block;
  position: absolute;
  top: 0;
  left: 0;
  height: 18px;
  background: url(@/assets/stars.png) 0 -20px no-repeat;
  pointer-events: none;
}
.starpoint_box .label_star {
  display: inline-block;
  width: 10px;
  height: 18px;
  box-sizing: border-box;
}
.starpoint_box .star_radio {
  opacity: 0;
  width: 0;
  height: 0;
  position: absolute;
}
.starpoint_box .star_radio:nth-of-type(1):hover ~ .starpoint_bg,
.starpoint_box .star_radio:nth-of-type(1):checked ~ .starpoint_bg {
  width: 10%;
}
.starpoint_box .star_radio:nth-of-type(2):hover ~ .starpoint_bg,
.starpoint_box .star_radio:nth-of-type(2):checked ~ .starpoint_bg {
  width: 20%;
}
.starpoint_box .star_radio:nth-of-type(3):hover ~ .starpoint_bg,
.starpoint_box .star_radio:nth-of-type(3):checked ~ .starpoint_bg {
  width: 30%;
}
.starpoint_box .star_radio:nth-of-type(4):hover ~ .starpoint_bg,
.starpoint_box .star_radio:nth-of-type(4):checked ~ .starpoint_bg {
  width: 40%;
}
.starpoint_box .star_radio:nth-of-type(5):hover ~ .starpoint_bg,
.starpoint_box .star_radio:nth-of-type(5):checked ~ .starpoint_bg {
  width: 50%;
}
.starpoint_box .star_radio:nth-of-type(6):hover ~ .starpoint_bg,
.starpoint_box .star_radio:nth-of-type(6):checked ~ .starpoint_bg {
  width: 60%;
}
.starpoint_box .star_radio:nth-of-type(7):hover ~ .starpoint_bg,
.starpoint_box .star_radio:nth-of-type(7):checked ~ .starpoint_bg {
  width: 70%;
}
.starpoint_box .star_radio:nth-of-type(8):hover ~ .starpoint_bg,
.starpoint_box .star_radio:nth-of-type(8):checked ~ .starpoint_bg {
  width: 80%;
}
.starpoint_box .star_radio:nth-of-type(9):hover ~ .starpoint_bg,
.starpoint_box .star_radio:nth-of-type(9):checked ~ .starpoint_bg {
  width: 90%;
}
.starpoint_box .star_radio:nth-of-type(10):hover ~ .starpoint_bg,
.starpoint_box .star_radio:nth-of-type(10):checked ~ .starpoint_bg {
  width: 100%;
}

.blind {
  position: absolute;
  clip: rect(0 0 0 0);
  margin: -1px;
  width: 1px;
  height: 1px;
  overflow: hidden;
}

.pa-5 {
  padding: 5px;
}

.mb-4 {
  margin-bottom: 4px;
}

.cols-6 {
  width: 50%;
}

.my-auto {
  margin-top: auto;
  margin-bottom: auto;
}

.dense {
  padding: 4px;
}

.dark {
  color: #fff;
  background-color: #333;
}

.dark .v-text-field__slot input {
  color: #fff;
}

.dark .v-select .v-select__selections input {
  color: #fff;
}

.dark .v-btn {
  color: #fff;
}

.dark .v-btn:focus {
  background-color: #333;
}

.dark .v-btn:hover {
  background-color: #555;
}

.dark .v-btn:active {
  background-color: #777;
}

.dark .v-date-picker-header,
.dark .v-date-picker-date-table {
  background-color: #333;
}

.dark .v-date-picker-title button:focus,
.dark .v-date-picker-title button:hover {
  background-color: #333;
}

.dark .v-date-picker-date--current {
  color: #fff;
  background-color: #555;
}
</style>
