<template>
  <div>
    <videos-youtube :body-part="'어깨운동'"></videos-youtube>
  </div>
</template>

<script>
import VideosYoutube from "./include/VideosYoutube.vue";

export default {
  name: "BoardShoulder",
  components: { VideosYoutube },
};
</script>

<style></style>
