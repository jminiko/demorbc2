package info.iniko.central;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import info.iniko.demo.model.Robot;

@Controller
public class GrailsController {
	
	@Autowired
	JsonService service;

	@RequestMapping(value="/l", method=RequestMethod.GET)
    public ModelAndView showForm() {
		ModelAndView mav = null;
		try {
			System.out.println("DBG020:::"+service);
			List<Object> list = service.getRobotDTO();
			System.out.println("DBG0100:::"+list);
			mav = new ModelAndView("listofrobots","modelList",list);
			return mav;
		} catch (Exception e) {
			mav = new ModelAndView("listofrobots","modelList",null);
			return mav;
		}
 
		
	}
}
