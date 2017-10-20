package org.LTT.persistence.dao;

import org.LTT.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findByEnabled(boolean enabled);


    List<User> findByLastNameOrFirstName(String lastname,String firtname);


   // List<User> findByLastNameAndAndFirstNameOrUniversityId(String lastname,String firtname,long univer);

    List<User>findByLastNameOrFirstNameOrUniversityId(String lastname,String firtname,long univer);

    List<User>findByLastNameAndLastNameAndUniversityId(String lastname,String firtname,long univer);


    List<User> findByUniversity(long univer);

    List<User> findByCompanyCardsIsNull();

    @Override
    void delete(User user);

}
