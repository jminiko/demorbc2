package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import info.iniko.central.JsonService;
import info.iniko.demo.model.RobotDTO;
import junit.framework.Assert;

/**
 *
 * @author jminiko
 */
@RunWith(MockitoJUnitRunner.class)
public class DemoApplicationTests {
	JsonService jsonService;

	@Before
	public void setup() {
		jsonService = new JsonService();
	}

	@Test
	public void testInit() {
		assertNotNull(jsonService);
	}

	@Test
   public void testFindAll(){
	   RobotDTO dto = jsonService.getRobotDTO();
	   assertTrue("list no empty", !dto.getRobots().isEmpty());
	   assertSame(dto.getRobots(), 2);
   }
}
