package com.vison.canteen.biz.common;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vison.canteen.biz.bean.BasePO;
import com.vison.canteen.biz.util.BeanUtil;

import java.util.List;

/**
 * @author huangwenshen 2018/3/10 15:51
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BasePO<T>> extends ServiceImpl<M, T> {

    @Override
    public boolean insert(T entity) {
        BeanUtil.load(entity);
        return super.insert(entity);
    }

    @Override
    public boolean insertAllColumn(T entity) {
        BeanUtil.load(entity);
        return super.insertAllColumn(entity);
    }

    @Override
    public boolean insertBatch(List<T> entities) {
        BeanUtil.loads(entities);
        return super.insertBatch(entities);
    }

    @Override
    public boolean insertBatch(List<T> entities, int batchSize) {
        BeanUtil.loads(entities);
        return super.insertBatch(entities, batchSize);
    }

    @Override
    public boolean insertOrUpdateBatch(List<T> entities) {
        BeanUtil.loads(entities);
        return super.insertOrUpdateBatch(entities);
    }

    @Override
    public boolean insertOrUpdateBatch(List<T> entities, int batchSize) {
        BeanUtil.loads(entities);
        return super.insertOrUpdateBatch(entities, batchSize);
    }

    @Override
    public boolean insertOrUpdateAllColumnBatch(List<T> entities) {
        BeanUtil.loads(entities);
        return super.insertOrUpdateAllColumnBatch(entities);
    }

    @Override
    public boolean insertOrUpdateAllColumnBatch(List<T> entities, int batchSize) {
        BeanUtil.loads(entities);
        return super.insertOrUpdateAllColumnBatch(entities, batchSize);
    }

    //    @Override
    //    public boolean deleteById(Serializable id) {
    //    }
    //
    //    @Override
    //    public boolean deleteByMap(Map<String, Object> var1);
    //
    //    @Override
    //    public boolean delete(Wrapper<T> var1);
    //
    //    @Override
    //    public boolean deleteBatchIds(List<? extends Serializable> var1);

    @Override
    public boolean updateById(T entity) {
        BeanUtil.refreshTime(entity);
        return super.updateById(entity);
    }

    @Override
    public boolean updateAllColumnById(T entity) {
        BeanUtil.refreshTime(entity);
        return super.updateAllColumnById(entity);
    }

    @Override
    public boolean update(T entity, Wrapper<T> wrapper) {
        BeanUtil.refreshTime(entity);
        return super.update(entity, wrapper);
    }

    @Override
    public boolean updateBatchById(List<T> entities) {
        BeanUtil.loads(entities);
        return super.updateBatchById(entities);
    }

    @Override
    public boolean updateBatchById(List<T> entities, int batchSize) {
        BeanUtil.loads(entities);
        return super.updateBatchById(entities, batchSize);
    }

    @Override
    public boolean updateAllColumnBatchById(List<T> entities) {
        BeanUtil.loads(entities);
        return super.updateAllColumnBatchById(entities);
    }

    @Override
    public boolean updateAllColumnBatchById(List<T> entities, int batchSize) {
        BeanUtil.loads(entities);
        return super.updateAllColumnBatchById(entities, batchSize);
    }

    @Override
    public boolean insertOrUpdate(T entity) {
        BeanUtil.refreshTime(entity);
        return super.insertOrUpdate(entity);
    }

    @Override
    public boolean insertOrUpdateAllColumn(T entity) {
        BeanUtil.refreshTime(entity);
        return super.insertOrUpdateAllColumn(entity);
    }

}
