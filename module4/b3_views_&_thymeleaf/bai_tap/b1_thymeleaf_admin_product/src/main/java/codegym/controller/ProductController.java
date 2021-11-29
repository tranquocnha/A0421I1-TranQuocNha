package codegym.controller;

import codegym.model.Product;
import codegym.services.IProductService;
import codegym.services.IProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    IProductService iProductService = new IProductServiceImpl();

    @GetMapping("")
    public String listProduct(Model model){
        List<Product> productList = iProductService.findAll();
        model.addAttribute("listProduct",productList);
        return "/list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Product product) {
        product.setProductId((int) (Math.random() * 10000));
        iProductService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable(value = "id") int productId,Model model){
        model.addAttribute("product",iProductService.findById(productId));
        return "/edit";
    }
    @PostMapping("/update")
    public String updateProduct(Product product) {
        iProductService.update(product.getProductId(), product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable(value = "id") int productId, RedirectAttributes redirect){
        iProductService.remove(productId);
        redirect.addAttribute("success","Xóa thành công");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable(value = "id") int productId, Model model) {
        model.addAttribute("product", iProductService.findById(productId));
        return "/view";
    }
    @GetMapping("/search")
    public String searchNameProduct(@RequestParam(name = "search-name",required = false) String search, Model model) {
        model.addAttribute("listProduct", iProductService.findByName(search));
        return "/list";
    }
}
