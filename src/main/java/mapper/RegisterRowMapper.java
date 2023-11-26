package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.*;
import org.jdbi.v3.core.statement.StatementContext;

import model.User;
import response.ProductResponse;

public class RegisterRowMapper {

	//https://github.com/qualidafial/jdbi-examples/blob/master/src/test/java/org/jdbi/examples/v3/Example03RegisterRowMapper.java
	public static class UserMapper implements RowMapper<User> {

		@Override
		public User map(ResultSet rs, StatementContext ctx) throws SQLException {
			//resultset lấy dữ liệu từng dòng từ sql lên
			int iduser = rs.getInt("iduser");
			String lastname = rs.getString("lastname");
			
		    return new User(
		    		rs.getInt("iduser"), 
		    		rs.getString("lastname"),
		    		rs.getString("firstname"), 
		    		rs.getString("email"), 
		    		rs.getString("username"), 
		    		rs.getString("phone"), 
		    		rs.getString("password"), 
		    		rs.getInt("status"), 
		    		rs.getInt("role"),
		    		rs.getInt("idrole")
		    		);
		}
	}
	
	public static class ProductResponseMapper implements RowMapper<ProductResponse> {

	    @Override
	    public ProductResponse map(ResultSet rs, StatementContext ctx) throws SQLException {
	        return new ProductResponse(
	                rs.getInt("idproduct"),
	                rs.getInt("idcategory"),
	                rs.getInt("idmaterial"),
	                rs.getString("sku"),
	                rs.getString("title"),
	                rs.getString("image"),
	                rs.getFloat("price"),
	                rs.getFloat("discount"),
	                rs.getInt("quantity"),
	                rs.getInt("status"),
	                rs.getInt("mode"),
	                rs.getTimestamp("startAt"),
	                rs.getString("content"),
	                rs.getString("namematerialmapper")//thêm biến tên chất liệu - dùng mapping để custom tên biến
	                );
	    }
	}
}
