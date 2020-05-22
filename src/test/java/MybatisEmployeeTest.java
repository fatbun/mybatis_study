import com.benjamin.bean.Department;
import com.benjamin.bean.Employee;
import com.benjamin.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ben Li.
 * Date: 2020/5/20
 */
public class MybatisEmployeeTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void test01() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeDao mapper = session.getMapper(EmployeeDao.class);

            List<Employee> all = mapper.findAll();
            System.out.println(all);
        }
    }

    @Test
    public void test02() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeDao mapper = session.getMapper(EmployeeDao.class);

            Employee e = mapper.findByIdJoin(2);
            System.out.println(e);
        }
    }

    @Test
    public void test03() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeDao mapper = session.getMapper(EmployeeDao.class);

            Employee e = mapper.findByIdSelect(1);
            System.out.println(e);
        }
    }

    @Test
    public void test04() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeDao mapper = session.getMapper(EmployeeDao.class);

            Employee e = new Employee();
            e.setId(3);
            e.setName("wangwu");
            e.setPhone("13200000000");
            e.setIdentity("440100xxxxx");

            Integer save = mapper.save(e);
            System.out.println(save);

            session.commit();
        }
    }

    @Test
    public void test05() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeDao mapper = session.getMapper(EmployeeDao.class);
            Employee e = new Employee();
            e.setId(1);
            e.setName("lb");
            e.setPhone("13288888888");
            Department d = new Department();
            d.setId(1);
            e.setDepartment(d);

            //            List<Employee> employees = mapper.findAllByIf(e);
            //            List<Employee> employees = mapper.findAllByChoose(e);
            List<Employee> employees = mapper.findAllByTrim(e);

            System.out.println(employees);
        }
    }

    @Test
    public void test06() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeDao mapper = session.getMapper(EmployeeDao.class);
            List<Integer> ids = Arrays.asList(1,
                    2);
            List<Employee> employees = mapper.findAllByIdForeach(ids);
//            List<String> names = Arrays.asList("lb",
//                    "wangwu");
//            List<Employee> employees = mapper.findAllByNameForeach(names);
            System.out.println(employees);
        }
    }
}
