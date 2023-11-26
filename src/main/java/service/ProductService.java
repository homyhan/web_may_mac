package service;

import db.JDBIConnector;
import mapper.RegisterRowMapper.ProductResponseMapper;
import model.Product;
import model.User;
import response.ProductResponse;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {

    // lấy danh sách
    public static List<Product> getData() {
        // SELECT * FROM product where status = 1;
        String query = "select * from product where status = 1";
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query).mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    // lấy chi tiết 1 theo id cuar san pham
    public static Product getDetailProductByidproduct(int idproduct) {
        String query = "SELECT * FROM product where status = 1 and idproduct = ?";
        List<Product> datas = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
                    .bind(0, idproduct).mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        if (datas.size() > 0) {
            if (datas.size() != 1)
                return null;
            return datas.get(0);// lấy duy nhất 1 sản phẩm
        }
        return null;
    }

    // lấy danh sách sản phẩm theo danh mục
    public static List<Product> getProductByCategoryId(int idcategory) {

        String query = "select * from product p where status = 1 and p.idcategory = ?";
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
                    .bind(0, idcategory)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    // giá tăng dần
    public static List<Product> getProductASC() {

        String query = "select * from product p where status = 1 order by price";
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    // giảm dần

    public static List<Product> getProductDESC() {

        String query = "select * from product p where status = 1 order by price desc";
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    // thêm sản phẩm mới vào
    public static boolean inserProduct(Product input) {
        input.setStatus(1);
        return insert(input);
    }

    public static boolean insert(Product input) {
        // query > insert
        String query = "INSERT INTO product (`idcategory`,`idmaterial`,`idcolor`,`sku`,`title`,`image`,`price`,`discount`,`quantity`,`status`,`mode`,`startAt`,`content`) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int result = JDBIConnector.get().withHandle(handle -> {
            int count = handle.createUpdate(query)
                    .bind(0, input.getIdcategory())
                    .bind(1, input.getIdmaterial())
                    .bind(2, input.getIdcolor())
                    .bind(3, input.getSku())
                    .bind(4, input.getTitle())
                    .bind(5, input.getImage())
                    .bind(6, input.getPrice())
                    .bind(7, input.getDiscount())
                    .bind(8, input.getQuantity())
                    .bind(9, input.getStatus())
                    .bind(10, input.getMode())
                    .bind(11, input.getStartAt())
                    .bind(12, input.getContent())
                    .execute();
            return count;
        });
        if (result == 1) {
            return true;
        }
        return false;
    }

    // xoa 1 san phẩm
    public static boolean getDeleteOne(int idproduct) {
        String query = "delete from product where idproduct = ?";
        int result = JDBIConnector.get().withHandle(handle -> {
            int count = handle.createUpdate(query)
                    .bind(0, idproduct)
                    .execute();
            return count;
        });
        if (result == 1) {
            return true;
        }
        return false;
    }

    // lấy ra số lượng hàng của 1 sản phẩm
    public static int quantityProduct(int idproduct) {

        String query = "SELECT quantity FROM product where idproduct = ?";
        Optional<Integer> result = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
                    .bind(0, idproduct)
                    .mapTo(Integer.class)
                    .findFirst();
        });
        return result.get();
    }

    public static String getNameById(int id){
        String queryGetNameByCode = "SELECT title FROM product WHERE idproduct=?";
        Optional<String> nameByCode = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryGetNameByCode).bind(0, id).mapTo(String.class).findFirst();
        });
        return nameByCode.get();
    }

    public static boolean updatePByIdProduct(int id, Product p) {
    	System.out.println(id);
        // query > insert
        String query = "update product set idcategory=?, idmaterial=?, idcolor=?, sku=?, title=?, image=?, price=?, discount=?, mode=?, status=?, startAt=? where idproduct = ?";
        int result = JDBIConnector.get().withHandle(handle -> {
            int count = handle.createUpdate(query).bind(0, p.getIdcategory()).bind(1, p.getIdmaterial())
                    .bind(2, p.getIdcolor()).bind(3, p.getSku()).bind(4, p.getTitle()).bind(5, p.getImage()).bind(6, p.getPrice()).bind(7, p.getDiscount()).bind(8, p.getMode()).bind(9, p.getStatus()).bind(10, p.getStartAt()).bind(11, id).execute();
            return count;
        });
        System.out.println("update product");
        System.out.println(result);
        if (result == 1) {
            return true;
        }
        return false;
    }

    public static Timestamp getCurrentTimeStamp(){
        String query = "SELECT CURRENT_TIMESTAMP()";
        Optional<Timestamp> result = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
                    .mapTo(Timestamp.class)
                    .findFirst();
        });
        return result.get();
    }

    public static int getIdCateByIdP(int id){
        String queryCountPByCode = "SELECT idcategory FROM product WHERE idproduct=?";
        Optional<Integer> countPByCode= JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountPByCode).bind(0, id).mapTo(Integer.class).findFirst();
        });
        return countPByCode.get();
    }
    public static int getIdMByIdP(int id){
        String queryCountPByCode = "SELECT idmaterial FROM product WHERE idproduct=?";
        Optional<Integer> countPByCode= JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountPByCode).bind(0, id).mapTo(Integer.class).findFirst();
        });
        return countPByCode.get();
    }
    public static int getIdColorByIdP(int id){
        String queryCountPByCode = "SELECT idcolor FROM product WHERE idproduct=?";
        Optional<Integer> countPByCode= JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountPByCode).bind(0, id).mapTo(Integer.class).findFirst();
        });
        return countPByCode.get();
    }
    public static void main(String[] args) {
        System.out.println("Current-Time" + ProductService.getCurrentTimeStamp());

        // https://mkyong.com/java/how-to-get-current-timestamps-in-java/

        // 2021-03-24 16:48:05.591
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);

        // 2021-03-24 16:48:05.591
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        System.out.println(timestamp2);

        // convert Instant to Timestamp
        Timestamp ts = Timestamp.from(Instant.now());
        System.out.println(ts);

        // List<Product> data = getData();
        // System.out.println(data);
        // Product item = getDetailProductByidproduct(3);
        // System.out.println(item);
        // System.out.println(quantityProduct(2));

        Product input = new Product(12, 11, 6, 3,"AD01", "Ao dai 2", "/images/products/da-hoi/DH%20(1).jpg", 1000000, 50000,
                50, 1, 1, timestamp, "");
        boolean isInsert = inserProduct(input);
        System.out.println(isInsert);

        List<ProductResponse> lists = JDBIConnector.get()
                .withHandle(h -> h.createQuery(
                        "select p.*, m.title as namematerialmapper from product p join material m on p.idmaterial = m.idmaterial where p.status = 1;")
                        .map(new ProductResponseMapper()).list());
                        // .mapToBean(ProductResponse.class).stream().collect(Collectors.toList());
        System.out.println(lists);
    }
}
