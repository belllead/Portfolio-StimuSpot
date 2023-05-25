<template>
  <div class="main-partranking">
    <div class="subbox-partranking">
      <div class="title">자극된 지 오래된 순위</div>
      <br />
      <div class="margin">
        <div v-if="selectedPart" class="selectedranking">
          <div class="ranking">-</div>
          <!-- <div class="icon">
            <div class="icon-place"></div>
          </div> -->
          <div class="name">{{ selectedPart }}</div>
          <div class="differ">
            {{
              Math.floor(
                (new Date(today).getTime() -
                  new Date(
                    parts.find(
                      (part) => part.partName === selectedPart
                    ).lastWorkout
                  ).getTime()) /
                  (1000 * 60 * 60 * 24)
              )
            }}일 전
          </div>
        </div>
        <div v-for="(el, index) in top3Parts()" :key="index" class="rankingbox">
          <div class="ranking">{{ index + 1 }}</div>
          <!-- <div class="icon">
            <div class="icon-place"></div>
          </div> -->
          <div class="name">{{ el.partName }}</div>
          <div class="differ">
            {{
              Math.floor(
                (new Date(today).getTime() -
                  new Date(el.lastWorkout).getTime()) /
                  (1000 * 60 * 60 * 24)
              )
            }}일 전
          </div>
        </div>
      </div>
    </div>
    <div class="btns">
      <router-link :to="{ name: 'PartRankingView' }"
        ><button-basic-1 class="basic-btn"></button-basic-1>
      </router-link>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import { dateFormat } from "@/util/dateFormat";
import ButtonBasic1 from "../ui-element/ButtonBasic1.vue";

export default {
  name: "PartsRankingUi",
  components: { ButtonBasic1 },
  data() {
    const date = new Date();
    const today = dateFormat(date);
    return {
      today,
      top3Parts() {
        return this.parts.slice(0, 3);
      },
    };
  },
  computed: {
    ...mapState(["selectedPart"]),
    ...mapState(["parts"]),
  },
  created() {
    this.$store.dispatch("setParts");
  },
  methods: {
    isSelected(partName) {
      return partName === this.selectedPart;
    },
  },
};
</script>

<style scoped>
.title {
  position: absolute;
  top: 0px;
  left: 0px;
  font-size: 1.2em;
  font-weight: 600;
}

.basic-btn {
  position: absolute;
  top: 300px;
  left: 1220px;
  width: 80px;
  height: 40px;
  color: #a0a0a0;
}

.rankingbox {
  display: flex;
  justify-content: space-between;
  margin: 10px 0;
}
.subbox-partranking {
  position: absolute;
  width: 200px;
  height: 195px;
  left: 1220px;
  top: 60px;
}
.margin {
  margin-top: 30px;
}

.selectedranking {
  display: flex;
  background-color: #e8cb66;
  border-radius: 4px;
  justify-content: space-between;
  color: white;
  padding: 6px 0 0;
}

.selectedranking .differ {
  color: white;
}

.ranking {
  margin: 3px;
  margin-right: 5px;
}

/* .icon {
  margin: 3px;
}

.icon-place {
  width: 30px;
  height: 30px;
  background-color: gainsboro;
  border-radius: 30px;
} */

.name {
  margin: 3px;
  width: 50px;
  height: 30px;
  text-align: left;
}

.differ {
  margin-top: 8px;
  margin-left: 35px;
  font-family: "Inter";
  font-style: normal;
  font-weight: 500;
  font-size: 12px;
  line-height: 15px;
  color: #a0a0a0;
  text-align: center;
}
</style>
