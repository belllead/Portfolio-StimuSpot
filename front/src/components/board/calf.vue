<template>
  <div>
    <videos-youtube :body-part="'종아리운동'"></videos-youtube>
  </div>
</template>

<script>
import VideosYoutube from "./include/VideosYoutube.vue";

export default {
  name: "BoardCalf",
  components: { VideosYoutube },
};
</script>

<style></style>
