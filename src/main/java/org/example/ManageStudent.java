package org.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Data
public class ManageStudent {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public boolean add(Student student) {
        String sql = "insert into student values(?,?)";
        jdbcTemplate.update(sql,student.getId(),student.getName());
        return true;
    }
    public boolean delete(int id) {
        String sql = "delete from student where id=?";
        jdbcTemplate.update(sql,id);
        return true;
    }
    public boolean update(int id, String name) {
        String sql = "update student set name=? where id=?";
        jdbcTemplate.update(sql,name,id);
        return true;
    }
    public Student search(int id) {
        String sql = "select * from student WHERE id=?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        List<Student> list = jdbcTemplate.query(sql, rowMapper,id);
        return list.isEmpty() ? null : list.get(0);
    }
}
