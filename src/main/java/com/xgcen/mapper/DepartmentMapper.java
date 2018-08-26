package com.xgcen.mapper;


import com.xgcen.model.Department;

/**
 * @author xg
 * @date 2018/8/25 15:33
 */
public interface DepartmentMapper {

    Department selectOneById(Integer id);

}
