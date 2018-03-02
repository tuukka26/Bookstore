package fi.haagahelia.Bookstore;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.Bookstore.domain.User;
import fi.haagahelia.Bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void findByUsernameShouldReturnUser() {
		List<User> users = repository.findByRole("ADMIN");
		
		assertThat(users).hasSize(1);
		assertThat(users.get(0).getUsername()).isEqualTo("admin");
	}
	
	@Test
	public void createNewUser() {
		User user = new User("Test", "test", "test");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}

}
