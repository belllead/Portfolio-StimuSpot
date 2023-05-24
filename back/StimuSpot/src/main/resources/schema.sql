DROP DATABASE IF EXISTS project;
create database if not exists project;
use project;

CREATE TABLE IF NOT EXISTS users (
 user_num     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 user_id       VARCHAR(20),
 user_pw       VARCHAR(20),
 user_nickname VARCHAR(20),
 user_email    VARCHAR(45),  
 user_age      INT,
 user_selfie   VARCHAR(50)
); 

INSERT INTO users 
(user_id, user_pw, user_email, user_age)
VALUES
('ssafy', '1234', 'ssafy@naver.com', 27),
('song', '1234', 'adam1229@naver.com', 28);

CREATE TABLE friends (
user_num      INT,
friend_num    INT,
friend_date   DATETIME,
FOREIGN KEY (user_num) REFERENCES users(user_num),
FOREIGN KEY (friend_num) REFERENCES users(user_num)
);

INSERT INTO friends
VALUES
(1,2,"2023-05-21");

CREATE TABLE loginlog (
user_num       INT,
logdate        DATETIME,
FOREIGN KEY (user_num) REFERENCES users(user_num)
);

CREATE TABLE achievements (
achv_id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
achv_title     VARCHAR(30), 
achv_content   VARCHAR(50)
);

INSERT INTO achievements
(achv_title, achv_content)
VALUES
('시작이 반이다', '첫 운동 다이어리 작성과 함께 꾸준히 운동해봐요!'),
('상체충', '하체 운동 없이 상체 운동만 10번 연속 시행한 당신, 아주 대단해요!');

CREATE TABLE user_achieve(
user_num       INT,
achv_id        INT,
achieved_date      Date,
FOREIGN KEY(user_num) REFERENCES users(user_num),
FOREIGN KEY(achv_id) REFERENCES achievements(achv_id)
);

INSERT INTO user_achieve
VALUES
(1,1,"2023-04-21"),
(1,2,"2023-05-21"),
(2,1,"2023-05-21");

CREATE TABLE streak (
streak_id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_num         INT,
streak_start_date DATE,
streak_passed    INT,
FOREIGN KEY(user_num) REFERENCES users(user_num)
); 

CREATE TABLE diaries (
diary_id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_num         INT,
diary_title     VARCHAR(30),
diary_regdate   DATE,
diary_rating    INT,
diary_content   VARCHAR(100),
FOREIGN KEY(user_num) REFERENCES users(user_num)
);

INSERT INTO diaries
(user_num, diary_regdate, diary_rating, diary_content)
VALUES
(1,'2023-05-12', 2, '세상은 날씨였지만 운동 사실 별로 안했어요 ㅠㅜㅠ'),
(2,'2023-05-14', 1, '세상동 사실 별로 안했어요 ㅠㅜㅠ'),
(1,'2023-05-15', 4, '기 딱 좋은 날씨였지만 운동 사실 별로 안했어요 ㅠㅜㅠ'),
(1,'2023-05-16', 5, '만 운동 사실 별로 안했어요 ㅠㅜㅠ');

CREATE TABLE parts (
part_id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
part_name        VARCHAR(20),
part_content     VARCHAR(100),
part_icon        VARCHAR(50)
);

INSERT INTO parts
(part_name, part_content)
VALUES
('가슴', '가슴 운동입니다'),('전완근', '전완근 운동입니다'),('엉덩이', '엉덩이 운동입니다'),
('복근', '복근 운동입니다'),
('이두', '이두 운동입니다'),
('삼두', '삼두 운동입니다'),
('어깨', '어깨 운동입니다'),
('등', '등 운동입니다'),
('종아리', '종아리 운동입니다'),
('허벅지', '허벅지 운동입니다');

CREATE TABLE diary_part (
diary_id         INT,
part_id          INT,
FOREIGN KEY(diary_id) REFERENCES diaries(diary_id),
FOREIGN KEY(part_id) REFERENCES parts(part_id)
);

INSERT INTO diary_part
VALUES
(1,2),
(1,3);



CREATE TABLE user_part (
user_num         INT,
part_id          INT,
last_workout     DATE,
FOREIGN KEY(user_num) REFERENCES users(user_num),
FOREIGN KEY(part_id) REFERENCES parts(part_id)
);

INSERT INTO user_part
VALUES
(1,1,'2023-05-10'),
(1,2,'2023-05-13'),
(1,3,'2023-05-15'),
(1,4,'2023-05-13'),
(1,5,'2023-05-11'),
(1,6,'2023-05-12'),
(1,7,'2023-05-13');

CREATE TABLE scraps (
scrap_id  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_num  INT,
scrap_url VARCHAR(30),
scrap_content  VARCHAR(100),
scrap_title VARCHAR(30),
scrap_regdate DATE,
FOREIGN KEY(user_num) REFERENCES users(user_num)
);

CREATE TABLE comments (
comment_id  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
scrap_id INT,
comment_content VARCHAR(100),
comment_writer VARCHAR(30),
FOREIGN KEY(scrap_id) REFERENCES scraps(scrap_id)
);


CREATE TABLE luck (
luck_id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
luck_content    VARCHAR(45)
);

INSERT INTO luck (luck_content)
-- VALUES ('오늘의 나는 두고 가'); 
VALUES ('내일의 나한테 맡기자');

INSERT INTO streak (user_num, streak_start_date, streak_passed)
VALUES (1, '2023-05-19', 4),
(1, '2023-05-06', 2),
(1, '2023-05-08', 3),
(1, '2023-05-15', 6),
(1, '2023-05-24', 1),
(1, '2023-05-28', 3);



select * from users;
select * from streak;
desc streak;

SELECT *
		FROM streak
		ORDER BY streak_start_date DESC
		LIMIT 20;
        
DELETE from streak
where streak_id = 9;

SELECT streak_passed
		FROM streak
		ORDER BY streak_passed DESC;
SELECT *
		FROM streak
		ORDER BY streak_start_date DESC
		LIMIT 1;

desc diaries;
SELECT * from diaries;
SELECT *
		FROM diaries
		WHERE diary_regdate = '2023-05-12'
			AND user_num = 1;
            
            SELECT *
		FROM diaries
		WHERE diary_regdate BETWEEN '2023-05-13' AND '2023-05-16'
        AND user_num = 2;

SELECT * from parts;
DESC parts;

SELECT * From diary_part;

SELECT * from users;

desc diaries;
SELECT * from diaries;

select * from parts;
select * from user_part;


insert into diaries (user_num, diary_title, diary_rating, diary_regdate, diary_content)
values
(2,
 'test',
 5,
 '2023-03-15',
 'test1'
);

SELECT * from achievements;
SELECT * from user_achieve;

SELECT ua.achv_id AS achvId, ac.achv_title AS achvTitle, ac.achv_content AS achvContent, ua.achieved_date AS achievedDate
		FROM user_achieve ua
		JOIN achievements ac 
		ON ua.achv_id = ac.achv_id 
		WHERE ua.user_num = 1;
        
insert INTO user_part
values (1, 10, '2023-05-20');
select * from user_part;
select * from parts;

select * from luck;
INSERT INTO luck
VALUES ('삶이 있는 한 희망은 있다.'),
('산다는 것, 그것은 치열한 전투이다.'),
('하루에 3시간을 걸으면 7년 후에 지구를 한바퀴 돌 수 있다.'),
('언제나 현재에 집중할 수 있다면 행복할 것이다.'),
('진정으로 웃으려면 고통을 참아야 하며, 나아가 고통을 즐길 줄 알아야 해.'),
('직업에서 행복을 찾아라. 아니면 행복이 무엇인지 절대 모를 것이다.'),
('신은 용기있는 자를 결코 버리지 않는다.'),
('행복의 문이 하나 닫히면 다른 문이 열린다. 그러나 우리는 종종 닫힌 문을 멍하니 바라보다가 우리를 향해 열린 문을 보지 못하게 된다.'),
('피할수 없으면 즐겨라.'),
('단순하게 살아라. 현대인은 쓸데없는 절차와 일 때문에 얼마나 복잡한 삶을 살아가는가?'),
('먼저 자신을 비웃어라. 다른 사람이 당신을 비웃기 전에'),
('먼저핀 꽃은 먼저진다. 남보다 먼저 공을 세우려고 조급히 서둘 것이 아니다.'),
('행복한 삶을 살기 위해 필요한 것은 거의 없다.'),
('절대 어제를 후회하지 마라. 인생은 오늘의 나 안에 있고 내일은 스스로 만드는 것이다.'),
('어리석은 자는 멀리서 행복을 찾고, 현명한 자는 자신의 발치에서 행복을 키워간다.'),
('너무 소심하고 까다롭게 자신의 행동을 고민하지 말라. 모든 인생은 실험이다. 더 많이 실험할수록 더나아진다.'),
('한번의 실패와 영원한 실패를 혼동하지 마라.'),
('계단을 밟아야 계단 위에 올라설수 있다.'),
('오랫동안 꿈을 그리는 사람은 마침내 그 꿈을 닮아 간다.'),
('좋은 성과를 얻으려면 한 걸음 한 걸음이 힘차고 충실하지 않으면 안 된다.'),
('행복은 습관이다. 그것을 몸에 지니라.'),
('성공의 비결은 단 한 가지, 잘할 수 있는 일에 광적으로 집중하는 것이다.'),
('자신감 있는 표정을 지으면 자신감이 생긴다.'),
('평생 살 것처럼 꿈을 꾸어라. 그리고 내일 죽을 것처럼 오늘을 살아라.'),
('네 믿음은 네 생각이 된다. 네 생각은 네 말이 된다. 네 말은 네 행동이 된다. 네 행동은 네 습관이 된다. 네 습관은 네 가치가 된다. 네 가치는 네 운명이 된다.'),
('일하는 시간과 노는 시간을 뚜렷이 구분하라. 시간의 중요성을 이해하고 매 순간을 즐겁게 보내고 유용하게 활용하라. 그러면 젋은 날은 유쾌함으로 가득찰 것이고 늙어서도 후회할 일이 적어질 것이며 비록 가난할 때라도 인생을 아름답게 살아갈 수 있다.'),
('절대 포기하지 말라. 당신이 되고 싶은 무언가가 있다면, 그에 대해 자부심을 가져라.'),
('당신 자신에게 기회를 주어라. 스스로가 형편없다고 생각하지 말라. 그래봐야 아무 것도 얻을 것이 없다.'),
('목표를 높이 세워라. 인생은 그렇게 살아야 한다.'),
('1퍼센트의 가능성, 그것이 나의 길이다.'),
('그대 자신의 영혼을 탐구하라. 다른 누구에게도 의지하지 말고 오직 그대 혼자의 힘으로 하라.'),
('그대의 여정에 다른 이들이 끼어들지 못하게 하라. 이 길은 그대만의 길이요, 그대 혼자 가야할 길임을 명심하라.'),
('비록 다른 이들과 함께 걸을 수는 있으나 다른 그 어느 누구도 그대가 선택한 길을 대신 가줄 수 없음을 알라.'),
('고통이 남기고 간 뒤를 보라! 고난이 지나면 반드시 기쁨이 스며든다.'),
('삶은 소유물이 아니라 순간 순간의 있음이다. 영원한 것이 어디 있는가 모두가 한때일 뿐 그러나 그 한때를 최선을 다해 최대한으로 살수 있어야 한다. 삶은 놀라운 신비요, 아름다움이다.'),
('꿈을 계속 간직하고 있으면 반드시 실현할 때가 온다.'),
('화려한 일을 추구하지 말라. 중요한 것은 스스로의 재능이며, 자신의 행동에 쏟아 붓는 사랑의 정도이다.'),
('마음만을 가지고 있어서는 안된다. 반드시 실천하여야 한다.'),
('흔히 사람들은 기회를 기다리고 있지만 기회는 기다리는 사람에게 잡히지 않는 법이다. 우리는 기회를 기다리는 사람이 되기 전에 기회를 얻을 수 있는 실력을 갖춰야 한다.'),
('나이가 60이다 70이다 하는 것으로 그 사람이 늙었다 젊었다 할 수 없다. 늙고 젊은 것은 그 사람의 신념이 늙었느냐 젊었느냐 하는데 있다.'),
('만약 우리가 할 수 있는 일을 모두 한다면 우리들은 우리 자신에 깜짝 놀랄 것이다.'),
('나는 누구인가 스스로 물으라 자신의 속얼굴이 드러나 보일 때까지 묻고 묻고 물어야 한다. 건성으로 묻지 말고 목소리 속의 목소리로 귀 속의 귀에 대고 간절하게 물어야 한다. 해답은 그 물음 속에 있다.'),
('행복은 결코 많고 큰 데만 있는 것이 아니다. 작은 것을 가지고도 고마워하고 만족할 줄 안다면 그는 행복한 사람이다.'),
('여백과 공간의 아름다움은 단순함과 간소함에 있다.'),
('물러나서 조용하게 구하면 배울 수 있는 스승은 많다. 사람은 가는 곳마다 보는 것마다 모두 스승으로서 배울 것이 많은 법이다.'),
('눈물과 더불어 빵을 먹어 보지 않은 자는 인생의 참다운 맛을 모른다.'),
('진짜 문제는 사람들의 마음이다. 그것은 절대로 물리학이나 윤리학의 문제가 아니다.'),
('해야 할 것을 하라. 모든 것은 타인의 행복을 위해서, 동시에 특히 나의 행복을 위해서이다.'),
('사람이 여행을 하는 것은 도착하기 위해서가 아니라 여행하기 위해서이다.'),
('화가 날 때는 100까지 세라. 최악일 때는 욕설을 퍼부어라.'),
('재산을 잃은 사람은 많이 잃은 것이고, 친구를 잃은 사람은 더많이 잃은 것이며, 용기를 잃은 사람은 모든 것을 잃은 것이다.'),
('돈이란 바닷물과도 같다. 그것은 마시면 마실수록 목이 말라진다.'),
('이룰 수 없는 꿈을 꾸고 이길수 없는 적과 싸우며, 이룰 수 없는 사랑을 하고 견딜 수 없는 고통을 견디고, 잡을 수 없는 저 하늘의 별도 잡자.'),
('고개 숙이지 마십시오. 세상을 똑바로 정면으로 바라보십시오.'),
('고난의 시기에 동요하지 않는 것, 이것은 진정 칭찬받을 만한 뛰어난 인물의 증거다.'),
('사막이 아름다운 것은 어딘가에 샘이 숨겨져 있기 때문이다.'),
('만족할 줄 아는 사람은 진정한 부자이고, 탐욕스러운 사람은 진실로 가난한 사람이다.'),
('성공해서 만족하는 것은 아니다. 만족하고 있었기 때문에 성공한 것이다.'),
('곧 위에 비교하면 족하지 못하나, 아래에 비교하면 남음이 있다.'),
('그대의 하루 하루를 그대의 마지막 날이라고 생각하라.'),
('자신을 내보여라. 그러면 재능이 드러날 것이다.'),
('자신의 본성이 어떤 것이든 그에 충실하라. 자신이 가진 재능의 끈을 놓아 버리지 마라. 본성이 이끄는 대로 따르면 성공할 것이다.'),
('당신이 할 수 있다고 믿든 할 수 없다고 믿든 믿는 대로 될 것이다.'),
('당신이 인생의 주인공이다. 그 사실을 잊지마라. 지금까지 당신이 만들어온 의식적 그리고 무의식적 선택으로 인해 지금의 당신이 있는것이다.'),
('지금이야말로 일할 때다. 지금이야말로 싸울 때다. 지금이야말로 나를 더 훌륭한 사람으로 만들 때다. 오늘 그것을 못하면 내일 그것을 할수있는가.'),
('모든 것들에는 나름의 경이로움과 심지어 어둠과 침묵이 있고, 내가 어떤 상태에 있더라도 나는 그 속에서 만족하는 법을 배운다.'),
('작은 기회로부터 종종 위대한 업적이 시작된다.'),
('인생이란 학교에는 불행이란 훌륭한 스승이 있다. 그 스승 때문에 우리는 더욱 단련되는 것이다.'),
('세상은 고통으로 가득하지만 그것을 극복하는 사람들로도 가득하다.'),
('도저히 손댈 수가 없는 곤란에 부딪혔다면 과감하게 그 속으로 뛰어들라. 그리하면 불가능하다고 생각했던 일이 가능해진다.'),
('용기있는 자로 살아라. 운이 따라주지 않는다면 용기 있는 가슴으로 불행에 맞서라.'),
('최고에 도달하려면 최저에서 시작하라.'),
('내 비장의 무기는 아직 손안에 있다. 그것은 희망이다.'),
('문제는 목적지에 얼마나 빨리 가느냐가 아니라 그 목적지가 어디냐는 것이다.'),
('한 번 실패와 영원한 실패를 혼동하지 마라.'),
('인간의 삶 전체는 단지 한 순간에 불과하다. 인생을 즐기자.'),
('겨울이 오면 봄이 멀지 않으리.'),
('일하여 얻으라. 그러면 운명의 바퀴를 붙들어 잡은 것이다.'),
('당신의 행복은 무엇이 당신의 영혼을 노래하게 하는가에 따라 결정된다.'),
('자신이 해야 할 일을 결정하는 사람은 세상에서 단 한 사람, 오직 나 자신뿐이다.'),
('먹고 싶은것을 다 먹는 것은 그렇게 재미있지 않다. 인생을 경계선 없이 살면 기쁨이 덜하다. 먹고싶은 대로 다 먹을 수있다면 먹고싶은 것을 먹는데 무슨 재미가 있겠나.'),
('인생을 다시 산다면 다음번에는 더 많은 실수를 저지르리라.'),
('절대 어제를 후회하지 마라. 인생은 오늘의 나 안에 있고 내일은 스스로 만드는 것이다.'),
('인생에서 원하는 것을 엇기 위한 첫번째 단계는 내가 무엇을 원하는지 결정하는 것이다.'),
('가난은 가난하다고 느끼는 곳에 존재한다.'),
('삶이 그대를 속일지라도 슬퍼하거나 노하지 말아라 슬픈 날에 참고 견디라. 즐거운 날은 오고야 말리니 마음은 미래를 바라느니 현재는 한없이 우울한 것. 모든 건 하염없이 지나가 버리고 그리움이 되리니.'),
('문제점을 찾지 말고 해결책을 찾으라.'),
('우선 무엇이 되고자 하는가를 자신에게 말하라 그리고 해야 할일을 하라.'),
('되찾을 수 없는 게 세월이니 시시한 일에 시간을 낭비하지 말고 순간순간을 후회 없이 잘 살아야 한다.'),
('인생에 뜻을 세우는 데 있어 늦은 때라곤 없다.'),
('도중에 포기하지 말라. 망설이지 말라. 최후의 성공을 거둘 때까지 밀고 나가자.'),
('네 자신의 불행을 생각하지 않게 되는 가장 좋은 방법은 일에 몰두하는 것이다.'),
('우리는 두려움의 홍수에 버티기 위해서 끊임없이 용기의 둑을 쌓아야 한다.'),
('직접 눈으로 본 일도 오히려 참인지 아닌지 염려스러운 데 더구나 등뒤에서 남이 말하는 것이야 어찌 이것을 깊이 믿을 수 있으랴?'),
('이미 끝나버린 일을 후회하기보다는 하고 싶었던 일들을 하지못한 것을 후회하라.'),
('실패는 잊어라. 그러나 그것이 준 교훈은 절대 잊으면 안된다.'),
('내가 헛되이 보낸 오늘은 어제 죽어간 이들이 그토록 바라던 하루이다. 단 하루면 인간적인 모든 것을 멸망시킬수도 다시 소생시킬 수도 있다.'),
('성공으로 가는 엘리베이터는 고장입니다. 당신은 계단을 이용해야만 합니다. 한계단 한계단씩.'),
('길을 잃는다는 것은 곧 길을 알게 된다는 것이다.'),
('삶을 사는 데는 단 두가지 방법이 있다. 하나는 기적이 전혀 없다고 여기는 것이고 또 다른 하나는 모든 것이 기적이라고 여기는 방식이다.');
