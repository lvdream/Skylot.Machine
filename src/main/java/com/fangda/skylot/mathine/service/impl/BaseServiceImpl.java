package com.fangda.skylot.mathine.service.impl;

import com.fangda.skylot.mathine.dao.IBaseDao;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Saul on 22/01/2017.
 */
@Service
public abstract class BaseServiceImpl<T, F> implements IBaseService<T, F> {
    @Autowired
    public Map<String, IBaseService> serviceMap;
    private IBaseDao<T, F> baseDao;

    public Map<String, IBaseService> getServiceMap() {
        return serviceMap;
    }

    public IBaseDao<T, F> getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(IBaseDao<T, F> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public int add(T t) throws Exception {
        if (t != null) {
            try {
                baseDao.save(t);
            } catch (Exception e) {
                throw e;
            }
        }
        return 0;
    }

    @Override
    public int delete(F obj) throws Exception {
        if (obj != null) {
            try {
                return baseDao.delete(obj);
            } catch (Exception e) {
                throw e;
            }
        }
        return 0;
    }

    @Override
    public int update(T t) throws Exception {
        if (t != null) {
            try {
                return baseDao.update(t);
            } catch (Exception e) {
                throw e;
            }
        }
        return 0;
    }

    @Override
    public int update(T t, F find) throws Exception {
        if (t != null) {
            try {
                return baseDao.updatewithoutNull(t, find);
            } catch (Exception e) {
                throw e;
            }
        }
        return 0;
    }

    @Override
    public T query(int id) throws Exception {
        try {
            return baseDao.ReadByID(id);
        } catch (Exception e) {
            throw e;
        }
//		return null;
    }

    @Override
    public T query(F find) throws Exception {
        try {
            return baseDao.ReadSingle(find);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<T> queryForAll(F find) throws Exception {
        try {
            return baseDao.ReadAll(find);
        } catch (Exception e) {
            throw e;

        }
    }

    @Override
    public List<T> queryForAll(F find, Page page) throws Exception {
        try {
            return baseDao.ReadLimitedByOrder(find, page);
        } catch (Exception e) {
            throw e;

        }
    }
}