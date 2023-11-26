package service;

import db.JDBIConnector;
import model.Material;
import response.ProductInf;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaterialService {
    private static MaterialService instance;
    private MaterialService() {
    }
    public static MaterialService getInstance() {
        if (instance == null) {
            instance = new MaterialService();
        }
        return instance;
    }

//  @BASE
//  show list Material => sidebar(product-page)
    public List<Material> showListMaterial() {
        String query = "SELECT * FROM material";
        List<Material> materialList = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).mapToBean(Material.class).stream().collect(Collectors.toList()));
        return materialList;
    }
//   get name by materialcode (material) => breadcrumb(product-page)
   public String getNameByCode(String code){
        String queryGetNameByCode = "SELECT title FROM material WHERE codematerial=?";
        Optional<String> nameByCode = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryGetNameByCode).bind(0, code).mapTo(String.class).findFirst();
        });
        return nameByCode.get();
    }

    public String getNameCateById(int idproduct) {
    	String queryGetNameByCode = "SELECT title FROM material WHERE idmaterial=?";
        Optional<String> nameByCode = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryGetNameByCode).bind(0, idproduct).mapTo(String.class).findFirst();
        });
        return nameByCode.get();
	}

//  @COUNT
    public int countProductByCode(String code){
        String queryCountPByCode = "SELECT COUNT(*) FROM product p LEFT JOIN material m ON p.idmaterial=m.idmaterial WHERE m.codematerial=?";
        Optional<Integer> countPByCode = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountPByCode).bind(0, code).mapTo(Integer.class).findFirst();
        });
        return countPByCode.get();
    }
    public int countProductDiscountByCode(String code){
        String queryCountPDByCode = "SELECT COUNT(*) FROM product p LEFT JOIN material m ON p.idmaterial=m.idmaterial WHERE m.codematerial=? AND p.discount>0 ";
        Optional<Integer> countPDByCode= JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountPDByCode).bind(0, code).mapTo(Integer.class).findFirst();
        });
        return countPDByCode.get();
    }
    //    count total product hot
    public int countProductHotByCode(String code){
        String queryCountPHByCode = "SELECT COUNT(*) FROM product p LEFT JOIN material m ON p.idmaterial=m.idmaterial WHERE m.codematerial=? AND p.`mode`=1";
        Optional<Integer> countPHByCode= JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountPHByCode).bind(0, code).mapTo(Integer.class).findFirst();
        });
        return countPHByCode.get();
    }

//  @FILTER + @PAGINATION
//    get list product by materialcode (material)
    public List<ProductInf> getProductByCode(String code, int indexPage){
        String queryPByCode = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor LEFT JOIN material m ON p.idmaterial=m.idmaterial WHERE m.codematerial=? LIMIT ?,12";
        List<ProductInf> listPByCode = JDBIConnector.get().withHandle(handle -> handle.createQuery(queryPByCode).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listPByCode;
    }
//    get list product-discount by materialcode (material)
    public List<ProductInf> getListProductDiscountByCode(String code, int indexPage){
    String queryPDByCode = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor LEFT JOIN material m ON p.idmaterial=m.idmaterial WHERE m.codematerial=? AND p.discount>0 LIMIT ?,12";
    List<ProductInf> listPDByCode = JDBIConnector.get().withHandle(handle -> handle.createQuery(queryPDByCode).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
    return listPDByCode;
}
    //    show list product order newest by codecate (category)
    public List<ProductInf> showListProductNewestByCode(String code, int indexPage){
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor LEFT JOIN material m ON p.idmaterial=m.idmaterial WHERE m.codematerial=? ORDER BY p.startAt DESC LIMIT ?,12";
        List<ProductInf> listNewest = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listNewest;
    }
    //    show list product hot(featured) by codecate (category)
    public List<ProductInf> showListProductFeaturedByCode(String code, int indexPage){
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor LEFT JOIN material m ON p.idmaterial=m.idmaterial WHERE m.codematerial=? AND p.`mode`=1 ORDER BY p.discount DESC LIMIT ?,12";
        List<ProductInf> listHot = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listHot;
    }
    //    Sort price asc/desc by codecate
    public List<ProductInf> sortByPriceASCByCode(String code, int indexPage){
        String qSortByPriceASC = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor LEFT JOIN material m ON p.idmaterial=m.idmaterial WHERE m.codematerial=? ORDER BY p.price ASC LIMIT ?,12";
        List<ProductInf> listSortPriceASC = JDBIConnector.get().withHandle(handle -> handle.createQuery(qSortByPriceASC).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listSortPriceASC;
    }
    public List<ProductInf> sortByPriceDESCByCode(String code, int indexPage){
        String qSortByPriceASC = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor LEFT JOIN material m ON p.idmaterial=m.idmaterial WHERE m.codematerial=? ORDER BY p.price DESC LIMIT ?,12";
        List<ProductInf> listSortPriceDESC = JDBIConnector.get().withHandle(handle -> handle.createQuery(qSortByPriceASC).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listSortPriceDESC;
    }

//    @TEST
    public static void main(String[] args) {
        List list = MaterialService.getInstance().showListMaterial();
        String nameM = MaterialService.instance.getNameByCode("cotton");
        int countPD = MaterialService.getInstance().countProductDiscountByCode("cotton");
        List listPD = MaterialService.instance.getListProductDiscountByCode("cotton", 1);
        System.out.println("Test1: " + list);
        System.out.println("Test2: " + nameM );
        System.out.println("Test3: " + countPD);
        System.out.println("Test4: \n" + listPD);
    }
	
}
