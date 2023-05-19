<template>
  <div class="main-partranking">
    <h2>최근 자극된 부위 순위</h2>
    <div v-for="(el, index) in top3" :key="index">
      <span>{{ index + 1 }} </span>
      <span>{{ el.partName }}</span>
    </div>
    <router-link to="/part-ranking" class="btn">전체보기</router-link>
  </div>
</template>

<script>
export default {
  name: "PartsRankingUi",
  data() {
    return {
      top3: [],
    };
  },
  created() {
    const ranking = [
      { partName: "허벅지" },
      { partName: "종아리" },
      { partName: "어깨" },
    ]; // API에서 가져오기 => 부위 선택했을 때 순서 바꿔줘야 하니까 top3가 아니라 다 가져오기
    this.top3 = ranking;
  },
};
</script>

<style></style>
