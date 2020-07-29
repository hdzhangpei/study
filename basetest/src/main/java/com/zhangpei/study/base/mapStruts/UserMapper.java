package com.zhangpei.study.base.mapStruts;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    @Mappings({
            @Mapping(source = "string2integerTest", target = "integerTest", defaultValue = ""),
    })
    UserVo trans2UserVo(User user);
}
