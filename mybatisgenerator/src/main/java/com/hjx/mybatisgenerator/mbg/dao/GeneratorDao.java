
package com.hjx.mybatisgenerator.mbg.dao;

import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 数据库接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface GeneratorDao {
    List<Map<String, Object>> queryList(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
