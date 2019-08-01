package co.grandcircus.coffeeshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class CoffeeShopController {
	
	@Autowired
	private ProductsDao dao;
	
	@Autowired
	private UsersDao dao1; 
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("redirect:/products");
	}

	@RequestMapping("/products")
	public ModelAndView list() {
		List<Product> leListOfProducts = dao.findAll();
		return new ModelAndView("products", "products", leListOfProducts);
	}
	
	@RequestMapping("/users")
	public ModelAndView add() {		
		return new ModelAndView("users");
	}
	
	@PostMapping("/newMember")
	public ModelAndView addSubmit(User user) {
		dao1.create(user);
		return new ModelAndView("/newMember");
	}
	
	@RequestMapping("/admin")
	public ModelAndView list1() {
		List<Product> leListOfProducts = dao.findAll();
		return new ModelAndView("admin", "products", leListOfProducts);
	
	}
	
	@RequestMapping("/create")
	public ModelAndView showCreateForm() {
		// If there is only one model value to add, use this one-line shortcut. Equivalent to
		// ModelAndView mav = new ModelAndView("food-form");
		// mav.addObject("title", "Add a Food");
		return new ModelAndView("create", "title", "Add a Food");
	}
	
	@PostMapping("/create")
	public ModelAndView submitCreateForm(Product products) {
		dao.create(products);
		return new ModelAndView("redirect:admin");
	}	
	
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id") Integer id) {
		System.out.println("hello");
		dao.delete(id);
		return new ModelAndView("redirect:/admin");}
	
	
	
	// path variable required to identify which food we're editing
		@RequestMapping("/update")
		public ModelAndView showEditForm(@RequestParam("id") Integer id) {
			ModelAndView mav = new ModelAndView("update");
			mav.addObject("products", dao.findById(id));
			mav.addObject("title", "Edit Item");
			return mav;
		}
		
		// same URL but different method
		@PostMapping("/update")
		public ModelAndView submitEditForm(Product products) {
			dao.update(products);
			return new ModelAndView("redirect:/admin");	
	
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
