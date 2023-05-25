<template>
  <div>
    <header-nav></header-nav>
    <div class="rankingcontainer">
      <div class="table">
        <table>
          <colgroup>
            <col style="width: 5%" />
            <col style="width: 10%" />
            <col style="width: 20%" />
            <col style="width: 20%" />
            <col style="width: 45%" />
          </colgroup>
          <thead>
            <tr>
              <th><div class="view1">순위</div></th>
              <!-- <th>아이콘</th> -->
              <th><div class="view3">마지막 운동 일시</div></th>
              <th><div class="view4">부위 명</div></th>
              <th><div class="view5">부위 정보</div></th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(part, index) in parts" :key="index">
              <td>
                <div class="view1">
                  {{ index + 1 }}
                </div>
              </td>
              <!-- <td>
                <div class="view2">
                  {{ part.partIcon }}
                </div>
              </td> -->
              <td>
                <div class="view3">
                  {{ part.lastWorkout }}
                </div>
              </td>
              <td>
                <div class="view4">
                  {{ part.partName }}
                </div>
              </td>
              <td>
                <div class="view5">
                  {{ part.partContent }}
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <footer-info-2 />
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue";
import { mapState } from "vuex";
import FooterInfo2 from "../../components/common/FooterInfo2.vue";

export default {
  name: "PartRankingView",
  components: { HeaderNav, FooterInfo2 },
  computed: {
    ...mapState(["parts"]),
  },
  created() {
    this.$store.dispatch("setParts");
  },
};
</script>

<style scoped>
.rankingcontainer {
  position: absolute;
  width: 1470px;
  height: 800px;
  top: 30px;
  left: 320px;
  background: #ffffff;
  box-shadow: 0px 4px 16px rgba(0, 0, 0, 0.04);
  border-radius: 8px;
}

.table {
  width: 1240px;
  height: 680px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-620px, -370px);
}

th {
  color: #e86666;
  font-weight: 600;
}

th,
td {
  text-align: left;
}
col {
  display: flex;
  align-items: center;
  justify-content: center;
}
.view1 {
  height: 40px;
  width: 40px;
  border-radius: 8px;
  /* background-color: #d9d9d9; */
  line-height: 40px;
  margin: 0px 15px;
}
.view2 {
  height: 40px;
  width: 120px;
  border-radius: 8px;
  background-color: #d9d9d9;
  line-height: 40px;
  margin: 10px;
}
.view3 {
  height: 40px;
  width: 200px;
  border-radius: 8px;
  /* background-color: #d9d9d9; */
  line-height: 40px;
  margin: 10px;
}
.view4 {
  height: 40px;
  width: 200px;
  border-radius: 8px;
  /* background-color: #d9d9d9; */
  line-height: 40px;
  margin: 10px;
}
.view5 {
  height: 40px;
  width: 540px;
  border-radius: 8px;
  /* background-color: #d9d9d9; */
  line-height: 40px;
  margin: 10px;
}
</style>
