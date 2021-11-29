package codegym.controller;

import codegym.services.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;


    @GetMapping("/")
    public String showForm() {
        return "dictionary";
    }
    @GetMapping("/dictionary")
    public String getDictionary(@RequestParam String english, Model model){
        String vn = dictionaryService.findEnglish(english);
        model.addAttribute("eng", english);
        model.addAttribute("vn", vn);
        return "dictionary";
    }
}
