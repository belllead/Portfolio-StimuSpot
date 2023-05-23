<template>
  <div>
    <div v-if="commentsCnt">
      <table style="margin-left: auto; margin-right: auto">
        <tbody>
          <tr v-for="(comment, index) in comments" :key="index">
            <td>{{ index + 1 }}</td>
            <td>{{ comment.commentContent }} by {{ comment.commentWriter }}</td>
            <button @click="deleteComment(comment.commentId)">삭제</button>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-else>댓글이 없습니다.</div>
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
    registComment() {
      let comment = {
        scrapId: this.id,
        commentWriter: this.loginUser.user_nickname,
        commentContent: this.content,
      };
      console.log("create comment with comment=", comment);
      //   this.$store.dispatch("createComment", comment);
    },
    deleteComment(id) {
      console.log("delete comment with comment_id=", id);
      //   this.$store.dispatch("deleteComment", id);
    },
  },
  computed: {
    ...mapState(["comments"]),
    ...mapState(["loginUser"]),
    ...mapGetters(["commentsCnt"]),
  },
  created() {
    // this.$store.dispatch("setComments", this.id);
  },
};
</script>

<style></style>
