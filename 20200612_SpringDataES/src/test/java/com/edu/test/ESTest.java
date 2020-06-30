package com.edu.test;

import com.edu.dao.BookDao;
import com.edu.entity.Book;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ESTest {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void test01(){
        elasticsearchTemplate.createIndex(Book.class);
    }

    @Test
    public void test02(){
        Book book = new Book();
        book.setId(2L);
        book.setTitle("雪山飞狐");
        book.setContent("《笑傲江湖》是中国现代作家金庸创作的一部长篇武侠小说，于1967年开始创作并连载于《明报》，1969年完成。这部小说通过叙述华山派大弟子令狐冲的经历，反映了武林各派争霸夺权的历程。");
        bookDao.save(book);
    }

    @Test
    public void test03(){
        Book book = new Book();
        book.setId(1L);
        book.setTitle("笑傲江湖【修改】");
        book.setContent("《笑傲江湖》是中国现代作家金庸创作的一部长篇武侠小说，于1967年开始创作并连载于《明报》，1969年完成。这部小说通过叙述华山派大弟子令狐冲的经历，反映了武林各派争霸夺权的历程。");
        bookDao.save(book);

    }
    @Test
    public void test04(){
        Iterable<Book> books = bookDao.findAll();
        for(Book book : books){
            System.out.println(book);
        }

    }


    @Test
    public void testNativeSearchQuery() throws Exception {
        //创建一个查询对象
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery("飞狐").defaultField("title"))
                .withPageable(PageRequest.of(0, 15))
                .build();
        //执行查询
        List<Book> books = elasticsearchTemplate.queryForList(query, Book.class);
        for (Book book : books) {
            System.out.println(book);
        }

    }





}
