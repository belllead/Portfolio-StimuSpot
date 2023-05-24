export default {
  SELECT_PART(state, part) {
    state.selectedPart = part;
  },
  CLEAR_PART(state) {
    state.selectedPart = null;
  },
  GET_ACHIEVEMENTS(state, payload) {
    state.achievements = payload;
  },
  SET_YOUTUBE_VIDEOS(state, payload) {
    state.youtubeVideos = payload;
  },
  SET_YOUTUBE_NEXT_PAGE_TOKEN(state, payload) {
    state.nextPageToken = payload;
  },
  SET_YOUTUBE_NEXT_PREV_TOKEN(state, payload) {
    state.prevPageToken = payload;
  },
  SELECT_DATE(state, date) {
    state.selectedDate = date;
  },
  USER_LOGIN(state, userNum) {
    state.loginUser = userNum;
  },
  SET_PARTS(state, payload) {
    state.parts = payload;
  },
  SET_SELECTED_DATES(state, payload) {
    state.selectedDates = payload;
  },
  SET_DIARY(state, payload) {
    state.diary = payload;
  },
  SET_DIARY_PARTS(state, payload) {
    state.diaryParts = payload;
  },
};
