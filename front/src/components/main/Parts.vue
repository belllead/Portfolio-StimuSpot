<template>
  <div>
    <h2>운동부위</h2>
    <!-- <button @click="selectTriceps">삼두</button>
    <button @click="selectBiceps">이두</button>
    <button @click="selectShoulder">어깨</button>
    <button @click="selectChest">가슴</button>
    <button @click="selectAbs">복근</button> -->
  </div>
</template>

<script>
export default {
  name: "Parts",
  data() {
    return {
      part: "",
    };
  },
  methods: {
    // selectTriceps() {
    //   this.part = "triceps";
    //   this.$store.dispatch("setPart", part);
    // },
    // selectBiceps() {
    //   this.part = "biceps";
    //   this.$store.dispatch("setPart", part);
    // },
    // selectShoulder() {
    //   this.part = "shoulder";
    //   this.$store.dispatch("setPart", part);
    // },
    // selectChest() {
    //   this.part = "chest";
    //   this.$store.dispatch("setPart", part);
    // },
    // selectAbs() {
    //   this.part = "abs";
    //   this.$store.dispatch("setPart", part);
    // },
  },
  components: {},
};
</script>

<style></style>
