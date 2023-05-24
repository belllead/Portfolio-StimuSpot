<template>
  <div>
    <videos-youtube :body-part="'가슴운동'"></videos-youtube>
  </div>
</template>

<script>
import VideosYoutube from "./include/VideosYoutube.vue";

export default {
  name: "BoardChest",
  components: { VideosYoutube },
};
</script>

<style></style>
