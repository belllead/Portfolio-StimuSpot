<template>
  <div>
    <h2>abs</h2>
    <videos-my></videos-my>
    <videos-youtube :body-part="'abs'"></videos-youtube>
  </div>
</template>

<script>
import VideosYoutube from "./include/VideosYoutube.vue";
import VideosMy from "./include/VideosMy.vue";

export default {
  name: "BoardAbs",
  components: { VideosYoutube, VideosMy },
};
</script>

<style></style>

VideosYoutube
