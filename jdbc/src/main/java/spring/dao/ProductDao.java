package spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.daoi.ProductDaoI;
import spring.models.Product;

public class ProductDao implements ProductDaoI {
	
    private JdbcTemplate jdbcTemplate;

	public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
	}

	public Product findProductById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM Product WHERE Id = ?", new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Product(rs.getLong("Id"), rs.getString("Name"), rs.getInt("Quantity"), rs.getDouble("Price"));
			}
		}, id);
	}

	public List<Product> findAll() {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM Product");
		List<Product> result = new ArrayList<>();
		for(Map<String, Object> row: rows) {
			result.add(new Product((Long) row.get("Id"), (String) row.get("Name"), (Integer) row.get("Quantity"),
					(Double) row.get("Price")));
		}
		return result;
	}
}
