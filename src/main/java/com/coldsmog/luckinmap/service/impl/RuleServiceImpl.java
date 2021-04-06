package com.coldsmog.luckinmap.service.impl;

import com.coldsmog.luckinmap.mapper.RuleMapper;
import com.coldsmog.luckinmap.model.entity.Rule;
import com.coldsmog.luckinmap.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Rule)表服务实现类
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:30
 *
 */
@Service("ruleService")
public class RuleServiceImpl implements RuleService {
    @Autowired
    private RuleMapper ruleMapper;

    @Override
    public Integer insertByProperty(Rule rule) {
        return this.ruleMapper.insertByProperty(rule);
    }

    @Override
    public Integer insertBatchByProperty(List<Rule> list) {
        return this.ruleMapper.insertBatchByProperty(list);
    }

    @Override
    public Integer updateByPrimaryKey(Rule rule) {
        return this.ruleMapper.updateByPrimaryKey(rule);
    }

    @Override
    public Integer updateBatchByPrimaryKey(List<Rule> list) {
        return this.ruleMapper.updateBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return this.ruleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatchByPrimaryKey(List<Integer> list) {
        return this.ruleMapper.deleteBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByProperty(Rule rule) {
        return this.ruleMapper.deleteByProperty(rule);
    }

    @Override
    public Rule selectByPrimaryKey(Integer id) {
        return this.ruleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Rule> selectByProperty(Rule rule) {
        return this.ruleMapper.selectByProperty(rule);
    }

    @Override
    public Long countByProperty(Rule rule) {
        return this.ruleMapper.countByProperty(rule);
    }
}
