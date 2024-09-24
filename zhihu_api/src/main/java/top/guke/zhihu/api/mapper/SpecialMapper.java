package top.guke.zhihu.api.mapper;


import top.guke.zhihu.api.entity.Special;

import java.util.List;

public interface SpecialMapper {
    List<Special> selectAll();
    List<Special> selectByPage(int limit , int offset);

}
