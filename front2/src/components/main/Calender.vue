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
      <router-link to="/calendar" class="btn">전체보기</router-link>
    </div>
    <div class="modal" v-if="modalShow == true">
      <div>
        <h4>모달 제목</h4>
        <p>모달 상세 내용</p>
        <button @click="modalClose">창 닫기</button>
      </div>
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
    ...mapState(["diaries"]),

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
      alert(s1);
      this.modalShow = true;
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
  top: 200px;
  left: 700px;
  width: 500px;
  height: 500px;
  background-color: lightblue;
  color: white;
  border: solid black;
}
</style>
