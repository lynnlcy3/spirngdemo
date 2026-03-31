package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ManageStudent manageStudent = context.getBean(ManageStudent.class);
//        manageStudent.delete(2);
        System.out.println(manageStudent.search(1));
//        Student student = new Student();
//        student.setId(2);
//        student.setName("John Doe");
//        manageStudent.add(student);
//        String sql="update student set name='lynn' where id=1";
//        jdbcTemplate.update(sql);

    }
}
