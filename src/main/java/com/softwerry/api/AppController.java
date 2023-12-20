package com.softwerry.api;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("build")
    public ResponseEntity<String> rebuildSchema() {

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS " +
                                " 'employee' ( " +
                                    "'id' INT PRIMARY KEY AUTOINCREMENT, " +
                                    "'name' VARCHAR(100), " +
                                    "'lastname' VARCHAR(100), " +
                                    "'age' VARCHAR(100) )");

        jdbcTemplate.execute("INSERT INTO employee values ('Stella','Maria','24')");
        jdbcTemplate.execute("INSERT INTO employee values ('Roshen','Karthik','32')");
        jdbcTemplate.execute("INSERT INTO employee values ('Harish','Prasanna','41')");

        SqlRowSet resultSet= jdbcTemplate.queryForRowSet("SELECT * FROM employee");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("FirstName"));
        }

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
