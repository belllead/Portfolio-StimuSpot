import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "HomeView",
    component: () => import("@/views/HomeView.vue"),
  },
  {
    path: "/user",
    name: "UserView",
    component: () => import("@/views/UserView.vue"),
  },
  {
    path: "/main",
    name: "MainView",
    component: () => import("@/views/MainView.vue"),
  },
  {
    path: "/achievement",
    name: "AchievementView",
    component: () => import("@/views/AchievementView.vue"),
  },
  {
    path: "/board",
    name: "BoardView",
    component: () => import("@/views/BoardView.vue"),
  },
  {
    path: "/calendar",
    name: "CalendarView",
    component: () => import("@/views/CalendarView.vue"),
  },
  {
    path: "/part-ranking",
    name: "PartRankingView",
    component: () => import("@/views/PartRankingView.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
