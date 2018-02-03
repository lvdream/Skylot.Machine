package com.fangda.skylot.mathine.service.impl.utils;

import com.fangda.skylot.mathine.dao.customer.OftbSyncLogDAO;
import com.fangda.skylot.mathine.model.customer.OftbSyncLog;
import com.fangda.skylot.mathine.model.customer.OftbSyncLogCriteria;
import com.fangda.skylot.mathine.service.utils.SyncLogService;
import com.fangda.skylot.mathine.utils.constant.Constant;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service("syncLogService")
public class SyncLogServiceImpl implements SyncLogService{

	@Autowired
	private OftbSyncLogDAO oftbSyncLogDao;
	
	@Override
	public int saveLog(Object object) throws SkyLotException {
		//默认1失败
		int result = 1;
		try {
			this.oftbSyncLogDao.save((OftbSyncLog) object);
			result = 0;
		} catch (Exception e) {
			throw new SkyLotException("SyncLogServiceImpl - Exception:saveLog",e.getCause());
		}
		return result;
	}

	@Override
	public Map<String,Object> isSuccessSyncProcess() throws SkyLotException {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			OftbSyncLogCriteria objectCriteria = new OftbSyncLogCriteria();
			objectCriteria.setOrderByClause("osl_updatedate desc");

			List<OftbSyncLog> list = this.oftbSyncLogDao.ReadAllByOrder(objectCriteria);
			if(list != null){
				OftbSyncLog osl = list.get(0);
				map.put("status", osl.getOslStatus());
				map.put("lastCreateTime", osl.getOslCreatedate());
			}
		} catch (Exception e) {
			throw new SkyLotException("SyncLogServiceImpl - Exception:isSuccessSyncProcess",e.getCause());
		}
		return map;
	}

	@Override
	public int setFailed() throws SkyLotException {
		//默认1失败
		int result = 1;
		try {
			OftbSyncLogCriteria objectCriteria = new OftbSyncLogCriteria();
			objectCriteria.setOrderByClause("osl_updatedate desc");
			
			List<OftbSyncLog> list = this.oftbSyncLogDao.ReadAllByOrder(objectCriteria);
			OftbSyncLog osl = list.get(0);
			
			osl.setOslStatus(Constant.FN_RETURN_STATUS_ERROR);
			
			this.oftbSyncLogDao.update(osl);
			result = 0;
		} catch (Exception e) {
			throw new SkyLotException("SyncLogServiceImpl - Exception:setFailed",e.getCause());
		}
		return result;
	}

}
