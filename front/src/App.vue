<template>
  <div id="app">
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;400&display=swap"
      rel="stylesheet"
    />
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: "Noto Sans KR", sans-serif;
  text-align: center;
  font-weight: 400;
  font-size: 16px;
}

body {
  margin: 0px;
  background-color: #eff5f5;
}

.click {
  cursor: pointer;
}
</style>
