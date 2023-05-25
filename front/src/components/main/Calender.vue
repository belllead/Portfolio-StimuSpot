<template>
  <div class="container">
    <div class="title">다이어리</div>
    <!-- calendar -->
    <v-date-picker
      v-model="date"
      :attributes="attributes"
      class="main-calendar"
      color="yellow"
      @input="selectDate"
    />

    <div class="btns">
      <router-link :to="{ name: 'CalendarView' }"
        ><button-basic-1 class="basic-btn"></button-basic-1>
      </router-link>
      <div class="click" @click="writeModalOpen">
        <button-basic-6 class="diary-btn" />
      </div>
      <!-- <div class="arrow-btns">
        <button-arrow-left class="left-btn" />
        <button-arrow-right class="right-btn" />
      </div> -->
    </div>

    <!-- modal -->
    <transition name="slide-modal">
      <div class="modalBg" v-if="modalShow">
        <write-modal
          class="card"
          :modalType="modalType"
          :modalShow="modalShow"
          @modalClose="modalClose"
          @refreshDates="refreshDates"
        />
      </div>

      <!-- <div class="modal" v-if="modalShow">
      <label for="title">제목</label>
      <div class="view">{{ diary.diaryTitle }}</div>
      <br />
      <label for="regdate">날짜</label>
      <div class="view">{{ diary.diaryRegdate }}</div>
      <br />
      <label for="rating">성취도</label>
      <br />
      <div id="rating" class="main-calendar-rating-box">
        <div>
          <div v-if="diary.diaryRating > 0" class="main-rating-container"></div>
          <div v-else class="main-rating-container-grey"></div>
        </div>
        <div>
          <div v-if="diary.diaryRating > 1" class="main-rating-container"></div>
          <div v-else class="main-rating-container-grey"></div>
        </div>
        <div>
          <div v-if="diary.diaryRating > 2" class="main-rating-container"></div>
          <div v-else class="main-rating-container-grey"></div>
        </div>
        <div>
          <div v-if="diary.diaryRating > 3" class="main-rating-container"></div>
          <div v-else class="main-rating-container-grey"></div>
        </div>
      </div>
      <br />
      <hr />
      <label for="content">내용</label>
      <div class="view">{{ diary.diaryContent }}</div>
      <br />
      <br />
      <br />
      <br />
      <router-link to="/calendar" class="btn">수정하기</router-link>
      <button @click="modalClose">창 닫기</button>
    </div> -->
    </transition>
  </div>
</template>

<script>
import { mapState } from "vuex";
import { ref } from "vue";
import ButtonBasic1 from "../ui-element/ButtonBasic1.vue";
import ButtonBasic6 from "../ui-element/ButtonBasic6.vue";
import { dateFormat } from "@/util/dateFormat";
import WriteModal from "./include/WriteModal.vue";
// import ButtonArrowLeft from "../ui-element/ButtonArrowLeft.vue";
// import ButtonArrowRight from "../ui-element/ButtonArrowRight.vue";

export default {
  name: "CalenderUi",
  components: { ButtonBasic1, ButtonBasic6, WriteModal },
  data() {
    const date = new Date();
    const year = date.getFullYear();
    const month = date.getMonth();
    const attributes = ref([
      {
        key: "part",
        highlight: {
          color: "red",
          fillMode: "outline",
          contentClass: "italic",
        },
        dates: [],
      },
    ]);
    return {
      test: "",
      modalShow: false,
      masks: {
        weekdays: "WWW",
      },
      date,
      year,
      month,
      attributes,
      modalType: "",
    };
  },
  computed: {
    ...mapState(["diary", "diaryParts", "selectedDate", "selectedDates"]),
  },
  created() {
    this.$store.dispatch("setMonthlyDiaryDates");
    this.attributes[0].dates = this.selectedDates;
    if (!this.selectedDates.length) this.$router.go(0);
  },
  methods: {
    selectDate(date) {
      if (!date) return;

      const selected = dateFormat(date);

      let flag = true;

      for (var d of this.selectedDates) {
        if (selected == d) {
          flag = false;
          break;
        }
      }

      if (flag) return;

      this.$store.dispatch("selectDate", selected);
      this.$store.dispatch("getDiary", selected);

      this.modalType = "detail";
      this.modalShow = true;
    },
    refreshDates() {
      console.log("됐을까?");
      this.$store.dispatch("setMonthlyDiaryDates");
      this.attributes[0].dates = this.selectedDates;
      this.$router.go(0);
      this.modalShow = false;
    },
    writeModalOpen() {
      // const today = dateFormat(new Date());

      // let flag = true;

      // for (var d of this.selectedDates) {
      //   if (today == d) {
      //     flag = false;
      //     break;
      //   }
      // }

      // if (flag) {
      //   this.modalType = "write";
      // } else {
      //   this.$store.dispatch("selectDate", today);
      //   this.$store.dispatch("getDiary", today);

      //   this.modalType = "detail";
      // }
      this.modalType = "write";
      this.modalShow = true;
    },
    modalClose() {
      this.modalShow = false;
      this.test = null;
    },
  },
};
</script>

<style scoped>
.title {
  position: absolute;
  left: 80px;
  top: 60px;
  font-size: 1.2em;
  font-weight: 600;
}

.main-calendar {
  width: 270px;
  height: 330px;
  border: none;
  margin-top: 120px;
}

.main-calendar .v-date-picker-table-cell {
  padding: 20px;
  margin: 20px;
  height: 60px;
}

.btns {
  display: flex;
  justify-content: space-between;
  margin: 0 80px 0;
}

.arrow-btns {
  display: flex;
}
.basic-btn {
  width: 80px;
  height: 40px;
  color: #a0a0a0;
}

.diary-btn {
  width: 80px;
  height: 40px;
  color: #a0a0a0;
}

.left-btn {
  width: 40px;
  height: 40px;
  color: #a0a0a0;
}

.right-btn {
  width: 40px;
  height: 40px;
  color: #a0a0a0;
}

.modalBg {
  position: absolute;
  width: 1620px;
  height: 1000px;
  top: -48px;
  left: 76px;

  background: rgba(0, 0, 0, 0.12);

  border: 1px solid rgba(255, 255, 255, 0.12);

  box-shadow: 0px 4px 30px rgba(0, 0, 0, 0.1),
    inset 0px 0px 4px rgba(0, 0, 0, 0.24);
  backdrop-filter: blur(15px);

  border-radius: 8px;
  z-index: 1;
}

.card {
  margin: 32px 0 0 -80px;
}
.modal {
  position: absolute;
  top: 0;
  left: 446px;

  width: 720px;
  height: 880px;

  background-color: white;
  color: black;
  text-align: left;

  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
  z-index: 1;
}

.view {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  font-size: medium;
}

.main-rating-container {
  background-image: url(@/assets/star.png);
  background-size: contain;
  width: 30px;
  height: 30px;
}

.main-rating-container-grey {
  background-image: url(@/assets/star_grey.png);
  background-size: contain;
  width: 30px;
  height: 30px;
}

.main-calendar-rating-box {
  display: inline-flex;
}

.slide-modal-enter-active {
  transition: transform 0.5s ease;
}

.slide-modal-leave-active {
  transition: transform 0.5s ease;
}

.slide-modal-enter {
  transform: translateX(100%);
}

.slide-modal-leave-to {
  transform: translateX(100%);
}
</style>
