# Comento-spring-project
코멘토 직무부트캠프를 수강하며 작성한 코드를 모아놓았습니다.
4주차
----------
5가지 기능에 대한 API를 만들었습니다.
 * 월별 접속자 수
 * 일자별 접속자 수
 * 평균 하루 로그인 수
 * 휴일을 제외한 로그인 수
 * 부서별, 월별 로그인 수

사용한 DB 데이터는 아래와 같습니다.  
</br>
   #### user 테이블 </br>
  <img src="img/4주차/user table.png" height="200px" alt="user table"></img><br/>
  
   #### requestinfo 테이블 </br>
  <img src="img/4주차/requestinfo table.png" height="200px" alt="requestInfo table"></img><br/>

</br>

### 월별 접속자 수 API
  <img src="img/4주차/1. 월별.png" height="200px" alt="month"></img><br/><br/>
  
  <br/>
  
### 일자별 접속자 수 API
  <img src="img/4주차/2. 일자별.png" height="150px" alt="date"></img><br/><br/>
  
  <br/>
  
### 평균 하루 로그인 수 API
  <img src="img/4주차/3. 평균 로그인수.png" height="100px" alt="avg"></img><br/><br/>  
  Group by절을 이용해 년도, 월 별로 묶었으며, 로그인 수를 세어 해당 월의 전체 일수로 나눠줬습니다.  
  전체 일수를 구하기 위해 MySQL의 DATEDIFF, LAST_DAY 함수를 사용했습니다.
  
  
  <br/>
  
<br/>

### 휴일을 제외한 로그인 수 API
  <img src="img/4주차/4. 휴일 제외 로그인수.png" height="150px" alt="exceptHoliday"></img><br/>
  
  <br/>
  
  토요일, 일요일 판정을 위해 MySQL의 WEEKDAY 함수를 이용했습니다. 공휴일 판정에는 공공 데이터 포털에서 제공하는 특일 정보 API를 사용했습니다.  
  해당 API의 응답을 Java의 JSONObject와 JSONArray를 사용하여 파싱했습니다.
  
   <img src="img/4주차/공공 API 코드.png" height="300px" alt="dep_month"></img><br/><br/>
   
   <img src="img/4주차/공공 API.png" alt="dep_month"></img><br/><br/>
    
  <br/>
  
### 부서별, 월별 접속자 수 API
  <img src="img/4주차/5. 부서별 월별.png" height="150px" alt="dep_month"></img><br/><br/>


### 주간 보고  

<img src="img/4주차/주간보고1.png" height="400px" alt="week4_report"></img><br/>
<img src="img/4주차/주간보고2.png" height="400px" alt="week4_report"></img><br/>
<img src="img/4주차/주간보고3.png" height="400px" alt="week4_report"></img><br/>


3주차
----------
### 20년도 로그인 수 API
  20년도 로그인 수를 구하는 API를 만들었습니다.
  
  <img src="img/3주차/년별_로그인_수.png" height="200px" alt="week3_result"></img><br/>
  
### 5가지 쿼리에 대한 SQL문 작성
* 월별 접속자 수 조회
    
* 일일 접속자 수 조회
    
* 평균 하루 로그인 수
    
* 휴일을 제외한 로그인 수
    
* 부서별, 월별 로그인 수

### [파일](https://github.com/sunga201/Comento-spring-project/blob/3%EC%A3%BC%EC%B0%A8/%EB%AC%B8%EC%84%9C/3%EC%A3%BC%EC%B0%A8%20-%20SQL%20%EC%9E%91%EC%84%B1/sql.md)

### 주간 보고  

<img src="img/3주차/주간보고.png" height="400px" alt="week3_report"></img><br/>

2주차
----------
### API 문서 작성
SW 활용률과 관련된 API 문서를 작성했습니다. 

### [파일](https://github.com/sunga201/Comento-spring-project/tree/2%EC%A3%BC%EC%B0%A8/%EB%AC%B8%EC%84%9C/2%EC%A3%BC%EC%B0%A8-API%20%EB%AC%B8%EC%84%9C%20%EC%9E%91%EC%84%B1)

</br>

### 주간 보고  


<img src="img/2주차/주간보고.png" height="400px" alt="week2_report"></img><br/>

<br/>

1주차
----------
### 실행 결과
<img src="img/1주차/결과.png" height="400px" alt="week1_result"></img><br/>

<br/>

### 주간 보고
<img src="img/1주차/주간보고.png" height="600px" alt="week1_report"></img><br/>

### [파일](https://github.com/sunga201/Comento-spring-project/blob/2%EC%A3%BC%EC%B0%A8/%EB%AC%B8%EC%84%9C/weekly_report/1%EC%A3%BC%EC%B0%A8/%EC%A3%BC%EA%B0%84%EB%B3%B4%EA%B3%A0.pdf)
