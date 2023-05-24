<template>
  <div>
    <videos-youtube :body-part="'등 운동'"></videos-youtube>
  </div>
</template>

<script>
import VideosYoutube from "./include/VideosYoutube.vue";

export default {
  name: "BoardBack",
  components: { VideosYoutube },
};
</script>

<style></style>
