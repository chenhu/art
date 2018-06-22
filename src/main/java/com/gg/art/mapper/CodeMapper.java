package com.gg.art.mapper;

import com.gg.art.model.Code;

import java.util.List;

public interface CodeMapper {
    int insert(Code record);

    int insertSelective(Code record);

    List<Code> selectByType(String type);
}