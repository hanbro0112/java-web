-- 部門管理
create table dept (
    id int unsigned primary key auto_increment comment '主鍵ID',
    name varchar(10) not null unique comment '部門名稱',
    create_time datetime not null comment '創建時間',
    update_time datetime not null comment '修改時間'
) comment '部門表';

insert into dept (id, name, create_time, update_time) values
    (1, '研發部', now(), now()),
    (2, '行銷部', now(), now()),
    (3, '人事部', now(), now()),
    (4, '財務部', now(), now()
);

-- 員工管理
create table emp (
    id int unsigned primary key auto_increment comment 'ID',
    username varchar(20) not null unique comment '用戶名',
    password varchar(36) not null default '123456' comment '密碼',
    name varchar(50) not null comment '姓名',
    gender tinyint unsigned not null comment '性別 0-女 1-男',
    image varchar(300) comment '頭像',
    job tinyint unsigned comment '職位 0-班主任 1-講師 2-助教 3-咨詢師',
    entry_date date comment '入職日期',
    dept_id int unsigned comment '部門ID',
    create_time datetime not null comment '創建時間',
    update_time datetime not null comment '修改時間'
) comment '員工表';

insert into emp (id, username, password, name, gender, image, job, entry_date, dept_id, create_time, update_time) values
      (1, 'asdsafsa', '123456', '馬二', 1, null, 2, '2020-02-12', 2, now(), now()),
      (2, 'zhangsan', '123456', '張三', 1, null, 1, '2020-01-15', 1, now(), now()),
      (3, 'lisi', '123456', '李四', 0, null, 2, '2019-03-22', 2, now(), now()),
      (4, 'wangwu', '123456', '王五', 1, null, 0, '2021-07-30', 3, now(), now()),
      (5, 'zhaoliu', '123456', '趙六', 0, null, 3, '2018-11-05', 4, now(), now()),
      (6, 'tianqi', '123456', '田七', 1, null, 1, '2022-05-18', 1, now(), now()),
      (7, 'sunba', '123456', '孫八', 0, null, 2, '2019-09-09', 2, now(), now()),
      (8, 'zhaojiu', '123456', '趙九', 1, null, 0, '2020-12-12', 3, now(), now()),
      (9, 'qianer', '123456', '錢二', 0, null, 3, '2021-03-03', 4, now(), now()),
      (10, 'zhouyi', '123456', '周一', 1, null, 1, '2018-08-08', 1, now(), now()),
      (11, 'wuershi', '123456', '吳二十', 0, null, 2, '2019-10-10', 2, now(), now()),
      (12, 'zhangsi', '123456', '張四', 1, null, 0, '2020-04-04', 3, now(), now()),
      (13, 'liliu', '123456', '李六', 0, null, 3, '2021-06-06', 4, now(), now()),
      (14, 'wangqi', '123456', '王七', 1, null, 1, '2018-09-09', 1, now(), now()),
      (15, 'zhaoba', '123456', '趙八', 0, null, 2, '2019-11-11', 2, now(), now());

-- 部門操作日誌
create table dept_log (
    id int unsigned primary key auto_increment comment 'ID',
    create_time datetime not null comment '操作時間',
    description varchar(200) not null comment '操作描述'
)