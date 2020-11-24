package cl.ionix.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ionix.rest.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	public List<User> findByEmail(String email);
}
