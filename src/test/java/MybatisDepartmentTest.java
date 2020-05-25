import com.benjamin.bean.Department;
import com.benjamin.bean.Employee;
import com.benjamin.dao.DepartmentDao;
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
public class MybatisDepartmentTest {

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
            DepartmentDao mapper = session.getMapper(DepartmentDao.class);

            List<Department> d = mapper.findAll();
            System.out.println(d);

            d = mapper.findAll();
            System.out.println(d);
        }
    }

    @Test
    public void test02() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            DepartmentDao mapper = session.getMapper(DepartmentDao.class);

            Department e = new Department();
            e.setDname("客服部");

            Integer save = mapper.save(e);
            System.out.println(save);
            System.out.println(e);

            session.commit();
        }
    }


    @Test
    public void test03() {
        SqlSession session1 = sqlSessionFactory.openSession();
        SqlSession session2 = sqlSessionFactory.openSession();
        DepartmentDao mapper1 = session1.getMapper(DepartmentDao.class);
        DepartmentDao mapper2 = session2.getMapper(DepartmentDao.class);

        List<Department> d = mapper1.findAll();
        System.out.println(d);
        session1.close();

        d = mapper2.findAll();
        System.out.println(d);
    }

    @Test
    public void test04() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            DepartmentDao mapper = session.getMapper(DepartmentDao.class);

            Department e = new Department();
            e.setId(4);
            e.setDname("客服部3");

            Integer save = mapper.update(e);
            System.out.println(e);

            session.commit();
        }
    }

    @Test
    public void test05() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            DepartmentDao mapper = session.getMapper(DepartmentDao.class);

            Integer delete = mapper.delete(4);
            System.out.println(delete);

            session.commit();
        }
    }


}
