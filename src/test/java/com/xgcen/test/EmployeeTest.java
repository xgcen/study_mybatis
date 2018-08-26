package com.xgcen.test;

import com.xgcen.mapper.EmployeeMapper;
import com.xgcen.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author xg
 * @date 2018/8/25 15:59
 */
public class EmployeeTest {

    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testGetOneById() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.selectOneById(1);
            System.out.println(employee.getId() + "-->" + employee.getLastName());
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetByIds() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            //            List<Employee> employees = employeeMapper.selectList(Arrays.asList(1, 2, 3, 4, 5, 6, 8), null);
            List<Employee> employees = employeeMapper.selectList(null, null);
            employees.forEach(System.out::println);
        } finally {
            sqlSession.close();
        }
    }

}
