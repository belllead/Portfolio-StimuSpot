<template>
  <div>
    <h2>abs</h2>
    <div v-for="video in videos" :key="video.id.videoId">
      <img :src="`${video.snippet.thumbnails.high.url}`" alt="" />
      <br />
      <h3>{{ video.snippet.title }}</h3>
    </div>
  </div>
</template>

<script>
export default {
  name: "BoardBack",
  data() {
    return {
      videos: [],
    };
  },
  created() {},
};
</script>

<style></style>
