package com.gg.art.service;/**
 * Created by chenhu on 2018/6/22.
 */

import com.gg.art.model.Code;

import java.util.List;

/**
 * @Auther: chenhu
 * @Date: 2018/6/22 09:34
 * @Description:字典服务
 */
public interface CodeService {
    List<Code> queryByType(String type);
}
