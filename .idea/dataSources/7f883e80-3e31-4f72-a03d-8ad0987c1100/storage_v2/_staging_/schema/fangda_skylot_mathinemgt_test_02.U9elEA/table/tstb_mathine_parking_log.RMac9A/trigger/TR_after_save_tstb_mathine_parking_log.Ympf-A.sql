DROP TRIGGER IF EXISTS TR_after_save_tstb_mathine_parking_log;
DELIMITER ;;
CREATE TRIGGER TR_after_save_tstb_mathine_parking_log
  AFTER INSERT ON tstb_mathine_parking_log
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