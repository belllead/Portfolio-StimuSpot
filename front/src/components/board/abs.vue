<template>
  <div>
    <videos-youtube :body-part="'복근운동'"></videos-youtube>
  </div>
</template>

<script>
import VideosYoutube from "./include/VideosYoutube.vue";

export default {
  name: "BoardAbs",
  components: { VideosYoutube },
};
</script>

<style></style>
