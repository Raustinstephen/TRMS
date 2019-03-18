CREATE TABLE TRMS_REIMBURST(
    REIMBURST_ID INTEGER PRIMARY KEY,        /*SEQUENCE PK*/
    EMPLOYEE_ID INTEGER,                     /*FK*/
    EVENT_ID INTEGER,                        /*FK*/
    EVENT_COST NUMBER(8,2),
    EST_REIMB NUMBER(8,2),
    WORKHOURS_MISSED NUMBER(6,2),    /*NOT NULL*/
    JUSTIFICATION VARCHAR2(200),    /*NOT NULL*/
    REIMBURST_STATUS INTEGER,                /*FK*/
    NEXT_AUTHORIZE_ID INTEGER,                /*FK*/
    FEEDBACK    VARCHAR2(200),
    R_TIMESTAMP DATE
);

CREATE TABLE TRMS_EMPLOYEE(
    EMP_ID INTEGER PRIMARY KEY,                 /*PK*/
    FIRST_NAME VARCHAR2(15) NOT NULL,           /*NOT NULL*/
    LAST_NAME VARCHAR2(30)  NOT NULL,           /*NOT NULL*/
    EMAIL VARCHAR2(25)      NOT NULL,           /*NOT NULL*/
    PASSWORD VARCHAR2(12)   NOT NULL,           /*NOT NULL*/
    TITLE VARCHAR2(50)      NOT NULL,           /*NOT NULL*/    
    DEPT INTEGER,                               /*FK*/
    REPORTSTO INTEGER,                          /*FK TO THIS TABLE*/
    TOTAL_AWARDED NUMBER(6,2) 
    NOT NULL CHECK (TOTAL_AWARDED>=0)           /*CHECK NEGATIVE NOT NULL*/           
);

CREATE TABLE TRMS_EVENT(
    EVENT_ID INTEGER PRIMARY KEY,                    /*PK*/
    EVENT_NAME VARCHAR2(30),          /*NOT NULL*/
    EVENT_TYPE INTEGER,
    GRADE_FORMAT INTEGER,
    EVENT_DATE VARCHAR2(50),
    EVENT_LOCATION  VARCHAR2(60),          /*NOT NULL*/
    GRADE VARCHAR2(15)
);

CREATE TABLE TRMS_DEPT(
    DEPT_ID INTEGER PRIMARY KEY,                    /*PK*/
    DEPT_NAME VARCHAR2(15),             
    DEPT_HEAD INTEGER                               /*FK EMPLOYEES*/
);

--############# LOOKUP TABLES #########################
CREATE TABLE GRADE(
    GRADE_ID INTEGER PRIMARY KEY,                   /*PK*/
    G_FORMAT VARCHAR2(10)
);

CREATE TABLE EVENT_TYPE_TABLE(
    EVENT_TYPE_NUM INTEGER PRIMARY KEY,                   /*PK*/
    EVENT_TYPE VARCHAR2(35)
);

CREATE TABLE STATUS(
    STATUS_ID INTEGER PRIMARY KEY,                  /*PK*/
    STATUS_TYPE VARCHAR2(30)
);

COMMIT;

/* =============== CONSTRAINTS ================ */

--==== TRMS_REIMBURST CONSTRAINTS =====
--Foreign key referencing emp id in reimburs table
ALTER TABLE TRMS_REIMBURST ADD CONSTRAINT FK_TRMS_REIM_EMPID
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES TRMS_EMPLOYEE (EMP_ID)  ;

--Foreign key referencing event id in reimburs table
ALTER TABLE TRMS_REIMBURST ADD CONSTRAINT FK_TRMS_REIM_EVNTID
    FOREIGN KEY (EVENT_ID) REFERENCES TRMS_EVENT (EVENT_ID)  ;
    
--Foreign key referencing status in reimburs table
ALTER TABLE TRMS_REIMBURST ADD CONSTRAINT FK_TRMS_REIM_REIMSTAT
    FOREIGN KEY (REIMBURST_STATUS) REFERENCES STATUS (STATUS_ID)  ;

--==== TRMS_EMPLOYEE CONSTRAINTS =====
--Foreign key referencing dept id in employee table
ALTER TABLE TRMS_EMPLOYEE ADD CONSTRAINT FK_TRMS_EMP_DEPT
    FOREIGN KEY (DEPT) REFERENCES TRMS_DEPT (DEPT_ID)  ;

--Foreign key referencing emp id in this table
ALTER TABLE TRMS_EMPLOYEE ADD CONSTRAINT FK_TRMS_EMP_REPORTSTO
    FOREIGN KEY (REPORTSTO) REFERENCES TRMS_EMPLOYEE (EMP_ID)  ;
    
--==== TRMS_EVENT CONSTRAINTS ====
--Foreign key referencing grade id in grade format table
ALTER TABLE TRMS_EVENT ADD CONSTRAINT FK_TRMS_EVNT_GRADE
    FOREIGN KEY (GRADING_FORMAT) REFERENCES GRADE (GRADE_ID)  ;
    
--==== TRMS_DEPT CONSTRAINTS ====
--Foreign key referencing employee id in employee table
ALTER TABLE TRMS_DEPT ADD CONSTRAINT FK_TRMS_DEPT_HEAD
    FOREIGN KEY (DEPT_HEAD) REFERENCES TRMS_EMPLOYEE (EMP_ID)  ;

--==== FILES CONSTRAINTS ====
--Foreign key referencing reimbursement id in reimburst table
ALTER TABLE FILES ADD CONSTRAINT FK_FILES_REIMBURST_ID
    FOREIGN KEY (REIMBURST_ID) REFERENCES TRMS_REIMBURST (REIMBURST_ID)  ;

/* ========= SEQUENCES =============== */

CREATE SEQUENCE ADDREIMBURST_SEQ
MINVALUE 1
MAXVALUE 10000
START WITH 100
INCREMENT BY 1
CACHE 20;

CREATE SEQUENCE ADDEVENT_SEQ
MINVALUE 1
MAXVALUE 10000
START WITH 200
INCREMENT BY 1
CACHE 20;


/*  =========== STORED PROCEDURES ===============  */
CREATE OR REPLACE PROCEDURE INSERT_REIMB_REQ (
I_EMP_ID IN TRMS_REIMBURST.EMPLOYEE_ID%TYPE,            --INTEGER
I_EVENT_NAME IN TRMS_EVENT.EVENT_NAME%TYPE,             --STRING
I_EVENT_TYPE IN TRMS_EVENT.EVENT_TYPE%TYPE,             --INTEGER
I_GRADEFORM IN TRMS_EVENT.GRADE_FORMAT%TYPE,          --INTEGER
I_DATE  IN TRMS_EVENT.EVENT_DATE%TYPE,                  --STRING
I_EVENT_LOC IN TRMS_EVENT.EVENT_LOCATION%TYPE,          --STRING
I_COST IN TRMS_REIMBURST.EVENT_COST%TYPE,             --NUMBER
I_HOURS_MISSED IN TRMS_REIMBURST.WORKHOURS_MISSED%TYPE, --NUMBER
I_JUST IN TRMS_REIMBURST.JUSTIFICATION%TYPE,            --STRING
I_EST_REIMB IN TRMS_REIMBURST.EST_REIMB%TYPE
)
AS
BEGIN
INSERT INTO TRMS_REIMBURST VALUES (
    ADDREIMBURST_SEQ.NEXTVAL,  
    I_EMP_ID, 
    ADDEVENT_SEQ.NEXTVAL,
    I_COST, 
    I_EST_REIMB, 
    I_HOURS_MISSED,
    I_JUST,
    0,
    (SELECT REPORTSTO FROM TRMS_EMPLOYEE WHERE EMP_ID=I_EMP_ID),
    'None avaliable',
    CURRENT_TIMESTAMP
);
INSERT INTO TRMS_EVENT VALUES (
    ADDEVENT_SEQ.CURRVAL, 
    I_EVENT_NAME,
    I_EVENT_TYPE,
    I_GRADEFORM,
    I_DATE, 
    I_EVENT_LOC,
    'In Progress'
);
COMMIT;
END;
/

--============== Update Grade Procedure ========================
CREATE OR REPLACE PROCEDURE UPDATE_GRADE (
I_REIMBURST_ID IN TRMS_REIMBURST.REIMBURST_ID%TYPE, 
I_GRADE IN TRMS_EVENT.GRADE%TYPE)
AS
BEGIN
UPDATE TRMS_EVENT
SET GRADE = I_GRADE
WHERE EVENT_ID= (SELECT EVENT_ID FROM TRMS_REIMBURST
                WHERE REIMBURST_ID = I_REIMBURST_ID);
COMMIT;
END;
/
COMMIT;
CREATE OR REPLACE PROCEDURE APPROVE_OR_DENY (
I_REIMBURST_ID IN TRMS_REIMBURST.REIMBURST_ID%TYPE, 
I_REIMB_STATUS IN TRMS_REIMBURST.REIMBURST_STATUS%TYPE)
AS
BEGIN
UPDATE TRMS_REIMBURST
SET REIMBURST_STATUS = I_REIMB_STATUS
WHERE REIMBURST_ID=I_REIMBURST_ID;
COMMIT;
END;
/

--Sample Reimburstment Requests
EXECUTE INSERT_REIMB_REQ(500875,'CPR Training',2,3,'04/24/2020 12:55','somewhere idk where lalallalala',152.33,20,'because i want to',132.33);
EXECUTE INSERT_REIMB_REQ (500875,'Intro to Humanities2',4,1,'05/03/1962 04:32','12 Wilabee La Park City, NY',453.23,93,'To be more humane',13.36);
EXECUTE INSERT_REIMB_REQ (500875,'Intro to Humanities2',4,1,'05/03/1962 04:32','12 Wilabee La Park City, NY',453.23,93,'A GOOD REAson',13.36);
--Departments
INSERT INTO TRMS_DEPT values (100,'Clerical',100157);
INSERT INTO TRMS_DEPT values (200,'IT',200007);
INSERT INTO TRMS_DEPT values (300,'Accounting',300422);
INSERT INTO TRMS_DEPT values (400,'HR',400003);
INSERT INTO TRMS_DEPT values (500,'General',500182);
INSERT INTO TRMS_DEPT values (600,'Executive',600001);
--DEPT HEADS################################################
INSERT INTO TRMS_EMPLOYEE values (100157,'Regina','George','r.george@dseng.com','pinkwed','Office Manager',100,400032,362.5);
INSERT INTO TRMS_EMPLOYEE values (200007,'Theodore','Kord','t.kord@dseng.com','bluebeetle','IT Manager',200,400032,175);
INSERT INTO TRMS_EMPLOYEE values (300422,'Arthur','Andersen','a.andersen@dseng.com','cookthebooks','CFO',300,400032,999.99);
INSERT INTO TRMS_EMPLOYEE values (400003,'Pamela','Poovy','p.poovy@dseng.com','sploosh','HR Manager',400,400032,350);
INSERT INTO TRMS_EMPLOYEE values (500182,'Ronald','Swanson','r.swanson@dseng.com','NOTREAD','Director',500,400032,17.76);
INSERT INTO TRMS_EMPLOYEE values (600001,'Steve','Wozniak','s.wozniak@dseng.com','opensource','President',600,400032,0);
--founder/CEO
INSERT INTO TRMS_EMPLOYEE values (1,'Bruce','Wayne','darkknight@dseng.com','IMBATMAN','CEO',600,1,0);
--Clerical
INSERT INTO TRMS_EMPLOYEE values (100862,'Cady','Heron','c.heron@dseng.com','plastics','Head Secretary',100,100157,322.35);
INSERT INTO TRMS_EMPLOYEE values (100722,'Gretchen','Wieners','g.wieners@dseng.com','sofetch','Office Clerk',100,100862,85.5);
--IT
INSERT INTO TRMS_EMPLOYEE values (200329,'Michael','Carter','m.carter2@dseng.com','boostergold','Senior Software Engineer',200,200007,0);
INSERT INTO TRMS_EMPLOYEE values (200875,'Maxwell','Lord','m.lord@dseng.com','diebeetle','Junior Software Engineer',200,200329,0);
--Accounting
INSERT INTO TRMS_EMPLOYEE values (300158,'Kenneth','Lay','k.lay@dseng.com','enron','Senior Accountant',300,300422,0);
INSERT INTO TRMS_EMPLOYEE values (300764,'Jeffrey','Skilling','j.skilling@dseng.com','cookthebooks','Bookkeeper',300,300764,0);
--HR (includes Benefits Coordinator)
INSERT INTO TRMS_EMPLOYEE values (400097,'Cheryl','Tunt','c.tunt@dseng.com','babou','Chief Recruiter',400,400003,0);
INSERT INTO TRMS_EMPLOYEE values (400103,'Brett','Buckley','b.buckley@dseng.com','owthathurt','Recruiter',400,400097,0);
INSERT INTO TRMS_EMPLOYEE values (400032,'Ray','Gilette','r.gilette@dseng.com','bioniclegs','Benefits Coordinator',400,0,0);
--General
INSERT INTO TRMS_EMPLOYEE values (500383,'Leslie','Knope','l.knope@dseng.com','mspresident','Deputy Director',500,500182,0);
INSERT INTO TRMS_EMPLOYEE values (500875,'April','Ludgate','a.ludgate@dseng.com','imnotweird','Intern',500,500383,0);
INSERT INTO TRMS_EMPLOYEE values (500863,'Tom','Haverford','t.haverford@dseng.com','idontcare','Subordinate',500,500383,27.82);
--GRADING FORMAT #################
INSERT INTO GRADE values (1,'AF');
INSERT INTO GRADE values (2,'PassFail');
INSERT INTO GRADE values (3,'Percentage');
INSERT INTO GRADE values (4,'Score');
INSERT INTO GRADE values (5,'DosntApply');
--EVENT TYPE TABLE #############################
INSERT INTO EVENT_TYPE_TABLE values (1,'UniversityCourse');
INSERT INTO EVENT_TYPE_TABLE values (2,'Seminar');
INSERT INTO EVENT_TYPE_TABLE values (3,'CertPrep');
INSERT INTO EVENT_TYPE_TABLE values (4,'Certification');
INSERT INTO EVENT_TYPE_TABLE values (5,'TechnicalTraining');
INSERT INTO EVENT_TYPE_TABLE values (6,'Other');
--STATUS TABLE ###################################
INSERT INTO STATUS values (0,'Under Review-Direct Supervisor');
INSERT INTO STATUS values (1,'Under Review-Department Head');
INSERT INTO STATUS values (2,'Under Review-Ben. Coordinator');
INSERT INTO STATUS values (3,'Approved');
INSERT INTO STATUS values (4,'Denied by Direct Supervisor');
INSERT INTO STATUS values (5,'Denied by Department Head');
INSERT INTO STATUS values (6,'Denied by Benefits Coordinator');
INSERT INTO STATUS values (7,'Withdrawn by Employee');

COMMIT;
