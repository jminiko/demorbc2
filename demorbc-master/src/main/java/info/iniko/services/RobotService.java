/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.iniko.services;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import info.iniko.models.Robot;

/**
 *
 * @author jminiko
 */

public interface RobotService {
    @Secured({"ROLEA","ROLEB"})
    public Robot findById(Long id);
    @Secured({"ROLEB"})
    public void delete(Long id);
    @Secured({"ROLEB"})
    public Robot save(Robot robot);
    @Secured({"ROLEA","ROLEB"})
    public List<Robot> findAll();
}
