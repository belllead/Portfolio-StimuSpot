<template>
  <div>
    <header-nav></header-nav>
    <h2>게시판</h2>
    <hr />
    <scraps-my></scraps-my>
    <hr />
    <h2>영상 검색</h2>
    <router-link :to="{ name: 'BoardAbs' }">복근</router-link> |
    <router-link :to="{ name: 'BoardBack' }">등</router-link> |
    <router-link :to="{ name: 'BoardBicep' }">이두</router-link> |
    <router-link :to="{ name: 'BoardCalf' }">종아리</router-link> |
    <router-link :to="{ name: 'BoardChest' }">가슴</router-link> |
    <router-link :to="{ name: 'BoardForearm' }">전완근</router-link> |
    <router-link :to="{ name: 'BoardGlute' }">엉덩이</router-link> |
    <router-link :to="{ name: 'BoardShoulder' }">어깨</router-link> |
    <router-link :to="{ name: 'BoardThigh' }">허벅지</router-link> |
    <router-link :to="{ name: 'BoardTricep' }">삼두</router-link>
    <router-view />
  </div>
</template>

<script>
import ScrapsMy from "@/components/board/include/ScrapsMy.vue";
import HeaderNav from "@/components/common/HeaderNav.vue";
export default {
  name: "BoardView",
  components: { HeaderNav, ScrapsMy },
};
</script>

<style></style>
