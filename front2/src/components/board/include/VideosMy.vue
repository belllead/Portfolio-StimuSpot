<template>
  <div>
    <h2>내가 고른 영상 게시물들</h2>
    <div v-if="scrapCnt">
      <table class="user-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 40%" />
          <col style="width: 20%" />
          <col style="width: 20%" />
        </colgroup>
        <thead>
          <tr>
            <th>제목</th>
            <th>등록일</th>
            <th>주소</th>
            <th>내용</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(scrap, index) in scraps" :key="index">
            <td>{{ index + 1 }}</td>
            <td>
              <router-link :to="`/detail/${scrap.id}`">{{
                scrap.scrap_title
              }}</router-link>
            </td>
            <td>{{ scrap.scrap_regdate }}</td>
            <td>{{ scrap.scrap_url }}</td>
            <td>{{ scrap.scrap_content }} 세</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-else>스크랩한 동영상이 없습니다.</div>
  </div>
</template>

<script>
import {mapState, mapGetters} from 'vuex';

export default {
  name: "VideosMy",
  data() {
    return {
    };
  },
  computed: {
    ...mapState(["scraps"]),
    ...mapGetters(["scrapCnt"]),
  },
  created() {
    this.$store.dispatch("setScraps");
  },
};
</script>

<style></style>
