package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import response.InvoiceResponse;

public class InvoiceMapper implements RowMapper<InvoiceResponse> {

	@Override
	public InvoiceResponse map(ResultSet rs, StatementContext ctx) throws SQLException {
		// TODO mapping key db
		return null;
	}
}
