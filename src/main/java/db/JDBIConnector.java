package db;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import com.mysql.cj.jdbc.MysqlDataSource;

import mapper.InvoiceMapper;
import model.Product;
import model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class JDBIConnector {

    private static Jdbi jdbi;

    private static void makeConnect() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://" + DBProperties.getDbHost() + ":" + DBProperties.getDbPort() + "/" + DBProperties.getDbName());
        dataSource.setUser(DBProperties.getUsername());
        dataSource.setPassword(DBProperties.getPassword());

        try {
            dataSource.setUseCompression(true);
            dataSource.setAutoReconnect(true);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
        jdbi = Jdbi.create(dataSource);
        jdbi.installPlugin(new SqlObjectPlugin());
    }

    private JDBIConnector() {
    }

    public static Jdbi get() {
        if (jdbi == null) makeConnect();
        
        jdbi.registerRowMapper(ConstructorMapper.factory(User.class));
        //https://jdbi.org/#_rowmappers_registry
        //https://jdbi.org/#_map_entry_mapping
        jdbi.registerRowMapper(new InvoiceMapper());
        
        return jdbi;
    }
    
    public static void main(String[] args) {
        Jdbi me = JDBIConnector.get();
        List<Product> products = me.withHandle(handle -> {
            return handle.createQuery("select * from product").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        System.out.println(products.toString());
    }
}
