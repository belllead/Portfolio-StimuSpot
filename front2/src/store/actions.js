export default {
  focusPart({ commit }, payload) {
    commit("SELECT_PART", payload);
  },
  clearFocus({ commit }) {
    commit("CLEAR_PART");
  },
  getAchievements({ commit }, payload) {
    // let params = null;
    // if (payload) params = payload;

    commit;
    payload;
    // const API_URL = `${REST_API}/achievement-api/achievement`;
    // axios({
    //   url: API_URL,
    //   method: "GET",
    //   params,
    // })
    //   .then((res) => {
    //     commit("GET_ACHIEVEMENTS", res.data);
    //   })
    //   .catch((err) => {
    //     console.log(err);
    //   });
  },
};
