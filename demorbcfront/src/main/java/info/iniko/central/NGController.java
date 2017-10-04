package info.iniko.central;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NGController {

	@RequestMapping(path="/index")
	public ModelAndView index() {
        ModelAndView mav =new ModelAndView("index.html");
        
         
        return mav;
    }
}
