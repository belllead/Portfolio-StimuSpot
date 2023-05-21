import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import VCalendar from "v-calendar";
import moment from "moment";

Vue.config.productionTip = false;

Vue.prototype.$moment = moment;

Vue.use(VCalendar);
new Vue({
  router,
  store,
  VCalendar,
  moment,
  render: (h) => h(App),
}).$mount("#app");
