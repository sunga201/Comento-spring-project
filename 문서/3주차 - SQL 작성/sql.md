    <!-- 테이블 생성 -->  
    CREATE Table statistic.requestInfo (
       requestID numeric NOT NULL primary key,
       requestCode varchar(5) NOT NULL,
       userID varchar(5),
       createDate varchar(10)
    );
 
    CREATE table statistic.requestCode (
       requestCode varchar(5) NOT NULL primary key,
       code_explain varchar(50) NOT NULL
    );

    CREATE table statistic.user (
       userID varchar(5) NOT NULL primary key,
       HR_ORGAN varchar(5) NOT NULL,
       USERNAME varchar(5) NOT NULL
    );


    INSERT INTO statistic.requestInfo(requestID, requestCode, userID, createDate )
    VALUES(1, 'L', 'AAA', '2008180520'),
    (2, 'O', 'DDD', '2004040404'),
    (3, 'L', 'BBB', '2006220920'),
    (4, 'L', 'CCC', '1906220920');

    INSERT INTO statistic.user(userID, HR_ORGAN, USERNAME)
    VALUES('AAA', 'DEV', 'Kim'),
    ('BBB', 'DEV', 'Hong'),
    ('CCC', 'DEV', 'Choi'),
    ('DDD', 'DEV', 'Park'),
    ('EEE', 'SALES', 'Yi'),
    ('FFF', 'SALES', 'Shin'),
    ('GGG', 'HR', 'Ji'),
    ('HHH', 'HR', 'Son'),
    ('III', 'HR', 'Yu');


    <!-- 월별 접속자 수 조회 -->
    <select id="selectMonthLogin" parameterType="string" resultType="hashMap">
        select count(*) as totCnt
        from statistic.requestinfo ri
        where mid(ri.createDate, 3, 2) = #{month};
    </select>  

    <!-- 일일 접속자 수 조회 -->
    <select id="selectDayLogin" parameterType="string" resultType="hashMap">
        select count(*) as totCnt
        from statistic.requestinfo ri
        where mid(ri.createDate, 5, 2) = #{day};
    </select>    
    
    <!-- 평균 하루 로그인 수 -->
    <select id="averageMonthLogin" parameterType="string" resultType="hashMap">
        select count(*)/31 as avgCnt
        from statistic.requestinfo
        where mid(ri.createDate, 3, 2) = #{month};
    </select>

    <!-- 휴일을 제외한 로그인 수 -->
    <select id="selectExceptHolidayLogin" parameterType="string" resultType="hashMap">
        select count(*) as totCnt
        from statistic.requestinfo
        where mid(ri.createDate, 5, 2) = #{day};
    </select>

    <!-- 부서별, 월별 로그인 수 -->
    <select id="selectDepartmentMonthLogin" parameterType="string" resultType="hashMap">
        select count(*) as totCnt
        from statistic.requestinfo ri INNER JOIN statistic.user usr ON (ri.userID = usr.userID)
        where usr.HR_ORGAN = #{dep} and mid(ri.createDate, 3, 2) = #{month};
    </select>	 
