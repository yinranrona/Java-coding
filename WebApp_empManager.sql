/* Javaサーブレット基礎 演習問題用SQL */
/* DB作成 */
DROP DATABASE IF EXISTS emp_sys_db;
CREATE DATABASE emp_sys_db CHARACTER SET utf8 COLLATE utf8_general_ci;
 
/* ユーザを作成 */
CREATE USER IF NOT EXISTS embexU IDENTIFIED BY 'embexP';

/* 権限付与 */
GRANT ALL PRIVILEGES ON emp_sys_db.* TO embexU;

/* AUTOCOMMIT有効 */
SET AUTOCOMMIT = 1;

/* DB選択 */
USE emp_sys_db;


/* 部署マスタ作成 */
CREATE TABLE emp_sys_db.m_section
( 
    section_code    CHAR(4) PRIMARY KEY,
    section_name    VARCHAR(24) UNIQUE NOT NULL,
    update_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL
);

/* 従業員マスタ作成 */
CREATE TABLE emp_sys_db.m_employee
( 
    employee_code   CHAR(5) PRIMARY KEY,
    last_name       VARCHAR(16) NOT NULL,
    first_name      VARCHAR(16) NOT NULL,
    last_kana_name  VARCHAR(24),
    first_kana_name VARCHAR(24),
    gender          TINYINT DEFAULT 0 NOT NULL,
    birth_day       DATE,
    section_code    CHAR(4) DEFAULT 'S000' NOT NULL,
    hire_date       DATE,
    update_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY(section_code) REFERENCES emp_sys_db.m_section(section_code)
);

/* ユーザマスタ作成 */
CREATE TABLE emp_sys_db.m_user
( 
    user_id         VARCHAR(24) PRIMARY KEY,
    password        VARCHAR(32) NOT NULL,
    update_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL
);


/* ユーザマスタINSERT */
INSERT INTO emp_sys_db.m_user VALUES('test','test', CURRENT_TIMESTAMP);

/* 部署マスタINSERT */
INSERT INTO m_section(section_code,section_name)VALUE('S000','所属部未定');
INSERT INTO m_section(section_code,section_name)VALUE('S110','総務部');
INSERT INTO m_section(section_code,section_name)VALUE('S130','人事部');
INSERT INTO m_section(section_code,section_name)VALUE('S150','経理部');
INSERT INTO m_section(section_code,section_name)VALUE('S210','企画部');
INSERT INTO m_section(section_code,section_name)VALUE('S230','営業部');

/* 従業員マスタINSERT */
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0001','田辺','政広','たなべ','まさひろ','1','1985-08-16','S000','2011-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0002','小松','伝三郎','こまつ','でんざぶろう','0','1986-03-13','S110','2012-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0003','福島','清一','ふくしま','せいいち','0','1990-01-28','S130','2013-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0004','中沢','愛次郎','なかざわ','あいじろう','1','1994-02-24','S150','2014-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0005','小池','征四郎','こいけ','せいしろう','1','1988-01-26','S210','2015-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0006','関口','とみ子','せきぐち','とみこ','2','1979-07-25','S230','2016-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0007','谷本','富良','たにもと','ふら','2','1973-10-30','S000','2017-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0008','志村','光範','しむら','みつのり','1','1983-09-29','S110','2011-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0009','小柳','希','こやなぎ','のぞみ','2','1974-12-24','S130','2012-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0010','笠井','照和','かさい','てるかず','2','1982-02-12','S150','2013-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0011','前川','尊則','まえかわ','たつのり','1','1976-04-23','S210','2014-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0012','片山','沢子','かたやま','さわこ','2','1976-07-28','S230','2015-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0013','野村','初美','のむら','はつみ','2','1986-03-04','S000','2016-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0014','石原','智治','いしはら','ともはる','1','1990-11-19','S110','2017-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0015','上田','則昭','うえだ','のりあき','1','1992-06-21','S130','2011-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0016','福田','保光','ふくだ','やすみつ','1','1986-04-28','S150','2012-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0017','大槻','喜治','おおつき','よしはる','0','1991-09-29','S210','2013-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0018','田村','季雄','たむら','としお','0','1987-01-03','S230','2014-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0019','稲垣','佑治','いながき','ゆうじ','1','1987-01-16','S000','2015-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0020','三上','茂信','みかみ','しげのぶ','1','1987-08-29','S110','2016-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0021','辻','幸博','つじ','よしひろ','1','1973-12-26','S130','2017-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0022','池上','鋼三郎','いけがみ','こうさぶろう','1','1981-12-19','S150','2011-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0023','三谷','友美','みたに','ともみ','2','1992-07-16','S210','2012-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0024','大野','洋和','おおの','よしかず','1','1984-06-03','S230','2013-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0025','岡','長生','おか','ながお','1','1987-06-09','S000','2014-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0026','上野','泰秀','うえの','やすひで','1','1980-05-06','S110','2015-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0027','小山','さやか','こやま','さやか','2','1988-12-27','S130','2016-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0028','大石','忠和','おおいし','ただかず','0','1987-08-19','S150','2017-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0029','松村','三佐男','まつむら','みさお','0','1980-11-01','S210','2011-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0030','松田','美智','まつだ','みち','0','1991-09-11','S230','2012-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0031','前田','靖浩','まえだ','やすひろ','0','1987-12-12','S000','2013-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0032','西','幹也','にし','みきや','0','1987-03-03','S110','2014-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0033','岡野','義武','おかの','よしたけ','1','1993-08-11','S130','2015-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0034','田上','圭織','たかみ','かおり','2','1981-05-15','S150','2016-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0035','上野','亜里香','うえの','ありか','1','1984-06-13','S210','2017-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0036','茂木','金義','もぎ','かねよし','1','1993-06-21','S230','2011-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0037','小西','公紀','こにし','きみのり','1','1992-07-30','S000','2012-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0038','若林','善英','わかばやし','よしのり','1','1981-02-25','S110','2013-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0039','西川','千絵子','にしかわ','ちえこ','2','1972-06-20','S130','2014-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0040','竹本','純太','たけもと','じゅんた','1','1974-10-18','S150','2015-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0041','池上','裕史','いけがみ','ゆうし','1','1976-11-17','S210','2016-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0042','川村','勇太郎','かわむら','ゆうたろう','1','1978-09-03','S230','2017-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0043','菅野','清名','すがの','きよの','1','1976-06-18','S000','2011-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0044','山中','元三','やまなか','げんぞう','1','1989-06-20','S110','2012-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0045','森川','茂平','もりかわ','しげひら','1','1974-08-12','S130','2013-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0046','日野','義子','ひの','よしこ','2','1990-09-05','S150','2014-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0047','林田','浩治','はやしだ','こうじ','1','1992-10-11','S210','2015-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0048','園田','麻樹','そのだ','まき','1','1972-03-24','S230','2016-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0049','飯塚','源三郎','いいつか','げんざぶろう','1','1980-10-20','S000','2017-04-01');
INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE('E0050','松島','永基','まつしま','えいき','1','1983-07-12','S110','2011-04-01');

commit;

