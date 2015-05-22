# LoginApp
Login Application (Spring MVC + Security + Hibernate + etc...)

## 1. 숨김 파일 수정
받은 파일에 settings, classpath, project, springBeans 파일 이름 앞에 .붙일 것

## 2. 프로젝트 import
이클립스 메뉴 File->Import->General->Existing Projects into Workspace->Select root directory->다운받은 폴더(LoginApp) 선택->Copy projects into workspace 체크

## 3. MySQL 설정
- **SQL 입력(윈도우 기준)**
> 시작->모든 프로그램->MySQL->MySQL Server 5.5->The MYSQL Command Line Shell 실행
root로 로그인 후 login_app.sql 파일 내용 복사 후 mysql에 입력
http://ishyeok.tistory.com/32 참고(또는 구글링)
> The MYSQL Command Line Shell 안되면 C:\Program Files\MySQL\MySQL Server 5.6\bin 환경변수 path에 추가
- **Spring에서 MySQL 설정(선택사항. MySQL 사용자 비밀번호가 있는 경우 수정)**
> src/main/resources/database.properties 파일 자신에 맞게 수정

## 4. DATABASE 설정
LoginApp/src/main/resources에 있는 database.properties.dist를 database.properties로 수정 한 후에 각자의 DATABASE의 설정에 맞도록 수정합니다.

ex)

database.driver=com.mysql.jdbc.Driver <br />
database.url=jdbc:mysql://localhost:3306/login_app <br />
database.user=MYSQL 계정 아이디 <br />
database.password=계정 패스워드 <br />
hibernate.show_sql=true <br />

## 5. 프로젝트 실행
프로젝트 폴더(LoginApp) 선택->Run->Run on Server->Run Application by Tomcat7.0 선택 -> http://localhost:8080/login/home 접속 확인
