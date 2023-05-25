<template>
  <div class="modal" v-if="modalShow">
    <diary-detail v-if="modalType == 'detail'" @modalClose="modalClose" />
    <diary-write v-if="modalType == 'write'" @modalClose="modalClose" />
  </div>
</template>

<script>
import DiaryDetail from "../../calendar/diary/DiaryDetail.vue";
import DiaryWrite from "../../calendar/diary/DiaryWrite.vue";
export default {
  components: { DiaryDetail, DiaryWrite },
  name: "WriteModal",
  data() {
    return {
      diary: {
        diaryId: 0,
        diaryTitle: "",
        diaryRegdate: "",
        diaryRating: "",
        diaryContent: "",
      },
      DiaryParts: [],
    };
  },
  props: {
    modalType: String,
    modalShow: Boolean,
  },
  methods: {
    modalClose() {
      this.$emit("modalClose");
    },
  },
};
</script>

<style scoped>
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
