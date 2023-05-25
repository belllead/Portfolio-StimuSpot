<template>
  <div>
    <div>
      <div v-if="scrapCnt" class="scrapbox">
        <div
          class="scrap"
          v-for="(scrap, index) in currentScraps"
          :key="index"
          @click="getDetail(scrap)"
          :style="{
            'background-image': `url(${scrap.scrapThumbnail})`,
            'background-size': 'cover',
            'background-position': 'center',
          }"
        ></div>
        <div v-if="scrapCnt <= 5" class="noscrap"></div>
        <div v-if="scrapCnt <= 4" class="noscrap"></div>
        <div v-if="scrapCnt <= 3" class="noscrap"></div>
        <div v-if="scrapCnt <= 2" class="noscrap"></div>
        <div v-if="scrapCnt <= 1" class="noscrap"></div>
        <div v-if="scrapCnt <= 0" class="noscrap"></div>
        <div class="btngroup">
          <div>
            <button
              @click="previousPage"
              :disabled="currentPage === 1"
              class="arrow-button top"
            >
              <span class="arrow-up">&#8593;</span>
            </button>
            <br />
            <button
              @click="nextPage"
              :disabled="currentPage === totalPages"
              class="arrow-button bottom"
            >
              <span class="arrow-down"> &#8595;</span>
            </button>
          </div>
        </div>
      </div>
      <div v-else class="scrapbox">
        <div v-if="scrapCnt <= 5" class="noscrap"></div>
        <div v-if="scrapCnt <= 4" class="noscrap"></div>
        <div v-if="scrapCnt <= 3" class="noscrap"></div>
        <div v-if="scrapCnt <= 2" class="noscrap"></div>
        <div v-if="scrapCnt <= 1" class="noscrap"></div>
        <div v-if="scrapCnt <= 0" class="noscrap"></div>
      </div>
    </div>
    <transition name="slide-modal">
      <div class="scrapmodal" v-if="modalview == true">
        <div class="modalcontent" v-if="modalview == true">
          <div class="left">
            <br />
            <br />
            <youtube :video-id="Scrap.scrapUrl" ref="youtube"></youtube>
            <br />
            <h4>{{ "< " + Scrap.scrapVtitle + " >" }}</h4>
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
          <hr />
          <div class="right">
            <comments-my :id="Scrap.scrapId"></comments-my>
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>

<script>
import CommentsMy from "@/components/board/include/CommentsMy.vue";
import { mapState, mapGetters } from "vuex";
export default {
  name: "ScrapsMy",
  components: {
    CommentsMy,
  },
  data() {
    return {
      scrapTitles: [],
      currentPage: 1,
      perPage: 6,
      plugin: null,
      modalview: false,
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
    ...mapGetters(["commentsCnt"]),
  },
  created() {
    this.$store.dispatch("setScraps");
  },
  methods: {
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
      this.$store.dispatch("updateScrap", this.Scrap).then(() => {
        this.$store.dispatch("setScraps");
      });
      this.modalview = !this.modalview;
    },
    deleteScrap() {
      if (this.commentsCnt == 0) {
        this.$store.dispatch("deleteScrap", this.Scrap.scrapId).then(() => {
          this.$store.dispatch("setScraps");
        });
      } else {
        this.$store
          .dispatch("deleteCommentByScrap", this.Scrap.scrapId)
          .then(() => {
            return this.$store.dispatch("deleteScrap", this.Scrap.scrapId);
          })
          .then(() => {
            this.$store.dispatch("setScraps");
          });
      }
      this.modalview = !this.modalview;
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
  background-color: #d9d9d9;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
  margin: 10px;
  margin-top: 25px;
}

.noscrap {
  width: 200px;
  height: 200px;
  /* background-color: #d9d9d9; */
  border-radius: 8px;
  margin: 10px;
  margin-top: 25px;
}

.scrap:hover {
  transform: scale(1.05);
}

.noscrap:hover {
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

.modalcontent {
  position: absolute;
  width: 1094px;
  height: 920px;
  left: 190px;
  top: calc(50% - 920px / 2);
  background: #ffffff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
  display: flex;
  flex-direction: row;
}

.left {
  width: 75%;
}

.right {
  width: 25%;
}

.btngroup {
  display: flex;
  flex-direction: column;
  margin: auto;
}

.btns button {
  background-color: #ffffff;
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
  /* content: &#8593; */
  transform: rotate(180deg);
}

.arrow-down::before {
  /* content: "v"; */
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
