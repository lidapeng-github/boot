package com.dapeng;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import javax.sql.DataSource;
import javax.websocket.server.PathParam;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Demo04DataApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() {

        System.out.println( dataSource.getClass());

        try {
            Connection connection = dataSource.getConnection();

            System.out.println(connection);

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
