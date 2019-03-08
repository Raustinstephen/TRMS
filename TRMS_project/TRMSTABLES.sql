CREATE TABLE TRMS_REIMBURST(
    REIMBURST_ID INTEGER PRIMARY KEY,        /*SEQUENCE PK*/
    EMPLOYEE_ID INTEGER,                     /*FK*/
    EVENT_ID INTEGER,                        /*FK*/
    JUSTIFICATION VARCHAR2(200) NOT NULL,    /*NOT NULL*/
    REIMBURST_STATUS INTEGER,                /*FK*/
    WORKHOURS_MISSED NUMBER(5,2) NOT NULL    /*NOT NULL*/
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
    EVENT_NAME VARCHAR2(30)       NOT NULL,          /*NOT NULL*/
    EVENT_DESCRIPTION VARCHAR2(200),
    EVENT_LOCATION  VARCHAR2(50)  NOT NULL,          /*NOT NULL*/
    EVENT_TIME DATE               NOT NULL,          /*NOT NULL*/
    EVENT_COST NUMBER(7,2) CHECK (EVENT_COST>0),     /*CHECK POSITIVE*/
    GRADING_FORMAT INTEGER                           /*FK*/
);


CREATE TABLE TRMS_DEPT(
    DEPT_ID INTEGER PRIMARY KEY,                    /*PK*/
    DEPT_NAME VARCHAR2(15),             
    DEPT_HEAD INTEGER                               /*FK EMPLOYEES*/
);

CREATE TABLE FILES(
    FILE_ID INTEGER PRIMARY KEY,                    /*PK*/
    FILE_PATH VARCHAR2(50),
    FILE_TYPE VARCHAR2(15),
    REIMBURST_ID INTEGER                /*FK TO REIMBURST*/
);

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
I_EMP_ID IN TRMS_REIMBURST.EMPLOYEE_ID%TYPE,
I_JUST IN TRMS_REIMBURST.JUSTIFICATION%TYPE,
I_REIMBSTAT IN TRMS_REIMBURST.REIMBURST_STATUS%TYPE,
I_HOURS_MISSED IN TRMS_REIMBURST.WORKHOURS_MISSED%TYPE,
I_EVENT_NAME IN TRMS_EVENT.EVENT_NAME%TYPE,
I_EVENT_DESC IN TRMS_EVENT.EVENT_DESCRIPTION%TYPE,
I_EVENT_LOC IN TRMS_EVENT.EVENT_LOCATION%TYPE,
I_EVENT_TIME IN TRMS_EVENT.EVENT_TIME%TYPE,
I_EVENT_COST IN TRMS_EVENT.EVENT_COST%TYPE,
I_GRADEFORM IN TRMS_EVENT.GRADE_FORMAT%TYPE
)
AS
BEGIN
INSERT INTO TRMS_REIMBURST VALUES (
ADDREIMBURST_SEQ.NEXTVAL,  I_EMP_ID, ADDEVENT_SEQ.NEXTVAL,
I_JUST, I_REIMBSTAT, I_HOURS_MISSED);
INSERT INTO TRMS_EVENT VALUES (
ADDEVENT_SEQ.CURRVAL, I_EVENT_NAME,
I_EVENT_DESC, I_EVENT_LOC, I_EVENT_TIME,
I_EVENT_COST, I_GRADEFORM
);
COMMIT;
END;
/

