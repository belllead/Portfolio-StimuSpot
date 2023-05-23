<!-- <template>
  <div>
    <h2>나의 스크랩</h2>
    <div class="test-wrap">
      <div class="carousel-wrap" v-if="scrapCnt">
        <carousel v-bind="options">
          <div
            v-for="(scrap, index) in scraps"
            :key="index"
            @click="getDetail(scrap.scrapId)"
          >
            <div>
              <div>
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
        </carousel>
      </div>
      <div v-else>스크랩한 동영상이 없습니다.</div>
    </div>
    <transition name="fade">
      <div class="scrapmodal" v-if="modalview == true">
        <label for="title">제목</label>
        <input
          class="view"
          id="title"
          type="text"
          v-model="Scrap.scrapTitle"
        /><br />
        <label for="vtitle">영상 제목</label>
        <input
          class="view"
          id="vtitle"
          type="text"
          v-model="Scrap.scrapVtitle"
        /><br />
        <a :href="Scrap.scrapUrl"
          ><img :src="Scrap.scrapThumbnail" alt="thumbnail" /></a
        ><br />
        <label for="content">내용</label>
        <textarea
          class="view"
          id="content"
          cols="100"
          rows="20"
          v-model="Scrap.scrapContent"
        ></textarea
        ><br />
        <hr />
        <comments-my :id="Scrap.scrapId"></comments-my>
        <button @click="updateScrap">수정</button>
        <button @click="deleteScrap">삭제</button>
        <button @click="modalClose">닫기</button>
      </div>
    </transition>
  </div>
</template>

<script>
// import carousel from "vue-owl-carousel2";
import CommentsMy from "@/components/board/include/CommentsMy.vue";
import { mapState, mapGetters } from "vuex";
export default {
  name: "ScrapsMy",
  components: {
    CommentsMy,
    // carousel,
  },
  data() {
    return {
      plugin: null,
      options: {
        autoplay: false,
        items: 3,
        startPosition: 2,
        autoPlayTimeout: 1000,
      },
      modalview: false,
      myVideos: [{}],
      Scrap: {
        scrapId: 0,
        scrapTitle: "",
        scrapUrl: "",
        scrapVtitle: "",
        scrapThumbnail: "",
        scrapContent: "",
      },
    };
  },
  computed: {
    ...mapState(["scrap"]),
    ...mapState(["scraps"]),
    ...mapState(["comments"]),
    ...mapGetters(["scrapCnt"]),
  },
  created() {
    document.querySelectorAll(".owl-next").textContent = "next";
    document.querySelectorAll(".owl-prev").textContent = "prev";

    // this.$store.dispatch("setScraps");
  },
  methods: {
    getDetail(id) {
      console.log(id);
      // this.$store.dispatch("setScrap",id);
      this.Scrap = this.scrap;
      this.modalview = !this.modalview;
    },
    modalClose() {
      this.modalview = false;
    },
    updateScrap() {
      // this.$store.dispatch("updateScrap", this.Scrap);
    },
    deleteScrap() {
      // this.$store.dispatch("deleteScrap", this.Scrap.scrap_id);
    },
  },
};
</script>

<style scoped>
.scrap_img {
  width: 500px;
  height: 200px;
}

.scrapmodal {
  width: 1000px;
  height: 1200px;
  /* background-color: rgba(0, 0, 0, 0.8);
   */
  background-color: antiquewhite;
  border: solid 1px black;
  margin-left: auto;
  margin-right: auto;
}

.test-wrap {
  /* border: 1px solid #000; */
  height: 300px;
}

.carousel-wrap {
  width: 1000px;
  margin: 0 auto;
}

.owl-item,
.owl-item.active > div {
  width: 90% !important;
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

.fade-enter {
  opacity: 0;
}

.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s ease-out;
}

.fade-leave-to {
  opacity: 0;
}
</style> -->

<template>
  <div>
    <div>
      <div v-if="scrapCnt" class="scrapbox">
        <div
          class=""
          v-for="(scrap, index) in currentScraps"
          :key="index"
          @click="getDetail(scrap.scrapId)"
        >
          <div>
            <div>
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
        <div>
          <button @click="previousPage" :disabled="currentPage === 1">
            이전
          </button>
          <button @click="nextPage" :disabled="currentPage === totalPages">
            다음
          </button>
        </div>
      </div>
      <div v-else>스크랩한 동영상이 없습니다.</div>
    </div>
    <transition name="fade">
      <div class="scrapmodal" v-if="modalview == true">
        <label for="title">제목</label>
        <input
          class="view"
          id="title"
          type="text"
          v-model="Scrap.scrapTitle"
        /><br />
        <label for="vtitle">영상 제목</label>
        <input
          class="view"
          id="vtitle"
          type="text"
          v-model="Scrap.scrapVtitle"
        /><br />
        <a :href="Scrap.scrapUrl"
          ><img :src="Scrap.scrapThumbnail" alt="thumbnail" /></a
        ><br />
        <label for="content">내용</label>
        <textarea
          class="view"
          id="content"
          cols="100"
          rows="20"
          v-model="Scrap.scrapContent"
        ></textarea
        ><br />
        <hr />
        <comments-my :id="Scrap.scrapId"></comments-my>
        <button @click="updateScrap">수정</button>
        <button @click="deleteScrap">삭제</button>
        <button @click="modalClose">닫기</button>
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
      currentPage: 1,
      perPage: 3,
      plugin: null,
      modalview: false,
      myVideos: [{}],
      Scrap: {
        scrapId: 0,
        scrapTitle: "",
        scrapUrl: "",
        scrapVtitle: "",
        scrapThumbnail: "",
        scrapContent: "",
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
    // this.$store.dispatch("setScraps");
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
    getDetail(id) {
      console.log(id);
      // this.$store.dispatch("setScrap",id);
      this.Scrap = this.scrap;
      this.modalview = !this.modalview;
    },
    modalClose() {
      this.modalview = false;
    },
    updateScrap() {
      // this.$store.dispatch("updateScrap", this.Scrap);
    },
    deleteScrap() {
      // this.$store.dispatch("deleteScrap", this.Scrap.scrap_id);
    },
  },
};
</script>

<style scoped>
.scrapbox {
  display: inline-flex;
}
.scrap_img {
  width: 500px;
  height: 200px;
}

.scrapmodal {
  width: 1000px;
  height: 1200px;
  /* background-color: rgba(0, 0, 0, 0.8);
   */
  background-color: antiquewhite;
  border: solid 1px black;
  margin-left: auto;
  margin-right: auto;
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

.fade-enter {
  opacity: 0;
}

.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s ease-out;
}

.fade-leave-to {
  opacity: 0;
}
</style>
