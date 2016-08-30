package com.abaghel.examples.spring.springboot.hikaricp;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.abaghel.examples.spring.springboot.MySpringBootApp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApp.class)
public class HikariCPConnTest {

	@Autowired
	HikariCPConn hkConn;

	@Test
	public void testInsert() {
		JdbcTemplate jt = hkConn.getJdbcTemplate();
		jt.execute("create table employee (id int, name varchar(20))");
		jt.execute("insert into employee (id, name) values (1, 'Emp1')");
		jt.execute("insert into employee (id, name) values (2, 'Emp2')");
		List<Map<String, Object>> data = jt.queryForList("select * from employee");
		assertEquals(2,data.size());
		for (Map map : data) {
			System.out.println(map);
		}
	}

}
