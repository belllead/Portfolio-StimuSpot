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
  SELECT_DATE(state, date){
    state.selectedDate = date;
  },
};
