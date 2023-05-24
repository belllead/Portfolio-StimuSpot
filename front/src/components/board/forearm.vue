<template>
  <div>
    <videos-youtube :body-part="'전완근운동'"></videos-youtube>
  </div>
</template>

<script>
import VideosYoutube from "./include/VideosYoutube.vue";

export default {
  name: "BoardForearm",
  components: { VideosYoutube },
};
</script>

<style></style>
