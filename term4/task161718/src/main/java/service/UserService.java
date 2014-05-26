package service;

import model.CV;
import model.User;

public interface UserService {

    CV getCVById(Long id);

    CV getCVByIdWithCategories(Long id);

    User getUserById(Long id);

    Iterable<CV> getAllCVs();

    public Iterable<CV> getCVsByNamePart(String term);

    void saveCV(CV cv);

    Iterable<CV> getCVListByCategoryId(Long categoryID);
    void deleteCv(Long id);

    User loadUserByUsername(final String username);

}
