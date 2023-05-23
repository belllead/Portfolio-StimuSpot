<!-- 홈으로 버튼 -->

<template>
  <div class="hover">
    <svg
      id="_레이어_2"
      data-name="레이어 2"
      xmlns="http://www.w3.org/2000/svg"
      viewBox="0 0 81 41"
    >
      <g id="_레이어_1-2" data-name="레이어 1">
        <g>
          <rect
            class="cls-2"
            x=".5"
            y=".5"
            width="80"
            height="40"
            rx="4"
            ry="4"
          />
          <!-- <path
            class="cls-1"
            d="m22.38,16.01h.82v1.94c0,2.5-1.34,4.81-3.12,5.71l-.61-.82c1.61-.77,2.92-2.84,2.92-4.9v-1.94Zm.17,0h.82v1.94c0,1.98,1.3,3.97,2.9,4.72l-.6.79c-1.76-.86-3.12-3.1-3.12-5.51v-1.94Zm4.85-.95h1v10.87h-1v-10.87Zm5.83,1.13h.82v.88c0,1.99-1.2,3.65-3.01,4.3l-.53-.78c1.64-.58,2.72-1.97,2.72-3.52v-.88Zm.18,0h.82v.86c0,1.44,1.04,2.77,2.64,3.31l-.52.78c-1.79-.62-2.94-2.22-2.94-4.09v-.86Zm-2.59-.36h5.8v.82h-5.8v-.82Zm7.16-.76h1v6.53h-1v-6.53Zm.72,2.86h1.88v.83h-1.88v-.83Zm-6.77,4.25h7.04v3.74h-1v-2.92h-6.05v-.83Zm17.01-7.1h1v10.85h-1v-10.85Zm.76,4.45h2.02v.84h-2.02v-.84Zm-8.16-2.72h6.4v.82h-6.4v-.82Zm3.24,1.72c1.54,0,2.64,1.03,2.64,2.5s-1.1,2.5-2.64,2.5-2.64-1.03-2.64-2.5,1.12-2.5,2.64-2.5Zm0,.83c-.98,0-1.69.68-1.69,1.67s.71,1.67,1.69,1.67,1.69-.7,1.69-1.67-.71-1.67-1.69-1.67Zm-.52-4.14h1v1.97h-1v-1.97Zm16.27-.13h1v10.85h-1v-10.85Zm-3.18,1.16h.98c0,3.14-1.42,5.89-5.04,7.67l-.53-.8c3.13-1.51,4.58-3.82,4.58-6.7v-.17Zm-4.09,0h4.52v.82h-4.52v-.82Z"
          /> -->
        </g>
      </g>
    </svg>
    <span class="btn-text">홈으로</span>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.hover:hover .cls-2 {
  fill: #e86666;
  stroke-opacity: 0;
}
.hover:hover .cls-1 {
  fill: white;
  stroke-opacity: 0;
}

.cls-1 {
  fill: #a0a0a0;
}

.cls-2 {
  fill: none;
  stroke: #a0a0a0;
  stroke-miterlimit: 10;
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

.hover:hover .btn-text {
  color: white;
  font-weight: 600;
}
</style>
