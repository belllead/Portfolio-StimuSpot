<template>
  <div class="footer">
    <div class="info">
      <span>Copyright © 2023 YJSP All rights reserved.</span>
      <span>GitHub @belllead/StimuSpot</span>
    </div>
  </div>
</template>

<script>
export default {
  name: "FooterInfo",
};
</script>

<style scoped>
.footer {
  color: #a0a0a0;
  font-size: 0.8em;
  position: absolute;
  bottom: 0;
  width: 100vw;
}

.info {
  display: flex;
  justify-content: space-between;
  margin: 0 64px 8px 390px;
}
</style>
