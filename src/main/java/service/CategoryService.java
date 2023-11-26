package service;


import db.JDBIConnector;
import model.Category;
import response.ProductInf;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryService {
    private static CategoryService instance;

    private CategoryService() {
    }

    public static CategoryService getInstance() {
        if (instance == null) {
            instance = new CategoryService();
        }
        return instance;
    }

//  @BASE
//    show list category => sidebar(product-page) and menu(header)
    public List<Category> showListCate() {
        String query = "SELECT * FROM category";
        List<Category> categoryList = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).mapToBean(Category.class).stream().collect(Collectors.toList()));
        return categoryList;
    }
//    get name category by codecate (category) => breadcrumb(product-page)
    public String getNameCateByCode(String code){
        String queryGetNameByCode = "SELECT title FROM category WHERE codecate=?";
        Optional<String> nameByCode = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryGetNameByCode).bind(0, code).mapTo(String.class).findFirst();
        });
        return nameByCode.get();
    }
    public String getNameCateById(int id){
        String queryGetNameByCode = "SELECT title FROM category  WHERE idcategory=?";
        Optional<String> nameByCode = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryGetNameByCode).bind(0, id).mapTo(String.class).findFirst();
        });
        return nameByCode.get();
    }
    public String getCodeById(int id){
        String queryGetCodeByID = "SELECT codecate FROM category WHERE idcategory=?";
        Optional<String> codebyid = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryGetCodeByID).bind(0, id).mapTo(String.class).findFirst();
        });
        return codebyid.get();
    }


    //  @COUNT
    //    count total product by code => codecate (category)
    public int countProductByCode(String codeCate){
        String queryCountPByCode = "SELECT COUNT(*) FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory WHERE cate.codecate=?";
        Optional<Integer> countPByCode= JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountPByCode).bind(0, codeCate).mapTo(Integer.class).findFirst();
        });
        return countPByCode.get();
    }
    //    count total product-discount by code => codecate (category)
    public int countProductDiscountByCode(String code){
        String queryCountPDByCode = "SELECT COUNT(*) FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory WHERE cate.codecate=? AND p.discount>0";
        Optional<Integer> countPDByCode= JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountPDByCode).bind(0, code).mapTo(Integer.class).findFirst();
        });
        return countPDByCode.get();
    }
    //    count total product hot
    public int countProductHotByCode(String code){
        String queryCountPHByCode = "SELECT COUNT(*) FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory WHERE cate.codecate=? AND p.`mode`=1";
        Optional<Integer> countPHByCode= JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountPHByCode).bind(0, code).mapTo(Integer.class).findFirst();
        });
        return countPHByCode.get();
    }
    //    count total product discount hot
    public int countProductDiscountHotByCode(String code){
        String queryCountPHByCode = "SELECT COUNT(*) FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory WHERE cate.codecate=? AND p.`mode`=1 AND p.discount>0";
        Optional<Integer> countPHByCode= JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountPHByCode).bind(0, code).mapTo(Integer.class).findFirst();
        });
        return countPHByCode.get();
    }

    //  @FILTER + @PAGINATION
    //   Get list product by code => codecate (category)
    public List<ProductInf> getProductByCode(String code, int indexPage){
        String queryPByCode = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE cate.codecate=? LIMIT ?,12";
        List<ProductInf> listPByCode = JDBIConnector.get().withHandle(handle -> handle.createQuery(queryPByCode).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listPByCode;
    }

    public List<ProductInf> getProductByCodePageSize(String code, int indexPage, int pageSize){
        String queryPByCode = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE cate.codecate=? LIMIT ?,?";
        List<ProductInf> listPByCode = JDBIConnector.get().withHandle(handle -> handle.createQuery(queryPByCode).bind(0, code).bind(1, (indexPage-1)*pageSize).bind(2, pageSize).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listPByCode;
    }

    //    show list product order newest by codecate (category)
    public List<ProductInf> showListProductNewestByCode(String code, int indexPage){
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE cate.codecate=? ORDER BY p.startAt DESC LIMIT ?,12";
        List<ProductInf> listNewest = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listNewest;
    }
    //    show list product hot(featured) by codecate (category)
    public List<ProductInf> showListProductFeaturedByCode(String code, int indexPage){
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE cate.codecate=? AND p.`mode`=1 ORDER BY p.discount DESC LIMIT ?,12";
        List<ProductInf> listHot = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listHot;
    }
    //    Sort price asc/desc by codecate
    public List<ProductInf> sortByPriceASCByCode(String code, int indexPage){
    String qSortByPriceASC = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE cate.codecate=? ORDER BY p.price ASC LIMIT ?,12";
    List<ProductInf> listSortPriceASC = JDBIConnector.get().withHandle(handle -> handle.createQuery(qSortByPriceASC).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
    return listSortPriceASC;
}
    public List<ProductInf> sortByPriceDESCByCode(String code, int indexPage){
        String qSortByPriceASC = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE cate.codecate=? ORDER BY p.price DESC LIMIT ?,12";
        List<ProductInf> listSortPriceDESC = JDBIConnector.get().withHandle(handle -> handle.createQuery(qSortByPriceASC).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listSortPriceDESC;
    }

//    @DISCOUNT
    //   Get list product-discount by code => codecate (category)
    public List<ProductInf> getListProductDiscountByCode(String code, int indexPage){
        String queryPDByCode = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE cate.codecate=? AND p.discount>0 LIMIT ?,12";
        List<ProductInf> listPDByCode = JDBIConnector.get().withHandle(handle -> handle.createQuery(queryPDByCode).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listPDByCode;
    }
//    show list product discount order newest by codecate (category)
    public List<ProductInf> showListProductDiscountNewestByCode(String code, int indexPage){
    String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE cate.codecate=? AND p.discount>0  ORDER BY p.startAt DESC LIMIT ?,12";
    List<ProductInf> listNewest = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
    return listNewest;
}
    //    show list product discount hot(featured) by codecate (category)
    public List<ProductInf> showListProductDiscountFeaturedByCode(String code, int indexPage){
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE cate.codecate=? AND p.`mode`=1 AND p.discount>0 ORDER BY p.discount DESC LIMIT ?,12";
        List<ProductInf> listHot = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listHot;
    }
    //    Sort list product discount price asc/desc by codecate
    public List<ProductInf> sortDiscountByPriceASCByCode(String code, int indexPage){
        String qSortByPriceASC = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE cate.codecate=? AND p.discount>0 ORDER BY p.price ASC LIMIT ?,12";
        List<ProductInf> listSortPriceASC = JDBIConnector.get().withHandle(handle -> handle.createQuery(qSortByPriceASC).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listSortPriceASC;
    }
    public List<ProductInf> sortDiscountByPriceDESCByCode(String code, int indexPage){
        String qSortByPriceASC = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE cate.codecate=? AND p.discount>0 ORDER BY p.price DESC LIMIT ?,12";
        List<ProductInf> listSortPriceDESC = JDBIConnector.get().withHandle(handle -> handle.createQuery(qSortByPriceASC).bind(0, code).bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listSortPriceDESC;
    }

//    @TEST
    public static void main(String[] args) {
        List categoryList = CategoryService.getInstance().showListCate();
        String getNameByCode = CategoryService.getInstance().getNameCateByCode("ao-dai");
        List sortDesc = CategoryService.getInstance().sortByPriceDESCByCode("ao-dai", 1);
        List sortASC = CategoryService.getInstance().sortByPriceASCByCode("ao-dai", 1);
//        System.out.println(categoryList);
//        System.out.println(getNameByCode);
//        System.out.println(sortDesc);
        System.out.println(sortASC);
    }
}
