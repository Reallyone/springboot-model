package com.hjx.system.service;

import java.util.List;

import com.hjx.common.model.GetEasyUIData;
import com.hjx.common.model.Result;
import com.hjx.system.model.Dict;
import com.hjx.system.model.DictPage;

public interface DictService {

    GetEasyUIData findTByPage(DictPage dict);

    void insertDict(Dict dict);

    void updateByPrimaryKeyDict(Dict dict);

    void deleteByPrimaryKeyDict(String[] id);

    Dict selectByPrimaryKey(String id);

    List<Dict> findTByT(Dict dict);
}
