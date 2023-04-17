package case_m3.ozone.repository.loginRepository;

import case_m3.ozone.model.AccountUser;

import java.util.List;

public interface ILoginRepository {
    List<AccountUser> getListAccountUser();
    AccountUser checkAccountUser(String username, String password);
    int checkUsernameRetrive(String name);

    int checkEmailRetrive(String email);

    void saveAccountRegister(String name, String password, String email);
    int deleteUser (int id);
    List<AccountUser> getListAccountUserInAdmin();
}

