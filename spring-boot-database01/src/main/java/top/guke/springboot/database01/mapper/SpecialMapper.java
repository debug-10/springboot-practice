package top.guke.springboot.database01.mapper;

import top.guke.springboot.database01.entity.Special;

import java.util.List;

public interface SpecialMapper {
    List<Special> findAll();
}