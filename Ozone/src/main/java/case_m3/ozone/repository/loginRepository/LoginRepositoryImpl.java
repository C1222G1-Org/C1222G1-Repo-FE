package case_m3.ozone.repository.loginRepository;

import case_m3.ozone.model.AccountUser;
import case_m3.ozone.repository.DBConnnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginRepositoryImpl implements ILoginRepository {
    private static final String SELECT_ALL_ACCOUNT = "select * from account;";
    private static final String SAVE_ACCOUNT_REGISTER = "insert into account(username, password, email, isUser, isAdmin) \n" +
            "values (?,?,?,1,0);";
    private static final String DELETE_ACCOUNT_USER = "delete from account where id_account = ?";
    private static final String SELECT_ALL_ACCOUNT_USER = "select * from account where isAdmin = 0;";


    @Override
    public List<AccountUser> getListAccountUser() {
        List<AccountUser> accountUserList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_account");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email =  resultSet.getString("email");
                boolean isUser = resultSet.getBoolean("isUser");
                boolean isAdmin = resultSet.getBoolean("isAdmin");
                accountUserList.add(new AccountUser(id, username, password, email, isUser, isAdmin));
            }
            DBConnection.close();
            return accountUserList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AccountUser checkAccountUser(String username, String password) {
        List<AccountUser> accountUserList = getListAccountUser();
        for (AccountUser account : accountUserList) {
            if (username.equals(account.getUsername()) && password.equals(account.getPassword())) {
                return account;
            }
        }
        return null;
    }

    @Override
    public int checkUsernameRetrive(String name) {
        List<AccountUser> accountUserList = getListAccountUser();
        for (AccountUser accountUser : accountUserList) {
            if (name.equals(null)){
                return 3;
            }
            if (name.equals(accountUser.getUsername())) {
                return 0;
            }
        }
        return 1;
    }

    @Override
    public int checkEmailRetrive(String email) {
        List<AccountUser> accountUserList = getListAccountUser();
        for (AccountUser accountUser : accountUserList) {
            if (email.equals(null)){
                return 3;
            }
            if (email.equals(accountUser.getEmail())) {
                return 0;
            }
        }
        return 1;
    }

    @Override
    public void saveAccountRegister(String name, String password, String email) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_ACCOUNT_REGISTER)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
            DBConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteUser(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT_USER)) {
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            DBConnection.close();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<AccountUser> getListAccountUserInAdmin() {
        List<AccountUser> accountUserList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNT_USER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_acc");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                boolean isUser = resultSet.getBoolean("isUser");
                boolean isAdmin = resultSet.getBoolean("isAdmin");
                accountUserList.add(new AccountUser(id, username, password, email, isUser, isAdmin));
            }
            DBConnection.close();
            return accountUserList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}