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