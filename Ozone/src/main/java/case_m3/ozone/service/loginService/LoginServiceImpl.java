package case_m3.ozone.service.loginService;

import case_m3.ozone.model.AccountUser;
import case_m3.ozone.repository.loginRepository.LoginRepositoryImpl;

import java.util.List;

public class LoginServiceImpl implements ILoginService{
    private LoginRepositoryImpl loginRepository = new LoginRepositoryImpl();
    @Override
    public List<AccountUser> getListAccountUser() {
        return loginRepository.getListAccountUser();
    }

    @Override
    public AccountUser checkAccountUser(String username, String password) {
        return loginRepository.checkAccountUser(username, password);
    }

    @Override
    public int checkUsernameRetrive(String name) {
        return loginRepository.checkUsernameRetrive(name);
    }

    @Override
    public void saveAccountRegister(String name, String password) {
        loginRepository.saveAccountRegister(name, password);
    }
    @Override
    public int deleteUser(int id){ return loginRepository.deleteUser(id);
    }

    @Override
    public List<AccountUser> getListAccountUserInAdmin() {
        return loginRepository.getListAccountUserInAdmin();
    }
}

