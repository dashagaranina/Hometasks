package service;

import model.CV;
import model.User;

public interface UserService {

    CV getCVByIdWithCategories(Long id);

    User getUserById(Long id);
    CV getCVById(Long id);

    Iterable<CV> getAllCVs();

    void saveCV(CV cv);

    Iterable<CV> getCVListByCategoryId(Long categoryID);
}
