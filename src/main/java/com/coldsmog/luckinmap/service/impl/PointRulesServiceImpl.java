package com.coldsmog.luckinmap.service.impl;

import com.coldsmog.luckinmap.mapper.PointRulesMapper;
import com.coldsmog.luckinmap.model.entity.PointRules;
import com.coldsmog.luckinmap.service.PointRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (PointRules)表服务实现类
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:16
 *
 */
@Service("pointRulesService")
public class PointRulesServiceImpl implements PointRulesService {
    @Autowired
    private PointRulesMapper pointRulesMapper;

    @Override
    public Integer insertByProperty(PointRules pointRules) {
        return this.pointRulesMapper.insertByProperty(pointRules);
    }

    @Override
    public Integer insertBatchByProperty(List<PointRules> list) {
        return this.pointRulesMapper.insertBatchByProperty(list);
    }

    @Override
    public Integer updateByPrimaryKey(PointRules pointRules) {
        return this.pointRulesMapper.updateByPrimaryKey(pointRules);
    }

    @Override
    public Integer updateBatchByPrimaryKey(List<PointRules> list) {
        return this.pointRulesMapper.updateBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return this.pointRulesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatchByPrimaryKey(List<Integer> list) {
        return this.pointRulesMapper.deleteBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByProperty(PointRules pointRules) {
        return this.pointRulesMapper.deleteByProperty(pointRules);
    }

    @Override
    public PointRules selectByPrimaryKey(Integer id) {
        return this.pointRulesMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PointRules> selectByProperty(PointRules pointRules) {
        return this.pointRulesMapper.selectByProperty(pointRules);
    }

    @Override
    public Long countByProperty(PointRules pointRules) {
        return this.pointRulesMapper.countByProperty(pointRules);
    }
}
