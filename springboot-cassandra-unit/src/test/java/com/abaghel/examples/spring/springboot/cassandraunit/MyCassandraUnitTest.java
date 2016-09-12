package com.abaghel.examples.spring.springboot.cassandraunit;

import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest({ "spring.data.cassandra.port=9142","spring.data.cassandra.keyspace-name=myKeyspace" })
@TestExecutionListeners(listeners = { CassandraUnitDependencyInjectionTestExecutionListener.class,DependencyInjectionTestExecutionListener.class }, mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
@CassandraDataSet(value="simple.cql",keyspace = "myKeyspace")
@EmbeddedCassandra(timeout = 10000)
public class MyCassandraUnitTest {
	
	@Autowired
	private MyCassandraUnitRepository myRepository;

	@Test
	public void myTestOne() throws Exception {
		MyCassandraUnitData data = new MyCassandraUnitData();
		data.setId("11");
		data.setValue("myval11");
		myRepository.save(data);
		assertEquals(myRepository.findAll().iterator().next().getValue(),"myval11");		
	}
	
	@Test
	public void myTestTwo() throws Exception {
		MyCassandraUnitData data = new MyCassandraUnitData();
		data.setId("22");
		data.setValue("myval22");
		myRepository.save(data);
		assertEquals(myRepository.findAll().iterator().next().getValue(),"myval22");		
	}

}