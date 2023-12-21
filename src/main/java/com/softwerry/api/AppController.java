package com.softwerry.api;


import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

@RestController
@RequestMapping("/api/db")
public class AppController {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @GetMapping("hello")
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("select")
    public ResponseEntity<String> SelectStar() {
        @Query("select * from employee e");
        Collection<Employee> findAll();
        /* 
        SqlRowSet resultSet= jdbcTemplate.queryForRowSet("select id, name, lastname, age from employee");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("FirstName"));
        }
        */

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("insert")
    public ResponseEntity<String> InsertRow() {
        jdbcTemplate.execute("insert into employee (name, lastname, age) values ('Stella','Maria','24')");
        //jdbcTemplate.execute("INSERT INTO employee values ('Roshen','Karthik','32')");
        //jdbcTemplate.execute("INSERT INTO employee values ('Harish','Prasanna','41')");

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("build")
    public ResponseEntity<String> rebuildSchema() {

        jdbcTemplate.execute("create table if not exists " +
                                " employee ( " +
                                    "id int primary key auto_increment, " +
                                    "name varchar(100), " +
                                    "lastname varchar(100), " +
                                    "age varchar(100) )");

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
