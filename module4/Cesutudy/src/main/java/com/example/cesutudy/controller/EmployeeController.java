package com.example.cesutudy.controller;

import com.example.cesutudy.model.*;
import com.example.cesutudy.repository.employee.DivisionRepository;
import com.example.cesutudy.repository.employee.EducationDegreeRepository;
import com.example.cesutudy.repository.employee.PositionRepository;
import com.example.cesutudy.service.common.BCryptPassword;
import com.example.cesutudy.service.Employee.EmployeeService;
import com.example.cesutudy.service.role.RoleService;
import com.example.cesutudy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    BCryptPassword bCryptPassword;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DivisionRepository divisionRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    EducationDegreeRepository educationDegreeRepository;

    @ModelAttribute("listPosition")
    public List<Position> getPositions() {
        return positionRepository.findAll();
    }

    @ModelAttribute("listDivision")
    public List<Division> getDivisions() {
        return divisionRepository.findAll();
    }

    @ModelAttribute("listDegree")
    public List<EducationDegree> geEducationDegrees() {
        return educationDegreeRepository.findAll();
    }
    @GetMapping("/list")
    public ModelAndView list(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("listEmp", employeeService.findAll(pageable));
        return modelAndView;
    }
    @GetMapping("/createGet")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, Model model,
                         RedirectAttributes attributes) {
        if (userService.checkAccount(employee.getUser().getUserName())) {
            bindingResult.addError(new FieldError("employee", "user.userName", "Account name is already exist!"));
            return "/employee/create";
        }
        if (bindingResult.hasFieldErrors()) {
            return "/employee/create";
        }
        employee.getUser().setPassword(bCryptPassword.encodePassword(employee.getUser().getPassword()));
        Set<Role> roles = new HashSet<>();
        if (employee.getPosition().getPositionId() == 6 || employee.getPosition().getPositionId() == 5) {
            roles.add(roleService.findById(1));
        }else{
            roles.add(roleService.findById(2));
        }
        employee.getUser().setRoles(roles);
        attributes.addFlashAttribute("msg", "Create employee: "
                + employee.getEmployeeName() + " successful!");
        employeeService.create(employee);
        return "redirect:/employee/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes attributes) {
        attributes.addFlashAttribute("msg", "Delete customer: " +
                employeeService.findById(id).getEmployeeName() + " successful!");
        employeeService.delete(id);
        return "redirect:/employee/list";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/employee/detail");
        modelAndView.addObject("employee", employeeService.findById(id));
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView showView(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/employee/view");
        modelAndView.addObject("employee", employeeService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/employee/detail";
        }
        Set<Role> roles = new HashSet<>();
        if (employee.getPosition().getPositionId() == 6 || employee.getPosition().getPositionId() == 5)
            roles.add(roleService.findById(1));
        else
            roles.add(roleService.findById(2));
        employee.getUser().setPassword(bCryptPassword.encodePassword(employee.getUser().getPassword()));
        employee.getUser().setRoles(roles);
        attributes.addFlashAttribute("msg", "Update employee: "
                + employee.getEmployeeName() + " successful!");
        employeeService.update(employee);
        return "redirect:/employee/list";
    }
    @GetMapping("/search")
    public String search(@RequestParam String nameEmp,Model model,@PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("listEmp",employeeService.findByName(nameEmp,pageable));
        return "/employee/tableSearch";
    }

    @RequestMapping(value = "/autocompletee")
    @ResponseBody
    public Set<String> autoName(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
        return employeeService.selectName(term);
    }

}
