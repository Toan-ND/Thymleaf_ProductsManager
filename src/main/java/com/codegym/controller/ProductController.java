package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    ProductService productService = new ProductServiceImpl();

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/product/create")
    public String create(Model model){
        model.addAttribute("products",new Product());
        return "create";
    }

    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirect){
        product.setId((int) (Math.random()*10000));
        productService.save(product);
        redirect.addFlashAttribute("success","Saved product successfully!");
        return "redirect:/index";
    }

    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product",productService.fillById(id));
        return "edit";
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect){
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success","modified product successfully!");
        return "redirect:/index";
    }

    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product", productService.fillById(id));
        return "delete";
    }

    @PostMapping("/product/delete")
    public String delete(Product product,RedirectAttributes reditect){
       productService.delete(product.getId());
        reditect.addFlashAttribute("success","Remoted product successfuly!");
        return "redirect:/index";
    }

    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("product", productService.fillById(id));
        return "view";
    }
}
