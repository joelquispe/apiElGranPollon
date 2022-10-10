package repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface User extends JpaRepository<entity.User,Integer> {
}
