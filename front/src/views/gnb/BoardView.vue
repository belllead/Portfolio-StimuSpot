<template>
  <div class="background">
    <header-nav></header-nav>
    <div class="main">
      <div class="boardviewscrap">
        <hr />
        <scraps-my></scraps-my>
        <hr />
      </div>
      <div class="boardviewvideo">
        <div class="select">
          <div>
            <select v-model="selectedOption" @change="navigateToBoard">
              <option value="" disabled selected>카테고리</option>
              <option
                v-for="board in boards"
                :key="board.name"
                :value="board.name"
              >
                {{ board.label }}
              </option>
            </select>
          </div>
        </div>
        <br />
        <router-view />
      </div>
    </div>
  </div>
</template>

<script>
import ScrapsMy from "@/components/board/include/ScrapsMy.vue";
import HeaderNav from "@/components/common/HeaderNav.vue";
export default {
  name: "BoardView",
  components: { HeaderNav, ScrapsMy },
  data() {
    return {
      selectedOption: "",
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
  methods: {
    navigateToBoard() {
      const selectedBoard = this.boards.find(
        (board) => board.name === this.selectedOption
      );
      if (selectedBoard) {
        this.$router.push({ name: selectedBoard.name });
      }
    },
  },
};
</script>

<style scoped>
.background {
  background-color: rgb(241, 248, 248);
}
.main {
  position: absolute;
  top: 50px;
  left: 250px;
  width: 1600px;
  height: 800px;
}
.boardviewscrap {
  border: solid 1px black;
  width: 1600px;
  border-radius: 5px;
}
.boardviewvideo {
  align-items: center;
  border: solid 1px black;
  display: inline-flex;
  flex-direction: column;
  flex-wrap: wrap;
  height: 500px;
  width: 1600px;
  border-radius: 5px;
}

.select {
  background-color: white;
  border: solid 1px black;
}
</style>
