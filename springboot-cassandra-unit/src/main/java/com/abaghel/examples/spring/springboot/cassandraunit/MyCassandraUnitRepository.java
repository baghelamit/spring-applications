package com.abaghel.examples.spring.springboot.cassandraunit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author abaghel
 *
 */
@Repository
public interface MyCassandraUnitRepository extends CrudRepository<MyCassandraUnitData,String>{

}
