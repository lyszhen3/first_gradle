package com.lin.data.repository;

import com.lin.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lys on 2018/10/1.
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
public interface UserRepository extends JpaRepository<User,Long> {

	
}
