import { partMap } from "@/util/partMap";

export default {
  scrapCnt: function (state) {
    return state.scraps.length;
  },
  commentsCnt: function (state) {
    return state.comments.length;
  },
  diaryPartNums(state) {
    let partNums = [];
    for (let i = 0; i < state.diaryParts.length; i++) {
      partNums.push(partMap[`${state.diaryParts[i]}`]);
    }
    return partNums;
  },
};
