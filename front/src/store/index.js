import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

import state from "./state";
import getters from "./getters";
import mutations from "./mutations";
import actions from "./actions";

import createPersistedState from "vuex-persistedstate";

export default new Vuex.Store({
  state,
  getters,
  mutations,
  actions,
  plugins: [
    createPersistedState({
      paths: ["selectedDates"],
      key: "vuexPersistedStore",
      storage: window.sessionStorage,
    }),
  ],
});
