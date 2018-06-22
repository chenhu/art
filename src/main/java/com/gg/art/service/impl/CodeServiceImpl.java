package com.gg.art.service.impl;
/**
 * Created by chenhu on 2018/6/22.
 */

import com.gg.art.mapper.CodeMapper;
import com.gg.art.model.Code;
import com.gg.art.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: chenhu
 * @Date: 2018/6/22 09:35
 * @Description: 字典服务
 */
@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeMapper codeMapper;
    /**
    * @Description: 根据类型查询对应的字典数据，用于前端下拉列表显示
    * @Param: [type] @see {@link com.gg.art.bean.DictionaryCode}
    * @Return: java.util.List<com.gg.art.model.Code>
    **/
    @Override
    public List<Code> queryByType(String type) {
        return codeMapper.selectByType(type);
    }
}
