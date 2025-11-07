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