<template>
  <div>
    <!-- 유튜브 API로 받은 비디오 리스트 -->
    <div
      class="container"
      ref="container"
      @scroll="handleScroll"
      style="overflow-y: scroll"
    >
      <div v-for="video in videos" :key="video.id.videoId" class="videobox">
        <div class="video" @click="newscrap(video)">
          <div class="videotitle">
            <h5>{{ video.snippet.title }}</h5>
          </div>
          <img :src="`${video.snippet.thumbnails.high.url}`" alt="" />
        </div>
      </div>
    </div>
    <transition name="slide-modal2">
      <div class="scrapmodal2" v-if="modalview == true">
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
        <!-- <comments-my :id="Scrap.scrapId"></comments-my> -->
        <button @click="createScrap">등록</button>
        <button @click="modalClose">닫기</button>
      </div>
    </transition>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "VideosYoutube",
  data() {
    return {
      modalview: false,
      Scrap: {
        userNum: 0,
        scrapTitle: "",
        scrapUrl: "",
        scrapVtitle: "",
        scrapThumbnail: "",
        scrapContent: "",
      },
    };
  },
  props: { bodyPart: String },
  created() {
    this.$store.dispatch("getInitialYoutubeVideos", this.bodyPart);
    console.log("할당량 때문에 일단 기능 막아둠");
  },
  computed: {
    ...mapState(["loginUser"]),
    ...mapState({ videos: "youtubeVideos" }),
    ...mapState(["prevPageToken"]),
  },
  methods: {
    createScrap() {
      this.$store.dispatch("createScrap", this.Scrap);
    },
    newscrap(video) {
      this.modalview = !this.modalview;
      this.Scrap.userNum = this.loginUser;
      this.Scrap.scrapUrl = video.id.videoId;
      this.Scrap.scrapVtitle = video.snippet.title;
      this.Scrap.scrapThumbnail = video.snippet.thumbnails.high.url;
    },
    modalClose() {
      this.modalview = false;
    },
    handleScroll() {
      const container = this.$refs.container;
      if (
        container.scrollTop + container.clientHeight >=
        container.scrollHeight
      ) {
        // 스크롤이 가장 아래로 도달한 경우
        this.nextPage();
      } else if (container.scrollTop === 0) {
        // 스크롤이 가장 위로 도달한 경우
        this.prevPage();
      }
    },
    nextPage() {
      // this.$store.dispatch("getNextYoutubeVideos");
      console.log("할당량 때문에 일단 기능 막아둠");
    },
    prevPage() {
      // this.$store.dispatch("getPrevYoutubeVideos");
      console.log("할당량 때문에 일단 기능 막아둠");
    },
  },
};
</script>

<style scoped>
.container {
  margin-top: 10px;
  height: 500px;
  width: 1600px;
  display: flex;
  flex-wrap: wrap;
}
.container::-webkit-scrollbar {
  display: none;
}

.videoexample {
  width: 300px;
  height: 200px;
  border: solid 1px black;
  border-radius: 20px;
  display: inline-block;
  margin: 10px;
}

.video {
  width: 470px;
  height: 250px;
  background: #ffffff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
  display: inline-block;
  margin: 10px;
  flex-wrap: wrap;
}

.video:hover {
  transform: scale(1.05);
}

.video > img {
  margin-top: 5px;
  width: 280px;
  height: 150px;
}

.videotitle {
  width: 380px;
  height: 20px;
  background: #d9d9d9;
  border-radius: 8px;
  margin: auto;
}

body h5 {
  display: block;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  width: 350px;
}

.scrapmodal2 {
  box-sizing: border-box;
  position: absolute;
  width: 1500px;
  height: 1000px;
  left: 396px;
  top: 12px;
  background: rgba(0, 0, 0, 0.12);
  border: 1px solid rgba(255, 255, 255, 0.12);
  box-shadow: 0px 4px 30px rgba(0, 0, 0, 0.1),
    inset 0px 0px 4px rgba(0, 0, 0, 0.24);
  backdrop-filter: blur(15px);
  border-radius: 8px;
}

.slide-modal2-enter-active {
  transition: transform 0.5s ease;
}

.slide-modal2-leave-active {
  transition: transform 0.5s ease;
}

.slide-modal2-enter {
  transform: translateX(100%);
}

.slide-modal2-leave-to {
  transform: translateX(100%);
}
</style>
