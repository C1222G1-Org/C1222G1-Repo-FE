package case_m3.ozone.service.loginService;

import case_m3.ozone.model.AccountUser;

import java.util.List;

public interface ILoginService {
    List<AccountUser> getListAccountUser();
    AccountUser checkAccountUser(String username, String password);
    int checkUsernameRetrive(String name);
    void saveAccountRegister(String name, String password);
    int deleteUser(int id);
    List<AccountUser> getListAccountUserInAdmin();
}
