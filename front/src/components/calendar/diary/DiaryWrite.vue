<template>
  <div>
    <div class="diary-diary">
      <div class="regist_form">
        <div class="parts-group">
          <div class="parts-label" for="parts">자극 부위</div>
          <div class="checkbox-group">
            <input
              type="checkbox"
              class="checkbox"
              id="bicep"
              value="5"
              v-model.number="diaryParts"
            />
            <label class="part-label" for="bicep">이두</label>
            <input
              type="checkbox"
              class="checkbox"
              id="tricep"
              value="6"
              v-model.number="diaryParts"
            />
            <label class="part-label" for="tricep">삼두</label>
            <input
              type="checkbox"
              class="checkbox"
              id="forearm"
              value="2"
              v-model.number="diaryParts"
            />
            <label class="part-label" for="forearm">전완근</label>
            <input
              type="checkbox"
              class="checkbox"
              id="shoulder"
              value="7"
              v-model.number="diaryParts"
            />
            <label class="part-label" for="shoulder">어깨</label>
            <input
              type="checkbox"
              class="checkbox"
              id="chest"
              value="1"
              v-model.number="diaryParts"
            />
            <label class="part-label" for="chest">가슴</label>
            <div class="line-divider"></div>
            <input
              type="checkbox"
              class="checkbox"
              id="abs"
              value="4"
              v-model.number="diaryParts"
            />
            <label class="part-label" for="abs">복근</label>
            <input
              type="checkbox"
              class="checkbox"
              id="back"
              value="8"
              v-model.number="diaryParts"
            />
            <label class="part-label" for="back">등</label>
            <input
              type="checkbox"
              class="checkbox"
              id="glute"
              value="3"
              v-model.number="diaryParts"
            />
            <label class="part-label" for="glute">엉덩이</label>
            <input
              type="checkbox"
              class="checkbox"
              id="thigh"
              value="10"
              v-model.number="diaryParts"
            />
            <label class="part-label" for="thigh">허벅지</label>
            <input
              type="checkbox"
              class="checkbox"
              id="calf"
              value="9"
              v-model.number="diaryParts"
            />
            <label class="part-label" for="calf">종아리</label>
          </div>
        </div>

        <div class="title-group">
          <label class="title-label" for="title">제목</label>
          <input
            type="text"
            id="title"
            class="title-input"
            name="diaryTitle"
            v-model="diary.diaryTitle"
            ref="diaryTitle"
          />
        </div>

        <div class="flex-group">
          <div class="regdate-group">
            <label class="regdate-label" for="regdate">날짜</label>
            <input
              type="date"
              id="regdate"
              class="regdate-input"
              name="diaryRegdate"
              v-model="diary.diaryRegdate"
              ref="diaryRegdate"
              :max="today"
            />
          </div>

          <div class="rating-group">
            <label class="rating-label" for="rating">성취도</label>
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
                  v-model.number="diary.diaryRating"
                  value="0.5"
                />
                <input
                  type="radio"
                  name="starpoint"
                  id="starpoint_2"
                  class="star_radio"
                  v-model.number="diary.diaryRating"
                  value="1"
                />
                <input
                  type="radio"
                  name="starpoint"
                  id="starpoint_3"
                  class="star_radio"
                  v-model.number="diary.diaryRating"
                  value="1.5"
                />
                <input
                  type="radio"
                  name="starpoint"
                  id="starpoint_4"
                  class="star_radio"
                  v-model.number="diary.diaryRating"
                  value="2"
                />
                <input
                  type="radio"
                  name="starpoint"
                  id="starpoint_5"
                  class="star_radio"
                  v-model.number="diary.diaryRating"
                  value="2.5"
                />
                <input
                  type="radio"
                  name="starpoint"
                  id="starpoint_6"
                  class="star_radio"
                  v-model.number="diary.diaryRating"
                  value="3"
                />
                <input
                  type="radio"
                  name="starpoint"
                  id="starpoint_7"
                  class="star_radio"
                  v-model.number="diary.diaryRating"
                  value="3.5"
                />
                <input
                  type="radio"
                  name="starpoint"
                  id="starpoint_8"
                  class="star_radio"
                  v-model.number="diary.diaryRating"
                  value="4"
                />
                <input
                  type="radio"
                  name="starpoint"
                  id="starpoint_9"
                  class="star_radio"
                  v-model.number="diary.diaryRating"
                  value="4.5"
                />
                <input
                  type="radio"
                  name="starpoint"
                  id="starpoint_10"
                  class="star_radio"
                  v-model.number="diary.diaryRating"
                  value="5"
                />
                <rating-stars class="rating-stars" :starFill="starFill" />

                <span class="starpoint_bg"></span>
              </div>
            </div>
          </div>
        </div>

        <div class="content-group">
          <label class="content-label" for="content">내용</label>
          <textarea
            class="content-input"
            id="content"
            name="diary_content"
            v-model="diary.diaryContent"
            ref="diary_content"
          ></textarea>
        </div>
        <div class="btn-group">
          <span class="click" @click="registDiary">
            <button-basic-7 class="basic-btn" />
          </span>
          <span class="click" @click="modalClose"
            ><button-basic-8 class="basic-btn"
          /></span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import RatingStars from "../../ui-element/RatingStars.vue";
import ButtonBasic7 from "@/components/ui-element/ButtonBasic7.vue";
import ButtonBasic8 from "../../ui-element/ButtonBasic8.vue";
import { dateFormat } from "@/util/dateFormat";

export default {
  components: { RatingStars, ButtonBasic7, ButtonBasic8 },
  name: "DiaryDetail",
  data() {
    return {
      diary: {
        diaryId: 0,
        diaryTitle: "",
        diaryRegdate: "",
        diaryRating: 0,
        diaryContent: "",
      },
      diaryParts: [],
      today: "",
    };
  },
  created() {
    return (this.today = dateFormat(new Date()));
  },
  computed: {
    starFill() {
      return this.diary.diaryRating;
    },
  },
  methods: {
    registDiary() {
      this.$store.dispatch("registDiary", {
        diary: this.diary,
        diaryParts: this.diaryParts,
      });
    },
    modalClose() {
      this.$emit("modalClose");
    },
  },
};
</script>

<style scoped>
.parts-group {
  margin: 100px 64px 0;
  height: 84px;
  display: flex;
  flex-direction: column;
  align-items: start;
}

.parts-label {
  /* width: 140px; */
  /* height: 20px; */
  font-size: 1em;
  font-weight: 600;
}

.parts {
  font-size: 1em;
  margin: 12px 20px 0 0;
}

.checkbox-group {
  display: flex;
  flex-wrap: wrap;
}

.checkbox {
  margin-top: 12px;
  height: 20px;
}

.line-divider {
  width: 100%;
}

.part-label {
  font-size: 14px;
  margin: 11px 20px 0 4px;
}

/* -----title---- */

.title-group {
  margin: 40px 64px 0;
  height: 80px;
  display: flex;
  flex-direction: column;
  align-items: start;
}

.title-label {
  font-weight: 600;
}

.title-input {
  width: 313px;
  height: 48px;

  margin-top: 12px;
  padding: 1em;

  border: none;
  background: #eeeeee;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 4px;
}

.title-input:focus {
  outline: none;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04) inset;
}

/* -----regdate----- */

.flex-group {
  display: flex;
}

.regdate-group {
  margin: 40px 0 0 64px;
  height: 80px;
  width: 200px;
  display: flex;
  flex-direction: column;
  align-items: start;
}

.regdate-label {
  font-weight: 600;
}

.regdate-input {
  width: 181px;
  height: 48px;

  margin-top: 12px;
  padding: 1em;

  border: none;
  background: #eeeeee;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 4px;
}

.regdate-input:focus {
  outline: none;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04) inset;
}

/* -----rating----- */

.rating-group {
  margin: 40px 0 0 40px;
  height: 80px;
  width: 200px;
  display: flex;
  flex-direction: column;
  align-items: start;
}

.rating-label {
  font-weight: 600;
}

.starpoint_wrap {
  display: inline-block;
  width: 200px;
  height: 48px;
}
.starpoint_box {
  position: relative;
  /* background: url(@/assets/stars.png) 0 0 no-repeat; */
  font-size: 0;
}
.starpoint_box .label_star {
  display: inline-block;
  width: 19px;
  height: 40px;
  box-sizing: border-box;
  background-color: #fff;
  margin: 16px 1px 0 0;
}

.star_radio {
  display: none;
}

.rating-stars {
  margin-top: -40px;
  pointer-events: none;
}

/* -----content----- */

.content-group {
  margin: 40px 64px 0;
  height: 272px;
  display: flex;
  flex-direction: column;
  align-items: start;
}

.content-label {
  font-weight: 600;
}

.content-input {
  width: 100%;
  height: 240px;
  padding: 1em;
  box-sizing: border-box;
  resize: none;
  margin-top: 12px;

  border: none;
  background: #eeeeee;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 4px;
}

.content-input:focus {
  outline: none;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04) inset;
}

.btn-group {
  margin: 40px 64px 0;
  height: 40px;
  display: flex;
}

.basic-btn {
  width: 80px;
  height: 40px;
  margin-right: 12px;
}

input[type="date"] {
  font-family: "Noto Sans KR";
  font-size: 14px;
}
</style>
