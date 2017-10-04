/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.iniko.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import info.iniko.models.Robot;
import info.iniko.services.RobotService;

/**
 *
 * @author jminiko
 */
@RestController
public class RobotController {
    
    private final RobotService pojoService;
    
    @Autowired
    public RobotController(final RobotService service) {
        this.pojoService = service;
    }
    
    public RobotController(){
        pojoService = null;
    }
    
    @RequestMapping(value = "/robot/{robotId}", method = RequestMethod.GET)
    public Robot findRobot(@PathVariable String robotId) {
        try{
            Robot robot = pojoService.findById(Long.valueOf(robotId));
            if(robot==null)
                throw new RobotNotFoundException(robotId);
            return robot;
        }catch(Exception ex){
            throw new RobotNotFoundException(robotId);
        }
        
    }
    
    @RequestMapping(value = "/robot/{robotId}", method = RequestMethod.DELETE)
    public void deleteRobot(@PathVariable String robotId) {
        pojoService.delete(Long.valueOf(robotId));
    }
    @RequestMapping(value = "/robot/{robotId}", method = RequestMethod.POST)
    public Robot createRobot( @RequestBody @Valid final Robot r) {
        Robot robot = null;
        try{
        	robot = pojoService.save(r);
            if(robot==null)
                throw new RobotSaveFoundException(); // for not found TBD distinction with below semantically
        }catch(Exception ex){  // for whatever reason else
            throw new RobotSaveFoundException();
        }
        return robot;
    }
    
    @CrossOrigin
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Robot> findAll(){
    	return pojoService.findAll();
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    class RobotNotFoundException extends RuntimeException {

	public RobotNotFoundException(String id) {
		super("could not load robot with id: "+id+" .");
	}
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    class RobotSaveFoundException extends RuntimeException {

	public RobotSaveFoundException() {
		super("could not save robot.");
	}
    }
}
