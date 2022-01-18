package com.example.cesutudy.controller;

import com.example.cesutudy.model.Contract;
import com.example.cesutudy.model.Customer;
import com.example.cesutudy.model.Employee;
import com.example.cesutudy.model.Service;
import com.example.cesutudy.repository.service.ServiceRepository;
import com.example.cesutudy.service.Employee.EmployeeService;
import com.example.cesutudy.service.contract.ContractService;
import com.example.cesutudy.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ContractService contractService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ServiceRepository serviceRepo;

    @ModelAttribute("listCus")
    public List<Customer> getCustomer() {
        return customerService.findAll();
    }

    @ModelAttribute("listService")
    public List<Service> getService() {
        return serviceRepo.findAll();
    }

    @ModelAttribute("listEmp")
    public List<Employee> getEmployee() {
        return employeeService.findAll();
    }

    @GetMapping("/list")
    public String list(Model model) {
        return viewPage(model, 1);
    }

    @GetMapping("/list/page/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum) {
        int pageSize = 2;
        Page<Contract> page = contractService.findAllSort(pageNum, pageSize);
        List<Contract> listContract = page.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listContract", listContract);
        return "/contract/list";
    }

    @GetMapping("/createGet")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        modelAndView.addObject("contract", new Contract());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        if (bindingResult.hasFieldErrors()) {
            return "contract/create";
        }
        LocalDate startDate = LocalDate.parse(contract.getContractStartDate());
        LocalDate endDate = LocalDate.parse(contract.getContractEndDate());
        if (ChronoUnit.DAYS.between(startDate, endDate) < 1) {
            bindingResult.addError(new FieldError("contract", "contractEndDate", "End date must be greater than start date"));
            return "contract/create";
        }
        attributes.addFlashAttribute("msg", "Create contract: " + contract.getContractId() + " successful!");
        contractService.create(contract);
        return "redirect:/contract/list";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/contract/detail");
        modelAndView.addObject("contract", contractService.findById(id));
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView showView(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/contract/view");
        modelAndView.addObject("contract", contractService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/contract/detail";
        }
        LocalDate startDate = LocalDate.parse(contract.getContractStartDate());
        LocalDate endDate = LocalDate.parse(contract.getContractEndDate());
        if (ChronoUnit.DAYS.between(startDate, endDate) < 1) {
            bindingResult.addError(new FieldError("contract", "contractEndDate", "End date must be greater than start date"));
            return "contract/create";
        }
        attributes.addFlashAttribute("msg", "Update contract successful!");
        contractService.update(contract);
        return "redirect:/contract/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes attributes) {
        attributes.addFlashAttribute("msg", "Delete contract successful!");
        contractService.delete(id);
        return "redirect:/contract/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam String nameCus, Model model, @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("listCustomer", customerService.findByName(nameCus, pageable));
        return "/customer/tableSearch";
    }

    @RequestMapping(value = "/autocomplete")
    @ResponseBody
    public Set<String> autoName(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
        return customerService.selectName(term);
    }
}
