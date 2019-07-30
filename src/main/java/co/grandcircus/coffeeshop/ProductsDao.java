package co.grandcircus.coffeeshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductsDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<Product> findAll() {
		String sql = "SELECT * FROM products";
		return jdbc.query(sql, new BeanPropertyRowMapper(Product.class));
	}
	

}
