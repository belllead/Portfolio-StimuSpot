<template>
  <div>
    <div v-if="commentsCnt">
      <table style="margin-left: auto; margin-right: auto">
        <tbody>
          <tr v-for="(comment, index) in comments" :key="index">
            <td>{{ index + 1 }}</td>
            <td>{{ comment.commentContent }}</td>
            <button @click="deleteComment(comment.commentId)">삭제</button>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-else>메모가 없습니다.</div>
    <input type="text" v-model="content" />
    <button class="btn" @click="registComment">등록</button>
    <hr />
  </div>
</template>

<script>
import { mapState, mapGetters } from "vuex";
export default {
  name: "CommentsMy",
  props: {
    id: Number,
  },
  data() {
    return {
      content: "",
    };
  },
  methods: {
    registComment(state) {
      let comment = {
        scrapId: this.id,
        commentWriter: state.loginUser,
        commentContent: this.content,
      };
      this.$store.dispatch("registComment", comment).then(() => {
        this.$store.dispatch("setComments", this.id);
      });
    },
    deleteComment(id) {
      this.$store.dispatch("deleteComment", id).then(() => {
        this.$store.dispatch("setComments", this.id);
      });
    },
  },
  computed: {
    ...mapState(["comments"]),
    ...mapState(["loginUser"]),
    ...mapGetters(["commentsCnt"]),
  },
  created() {
    this.$store.dispatch("setComments", this.id);
  },
};
</script>

<style></style>
