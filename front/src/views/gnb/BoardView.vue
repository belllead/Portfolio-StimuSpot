<template>
  <div>
    <header-nav></header-nav>
    <div class="boardcontainer">
      <div class="boardviewscrap">
        <scraps-my></scraps-my>
      </div>
      <div class="boardviewvideo">
        <div class="btngroup">
          <div v-for="(board, index) in boards" :key="index">
            <button class="btn" @click="selectboard(board.name)">
              {{ board.label }}
            </button>
          </div>
        </div>
        <br />
        <router-view />
      </div>
    </div>
    <footer-info-2 style="pointer-events: none; z-index: -1" />
  </div>
</template>

<script>
import ScrapsMy from "@/components/board/include/ScrapsMy.vue";
import HeaderNav from "@/components/common/HeaderNav.vue";
import FooterInfo2 from "../../components/common/FooterInfo2.vue";
export default {
  name: "BoardView",
  components: { HeaderNav, ScrapsMy, FooterInfo2 },
  data() {
    return {
      boards: [
        { name: "BoardAbs", label: "복근" },
        { name: "BoardBack", label: "등" },
        { name: "BoardBicep", label: "이두" },
        { name: "BoardCalf", label: "종아리" },
        { name: "BoardChest", label: "가슴" },
        { name: "BoardForearm", label: "전완근" },
        { name: "BoardGlute", label: "엉덩이" },
        { name: "BoardShoulder", label: "어깨" },
        { name: "BoardThigh", label: "허벅지" },
        { name: "BoardTricep", label: "삼두" },
      ],
    };
  },
  // created() {
  //   this.$router.push({ name: "BoardAbs" });
  // },
  methods: {
    selectboard(boardname) {
      this.$router.push({ name: boardname });
    },
    modalClose() {
      this.modalview = false;
    },
  },
};
</script>

<style scoped>
.boardcontainer {
  position: absolute;
  width: 1470px;
  height: 880px;
  top: 30px;
  left: 320px;
  /* background: #ffffff; */
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
}
.boardviewscrap {
  /* border: solid black; */
  width: 1470px;
  height: 260px;
  background: #ffffff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
}
.boardviewvideo {
  margin-top: 20px;
  align-items: center;
  display: inline-flex;
  flex-direction: column;
  flex-wrap: wrap;
  height: 600px;
  width: 1470px;
  z-index: -1;
}
.btngroup {
  position: absolute;
  right: 0px;
  top: 290px;
  display: flex;
  z-index: 0;
}

.btn {
  width: 60px;
  border: #ffffff;
  background: #ffffff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
  margin-right: 5px;
}
.btn:hover {
  transform: scale(1.2);
  /* transition: transform 0.2s ease; */
}
</style>
