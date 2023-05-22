export default {
  selectedPart: null,
  selectedDate: null,
  achievements: [
    {
      achv_id: 1,
      achv_title: "시작이 반이다",
      achv_content: "첫 다이어리 작성 완료",
    },
    {
      achv_id: 2,
      achv_title: "남자는 하체",
      achv_content: "하체 운동 30일 연속",
    },
  ],
  achievement: {},
  loginUser: {},
  diaries: [],
  diary: {
    diary_id: 1,
    diary_title: "오늘은 하체데이~ 징징이 다리되는 날!",
    diary_regdate: "2023-05-10",
    diary_rating: 2,
    diary_content:
      "오늘은 하체날이었는데 하체가 너무 재미없어서 데드리프트랑 케틀벨도 같이 조졌다. 하체 왜 해야 해...하지만 하체 없이는 성장이 없지..!",
  },
  diaryParts: ["abs", "thigh", "back"],
  selectedDates: ["2023-05-10", "2023-05-19", "2023-05-26", "2023-05-31"],
  scrap: {
    scrap_id: 1,
    scrap_title: "첫번째 스크랩입니다",
    scrap_url: "https://www.youtube.com/watch?v=4jM5y9iG4NU",
    scrap_vtitle: "영상 제목은 이거죠",
    scrap_thumbnail:
      "https://i.ytimg.com/vi/4jM5y9iG4NU/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCbmzUCTubUSnbJQe3MTdR8CZCQ9A",
    scrap_content: "꼭 해야 됨",
  },
  scraps: [
    {
      scrap_id: 1,
      scrap_title: "첫번째 스크랩입니다",
      scrap_url: "https://www.youtube.com/watch?v=4jM5y9iG4NU",
      scrap_vtitle: "영상 제목은 이거죠",
      scrap_thumbnail:
        "https://i.ytimg.com/vi/4jM5y9iG4NU/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCbmzUCTubUSnbJQe3MTdR8CZCQ9A",
      scrap_content: "꼭 해야 됨",
    },
    {
      scrap_id: 2,
      scrap_title: "두번째 스크랩입니다",
      scrap_url: "https://www.youtube.com/watch?v=4jM5y9iG4NU",
      scrap_vtitle: "영상 제목은 이거죠",
      scrap_thumbnail:
        "https://i.ytimg.com/vi/4jM5y9iG4NU/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCbmzUCTubUSnbJQe3MTdR8CZCQ9A",
      scrap_content: "꼭 해야 됨",
    },
    {
      scrap_id: 3,
      scrap_title: "세번째 스크랩입니다",
      scrap_url: "https://www.youtube.com/watch?v=4jM5y9iG4NU",
      scrap_vtitle: "영상 제목은 이거죠",
      scrap_thumbnail:
        "https://i.ytimg.com/vi/4jM5y9iG4NU/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCbmzUCTubUSnbJQe3MTdR8CZCQ9A",
      scrap_content: "꼭 해야 됨",
    },
    {
      scrap_id: 4,
      scrap_title: "네번째 스크랩입니다",
      scrap_url: "https://www.youtube.com/watch?v=4jM5y9iG4NU",
      scrap_vtitle: "영상 제목은 이거죠",
      scrap_thumbnail:
        "https://i.ytimg.com/vi/4jM5y9iG4NU/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCbmzUCTubUSnbJQe3MTdR8CZCQ9A",
      scrap_content: "꼭 해야 됨",
    },
    {
      scrap_id: 5,
      scrap_title: "다섯번째 스크랩입니다",
      scrap_url: "https://www.youtube.com/watch?v=4jM5y9iG4NU",
      scrap_vtitle: "영상 제목은 이거죠",
      scrap_thumbnail:
        "https://i.ytimg.com/vi/4jM5y9iG4NU/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCbmzUCTubUSnbJQe3MTdR8CZCQ9A",
      scrap_content: "꼭 해야 됨",
    },
    {
      scrap_id: 6,
      scrap_title: "여섯번째 스크랩입니다",
      scrap_url: "https://www.youtube.com/watch?v=4jM5y9iG4NU",
      scrap_vtitle: "영상 제목은 이거죠",
      scrap_thumbnail:
        "https://i.ytimg.com/vi/4jM5y9iG4NU/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCbmzUCTubUSnbJQe3MTdR8CZCQ9A",
      scrap_content: "꼭 해야 됨",
    },
    {
      scrap_id: 7,
      scrap_title: "일곱번째 스크랩입니다",
      scrap_url: "https://www.youtube.com/watch?v=4jM5y9iG4NU",
      scrap_vtitle: "영상 제목은 이거죠",
      scrap_thumbnail:
        "https://i.ytimg.com/vi/4jM5y9iG4NU/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCbmzUCTubUSnbJQe3MTdR8CZCQ9A",
      scrap_content: "꼭 해야 됨",
    },
    {
      scrap_id: 8,
      scrap_title: "여덟번째 스크랩입니다",
      scrap_url: "https://www.youtube.com/watch?v=4jM5y9iG4NU",
      scrap_vtitle: "영상 제목은 이거죠",
      scrap_thumbnail:
        "https://i.ytimg.com/vi/4jM5y9iG4NU/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCbmzUCTubUSnbJQe3MTdR8CZCQ9A",
      scrap_content: "꼭 해야 됨",
    },
    {
      scrap_id: 9,
      scrap_title: "아홉번째 스크랩입니다",
      scrap_url: "https://www.youtube.com/watch?v=4jM5y9iG4NU",
      scrap_vtitle: "영상 제목은 이거죠",
      scrap_thumbnail:
        "https://i.ytimg.com/vi/4jM5y9iG4NU/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCbmzUCTubUSnbJQe3MTdR8CZCQ9A",
      scrap_content: "꼭 해야 됨",
    },
  ],
  comments: [
    {
      comment_id: 1,
      scrap_id: 1,
      comment_writer: "송윤제",
      comment_content: "나도 해야지",
    },
    {
      comment_id: 2,
      scrap_id: 1,
      comment_writer: "북극곰",
      comment_content: "콜라 좋아",
    },
  ],
  youtubeVideos: [],
  nextPageToken: "",
  prevPageToken: "",
};
