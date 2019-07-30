package co.grandcircus.coffeeshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Repository
public class UsersDao {
	@Autowired
	private JdbcTemplate jdbc;
	
	public void create(User user) {
		String sql = "INSERT INTO users ( name, email, password) VALUES ( ?,?,? )";
		jdbc.update(sql, user.getName(), user.getEmail(), user.getPassword());
	}

}
