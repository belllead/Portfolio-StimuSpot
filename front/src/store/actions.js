import { dateFormat } from "@/util/dateFormat";
import axios from "axios";
import router from "@/router";

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
  getInitialYoutubeVideos({ commit }, payload) {
    const key = process.env.VUE_APP_YOUTUBE_API_KEY;
    // const key = process.env.VUE_APP_YOUTUBE_API_KEY2;
    const API_URL = process.env.VUE_APP_YOUTUBE_API_URL;

    axios({
      method: "get",
      url: API_URL,
      params: {
        key: key,
        part: "snippet",
        q: payload,
        type: "video",
        maxResults: 21,
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
    const key = process.env.VUE_APP_YOUTUBE_API_KEY;
    // const key = process.env.VUE_APP_YOUTUBE_API_KEY2;
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
    const key = process.env.VUE_APP_YOUTUBE_API_KEY;
    // const key = process.env.VUE_APP_YOUTUBE_API_KEY2;
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
  setMonthlyDiaryDates({ commit, state }) {
    const now = new Date();
    const year = now.getFullYear();
    const month = now.getMonth();
    const startDate = new Date(year, month - 3, 1);
    const lastDate = new Date(year, month + 3, 0);

    const start = dateFormat(startDate);
    const end = dateFormat(lastDate);

    const API_URL = `http://localhost:9999/diary-api`;
    axios({
      url: API_URL,
      method: "GET",
      params: {
        startDate: start,
        endDate: end,
        userNum: state.loginUserNum,
      },
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    })
      .then((res) => {
        return [...res.data];
      })
      .then((res) => res.map((el) => el.diaryRegdate))
      .then((res) => {
        commit("SET_SELECTED_DATES", res);
      });
    // .then((res) => console.log(res));
  },

  userLogin({ commit }, user) {
    const API_URL = `http://localhost:9999/user-api/login`;
    axios({
      url: API_URL,
      method: "POST",
      data: user,
    })
      .then((res) => {
        // console.log(res);
        sessionStorage.setItem("access-token", res.data["access-token"]);
        console.log(res.data);
        commit("SET_LOGIN_USER_NUM", res.data["userNum"]);
        commit("SET_LOGIN_USER_NICKNAME", res.data["userNickname"]);
        router.push({ name: "MainView" });
      })
      .catch(() => {
        alert("아이디 또는 비밀번호 입력이 잘못되었습니다.");
      });
  },

  async userLogout({ commit }) {
    await commit("CLEAR_SELECTED_DATES");
    await commit("USER_LOGOUT");
    router.push({ name: "HomeView" });
  },

  setParts({ commit, state }) {
    axios({
      method: "GET",
      url: `http://localhost:9999/part-api`,
      params: {
        userNum: state.loginUserNum,
      },
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    })
      .then((res) => {
        commit("SET_PARTS", res.data);
        // console.log(res);
      })
      .catch((err) => {
        // console.log(err);
        err;
      });
  },

  setAchieves({ commit }) {
    axios({
      method: "GET",
      url: `http://localhost:9999/achievement-api`,
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    })
      .then((res) => {
        commit("SET_ACHIEVES", res.data);
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  },

  setUserAchieves({ commit, state }) {
    axios({
      method: "GET",
      url: `http://localhost:9999/achievement-api/achieved`,
      params: {
        userNum: state.loginUserNum,
      },
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    })
      .then((res) => {
        commit("SET_USERACHIEVES", res.data);
        // console.log(res);
      })
      .catch((err) => {
        // console.log(err);
        err;
      });
  },

  getDiary({ commit, state }, date) {
    const API_URL = `http://localhost:9999/diary-api/detail`;
    axios({
      url: API_URL,
      method: "GET",
      params: {
        specificDate: date,
        userNum: state.loginUserNum,
      },
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    })
      .then((res) => {
        // console.log(res.data);
        commit("SET_DIARY", res.data);
        commit("SET_DIARY_PARTS", res.data.partNames);
      })
      // .catch((err) => console.log(err));
      .catch(() => {
        return;
      });
  },
  registDiary({ commit, state }, payload) {
    commit;
    const API_URL = `http://localhost:9999/diary-api`;
    return axios({
      url: API_URL,
      method: "POST",
      data: {
        diaryContent: payload.diary.diaryContent,
        diaryRating: payload.diary.diaryRating,
        diaryRegdate: payload.diary.diaryRegdate,
        diaryTitle: payload.diary.diaryTitle,
        partIds: payload.diaryParts,
        userNum: state.loginUserNum,
      },
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    }).then((res) => console.log(res.data));
  },
  setPartScores({ commit, state }) {
    const API_URL = `http://localhost:9999/part-api/score`;
    axios({
      url: API_URL,
      method: "GET",
      params: {
        userNum: state.loginUserNum,
      },
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    }).then((res) => {
      {
        // console.log(userNum);
        // console.log(res.data);
        commit("SET_PART_SCORES", res.data);
      }
    });
  },
  setTodayLuck({ commit, state }) {
    const API_URL = `http://localhost:9999/today-luck-api`;
    axios({
      url: API_URL,
      method: "GET",
      params: {
        luckId: state.todayLuckId,
      },
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    }).then((res) => {
      console.log(res.data);
      commit("SET_TODAY_LUCK", res.data.luckContent);
      commit("SET_TODAY_LUCK_ID", res.data.luckId);
    });
  },

  setScraps({ commit, state }) {
    const API_URL = `http://localhost:9999/scrap-api/`;
    axios({
      url: API_URL,
      method: "GET",
      params: {
        userNum: state.loginUserNum,
      },
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    })
      .then((res) => {
        console.log(res.data);
        commit("SET_SCRAPS", res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  },

  createScrap({ commit }, scrap) {
    commit;
    return axios({
      method: "POST",
      url: `http://localhost:9999/scrap-api/`,
      data: scrap,
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    });
  },

  updateScrap({ commit }, scrap) {
    commit;
    const API_URL = `http://localhost:9999/scrap-api/`;
    return axios({
      url: API_URL,
      method: "PUT",
      data: scrap,
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    });
  },

  deleteScrap({ commit }, id) {
    commit;
    const API_URL = `http://localhost:9999/scrap-api/`;
    return axios({
      url: API_URL,
      method: "DELETE",
      params: {
        id: id,
      },
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    });
  },

  setComments({ commit }, id) {
    const API_URL = `http://localhost:9999/comment-api/`;
    axios({
      url: API_URL,
      method: "GET",
      params: {
        id: id,
      },
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    })
      .then((res) => {
        console.log(res);
        commit("SET_COMMENTS", res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  },

  registComment({ commit }, comment) {
    commit;
    const API_URL = `http://localhost:9999/comment-api/`;
    return axios({
      url: API_URL,
      method: "POST",
      data: comment,
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    });
  },

  deleteComment({ commit }, id) {
    commit;
    const API_URL = `http://localhost:9999/comment-api/`;
    return axios({
      url: API_URL,
      method: "DELETE",
      params: {
        id: id,
      },
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    });
  },

  deleteCommentByScrap({ commit }, scrapId) {
    commit;
    const API_URL = `http://localhost:9999/comment-api/byscrap`;
    return axios({
      url: API_URL,
      method: "DELETE",
      params: {
        id: scrapId,
      },
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    });
  },

  registUser({ commit }, user) {
    const API_URL = `http://localhost:9999/user-api/regist`;
    axios({
      url: API_URL,
      method: "POST",
      data: user,
      headers: {
        "access-token": sessionStorage.getItem("access-token"),
      },
    })
      .then((res) => {
        console.log(res);
        commit;
      })
      .catch((err) => {
        alert(err);
      });
  },
};
