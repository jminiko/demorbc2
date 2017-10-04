/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.iniko.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import info.iniko.models.Robot;

/**
 *
 * @author jminiko
 */
@Service
public class RobotServiceImpl implements RobotService{

	@Resource
    private final RobotRepository repository;

    public RobotServiceImpl(){
    	repository=null;
    }
    
    public RobotServiceImpl(RobotRepository robotRepository){
        repository = robotRepository;
    }
    @Override 
    public void delete(Long id) {
        repository.delete(id);
    }

    public Robot findById(Long id){
        return repository.findOne(id);
    }
    
    @Override
    public Robot save(Robot robot) {
        return repository.save(robot);
    }

	@Override
	public List<Robot> findAll() {
		return repository.findAll();
	}
    
}
