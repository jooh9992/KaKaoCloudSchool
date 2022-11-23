CREATE table contact(
	num integer,
	name char(20),
	address varchar(100),
	tel char(20),
	email char(100),
	birthday date
) ENGINE = MyISAM;

ALTER TABLE contact ADD age integer;

DESC contact;

ALTER TABLE contact DROP age;

DESC contact;

ALTER TABLE contact CHANGE tel phone varchar(11);

DESC contact;

DROP TABLE contact;

CREATE TABLE tNullable(
	name char(10) NOT NULL,
	age INTEGER
);

INSERT INTO tNullable(name, age) values('adam',34);
INSERT INTO tNullable(name, age) values('aespa');
INSERT INTO tNullable(name, age) values('adam',34);

CREATE TABLE tEmployee(
				name VARCHAR(20) PRIMARY KEY,
				salary INTEGER NOT NULL,
				addr CHAR(100) NOT NULL );
				
INSERT INTO tEmployee (name, salary, addr)
VALUES('아이린', 5000, '대구');

INSERT INTO tEmployee (name, salary, addr)
VALUES('수지', 15000, '광주');

INSERT INTO tEmployee (name, salary, addr)
VALUES('조이', 3000, '경기');

DESC tEmployee;

CREATE TABLE tProject(
	projectid INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(20),
	project VARCHAR(50),
	cost INTEGER
);

INSERT INTO tProject(name, project, cost)
VALUES('아이린', 'KB' , 5000);

INSERT INTO tProject(name, project, cost)
VALUES('수지', 'KB' , 7000);

INSERT INTO tProject(name, project, cost)
VALUES(NULL, 'KB' , 5000);

INSERT INTO tProject(name, project, cost)
VALUES('아이유', 'KB' , 5000);

DROP TABLE tProject;

CREATE TABLE tProject(
	projectid INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(20) REFERENCES tEmployee(name),
	project VARCHAR(50),
	cost INTEGER
);

INSERT INTO tProject(name, project, cost)
VALUES('아이린', 'KB' , 5000);
INSERT INTO tProject(name, project, cost)
VALUES('수지', 'KB' , 7000);

INSERT INTO tProject(name, project, cost)
VALUES(NULL, 'KB' , 5000);
# 외래키는 NULL 가능
INSERT INTO tProject(name, project, cost)
VALUES('아이유', 'KB' , 5000); 
# 에러 발생 - 아이유는 tEmployee 테이블에 존재하지 않는 데이터이기 때문

DELETE FROM tEmployee WHERE name = '조이';

SELECT * FROM tEmployee;
# 조이는 참조되지 않고 있기 떄문에 삭제가 가능하지만 아이린은 참조되고 있어서 삭제 불가능
DELETE FROM tEmployee WHERE name = '아이린';

DROP TABLE tProject;

CREATE TABLE tProject(
	projectid INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(20) REFERENCES tEmployee(name) ON DELETE SET NULL,
	project VARCHAR(50),
	cost INTEGER
);
INSERT INTO tProject(name, project, cost)
VALUES('아이린', 'KB' , 5000);
INSERT INTO tProject(name, project, cost)
VALUES('수지', 'KB' , 7000);

INSERT INTO tProject(name, project, cost)
VALUES(NULL, 'KB' , 5000);

DELETE FROM tEmployee WHERE name = '조이';

DELETE FROM tEmployee WHERE name = '수지'; #삭제 가능

SELECT * FROM tProject; #수지가 있던 데이터는 NULL로 수정

DESC tCity;

INSERT INTO tCity(name, area, popu, metro, region)
VALUES('목포', 100, 22, 'n', '전라');

INSERT INTO tCity
VALUES('마산', 200, 45, 'n', '경상');

INSERT INTO DEPT(DEPTNO, DNAME, LOC)
VALUES(70, '총무', null);

SELECT * FROM DEPT;

INSERT INTO DEPT(DEPTNO, DNAME, LOC)
VALUES(100,'홍보', NULL), (110, '마케팅', NULL);

DELETE FROM DEPT WHERE DEPTNO > 40;

UPDATE tCity
SET popu = 1000, region ='전라'
WHERE name = '서울';

#DEPT 테이블의 모든 내욜을 가지고 DEPT01 테이블 생성
CREATE TABLE DEPT01
AS
SELECT *
FROM DEPT;

#DEPT 테이블의 모든 데이터 삭제
#DELETE 문장을 성공적으로 수행하므로 TRANSACTION이 생성됨
DELETE FROM DEPT01;

SELECT * FROM DEPT01;

ROLLBACK; #TRANSACTION 시작점으로 이동
 
SELECT * FROM DEPT01; #데이터 확인 - 지우는 작업이 취소된 결과
DROP TABLE DEPT01;
#DEPTNO 가 20인 데이터를 삭제
DELETE FROM DEPT01
WHERE DEPTNO = 20;

SELECT * FROM DEPT01;

COMMIT; #현재까지 내역을 원본에 반영 - 트랜잭션 종료

#트랜잭션이 이미 종료되서 ROLLBACK을 해도 데이터가 복구되지 않음
ROLLBACK;

SELECT * FROM DEPT01;

#DEPT01 테이블에서 DEPTNO 가 10인 데이터를 삭제
DELETE FROM DEPT01
WHERE DEPTNO = 10;

#DEPT 테이블을 이용해서 DEPT02 테이블을 생성
CREATE TABLE DEPT02
AS
SELECT *
FROM DEPT;

#DDL 문장을 수행하면 트랜잭션은 종료
#ROLLBACK 할 지점이 없어짐
CREATE TABLE DEPT03(DEPTNO INT);

#CREATE 구문이 성공적으로 수행되면 트랜잭션은 종료됨
#ROLLBACK을 해도 돌아가지 못함
ROLLBACK;

SELECT * FROM DEPT01;

DROP TABLE DEPT01;

CREATE TABLE DEPT01
AS
SELECT *
FROM DEPT;

SELECT *
FROM DEPT01;

DELETE FROM DEPT01
WHERE DEPTNO = 40;

#SAVEPOINT 생성
SAVEPOINT s1;

DELETE FROM DEPT01
WHERE DEPTNO = 30;

SAVEPOINT s2;

DELETE FROM DEPT01
WHERE DEPTNO = 20;

SELECT * FROM DEPT01;

#ROLLBACK 방법이 3가지
ROLLBACK; #테이블을 생성한 지점으로 롤백 - 데이터가 4개
#만든 SAVAPOINT는 모두 제거

ROLLBACK TO s1; #40인 데이터를 지운 지점까지 롤백 - 데이터가 3개
#ROLLBACK을 또 하면 데이터가 4개가 되지만 S2라는 SAVEPOINT는 제거

ROLLBACK TO s2; #30인 데이터를 지운 지점까지 롤백 - 데이터가 2개
#ROLLBACK을 또 하면 데이터가 4개가 되지만 ROLLBACK TO s1도 가능

CREATE TABLE DEPTCOPY
AS
SELECT *
FROM DEPT;

CREATE OR REPLACE VIEW DEPTVIEW
AS
SELECT *
FROM DEPTCOPY
WHERE DEPTNO > 20;

#DEPTVIEW는 테이블처럼 사용이 가능
SELECT *
FROM DEPTVIEW;

#VIEW는 테이블처럼 사용이 가능
#VIEW는 SQL을 가지고 있는 것이지 실제 데이터를 가지고 있는 것이 아님

#VIEW에 데이터 삽입 - 원본 테이블에 삽입
INSERT INTO DEPTVIEW (DEPTNO, DNAME, LOC) VALUES(50,'영업', '분당');

#원본 테이블 확인
SELECT *
FROM DEPTCOPY;


#프로시저 생성 - 블록을 잡고 스크립토로 실행해야 함
DELIMITER //
CREATE OR REPLACE PROCEDURE myproc(
	vdeptno int(2), 
	vdname varchar(14), 
	vloc varchar(13))
	
	BEGIN
		INSERT INTO DEPT(DEPTNO, DNAME, LOC)
		VALUES(vdeptno, vdname, vloc);
	END //

DELIMITER ;

#프로시저 호출
CALL myproc(77, '회계', '서울');

#프로시저 호출 결과 확인
SELECT *
FROM DEPT;

#프로시저 삭제
DROP PROCEDURE myproc;

=> 삽입 트리거 - 하나의 테이블에 데이터를 삽입하면 다른 테이블에 데이터가 자동으로 삽입되도록 하는 트리거(블로그 같은 곳에서 회원 가입을 하면 가입한 회원의 데이터를 관리할 수 있는 테이블을 별도로 생성하는 경우가 있다)

-- <데이터를 삽입할 테이블>
CREATE TABLE EMP01(
   EMPNO INT PRIMARY KEY,
    ENAME VARCHAR(10),
    JOB VARCHAR(30))
    
    
#<트리거로 데이터를 삽입할 테이블>
CREATE TABLE SAL01(
   SALNO INT PRIMARY KEY AUTO_INCREMENT,
    SAL FLOAT(7,2), #실수는 앞에가 전체자리수, 뒤에가 소수자리수
    EMPNO INT REFERENCES EMP01(EMPNO) ON DELETE CASCADE)
    
#<삽입 트리거>
DELIMITER //
CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT
ON EMP01
FOR EACH ROW
BEGIN
   INSERT INTO SAL01(SAL,EMPNO) VALUES(100, NEW.EMPNO);
END //
DELIMITER ;

#<데이터를 삽입하고 확인>
INSERT INTO EMP01 VALUES(1,'adam','singer');
SELECT * FROM EMP01; 

#<트리거로 인해서 데이터가 삽입이 됨>
SELECT * FROM EMP02;
