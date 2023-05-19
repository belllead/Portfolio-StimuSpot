import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "HomeView",
    component: () => import("@/views/HomeView"),
  },
  {
    path: "/user",
    component: () => import("@/views/UserView"),
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
    component: () => import("@/views/gnb/MainView"),
  },
  {
    path: "/achievement",
    name: "AchievementView",
    component: () => import("@/views/gnb/AchievementView"),
  },
  {
    path: "/board",
    name: "BoardView",
    component: () => import("@/views/gnb/BoardView"),
    children: [
      {
        path: "1",
        name: "BoardThigh",
        component: () => import("@/components/board/thigh"),
      },
      {
        path: "2",
        name: "BoardAbs",
        component: () => import("@/components/board/abs"),
      },
      {
        path: "3",
        name: "BoardBack",
        component: () => import("@/components/board/back"),
      },
      {
        path: "4",
        name: "BoardBicep",
        component: () => import("@/components/board/bicep"),
      },
      {
        path: "5",
        name: "BoardCalf",
        component: () => import("@/components/board/calf"),
      },
      {
        path: "6",
        name: "BoardChest",
        component: () => import("@/components/board/chest"),
      },
      {
        path: "7",
        name: "BoardForearm",
        component: () => import("@/components/board/forearm"),
      },
      {
        path: "8",
        name: "BoardGlute",
        component: () => import("@/components/board/glute"),
      },
      {
        path: "9",
        name: "BoardShoulder",
        component: () => import("@/components/board/shoulder"),
      },
      {
        path: "10",
        name: "BoardTricep",
        component: () => import("@/components/board/tricep"),
      },
    ],
  },
  {
    path: "/calendar",
    name: "CalendarView",
    component: () => import("@/views/gnb/CalendarView"),
  },
  {
    path: "/part-ranking",
    name: "PartRankingView",
    component: () => import("@/views/gnb/PartRankingView"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
