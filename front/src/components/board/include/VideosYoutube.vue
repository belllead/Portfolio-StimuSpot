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
        <div class="video">
          <img :src="`${video.snippet.thumbnails.high.url}`" alt="" />
          <div class="videotitle">
            <h5>{{ video.snippet.title }}</h5>
          </div>
        </div>
      </div>
    </div>
    <!-- <div
      ref="container"
      @scroll="handleScroll"
      style="overflow-y: scroll; height: 300px"
    >
      <div v-for="(video, index) in tempVideos" :key="index" class="videobox">
        <div class="videoexample">
          <h3>{{ video }}</h3>
        </div>
      </div>
      <button @click="prevPage" :disabled="!prevPageToken">prev page</button>
    <button @click="nextPage">next page</button>
    </div> -->
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "VideosYoutube",
  data() {
    return {
      tempVideos: [
        "비디오1",
        "비디오2",
        "비디오3",
        "비디오4",
        "비디오5",
        "비디오6",
        "비디오7",
        "비디오8",
        "비디오9",
        "비디오10",
        "비디오11",
        "비디오12",
      ],
    };
  },
  props: { bodyPart: String },
  created() {
    // this.$store.dispatch("getInitialYoutubeVideos");
    console.log("할당량 때문에 일단 기능 막아둠");
  },
  computed: {
    ...mapState({ videos: "youtubeVideos" }),
    ...mapState(["prevPageToken"]),
  },
  methods: {
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

<style>
.container {
  margin-top: 50px;
  height: 400px;
  width: 1450px;
  display: flex;
  flex-wrap: wrap;
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
  width: 450px;
  height: 230px;
  background-color: white;
  border: solid 1px black;
  border-radius: 20px;
  display: inline-block;
  margin-bottom: 0px;
  flex-wrap: wrap;
}

.video > img {
  margin-top: 5px;
  width: 280px;
  height: 150px;
}

.videotitle {
  width: 380px;
  height: 20px;
  background-color: rgba(69, 69, 70, 0);
}
</style>
