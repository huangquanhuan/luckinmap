package com.coldsmog.luckinmap.service.impl;

import com.coldsmog.luckinmap.mapper.PointMapper;
import com.coldsmog.luckinmap.model.entity.Point;
import com.coldsmog.luckinmap.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Point)表服务实现类
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:12
 *
 */
@Service("pointService")
public class PointServiceImpl implements PointService {
    @Autowired
    private PointMapper pointMapper;

    @Override
    public Integer insertByProperty(Point point) {
        return this.pointMapper.insertByProperty(point);
    }

    @Override
    public Integer insertBatchByProperty(List<Point> list) {
        return this.pointMapper.insertBatchByProperty(list);
    }

    @Override
    public Integer updateByPrimaryKey(Point point) {
        return this.pointMapper.updateByPrimaryKey(point);
    }

    @Override
    public Integer updateBatchByPrimaryKey(List<Point> list) {
        return this.pointMapper.updateBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return this.pointMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatchByPrimaryKey(List<Integer> list) {
        return this.pointMapper.deleteBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByProperty(Point point) {
        return this.pointMapper.deleteByProperty(point);
    }

    @Override
    public Point selectByPrimaryKey(Integer id) {
        return this.pointMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Point> selectByProperty(Point point) {
        return this.pointMapper.selectByProperty(point);
    }

    @Override
    public Long countByProperty(Point point) {
        return this.pointMapper.countByProperty(point);
    }
}
