/* Javaサーブレット基礎 演習問題用SQL */
/* DB作成 */
DROP DATABASE IF EXISTS emp_manager_db;
CREATE DATABASE emp_manager_db CHARACTER SET utf8 COLLATE utf8_general_ci;
 
/* ユーザを作成 */
CREATE USER IF NOT EXISTS embexU IDENTIFIED BY 'embexP';

/* 権限付与 */
GRANT ALL PRIVILEGES ON emp_manager_db.* TO embexU;

/* AUTOCOMMIT無効 */
SET AUTOCOMMIT = 0;

/* 従業員マスタ作成 */
CREATE TABLE emp_manager_db.m_employee
( 
    employee_code   CHAR(5) PRIMARY KEY,
    last_name       VARCHAR(16),
    first_name      VARCHAR(16),
    last_kana_name  VARCHAR(24),
    first_kana_name VARCHAR(24),
    gender          TINYINT(1),
    birth_day       DATE,
    section_code    CHAR(4) DEFAULT 'S000',
    hire_date       DATE,
    update_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* 部署マスタ作成 */
CREATE TABLE emp_manager_db.m_section
( 
    section_code    CHAR(4) PRIMARY KEY,
    section_name    VARCHAR(24),
    update_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* ユーザマスタ作成 */
CREATE TABLE emp_manager_db.m_user
( 
    user_id         VARCHAR(24) PRIMARY KEY,
    password        VARCHAR(32),
    update_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


/* ユーザマスタINSERT */
INSERT INTO emp_manager_db.m_user VALUES('test','test', CURRENT_TIMESTAMP);

commit;

