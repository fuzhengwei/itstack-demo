package itstack.demo.erp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fuzhengwei on 2016/3/12.
 */
@Controller("jump")
@RequestMapping("/jump/")
public class JumpController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login/login");
        return modelAndView;
    }


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/index");
        return modelAndView;
    }

}
