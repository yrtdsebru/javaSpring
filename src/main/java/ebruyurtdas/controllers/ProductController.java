package ebruyurtdas.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ebruyurtdas.entities.Product;
import ebruyurtdas.service.ProductService;

@Controller
@RequestMapping(value = "products")
public class ProductController {

	@Autowired
	ProductService productService;
  
	@RequestMapping(value = "/getPageProductAdd", method = RequestMethod.GET)
	private ModelAndView getPageProductAdd() {
		ModelAndView view = new ModelAndView("create");
		view.addObject("product", new Product());
		return view;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String create(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		return "redirect:/products/list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product product) {
		productService.updateProduct(product); 
		return "redirect:/products/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getAll(Product products) {
		ModelAndView view = new ModelAndView("products");
		List<Product> data = productService.list();
		view.addObject("datas", data);
		return view;
	}

	@RequestMapping(value = "/productDelete/{id}")
	public String delete(@PathVariable("id") int id) {
		productService.removeProduct(id);
		return "redirect:/products/list";
	}

	@RequestMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		model.addAttribute("product", this.productService.getProduct(id));
		return "editUser";
	}
}
