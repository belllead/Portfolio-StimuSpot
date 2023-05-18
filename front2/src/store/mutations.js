export default {
  SELECT_PART(state, part) {
    state.selectedPart = part;
  },
  CLEAR_PART(state) {
    state.selectedPart = null;
  },
};
