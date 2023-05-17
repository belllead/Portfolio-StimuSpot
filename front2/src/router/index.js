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
    component: () => import("@/views/UserView.vue"),
    children: [
      {
        path: "",
        name: "UserLogin",
        component: () => import("@/components/user/UserLogin"),
      },
      {
        path: "regist",
        name: "UserRegist",
        component: () => import("@/components/user/UserRegist"),
      },
      {
        path: "detail",
        name: "UserDetail",
        component: () => import("@/components/user/UserDetail"),
      },
    ],
  },
  {
    path: "/main",
    name: "MainView",
    component: () => import("@/views/gnb/MainView.vue"),
  },
  {
    path: "/achievement",
    name: "AchievementView",
    component: () => import("@/views/gnb/AchievementView.vue"),
  },
  {
    path: "/board",
    name: "BoardView",
    component: () => import("@/views/gnb/BoardView.vue"),
  },
  {
    path: "/calendar",
    name: "CalendarView",
    component: () => import("@/views/gnb/CalendarView.vue"),
  },
  {
    path: "/part-ranking",
    name: "PartRankingView",
    component: () => import("@/views/gnb/PartRankingView.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
