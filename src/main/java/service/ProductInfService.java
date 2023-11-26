package service;

import db.JDBIConnector;
import response.ProductInf;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductInfService {
    private static ProductInfService instance;

    private ProductInfService() {
    }

    public static ProductInfService getInstance() {
        if (instance == null) {
            instance = new ProductInfService();
        }
        return instance;
    }
    public List<ProductInf> showListProduct(){
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor ORDER BY p.idproduct";
        List<ProductInf> list = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return list;
    }

    public List<ProductInf> showListProductByID(int id){
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE p.idproduct=?";
        List<ProductInf> list = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).bind(0, id).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return list;
    }
    //    @Show List Product - @Paging
    public List<ProductInf> showListProduct(int indexPage){
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor ORDER BY p.discount DESC LIMIT ?,12";
        List<ProductInf> list = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).bind(0, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return list;
    }
    public List<ProductInf> showListProductByPageSize(int indexPage, int pageSize){
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor ORDER BY p.idproduct LIMIT ?,?";
        List<ProductInf> list = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).bind(0, (indexPage-1)*pageSize).bind(1, pageSize).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return list;
    }
    //    show top 8 products for Featured-Product page-home, condition: mode=1 (hot) and sort discount
    public List<ProductInf> showTop8FeaturedProducts() {
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE p.`mode`=1 AND p.discount>0 LIMIT 8";
        List<ProductInf> listTop8FeaturedProducts = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listTop8FeaturedProducts;
    }
    //    show list product order newest
    public List<ProductInf> showListProductNewest(int indexPage){
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor ORDER BY p.startAt DESC LIMIT ?,12";
        List<ProductInf> listNewest = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).bind(0, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listNewest;
    }
    //    show list product hot(featured) => condition mode=1
    public List<ProductInf> showListProductFeatured(int indexPage){
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE p.`mode`=1 ORDER BY p.discount DESC LIMIT ?,12";
        List<ProductInf> listHot = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).bind(0, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listHot;
    }
    //  show list product discount
    public List<ProductInf> showListProductDiscount(int indexPage){
        String queryPDiscount = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE p.discount>0 LIMIT ?,12";
        List<ProductInf> listPDiscount = JDBIConnector.get().withHandle(handle -> handle.createQuery(queryPDiscount).bind(0, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return  listPDiscount;
    }



    //  @Sort
    public List<ProductInf> sortByPriceASC(int indexPage){
        String qSortByPriceASC = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor ORDER BY p.price ASC LIMIT ?,12";
        List<ProductInf> listSortPriceASC = JDBIConnector.get().withHandle(handle -> handle.createQuery(qSortByPriceASC).bind(0, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listSortPriceASC;
    }
    public List<ProductInf> sortByPriceDESC(int indexPage){
        String qSortByPriceASC = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor ORDER BY p.price DESC LIMIT ?,12";
        List<ProductInf> listSortPriceDESC = JDBIConnector.get().withHandle(handle -> handle.createQuery(qSortByPriceASC).bind(0, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listSortPriceDESC;
    }

    //  @Search By Name Product
//    search-ajax: focus input search => result: submenu sticky input search
    public List<ProductInf> searchByName(String textSearch){
        String querySearchByName = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE p.title LIKE ?";
        List<ProductInf> listSearch = JDBIConnector.get().withHandle(handle -> handle.createQuery(querySearchByName).bind(0, "%" + textSearch + "%").mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listSearch;
    }

    //    search: click button-search => result: show product page.
    public List<ProductInf> searchByNamePaging(String textSearch, int indexPage){
        String querySearchByName = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE p.title LIKE ?  ORDER BY p.discount DESC LIMIT ?,12";
        List<ProductInf> listSearch = JDBIConnector.get().withHandle(handle -> handle.createQuery(querySearchByName).bind(0, "%" + textSearch + "%").bind(1, (indexPage-1)*12).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listSearch;
    }

    //  @Count
    //    count total products
    public int getTotalProduct(){
        String queryCountP = "SELECT COUNT(*) FROM product";
        Optional<Integer> countP = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountP).mapTo(Integer.class).findFirst();
        });
        return countP.get();
    }
    //    count total product, discount
    public int countTotalProductDiscount(){
        String queryCountPDiscount = "SELECT COUNT(*) FROM product WHERE discount>0";
        Optional<Integer> countPDiscount = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountPDiscount).mapTo(Integer.class).findFirst();
        });
        return countPDiscount.get();
    }
    //    count total product hot(featured)
    public int getTotalProductFeatured(){
        String queryCountP = "SELECT COUNT(*) FROM product WHERE `mode`=1";
        Optional<Integer> countP = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountP).mapTo(Integer.class).findFirst();
        });
        return countP.get();
    }
    //    count product for search
    public int countProductByKeyWord(String keyword){
        String queryCountPByKW = "SELECT COUNT(*) FROM product WHERE title LIKE ?";
        Optional<Integer> countPByKW = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(queryCountPByKW).bind(0, "%" + keyword + "%").mapTo(Integer.class).findFirst();
        });
        return countPByKW.get();
    }

    //    @Related Product
    public List<ProductInf> showTop9RelatedProducts(String code) {
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.startAt, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor WHERE cate.codecate=? AND p.discount>0 LIMIT 9";
        List<ProductInf> listTop9RelatedProducts = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        return listTop9RelatedProducts;
    }

    //mainguyen > thông tin chi tiết của 1 sản phẩm
    public ProductInf getDetailProductByidproduct(int idproduct){
        String query = "SELECT p.idproduct, p.idmaterial, cate.codecate, c.codecolor, p.sku, p.title, p.image, p.price, p.discount, p.quantity, p.status, p.mode, p.content FROM product p LEFT JOIN category cate ON p.idcategory=cate.idcategory LEFT JOIN color c ON p.idcolor=c.idcolor where p.idproduct = ? and status = 1";
        List<ProductInf> list = JDBIConnector.get().withHandle(handle -> handle.createQuery(query).bind(0, idproduct).mapToBean(ProductInf.class).stream().collect(Collectors.toList()));
        if (list.size()>0){
        	return list.get(0);
        }
        return null;
    }

    //  @Test
    public static void main(String[] args) {
        List showListP = ProductInfService.getInstance().showListProduct(1);
        List show8HotP = ProductInfService.getInstance().showTop8FeaturedProducts();
        List showPNew = ProductInfService.getInstance().showListProductNewest(1);
        List showPHot = ProductInfService.getInstance().showListProductFeatured(1);
        List showPD = ProductInfService.getInstance().showListProductDiscount(1);
        List listSearch = ProductInfService.getInstance().searchByName("áo");
        System.out.println(showListP);
        System.out.println(show8HotP);
        System.out.println(showPNew);
        System.out.println(showPHot);
        System.out.println(showPD);
        System.out.println(listSearch);
    }
}
