package case_m3.ozone.service.adminService;

import case_m3.ozone.model.Comment;
import case_m3.ozone.repository.adminRepository.AdminRepositoryImpl;

import java.util.List;

public class AdminServiceImpl implements IAdminService{
    private AdminRepositoryImpl adminRepository = new AdminRepositoryImpl();
    @Override
    public int deletePostById(int id) {
        return adminRepository.deletePostById(id);
    }

}
