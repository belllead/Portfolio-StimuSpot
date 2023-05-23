import { dateFormat } from "@/util/dateFormat";
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
        maxResults: 20,
        videoEmbeddable: true,
      },
      // headers:{
      //   "access-token": sessionStorage.getItem("access-token"),
      // },
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
        maxResults: 20,
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
        maxResults: 20,
        videoEmbeddable: true,
        pageToken: state.prevPageToken,
      },
    }).then((res) => {
      commit("SET_YOUTUBE_VIDEOS", res.data.items);
      commit("SET_YOUTUBE_NEXT_PAGE_TOKEN", res.data.nextPageToken);
      commit("SET_YOUTUBE_NEXT_PREV_TOKEN", res.data.prevPageToken);
    });
  },
  selectDate({ commit }, payload) {
    commit("SELECT_DATE", payload);
  },
  setMonthlyDiaryDates({ commit }) {
    const now = new Date();
    const year = now.getFullYear();
    const month = now.getMonth();
    const startDate = new Date(year, month, 1);
    const lastDate = new Date(year, month + 1, 0);

    console.log(dateFormat(startDate));
    console.log(dateFormat(lastDate));
    commit;
    // const API_URL =
  },
  setScrap() {},
  setScraps() {},
  updateScrap() {},
  deleteScrap() {},
  userLogin({ commit }, user) {
    const API_URL = `http://localhost:9999/user-api/login`;
    axios({
      url: API_URL,
      method: "POST",
      data: user,
    })
      .then((res) => {
        console.log(res);
        sessionStorage.setItem("access-token", res.data["access-token"]);
        sessionStorage.setItem("userNum",res.data["userNum"]);
        commit;
      })
      .catch((err) => {
        console.log(err);
      });
  },

  setParts({ commit, state }) {
    axios({
      method: "GET",
      url: `http://localhost:9999/part-api`,
      params: {
        userNum: sessionStorage.getItem("userNum"),
      },
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    })
      .then((res) => {
        console.log(state.loginUser);
        commit("SET_PARTS", res.data);
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
