#데이터베이스 확인
show databases;

#데이터베이스 생성
CREATE DATABASE 이름;

#데이터베이스 사용 설정
USE adam;

SELECT * FROM family;

-- 테이블이 존재하는 경우만 수행
DROP TABLE goods; 

-- 테이블 생성
CREATE TABLE goods(
itemid int,
itemname VARCHAR(100), 
price int,
description VARCHAR(200), 
pictureurl VARCHAR(100),
updatedate varchar(20),
PRIMARY KEY (itemid)
)engine=InnoDB DEFAULT CHARSET=utf8;

insert into goods values(1, '레몬', 500,'비타민 C가 풍부한 쓴귤', 'lemon.jpg', '2020-08-01');
insert into goods values(2, '오렌지', 1500, '비타민 C가 풍부한 당귤', 'orange.jpg', '2020-08-01');
insert into goods values(3, '키위', 2000, '비타민 C가 풍부한 다래', 'kiwi.jpg', '2020-08-01');
insert into goods values(4, '포도', 1000, '항상화 성분과 당분이 높고 무기물이 많은 과일', 'grape.jpg', '2020-08-01'); 
insert into goods values(5, '딸기', 2000, '수분함량이 높은 과일', 'strawberry.jpg', '2020-08-01');
insert into goods values(6, '무화과', 300, '칼슘, 섬유질 및 항산화 물질을 많이 함유된 식물', 'fig.jpg', '2020-08-01');
insert into goods values(7, '레몬', 500,'비타민 C가 풍부한 쓴귤', 'lemon.jpg', '2020-08-01');
insert into goods values(8, '오렌지', 1500, '비타민 C가 풍부한 당귤', 'orange.jpg', '2020-08-01');
insert into goods values(9, '키위', 2000, '비타민 C가 풍부한 다래', 'kiwi.jpg', '2020-08-01');
insert into goods values(10, '포도', 1000, '항상화 성분과 당분이 높고 무기물이 많은 과일', 'grape.jpg', '2020-08-01'); 
insert into goods values(11, '딸기', 2000, '수분함량이 높은 과일', 'strawberry.jpg', '2020-08-01');
insert into goods values(12, '무화과', 300, '칼슘, 섬유질 및 항산화 물질을 많이 함유된 식물', 'fig.jpg', '2020-08-01');
insert into goods values(13, '레몬', 500,'비타민 C가 풍부한 쓴귤', 'lemon.jpg', '2020-08-01');
insert into goods values(14, '오렌지', 1500, '비타민 C가 풍부한 당귤', 'orange.jpg', '2020-08-01');
insert into goods values(15, '키위', 2000, '비타민 C가 풍부한 다래', 'kiwi.jpg', '2020-08-01');
insert into goods values(16, '포도', 1000, '항상화 성분과 당분이 높고 무기물이 많은 과일', 'grape.jpg', '2020-08-01'); 
insert into goods values(17, '딸기', 2000, '수분함량이 높은 과일', 'strawberry.jpg', '2020-08-01');
insert into goods values(18, '무화과', 300, '칼슘, 섬유질 및 항산화 물질을 많이 함유된 식물', 'fig.jpg', '2020-08-01');
insert into goods values(19, '딸기', 2000, '수분함량이 높은 과일', 'strawberry.jpg', '2020-08-01');
insert into goods values(20, '무화과', 300, '칼슘, 섬유질 및 항산화 물질을 많이 함유된 식물', 'fig.jpg', '2020-08-01');
insert into goods values(21, '레몬', 500,'비타민 C가 풍부한 쓴귤', 'lemon.jpg', '2020-08-01');
insert into goods values(22, '오렌지', 1500, '비타민 C가 풍부한 당귤', 'orange.jpg', '2020-08-01');
insert into goods values(23, '키위', 2000, '비타민 C가 풍부한 다래', 'kiwi.jpg', '2020-08-01');
insert into goods values(24, '포도', 1000, '항상화 성분과 당분이 높고 무기물이 많은 과일', 'grape.jpg', '2020-08-01'); 
insert into goods values(25, '딸기', 2000, '수분함량이 높은 과일', 'strawberry.jpg', '2020-08-01');
insert into goods values(26, '무화과', 300, '칼슘, 섬유질 및 항산화 물질을 많이 함유된 식물', 'fig.jpg', '2020-08-01');
insert into goods values(27, '레몬', 500,'비타민 C가 풍부한 쓴귤', 'lemon.jpg', '2020-08-01');
insert into goods values(28, '오렌지', 1500, '비타민 C가 풍부한 당귤', 'orange.jpg', '2020-08-01');
insert into goods values(29, '키위', 2000, '비타민 C가 풍부한 다래', 'kiwi.jpg', '2020-08-01');
insert into goods values(30, '포도', 1000, '항상화 성분과 당분이 높고 무기물이 많은 과일', 'grape.jpg', '2020-08-01'); 

#작업 내역을 원본 데이터베이스에 반영
commit;
#데이터 확인
SELECT * from goods;

SELECT * from sessions;
