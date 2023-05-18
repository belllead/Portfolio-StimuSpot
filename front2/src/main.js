import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import VCalendar from "v-calendar";

Vue.config.productionTip = false;

Vue.use(VCalendar);
new Vue({
  router,
  store,
  VCalendar,
  render: (h) => h(App),
}).$mount("#app");
