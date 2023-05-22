import axios from "axios";

export default axios.create({
  baseURL: "spring-workout-api",
  headers: {
    "Content-Type": "application/json",
  },
});
