package com.hjx.system.dao;

import java.util.List;

import com.hjx.system.model.Dict;
import com.hjx.system.model.DictPage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictMapper {

    int deleteByPrimaryKey(String id);

    int insert(Dict record);

    Dict selectByPrimaryKey(String id);

    List<Dict> selectAll();

    int updateByPrimaryKey(Dict record);

    List<Dict> findTByPage(DictPage dict);

    int findTCountByT(DictPage dict);

    void deleteBy(String[] id);

    List<Dict> findTByT(Dict dict);
}