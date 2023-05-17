import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import LoginForm from "@/components/LoginForm.vue";
import User from "../views/User.vue";
import UserRegist from "@/components/user/UserRegist.vue";
import UserDetail from "@/components/user/UserDetail.vue";
import Main from "../views/Main.vue";
import Achievement from "@/components/workout/Achievement.vue";
import Calender from "@/components/workout/Calender.vue";
import Parts from "@/components/workout/Parts.vue";
import PartsRanking from "@/components/workout/PartsRanking.vue";
import Streak from "@/components/workout/Streak.vue";
import TodayLuck from "@/components/workout/TodayLuck.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/login",
    name: "Login",
    component: LoginForm,
  },
  {
    path: "/main",
    name: "Main",
    component: WorkOut,
    childern: [
      {
        path: "/achievement",
        name: "Achievement",
        component: Achievement,
      },
      {
        path: "/calender",
        name: "Calender",
        component: Calender,
      },
      {
        path: "/parts",
        name: "Parts",
        component: Parts,
      },
      {
        path: "/partsRanking",
        name: "PartsRanking",
        component: PartsRanking,
      },
      {
        path: "/streak",
        name: "Streak",
        component: Streak,
      },
      {
        path: "/todayLuck",
        name: "TodayLuck",
        component: TodayLuck,
      },
    ],
  },
  {
    path: "/user",
    component: User,
    children: [
      {
        path: "/regist",
        name: "Regist",
        component: UserRegist,
      },
      {
        path: "/:id",
        name: "Detail",
        component: UserDetail,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
