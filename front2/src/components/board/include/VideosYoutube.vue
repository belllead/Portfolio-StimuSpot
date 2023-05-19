<template>
  <div>
    <div>props로 받은 부위: {{ bodyPart }}</div>
    <!-- 유튜브 API로 받은 비디오 리스트 -->
    <div v-for="video in videos" :key="video.id.videoId">
      <img :src="`${video.snippet.thumbnails.high.url}`" alt="" />
      <br />
      <h3>{{ video.snippet.title }}</h3>
    </div>
    <div v-for="(video, index) in tempVideos" :key="index">
      <h3>{{ video }}</h3>
      <div
        style="
          width: 100px;
          height: 100px;
          background-color: aqua;
          display: inline-block;
        "
      >
        이게 비디오다 임마
      </div>
    </div>
    <button @click="prevPage" :disabled="!prevPageToken">prev page</button>
    <button @click="nextPage">next page</button>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "VideosYoutube",
  data() {
    return {
      tempVideos: ["비디오1", "비디오2", "비디오3", "비디오4", "비디오5"],
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

<style></style>
