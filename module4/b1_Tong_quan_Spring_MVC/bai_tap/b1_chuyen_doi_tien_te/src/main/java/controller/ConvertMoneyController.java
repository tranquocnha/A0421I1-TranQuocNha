package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.ConvertMonetService;

@Controller
public class ConvertMoneyController {
    @Autowired
    ConvertMonetService convertMonetService;

    @GetMapping("/")
    public String showConvert(){
        return "convert";
    }

    @GetMapping("/convert")
    public String getConvert(@RequestParam int usd, Model model){
        double usdConvert=usd;
        double vnd=convertMonetService.getConvert(usd);
        model.addAttribute("usd",usdConvert);
        model.addAttribute("vnd",vnd);
        return "convert";
    }
}
