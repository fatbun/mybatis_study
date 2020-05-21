import com.benjamin.bean.Employee;
import com.benjamin.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
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

            Employee e = mapper.findById(1);
            System.out.println(e);
        }
    }

    @Test
    public void test02() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeDao mapper = session.getMapper(EmployeeDao.class);

            Employee e = new Employee();
            e.setId(1);
            e.setName("lb");
            e.setPhone("13288888888");
            e.setIdentity("440102xxxxx");

            Integer save = mapper.save(e);
            System.out.println(save);

            session.commit();
        }
    }

    @Test
    public void test03() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeDao mapper = session.getMapper(EmployeeDao.class);

            List<Employee> all = mapper.findAll();
            System.out.println(all);
        }
    }
}
