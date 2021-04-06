package com.coldsmog.luckinmap.service.impl;

import com.coldsmog.luckinmap.mapper.RegionMapper;
import com.coldsmog.luckinmap.model.entity.Region;
import com.coldsmog.luckinmap.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Region)表服务实现类
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:21
 */
@Service("regionService")
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionMapper regionMapper;

    @Override
    public Integer insertByProperty(Region region) {
        return this.regionMapper.insertByProperty(region);
    }

    @Override
    public Integer insertBatchByProperty(List<Region> list) {
        return this.regionMapper.insertBatchByProperty(list);
    }

    @Override
    public Integer updateByPrimaryKey(Region region) {
        return this.regionMapper.updateByPrimaryKey(region);
    }

    @Override
    public Integer updateBatchByPrimaryKey(List<Region> list) {
        return this.regionMapper.updateBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return this.regionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatchByPrimaryKey(List<Integer> list) {
        return this.regionMapper.deleteBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByProperty(Region region) {
        return this.regionMapper.deleteByProperty(region);
    }

    @Override
    public Region selectByPrimaryKey(Integer id) {
        return this.regionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Region> selectByProperty(Region region) {
        return this.regionMapper.selectByProperty(region);
    }

    @Override
    public Long countByProperty(Region region) {
        return this.regionMapper.countByProperty(region);
    }
}
