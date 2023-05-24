<template>
  <div>
    <videos-youtube :body-part="'삼두운동'"></videos-youtube>
  </div>
</template>

<script>
import VideosYoutube from "./include/VideosYoutube.vue";

export default {
  name: "BoardTricep",
  components: { VideosYoutube },
};
</script>

<style></style>
