package codegym.controller;

import codegym.model.Commen;
import codegym.services.CommenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommenController {
    @Autowired
    CommenService commenService;
    @GetMapping("/home")
    public ModelAndView homePage(){
        ModelAndView modelAndView=new ModelAndView("/index");
        modelAndView.addObject("listComment",commenService.findAll());
        return modelAndView;
    }
}
