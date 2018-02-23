CREATE TABLE `oftb_code_info` (
  `oci_id`            INT(11) NOT NULL AUTO_INCREMENT
  COMMENT '序号',
  `ima_id`            VARCHAR(50)      DEFAULT NULL
  COMMENT '物业设备序号',
  `oci_physical_code` VARCHAR(100)     DEFAULT NULL
  COMMENT '实体车位序号',
  `oci_code_url`      VARCHAR(500)     DEFAULT NULL
  COMMENT '取车二维码',
  `oci_password`      VARCHAR(20)      DEFAULT NULL
  COMMENT '取车密码',
  `oci_status`        VARCHAR(2)       DEFAULT NULL
  COMMENT '状态',
  `oci_createdate`    VARCHAR(20)      DEFAULT NULL
  COMMENT '创建时间',
  `oci_createuser`    VARCHAR(20)      DEFAULT NULL
  COMMENT '创建人',
  `oci_updatedate`    VARCHAR(20)      DEFAULT NULL
  COMMENT '更新时间',
  `oci_updateuser`    VARCHAR(20)      DEFAULT NULL
  COMMENT '更新人',
  PRIMARY KEY (`oci_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT ='取车二维码表';


CREATE TABLE `oftb_reserve_taking` (
  `ort_id`            INT(11) NOT NULL AUTO_INCREMENT
  COMMENT '序号',
  `mc_id`             INT(11)          DEFAULT NULL
  COMMENT '客户表序号',
  `ima_id`            VARCHAR(50)      DEFAULT NULL
  COMMENT '物业设备序号',
  `ort_physical_code` VARCHAR(100)     DEFAULT NULL
  COMMENT '实体车位序号',
  `ort_reserve_time`  VARCHAR(20)      DEFAULT NULL
  COMMENT '预约取车时间',
  `ort_status`        VARCHAR(2)       DEFAULT NULL
  COMMENT '状态',
  `ort_createdate`    VARCHAR(20)      DEFAULT NULL
  COMMENT '创建时间',
  `ort_createuser`    VARCHAR(20)      DEFAULT NULL
  COMMENT '创建人',
  `ort_updatedate`    VARCHAR(20)      DEFAULT NULL
  COMMENT '更新时间',
  `ort_updateuser`    VARCHAR(20)      DEFAULT NULL
  COMMENT '更新人',
  PRIMARY KEY (`ort_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT ='预约取车表';

;
;
DELIMITER ;
DROP TRIGGER TR_after_save_tstb_mathine_parking_log;
DELIMITER ;;
CREATE TRIGGER TR_after_save_tstb_mathine_parking_log
  AFTER INSERT
  ON tstb_mathine_parking_log
  FOR EACH ROW
  BEGIN

    CALL sp_tstb_mathine_parking_log(
        NEW.ima_id,
        NEW.tmpl_car,
        NEW.tmpl_type,
        NEW.tmpl_status,
        NEW.tmpl_physical_code,
        NEW.tmpl_createuser,
        NEW.tmpl_createdate
    );
  END;


;;
DELIMITER ;

TRUNCATE TABLE iftb_item_customer;
TRUNCATE TABLE iftb_machine_action;
TRUNCATE TABLE iftb_schedule_action;
TRUNCATE TABLE mstb_customer;
TRUNCATE TABLE oftb_code_info;
TRUNCATE TABLE oftb_customer_car;
TRUNCATE TABLE oftb_mathine_item;
TRUNCATE TABLE oftb_reserve_taking;
TRUNCATE TABLE oftb_sync_log;
TRUNCATE TABLE schema_version;
TRUNCATE TABLE tstb_ftp_car_information;
TRUNCATE TABLE tstb_log;
TRUNCATE TABLE tstb_mathine_parking;
TRUNCATE TABLE tstb_mathine_parking_log;


;
;
DELIMITER ;

ALTER TABLE tstb_ftp_car_information
  ADD tfc_car_color VARCHAR(4) NULL
COMMENT '车辆颜色';
ALTER TABLE tstb_ftp_car_information
  ADD tfc_car_type VARCHAR(1) NULL
COMMENT '车辆类型
0:小型
1:中型
2:大型';
ALTER TABLE tstb_ftp_car_information
  ADD tfc_car_in_code VARCHAR(20) NULL
COMMENT '车台识别
车辆牌照';
ALTER TABLE tstb_ftp_car_information
  ADD tfc_car_in_type VARCHAR(1) NULL
COMMENT '车台识别
车辆类型
0:小型
1:中型
2:大型';
ALTER TABLE tstb_ftp_car_information
  ADD tfc_car_in_color VARCHAR(4) NULL
COMMENT '车台识别
车辆颜色';


ALTER TABLE tstb_ftp_car_information
  ADD tfc_car_action VARCHAR(1) NULL
COMMENT '停取车判断
0:停车
1:取车';
ALTER TABLE tstb_ftp_car_information
  MODIFY COLUMN tfc_car_action VARCHAR(1) COMMENT '停取车判断
0:停车
1:取车'
  AFTER tfc_car_color;
ALTER TABLE tstb_ftp_car_information
  MODIFY tfc_car_action VARCHAR(1) COMMENT '停取车判断
0:停车
1:取车
2:预约取车';


DROP PROCEDURE IF EXISTS sp_oftb_reserve_taking;

CREATE PROCEDURE `sp_tstb_ftp_car_information`()
  BEGIN
    -- 验证当前停车表是否拥有的记录数大于2条
    DECLARE tmp_count INT;

    SET tmp_count = (SELECT count(*)
                     FROM tstb_ftp_car_information);
    IF (tmp_count > 2)
    THEN
      SIGNAL SQLSTATE 'HY000'
      SET MESSAGE_TEXT = 'allow_parking_count_over';
    END IF;
  END;
;
;
DELIMITER ;

ALTER TABLE iftb_machine_action
  ADD ima_error_json TEXT NULL
COMMENT '错误信息JSON对象';

ALTER TABLE tstb_ftp_car_information
  ADD tfc_is_canceled VARCHAR(1) NULL
COMMENT '取消指令';
ALTER TABLE tstb_ftp_car_information
  MODIFY tfc_is_canceled VARCHAR(1) COMMENT '取消指令
0:取消';


DROP TRIGGER IF EXISTS TR_after_save_tstb_mathine_parking_log;
DELIMITER ;;
CREATE TRIGGER TR_after_save_tstb_mathine_parking_log
  AFTER INSERT
  ON tstb_mathine_parking_log
  FOR EACH ROW
  BEGIN

    CALL sp_tstb_mathine_parking_log(
        NEW.ima_id,
        NEW.tmpl_car,
        NEW.tmpl_type,
        NEW.tmpl_status,
        NEW.tmpl_physical_code,
        NEW.tmpl_createuser,
        NEW.tmpl_createdate
    );
  END;
;;
DELIMITER ;


ALTER TABLE iftb_machine_action
  ADD ima_physical_status VARCHAR(1) NULL
COMMENT '设备物理状态
0:正常
1:设备运转中
2:设备严重故障
3:设备一般故障';

DROP PROCEDURE IF EXISTS sp_oftb_reserve_taking;
DELIMITER ;;
CREATE PROCEDURE sp_oftb_reserve_taking()
  BEGIN
    -- 验证当前预约表是否有预约车辆
    DECLARE tmp_count INT;
    DECLARE tmp_car_code_w VARCHAR(200) CHARACTER SET utf8;
    DECLARE tmp_ima_id_w VARCHAR(100) CHARACTER SET utf8;
    DECLARE tmp_pysical_code_w VARCHAR(2) CHARACTER SET utf8;
    # 查询60秒钟之后和30秒之前是否有预约车辆
    SET tmp_count = (SELECT count(*)
                     FROM oftb_reserve_taking
                     WHERE date_add(now(), INTERVAL '60' SECOND) > ort_reserve_time AND
                           date_add(now(), INTERVAL '-30' SECOND) < ort_reserve_time);

    IF (tmp_count > 0)
    THEN
      SET tmp_pysical_code_w = (SELECT ort_physical_code
                                FROM oftb_reserve_taking
                                ORDER BY ort_id ASC
                                LIMIT 1);
      SET tmp_ima_id_w = (SELECT ima_id
                          FROM oftb_reserve_taking
                          ORDER BY ort_id ASC
                          LIMIT 1);

      SET tmp_car_code_w = (SELECT tmp_car_code
                            FROM tstb_mathine_parking
                            WHERE tmp_physical_code = (SELECT ort_physical_code
                                                       FROM oftb_reserve_taking
                                                       ORDER BY ort_id ASC
                                                       LIMIT 1));
      # 判断当前是否有车辆正在停取车,如果没有车辆正在停取车,则进行预约操作,反正不进行操作
      IF (SELECT count(*)
          FROM tstb_ftp_car_information) = 0
      THEN
        INSERT INTO tstb_ftp_car_information (ima_id, tfc_car_code, tfc_status, tfc_createtime, tfc_car_action)
        VALUES (tmp_ima_id_w, tmp_car_code_w, 1, now(), '2');
      END IF;
    END IF;
    # 删除过期预约项目
    SET tmp_count = (SELECT count(*)
                     FROM oftb_reserve_taking
                     WHERE date_add(now(), INTERVAL '-1' DAY) > ort_reserve_time);
    DROP EVENT IF EXISTS et_sp_reserve;
    DELIMITER ;;
    CREATE EVENT et_sp_reserve
      ON SCHEDULE EVERY 20 SECOND
      ON COMPLETION PRESERVE DO CALL sp_oftb_reserve_taking();
    IF (tmp_count > 0)
    THEN
      DELETE FROM oftb_reserve_taking
      WHERE date_add(now(), INTERVAL '-1' DAY) > ort_reserve_time;
    END IF;
  END;

;;
DELIMITER ;


DELIMITER ;

# 增加字段,保存如果和SaaS同步失败的情况下,原始数据的内容
ALTER TABLE oftb_sync_log
  ADD osl_orignal_message TEXT NULL
COMMENT '原始的数据信息';