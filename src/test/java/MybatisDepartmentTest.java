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

            Department d = mapper.findById(1);
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



}
