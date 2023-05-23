<!-- 홈으로 버튼 -->

<template>
  <div class="hover">
    <svg
      id="_레이어_2"
      data-name="레이어 2"
      xmlns="http://www.w3.org/2000/svg"
      viewBox="0 0 40 40"
    >
      <g id="_레이어_1-2" data-name="레이어 1">
        <g>
          <rect
            class="cls-1"
            x=".5"
            y=".5"
            width="39"
            height="39"
            rx="3.5"
            ry="3.5"
          />
          <path class="cls-2" d="m25,13l-10,7,10,7" />
        </g>
      </g>
    </svg>
    <!-- <span class="btn-text">&#5176;</span> -->
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.hover:hover .cls-1 {
  fill: #e86666;
  stroke-opacity: 0;
}

.cls-1 {
  fill: none;
  stroke: #a0a0a0;
}

.cls-2 {
  fill: none;
  stroke: #a0a0a0;
}

.hover {
  position: relative;
}

.btn-text {
  font-size: 0.75em;
  width: 4em;
  height: 1em;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-2em, -0.75em);
}

.hover:hover .cls-2 {
  stroke: white;
}
</style>
