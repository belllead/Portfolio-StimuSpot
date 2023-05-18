import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

const REST_API = `http://localhost:9999/`;

export default new Vuex.Store({
  state: {
    achievements: [],
    achievement: {},
    diaries: [],
    diary: {},
    selectedPart: {},
    selectedDates: ["2023-05-10", "2023-05-19", "2023-05-26", "2023-05-31"],
  },
  getters: {},
  mutations: {
    GET_ACHIEVEMENTS(state, payload) {
      state.achievements = payload;
    },
  },
  actions: {
    getAchievements({ commit }, payload) {
      let params = null;
      if (payload) params = payload;

      const API_URL = `${REST_API}/achievement-api/achievement`;
      axios({
        url: API_URL,
        method: "GET",
        params,
      })
        .then((res) => {
          commit("GET_ACHIEVEMENTS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
});
