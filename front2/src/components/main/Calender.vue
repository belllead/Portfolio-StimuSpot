<template>
  <div>
    <div class="main-calendar">
      <h4>다이어리</h4>
      <div class="">
        <v-date-picker
          v-model="date"
          @input="selectDate"
          :attributes="attributes"
        />
      </div>
      <br />
    </div>
    <div class="modal" v-if="modalShow == true">
      <label for="title">제목</label>
      <div class="view">{{ diary.diary_title }}</div>
      <br />
      <label for="regdate">날짜</label>
      <div class="view">{{ diary.diary_regdate }}</div>
      <br />
      <label for="rating">성취도</label>
      <br />
      <div id="rating" class="main-calendar-rating-box">
        <div>
          <div
            v-if="diary.diary_rating > 0"
            class="main-rating-container"
          ></div>
          <div v-else class="main-rating-container-grey"></div>
        </div>
        <div>
          <div
            v-if="diary.diary_rating > 1"
            class="main-rating-container"
          ></div>
          <div v-else class="main-rating-container-grey"></div>
        </div>
        <div>
          <div
            v-if="diary.diary_rating > 2"
            class="main-rating-container"
          ></div>
          <div v-else class="main-rating-container-grey"></div>
        </div>
        <div>
          <div
            v-if="diary.diary_rating > 3"
            class="main-rating-container"
          ></div>
          <div v-else class="main-rating-container-grey"></div>
        </div>
        <div>
          <div
            v-if="diary.diary_rating > 4"
            class="main-rating-container"
          ></div>
          <div v-else class="main-rating-container-grey"></div>
        </div>
      </div>
      <br />
      <label for="parts">자극 부위</label>
      <div class="view">{{ diaryParts[0] }} 등</div>
      <br />
      <hr />
      <label for="content">내용</label>
      <div class="view">{{ diary.diary_content }}</div>
      <br />
      <br />
      <br />
      <br />
      <router-link to="/calendar" class="btn">수정하기</router-link>
      <button @click="modalClose">창 닫기</button>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import { ref } from "vue";

export default {
  name: "CalenderUi",
  components: {},
  data() {
    const date = new Date();
    const year = date.getFullYear();
    const month = date.getMonth();
    const attributes = ref([
      {
        key: "part",
        highlight: {
          color: "purple",
          fillMode: "solid",
          contentClass: "italic",
        },
        dates: [],
      },
    ]);
    return {
      modalShow: false,
      masks: {
        weekdays: "WWW",
      },
      date,
      year,
      month,
      attributes,
    };
  },
  computed: {
    ...mapState(["diary"]),
    ...mapState(["diaryParts"]),
    selectedDates() {
      return this.$store.state.selectedDates;
    },
  },
  created() {
    this.attributes[0].dates = this.selectedDates;
  },
  methods: {
    selectDate(date) {
      var dd = date.getDate();
      var mm = date.getMonth() + 1;
      var yyyy = date.getFullYear();
      if (dd < 10) {
        dd = "0" + dd;
      }
      if (mm < 10) {
        mm = "0" + mm;
      }

      yyyy = yyyy.toString();
      mm = mm.toString();
      dd = dd.toString();

      var s1 = yyyy + "-" + mm + "-" + dd;

      this.$store.dispatch("selectDate", `${s1}`);

      this.modalShow = true;
      // this.$store.dispatch("getDiary");
    },
    modalClose() {
      this.modalShow = false;
    },
  },
};
</script>

<style>
.modal {
  position: absolute;
  top: 150px;
  left: 600px;
  width: 700px;
  height: 700px;
  /* background-color: rgba(0, 0, 0, 0.4); */
  background-color: white;
  color: black;
  text-align: left;
  border-radius: 5px;
  border: solid black;
  padding: 20px;
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
</style>
