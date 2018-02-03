DROP TABLE IF EXISTS iftb_item_customer;
CREATE TABLE iftb_item_customer
(
  iic_id         INT AUTO_INCREMENT
  COMMENT '序号'
    PRIMARY KEY,
  mc_id          INT         NULL
  COMMENT '客户表序号',
  omi_id         INT         NULL
  COMMENT '车位序号',
  iiic_status    VARCHAR(1)  NULL
  COMMENT '购买车位类型 0购买 1预定 2失效',
  iic_startdate  VARCHAR(20) NULL
  COMMENT '购买开始时间',
  iic_enddate    VARCHAR(20) NULL
  COMMENT '购买结束时间',
  iic_cost       VARCHAR(20) NULL
  COMMENT '花费',
  iic_formula    VARCHAR(50) NULL
  COMMENT '计算公式',
  iic_createdate VARCHAR(20) NULL
  COMMENT '创建时间',
  iic_createuser VARCHAR(20) NULL
  COMMENT '创建人',
  iic_updatedate VARCHAR(20) NULL
  COMMENT '更新时间',
  iic_updateuser VARCHAR(20) NULL
  COMMENT '更新人'
)
  COMMENT '客户和车位信息关系表';
DROP TABLE IF EXISTS iftb_machine_action;
CREATE TABLE iftb_machine_action
(
  ima_id         INT AUTO_INCREMENT
  COMMENT '关系表序号'
    PRIMARY KEY,
  mm_id          INT         NULL
  COMMENT '设备的序号',
  ma_id          INT         NULL
  COMMENT '物业的序号',
  ima_code       VARCHAR(20) NULL,
  ima_name       VARCHAR(20) NULL,
  ima_address    VARCHAR(20) NULL,
  ima_port       VARCHAR(20) NULL,
  ima_status     VARCHAR(1)  NULL
  COMMENT '0正常 1设备运行中 2设备故障 3存取车故障 4存车超时 5取车超时',
  ima_createtime VARCHAR(20) NULL,
  ima_createuser VARCHAR(20) NULL,
  ima_updatetime VARCHAR(20) NULL,
  ima_updateuser VARCHAR(20) NULL
)
  COMMENT '定义设备和物业的关系 多对多';
DROP TABLE IF EXISTS mstb_customer;
CREATE TABLE mstb_customer
(
  mc_id          INT AUTO_INCREMENT
  COMMENT '客户表序号'
    PRIMARY KEY,
  mc_code        VARCHAR(20) NULL
  COMMENT '客户表 - 客户代码',
  mc_pass        VARCHAR(20) NULL
  COMMENT '客户表 - 客户密码',
  mc_name_cn     VARCHAR(20) NULL
  COMMENT '客户表 - 客户中文名',
  mc_mobile      VARCHAR(20) NULL
  COMMENT '客户表 - 手机号',
  mc_type        VARCHAR(1)  NULL
  COMMENT '客户表 - 客户类型',
  mc_status      VARCHAR(1)  NULL
  COMMENT '客户表 - 客户状态',
  mc_verify_code VARCHAR(20) NULL
  COMMENT '用户验证码 - 忘记密码时使用',
  mc_createdate  VARCHAR(20) NULL
  COMMENT '创建时间',
  mc_createuser  VARCHAR(20) NULL
  COMMENT '创建人',
  mc_updatedate  VARCHAR(20) NULL
  COMMENT '更新时间',
  mc_updateuser  VARCHAR(20) NULL
  COMMENT '更新人'
)
  COMMENT '客户信息 - 保存客户的基本信息 -&#';

DROP TABLE IF EXISTS tstb_log;
CREATE TABLE tstb_log
(
  tl_id            INT PRIMARY KEY
  COMMENT '序号' AUTO_INCREMENT,
  tl_createdate    VARCHAR(20) COMMENT '创建日期',
  tl_create_thread VARCHAR(200) COMMENT '创建线程',
  tl_level         VARCHAR(20) COMMENT '错误级别',
  tl_message       VARCHAR(2000) COMMENT '错误信息'
);
ALTER TABLE tstb_log
  COMMENT = '项目运行错误日志';

DROP TABLE IF EXISTS oftb_customer_car;
CREATE TABLE oftb_customer_car
(
  mc_id          INT         NULL
  COMMENT '客户表序号',
  occ_id         INT AUTO_INCREMENT
  COMMENT '序号'
    PRIMARY KEY,
  occ_name       VARCHAR(50) NULL
  COMMENT '客户汽车信息 - 汽车命名',
  occ_code       VARCHAR(50) NULL
  COMMENT '客户汽车信息 - 车牌号',
  occ_type       VARCHAR(1)  NULL
  COMMENT '客户汽车信息 - 汽车类型',
  occ_status     VARCHAR(1)  NULL
  COMMENT '客户汽车信息 - 状态0启用 1禁用',
  occ_createuser VARCHAR(20) NULL
  COMMENT '创建人',
  occ_createdate VARCHAR(20) NULL
  COMMENT '创建时间 ',
  occ_updateuser VARCHAR(20) NULL
  COMMENT '更新人',
  occ_updatedate VARCHAR(20) NULL
  COMMENT '更新时间'
)
  COMMENT '客户汽车信息 - 被推送';
DROP TABLE IF EXISTS oftb_mathine_item;
CREATE TABLE oftb_mathine_item
(
  ima_id            INT          NULL
  COMMENT '关系表序号',
  omi_id            INT AUTO_INCREMENT
  COMMENT '车位序号'
    PRIMARY KEY,
  omi_code          VARCHAR(50)  NULL
  COMMENT '车位代码',
  omi_physical_code VARCHAR(100) NULL
  COMMENT '车位实际物理代码',
  omi_name          VARCHAR(50)  NULL
  COMMENT '车位名称信息',
  omi_rate          VARCHAR(20)  NULL
  COMMENT '费率',
  omi_startdate     VARCHAR(20)  NULL
  COMMENT '费率开始时间',
  omi_enddate       VARCHAR(20)  NULL
  COMMENT '费率结束时间',
  omi_status        VARCHAR(2)   NULL
  COMMENT '车位信息状态 -1弃用 0可购买 1已购买 2预定',
  omi_createuser    VARCHAR(20)  NULL
  COMMENT '创建人',
  omi_createdate    VARCHAR(20)  NULL
  COMMENT '创建时间',
  omi_updateuser    VARCHAR(20)  NULL
  COMMENT '更新人',
  omi_updatedate    VARCHAR(20)  NULL
  COMMENT '更新时间'
)
  COMMENT '设备车位信息子表';
DROP TABLE IF EXISTS oftb_sync_log;
CREATE TABLE oftb_sync_log
(
  osl_id         INT AUTO_INCREMENT
  COMMENT '序号'
    PRIMARY KEY,
  osl_type       VARCHAR(1)  NULL
  COMMENT '同步的类型0心跳同步1车位信息同步2其他',
  osl_count      INT         NULL
  COMMENT '同步数量',
  osl_status     VARCHAR(1)  NULL
  COMMENT '同步状态 0：成功1：错误2：处理中',
  osl_createdate VARCHAR(20) NULL,
  osl_createuser VARCHAR(20) NULL,
  osl_updatedate VARCHAR(20) NULL,
  osl_updateuser VARCHAR(20) NULL
)
  COMMENT '本地同步日志表';
DROP TABLE IF EXISTS tstb_ftp_car_information;
CREATE TABLE tstb_ftp_car_information
(
  tfc_id         INT AUTO_INCREMENT
  COMMENT '序号，自动增长'
    PRIMARY KEY,
  ima_id         INT         NULL
  COMMENT '停车设备序号',
  tfc_car_code   VARCHAR(20) NULL
  COMMENT '车牌信息',
  tfc_status     INT         NULL
  COMMENT '状态',
  tfc_createtime VARCHAR(20) NULL
  COMMENT '创建时间',
  tfc_createuser VARCHAR(20) NULL
  COMMENT '创建人',
  tfc_updatetime VARCHAR(20) NULL
  COMMENT '更新时间',
  tfc_updateuser VARCHAR(20) NULL
  COMMENT '更新人'
)
  COMMENT '存储FTP上面读取到的车牌信息，并且临时存储到本表';
DROP TABLE IF EXISTS tstb_mathine_parking;
CREATE TABLE tstb_mathine_parking
(
  tmp_id            INT AUTO_INCREMENT
  COMMENT '停车主表'
    PRIMARY KEY,
  ima_id            INT          NULL
  COMMENT '车位信息关系表序号',
  tmp_code          VARCHAR(50)  NULL
  COMMENT '停车位置代码,系统生成',
  tmp_physical_code VARCHAR(100) NULL
  COMMENT '停车位置PLC代码信息',
  tmp_car_code      VARCHAR(20)  NULL,
  tmp_status        VARCHAR(1)   NULL,
  tmp_createdate    VARCHAR(20)  NULL
  COMMENT '创建时间',
  tmp_createuser    VARCHAR(20)  NULL
  COMMENT '创建人',
  tmp_updateuser    VARCHAR(20)  NULL
  COMMENT '更新人',
  tmp_updatedate    VARCHAR(20)  NULL
  COMMENT '更新时间'
)
  COMMENT '停车信息主 - 主动推送信 -&#&';
DROP TABLE IF EXISTS tstb_mathine_parking_log;
CREATE TABLE tstb_mathine_parking_log
(
  tmpl_id            INT AUTO_INCREMENT
  COMMENT '停车日志序号'
    PRIMARY KEY,
  ima_id             INT         NULL
  COMMENT '关系表序号',
  tmpl_car           VARCHAR(20) NULL
  COMMENT '停车汽车号牌',
  tmpl_physical_code VARCHAR(20) NULL
  COMMENT '停车位置物理代码',
  tmpl_customer      VARCHAR(20) NULL
  COMMENT '停车用户名',
  tmpl_type          VARCHAR(1)  NULL
  COMMENT '停车类型0存车1取车',
  tmpl_status        VARCHAR(1)  NULL
  COMMENT '状态',
  tmpl_createdate    VARCHAR(20) NULL
  COMMENT '创建时间',
  tmpl_createuser    VARCHAR(20) NULL
  COMMENT '创建人',
  tmpl_updatedate    VARCHAR(20) NULL
  COMMENT '更新时间',
  tmpl_updateuser    VARCHAR(20) NULL
  COMMENT '更新人'
)
  COMMENT '停车信息日志表-当前表支持插入,不支持更新-每插入一条数据,需要更新';
;
;
DELIMITER ;

DELIMITER ;;
DROP TRIGGER IF EXISTS TR_after_save_tstb_mathine_parking_log;
CREATE TRIGGER TR_after_save_tstb_mathine_parking_log
AFTER INSERT ON tstb_mathine_parking_log
FOR EACH ROW
  BEGIN

    CALL sp_tstb_mathine_parking_log(
        NEW.ima_id,
        NEW.tmpl_car,
        NEW.tmpl_type,
        NEW.tmpl_status,
        NEW.tmpl_physical_code
    );
  END;
;;
DELIMITER ;

DELIMITER ;;
DROP PROCEDURE IF EXISTS sp_tstb_mathine_parking_log;
CREATE PROCEDURE sp_tstb_mathine_parking_log(IN sp_ima_id             INT, IN sp_tmpl_car VARCHAR(20),
                                             IN sp_tmpl_type          VARCHAR(1), IN sp_tmpl_status VARCHAR(2),
                                             IN sp_tmpl_physical_code VARCHAR(100))
  BEGIN

    DECLARE tmp_id_int INT;

    -- 判断操作状态，成功则执行
    IF (sp_tmpl_status = '0')
    THEN
      -- 停车
      IF (sp_tmpl_type = '0')
      THEN
        -- 判断当前是否还有车位可用
        SET tmp_id_int = (SELECT tmp_id
                          FROM tstb_mathine_parking
                          WHERE
                            ima_id = sp_ima_id AND tmp_physical_code = sp_tmpl_physical_code AND tmp_car_code IS NULL
                          LIMIT 1);

        IF (ISNULL(tmp_id_int))
        THEN
          SIGNAL SQLSTATE 'HY000'
          SET MESSAGE_TEXT = '没有可用车位';
        END IF;

        UPDATE tstb_mathine_parking
        SET tmp_car_code = sp_tmpl_car
        WHERE tmp_id = tmp_id_int AND tmp_physical_code = sp_tmpl_physical_code;
      END IF;

      -- 取车
      IF (sp_tmpl_type = '1')
      THEN
        -- 判断当前是否有该车在停
        SET tmp_id_int = (SELECT tmp_id
                          FROM tstb_mathine_parking
                          WHERE ima_id = sp_ima_id AND tmp_physical_code = sp_tmpl_physical_code AND
                                tmp_car_code = sp_tmpl_car
                          LIMIT 1);

        IF (ISNULL(tmp_id_int))
        THEN
          SIGNAL SQLSTATE 'HY000'
          SET MESSAGE_TEXT = '取车失败，当前机器没有该车';
        END IF;

        UPDATE tstb_mathine_parking
        SET tmp_car_code = NULL
        WHERE ima_id = sp_ima_id AND tmp_car_code = sp_tmpl_car AND tmp_physical_code = sp_tmpl_physical_code;
      END IF;
    END IF;
  END;

;;
DELIMITER ;