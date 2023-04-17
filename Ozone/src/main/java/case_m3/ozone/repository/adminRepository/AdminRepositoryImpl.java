package case_m3.ozone.repository.adminRepository;

import case_m3.ozone.model.Comment;
import case_m3.ozone.repository.DBConnnection.DBConnection;
import case_m3.ozone.service.adminService.IAdminService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminRepositoryImpl implements IAdminRepository {
    private final static String DELETE_POST = "delete from post where id_post = ?";

    public int deletePostById(int id) {
        String query = "{call delete_post(?)}";
        try (Connection connection = DBConnection.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            int result = callableStatement.executeUpdate();
            DBConnection.close();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
