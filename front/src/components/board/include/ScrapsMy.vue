<template>
  <div>
    <div>
      <div v-if="scrapCnt" class="scrapbox">
        <div
          class="scrap"
          v-for="(scrap, index) in currentScraps"
          :key="index"
          @click="getDetail(scrap)"
          @mouseenter="showScrapTitle(index)"
          @mouseleave="hideScrapTitle(index)"
        >
          <div>
            <div class="scrap_title">
              {{ scrap.scrapTitle }}
            </div>
          </div>
          <div>
            <img
              class="scrap_img"
              :src="scrap.scrapThumbnail"
              alt="Thumbnail"
              style="max-width: 100%"
            />
          </div>
        </div>
        <div v-if="scrapCnt<=5" class="noscrap"></div>
        <div v-if="scrapCnt<=4" class="noscrap"></div>
        <div v-if="scrapCnt<=3" class="noscrap"></div>
        <div v-if="scrapCnt<=2" class="noscrap"></div>
        <div v-if="scrapCnt<=1" class="noscrap"></div>
        <div v-if="scrapCnt<=0" class="noscrap"></div>
        <div class = "btngroup">
          <div>
            <button
              @click="previousPage"
              :disabled="currentPage === 1"
              class="arrow-button top"
            >
              <span class="arrow-up"></span>
            </button>
            <br />
            <button
              @click="nextPage"
              :disabled="currentPage === totalPages"
              class="arrow-button bottom"
            >
              <span class="arrow-down"></span>
            </button>
          </div>
        </div>
      </div>
    </div>
    <transition name="slide-modal">
      <div class="scrapmodal" v-if="modalview == true">
        <div class="modalcontent" v-if="modalview == true">
          <div class="left">
            <br>
            <br>
            <a :href="Scrap.scrapUrl">
              <img :src="Scrap.scrapThumbnail" alt="thumbnail" />
            </a><br/>
            <h4>{{"< " + Scrap.scrapVtitle + " >"}}</h4>
            <label for="title">제목</label>
            <input
              class="view"
              id="title"
              type="text"
              v-model="Scrap.scrapTitle"
            /><br />
            <label for="content">내용</label>
            <textarea
              class="view"
              id="content"
              cols="100"
              rows="15"
              v-model="Scrap.scrapContent"
            ></textarea
            ><br />
            <div class="btns">
              <button @click="updateScrap">수정</button>
              <button @click="deleteScrap">삭제</button>
              <button @click="modalClose">닫기</button>
            </div>
          </div>
          <hr>
          <div class="right">
            <!-- <comments-my :id="Scrap.scrapId"></comments-my> -->
          </div> 
        </div>
      </div>
    </transition>
  </div>
</template>

<script>
// import CommentsMy from "@/components/board/include/CommentsMy.vue";
import { mapState, mapGetters } from "vuex";
export default {
  name: "ScrapsMy",
  components: {
    // CommentsMy
  },
  data() {
    return {
      scrapTitles: [],
      currentPage: 1,
      perPage: 6,
      plugin: null,
      modalview: false,
      myVideos: [{}],
      Scrap: {
        scrapId: 0,
        userNum: "",
        scrapTitle: "",
        scrapUrl: "",
        scrapVtitle: "",
        scrapThumbnail: "",
        scrapContent: "",
        scrapRegdate: "",
      },
    };
  },
  computed: {
    currentScraps() {
      const startIndex = (this.currentPage - 1) * this.perPage;
      const endIndex = startIndex + this.perPage;
      return this.scraps.slice(startIndex, endIndex);
    },
    totalPages() {
      return Math.ceil(this.scraps.length / this.perPage);
    },
    ...mapState(["scrap"]),
    ...mapState(["scraps"]),
    ...mapState(["comments"]),
    ...mapGetters(["scrapCnt"]),
  },
  created() {
    this.$store.dispatch("setScraps");
  },
  methods: {
    showScrapTitle(index) {
    this.$set(this.scrapTitles, index, true); // 해당 인덱스의 scrap에 대한 title을 표시
  },
  hideScrapTitle(index) {
    this.$set(this.scrapTitles, index, false); // 해당 인덱스의 scrap에 대한 title을 숨김
  },
    previousPage() {
      if (this.currentPage > 1) {
        this.currentPage--;
      }
    },
    nextPage() {
      if (this.currentPage < this.totalPages) {
        this.currentPage++;
      }
    },
    getDetail(scrap) {
      console.log(scrap);
      this.modalview = !this.modalview;
      this.Scrap = scrap;
    },
    modalClose() {
      this.modalview = false;
    },
    updateScrap() {
      this.$store.dispatch("updateScrap", this.Scrap);
      this.modalview = !this.modalview;
      this.$router.go(this.$router.currentRoute)
    },
    deleteScrap() {
      this.$store.dispatch("deleteScrap", this.Scrap.scrapId);
      this.modalview = !this.modalview;
      this.$router.go(this.$router.currentRoute)
    },
  },
};
</script>

<style scoped>
.scrapbox {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  height: 280px;
}

.scrap {
  width: 200px;
  height: 200px;
  /* border: solid black; */
  background-color: #D9D9D9;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
  margin: 10px;
  margin-top: 25px;
}

.noscrap {
  width: 200px;
  height: 200px;
  background-color: #D9D9D9;
  border-radius: 8px;
  margin: 10px;
  margin-top: 25px;
}

.scrap:hover{
  transform: scale(1.05);
}

.noscrap:hover{
  transform: scale(1.05);
}

.scrap_title {
  display: block;
  transition: opacity 0.2s ease;
  opacity: 0;
}

.scrap:hover .scrap_title {
  opacity: 1;
}

.scrap_img {
  width: 150px;
  height: 150px;
}

.scrapmodal {
  box-sizing: border-box;
  position: absolute;
  width: 1500px;
  height: 950px;
  left: 76px;
  top: -20px;
  background: rgba(0, 0, 0, 0.12);
  border: 1px solid rgba(255, 255, 255, 0.12);
  box-shadow: 0px 4px 30px rgba(0, 0, 0, 0.1),
    inset 0px 0px 4px rgba(0, 0, 0, 0.24);
  backdrop-filter: blur(15px);
  border-radius: 8px;
  z-index: 1;
}

.modalcontent{
  position: absolute;
  width: 1094px;
  height: 920px;
  left: 190px;
  top: calc(50% - 920px/2);
  background: #FFFFFF;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
  display: flex;
  flex-direction: row;
}

.left{
  width:75%;
}

.right{
  width:25%;
}

.btngroup{
  display: flex; 
  flex-direction: column; 
  margin: auto;
}

.btns button{
  background-color: #FFFFFF;
  border-radius: 4px;
  border: solid 1px D9D9D9;
  color: D9D9D9;
  margin-left: 10px;
}
.arrow-button {
  position: relative;
  padding: 8px 16px;
  border: 1px solid #ccc;
  background-color: #f0f0f0;
  cursor: pointer;
  transition: transform 0.2s ease;
}

.arrow-button:hover {
  transform: scale(1.05);
}

.arrow-up::before {
  content: "v";
  transform: rotate(180deg);
}

.arrow-down::before {
  content: "v";
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
