<template>
  <div>
    <videos-youtube :body-part="'이두운동'"></videos-youtube>
  </div>
</template>

<script>
import VideosYoutube from "./include/VideosYoutube.vue";

export default {
  name: "BoardBicep",
  components: { VideosYoutube },
};
</script>

<style></style>
