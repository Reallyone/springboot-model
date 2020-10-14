
package com.hjx.mybatisgenerator.mbg.config;

import com.hjx.mybatisgenerator.mbg.dao.GeneratorDao;
import com.hjx.mybatisgenerator.mbg.dao.MySQLGeneratorDao;
import com.hjx.mybatisgenerator.mbg.utils.SDMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 数据库配置
 *
 * @author Mark sunlightcs@gmail.com
 */
@Configuration
public class DbConfig {

    @Value("${cet.database: mysql}")
    private String database;

    @Autowired
    private MySQLGeneratorDao mySQLGeneratorDao;

    @Bean
    @Primary
    public GeneratorDao getGeneratorDao(){
        if("mysql".equalsIgnoreCase(database)){
            return mySQLGeneratorDao;
        }else {
            throw new SDMException("不支持当前数据库：" + database);
        }
    }
}

