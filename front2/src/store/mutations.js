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
};
