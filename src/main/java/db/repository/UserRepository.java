package db.repository;

import db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query(value = "INSERT INTO user (first_Name, last_name, email, password, subscription)\n" +
            "VALUES (?1,?2,?3,?4,?5);", nativeQuery = true)
    @Transactional
    void addNewUser(
            String firstName, String lastname, String email, String password, Boolean subscription);
}
