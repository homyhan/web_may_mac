package service;

import db.JDBIConnector;
import model.Address;

import java.util.List;
import java.util.stream.Collectors;

public class AddressService {
    public static List<Address> getData() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select * from address").mapToBean(Address.class)
                    .stream().collect(Collectors.toList());
        });
    }
    
    // lấy chi tiết 1 theo id user
    public static Address getAddressDefaultByIdUser(int iduser) {
    	System.out.println(iduser);
        String query = "select * from address where iduser = ? and isdefault = 1 order by idaddress";
        List<Address> datas = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
                    .bind(0, iduser).mapToBean(Address.class).stream().collect(Collectors.toList());
        });
        if (datas.size() > 0) {
            return datas.get(0);// lấy duy nhất 1 sản phẩm
        }
        return null;
    }
    public static List<Address> getListAddressByIdUser(int iduser) {
    	System.out.println(iduser);
        String query = "select * from address where iduser = ? order by idaddress";
        
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(query)
                    .bind(0, iduser)
                    .mapToBean(Address.class).stream().collect(Collectors.toList());
        });
    }

    // them địa chỉ mặc định
    public static int addAddressDefault(Address input) {
        input.setIsdefault(1);
        input.setStatus(1);
        return insertAddress(input);
    }


    // -- chọn thay đổi địa chỉ > nhấn nút lưu update k mặc định
    public static boolean updateAddres(Address input) {
        input.setIsdefault(0);
        input.setStatus(1);

        return updateAddress(input);
    }

    public static int insertAddress(Address input) {
        // query > insert
        String query = "INSERT INTO address(`iduser`,`name`,`phone`,`address`,`isdefault`,`status`,`content`) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        int result = JDBIConnector.get().withHandle(handle -> {
            int id = handle.createUpdate(query)
                    .bind(0, input.getIduser())
                    .bind(1, input.getName())
                    .bind(2, input.getPhone())
                    .bind(3, input.getAddress())
                    .bind(4, input.getIsdefault())
                    .bind(5, input.getStatus())
                    .bind(6, input.getContent())
                    .executeAndReturnGeneratedKeys()
                    .mapTo(Integer.class)
                    .findOnly();
            return id;
        });
        return result;
    }

    public static boolean updateAddress(Address input) {

        String queryupdateAddress = "UPDATE address SET `name` = ?, `phone` = ?,`address`=? WHERE idaddress=?";
        int result = JDBIConnector.get().withHandle(handle -> {
            int count = handle.createUpdate(queryupdateAddress)
                    .bind(0, input.getName())
                    .bind(1, input.getPhone())
                    .bind(2, input.getAddress())

                    .execute();
            return count;
        });

        if (result == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

       List<Address> data = getData();
       System.out.println(data);

        Address input = new Address(2, "maimai","0784362816","hcm",1,1,"giao gio hanh chinh");
        int idInsert = insertAddress(input);
        System.out.println(idInsert);
        
       List<Address> dataByIdUser = getListAddressByIdUser(2);
       System.out.println(dataByIdUser);
    }
}
