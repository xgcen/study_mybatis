package com.xgcen.mapper;

import com.xgcen.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xg
 * @date 2018/8/25 15:33
 */
public interface EmployeeMapper {

    Employee selectOneById(Integer id);

    List<Employee> selectList(@Param("ids") List<Integer> ids, @Param("limit") Integer limit);

}
