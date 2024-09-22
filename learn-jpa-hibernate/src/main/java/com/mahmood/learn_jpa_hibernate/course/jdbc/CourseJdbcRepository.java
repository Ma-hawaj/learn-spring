package com.mahmood.learn_jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static final String INSERT_QUERY =
            """
            insert into course(id, name, author)
            values(?, ?, ?);
            """;

    private static final String DELETE_QUERY =
            """
            delete from course
            where id = ?
            """;

    private static final String SELECT_QUERY =
            """
            select * from course
            where id = ?
            """;

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id){
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id){
        return
                springJdbcTemplate.queryForObject
                        (SELECT_QUERY,
                                new BeanPropertyRowMapper<>(Course.class),
                                id);
        // We need to map the resultSet to a bean so we use a row mapper
        // Since out bean property names match the database records we can use
        // the BeanPropertyRowMapper
    }
}
