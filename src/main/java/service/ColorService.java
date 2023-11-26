package service;

import db.JDBIConnector;
import model.Color;
import response.ProductInf;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ColorService {
    private static ColorService instance;

    private ColorService(){}

    public static ColorService getInstance(){
        if(instance==null){
            instance=new ColorService();
        }
        return instance;
    }

    public List<Color> showListColorProduct(){
        String queryShowAll = "SELECT * FROM color";
        List<Color> colorList = JDBIConnector.get().withHandle(handle -> handle.createQuery(queryShowAll).mapToBean(Color.class).stream().collect(Collectors.toList()));
        return colorList;
    }
    //    get name category by codecolor (color) => breadcrumb(product-page)
    public String getNameByCode(String code){
        String queryGetNameByCode = "SELECT title FROM color WHERE codecolor=?";
        Optional<String> nameByCode = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryGetNameByCode).bind(0, code).mapTo(String.class).findFirst();
        });
        return nameByCode.get();
    }
    
    public String getNameCateById(int idColor) {
    	String queryGetNameByCode = "SELECT title FROM color  WHERE idcolor=?";
        Optional<String> nameByCode = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryGetNameByCode).bind(0, idColor).mapTo(String.class).findFirst();
        });
        return nameByCode.get();
	}
    
//    @COUNT
    //  --  count total product by code
    public int countProductByCode(String code){
        String queryCountPByCateID = "SELECT COUNT(*) FROM product p LEFT JOIN color c ON p.idcolor=c.idcolor WHERE c.codecolor=?";
        Optional<Integer> countPByCode = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountPByCateID).bind(0, code).mapTo(Integer.class).findFirst();
        });
        return countPByCode.get();
    }
    //    count total product hot
    public int countProductHotByCode(String code){
        String queryCountPHByCode = "SELECT COUNT(*) FROM product p LEFT JOIN color c ON p.idcolor=c.idcolor WHERE c.codecolor=? AND p.`mode`=1";
        Optional<Integer> countPHByCode= JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountPHByCode).bind(0, code).mapTo(Integer.class).findFirst();
        });
        return countPHByCode.get();
    }

    //    Filter by code

    //  -- get list product by code
    public List<ProductInf> getProductByCode(String codecolor, int indexPage){
        String queryPByCode = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE c.codecolor=? LIMIT ?,12";
        List<ProductInf> listPByCode = JDBIConnector.get().withHandle(handle -> handle.createQuery(queryPByCode).bind(0, codecolor).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listPByCode;
    }
    //    show list product order newest by codecate (category)
    public List<ProductInf> showListProductNewestByCode(String code, int indexPage){
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE c.codecolor=? ORDER BY p.startAt DESC LIMIT ?,12";
        List<ProductInf> listNewest = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listNewest;
    }
    //    show list product hot(featured) by codecate (category)
    public List<ProductInf> showListProductFeaturedByCode(String code, int indexPage){
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE c.codecolor=? AND p.`mode`=1 ORDER BY p.discount DESC LIMIT ?,12";
        List<ProductInf> listHot = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listHot;
    }
    //    Sort price asc/desc by codecate
    public List<ProductInf> sortByPriceASCByCode(String code, int indexPage){
        String qSortByPriceASC = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE c.codecolor=? ORDER BY p.price ASC LIMIT ?,12";
        List<ProductInf> listSortPriceASC = JDBIConnector.get().withHandle(handle -> handle.createQuery(qSortByPriceASC).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listSortPriceASC;
    }
    public List<ProductInf> sortByPriceDESCByCode(String code, int indexPage){
        String qSortByPriceASC = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE c.codecolor=? ORDER BY p.price DESC LIMIT ?,12";
        List<ProductInf> listSortPriceDESC = JDBIConnector.get().withHandle(handle -> handle.createQuery(qSortByPriceASC).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listSortPriceDESC;
    }

    public static void main(String[] args) {
        List list = ColorService.getInstance().showListColorProduct();
        int count = ColorService.getInstance().countProductByCode("black");
        List listP = ColorService.getInstance().getProductByCode("black", 1);
        String nameC = ColorService.getInstance().getNameByCode("black");
        System.out.println(list);
        System.out.println("Test1: " + count);
        System.out.println("Test2: " + listP);
        System.out.println("Test3: " + nameC);
    }

	
}
