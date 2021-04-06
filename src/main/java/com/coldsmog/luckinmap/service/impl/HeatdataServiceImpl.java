package com.coldsmog.luckinmap.service.impl;

import com.coldsmog.luckinmap.mapper.HeatdataMapper;
import com.coldsmog.luckinmap.model.entity.Heatdata;
import com.coldsmog.luckinmap.service.HeatdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Heatdata)表服务实现类
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:03
 *
 */
@Service("heatdataService")
public class HeatdataServiceImpl implements HeatdataService {
    @Autowired
    private HeatdataMapper heatdataMapper;

    @Override
    public Integer insertByProperty(Heatdata heatdata) {
        return this.heatdataMapper.insertByProperty(heatdata);
    }

    @Override
    public Integer insertBatchByProperty(List<Heatdata> list) {
        return this.heatdataMapper.insertBatchByProperty(list);
    }

    @Override
    public Integer updateByPrimaryKey(Heatdata heatdata) {
        return this.heatdataMapper.updateByPrimaryKey(heatdata);
    }

    @Override
    public Integer updateBatchByPrimaryKey(List<Heatdata> list) {
        return this.heatdataMapper.updateBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return this.heatdataMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatchByPrimaryKey(List<Integer> list) {
        return this.heatdataMapper.deleteBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByProperty(Heatdata heatdata) {
        return this.heatdataMapper.deleteByProperty(heatdata);
    }

    @Override
    public Heatdata selectByPrimaryKey(Integer id) {
        return this.heatdataMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Heatdata> selectByProperty(Heatdata heatdata) {
        return this.heatdataMapper.selectByProperty(heatdata);
    }

    @Override
    public Long countByProperty(Heatdata heatdata) {
        return this.heatdataMapper.countByProperty(heatdata);
    }

    @Override
    public void  getData(List<Heatdata> heatdataList){
        if(heatdataList.size() <= 1){
            return;
        }
        for (Heatdata heatdata : heatdataList) {

        }
    }
}
