package co.grandcircus.coffeeshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
	
	

}
