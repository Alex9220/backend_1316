package lesson6;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ExampleMain {
    public static void main( String[] args ) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        lesson6.db.dao.CategoriesMapper categoriesMapper = session.getMapper(lesson6.db.dao.CategoriesMapper.class);
        lesson6.db.model.CategoriesExample example = new lesson6.db.model.CategoriesExample();
        example.createCriteria().andIdEqualTo(800);
        List<lesson6.db.model.Categories> list = categoriesMapper.selectByExample(example);

        lesson6.db.model.Categories categories = new lesson6.db.model.Categories();
        categories.setId(800);
        categories.setTitle("123");
        categoriesMapper.updateByExample(categories, example);


        System.out.println(categoriesMapper.countByExample(example));

        System.out.println(list);
    }
}

