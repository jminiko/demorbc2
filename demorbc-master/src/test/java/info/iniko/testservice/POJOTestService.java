/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.iniko.testservice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.util.Assert;

import info.iniko.models.Robot;
import info.iniko.services.RobotRepository;
import info.iniko.services.RobotService;
import info.iniko.services.RobotServiceImpl;

/**
 *
 * @author jminiko
 */
@RunWith(MockitoJUnitRunner.class) 
public class POJOTestService {
    @Mock
    RobotRepository repo;        
            
    RobotService service;
    
    @Before
    public void setUp(){
        service = new RobotServiceImpl(repo);
    }
    
    @Test
    public void testFindAll(){
    	Robot r = service.findById(1L);
        System.out.println(r);
        Assert.isNull(r);
    }
}
