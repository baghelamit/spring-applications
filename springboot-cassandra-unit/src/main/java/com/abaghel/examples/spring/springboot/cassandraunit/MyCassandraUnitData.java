package com.abaghel.examples.spring.springboot.cassandraunit;

import java.io.Serializable;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

/**
 * 
 * @author abaghel
 *
 */
@Table("MyCassandraUnitData")
public class MyCassandraUnitData implements Serializable {
	@PrimaryKeyColumn(name = "id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
	private String id;
	@Column(value = "value")
	private String value;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
