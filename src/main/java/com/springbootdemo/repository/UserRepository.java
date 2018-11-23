package com.springbootdemo.repository;

import com.springbootdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 *
 * @author 002864
 * @created 2018/5/24 14:48
 * @since v1.0.0
 * {@link User} {@link Repository}
 */
@Repository
public class UserRepository {

	/**
	 * 内存型存储
	 */
	private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();

	private final static AtomicInteger idGenerator = new AtomicInteger();

	/**
	 * 描述:保存一条数据，成功返回<code>true</code>,失败返回<code>false</code>
	 *
	 * @param user
	 * @return boolean
	 * @author 002864
	 * @created 2018/5/24 14:53
	 * @since v1.0.0
	 */
	public boolean save(User user) {
		Integer id = idGenerator.incrementAndGet();
		user.setId(id);
		return repository.put(id, user) == null;
	}

	public Collection<User> findAll() {
		return repository.values();
	}

}
