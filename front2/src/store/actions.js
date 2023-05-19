import axios from "axios";

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
  getInitialYoutubeVideos({ commit }) {
    const key = process.env.VUE_APP_YOUTUBE_API_KEY2;
    const API_URL = process.env.VUE_APP_YOUTUBE_API_URL;

    axios({
      method: "get",
      url: API_URL,
      params: {
        key: key,
        part: "snippet",
        q: "복근운동",
        type: "video",
        maxResults: 10,
        videoEmbeddable: true,
      },
    }).then((res) => {
      commit("SET_YOUTUBE_VIDEOS", res.data.items);
      commit("SET_YOUTUBE_NEXT_PAGE_TOKEN", res.data.nextPageToken);
    });
  },
  getNextYoutubeVideos({ commit, state }) {
    const key = process.env.VUE_APP_YOUTUBE_API_KEY2;
    const API_URL = process.env.VUE_APP_YOUTUBE_API_URL;

    axios({
      method: "get",
      url: API_URL,
      params: {
        key: key,
        part: "snippet",
        q: "복근운동",
        type: "video",
        maxResults: 10,
        videoEmbeddable: true,
        pageToken: state.nextPageToken,
      },
    }).then((res) => {
      console.log("done?");
      commit("SET_YOUTUBE_VIDEOS", res.data.items);
      commit("SET_YOUTUBE_NEXT_PAGE_TOKEN", res.data.nextPageToken);
      commit("SET_YOUTUBE_NEXT_PREV_TOKEN", res.data.prevPageToken);
    });
  },
  getPrevYoutubeVideos({ commit, state }) {
    const key = process.env.VUE_APP_YOUTUBE_API_KEY2;
    const API_URL = process.env.VUE_APP_YOUTUBE_API_URL;

    axios({
      method: "get",
      url: API_URL,
      params: {
        key: key,
        part: "snippet",
        q: "복근운동",
        type: "video",
        maxResults: 10,
        videoEmbeddable: true,
        pageToken: state.prevPageToken,
      },
    }).then((res) => {
      commit("SET_YOUTUBE_VIDEOS", res.data.items);
      commit("SET_YOUTUBE_NEXT_PAGE_TOKEN", res.data.nextPageToken);
      commit("SET_YOUTUBE_NEXT_PREV_TOKEN", res.data.prevPageToken);
    });
  },
};
