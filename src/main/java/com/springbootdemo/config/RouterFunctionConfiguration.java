package com.springbootdemo.config;

import com.springbootdemo.domain.User;
import com.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * 描述:路由器函数配置
 *
 * @author 002864
 * @created 2018/5/24 16:13
 * @since v1.0.0
 */
@Configuration
public class RouterFunctionConfiguration {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Reactive 中的Flux 或者Mono 是异步处理（非阻塞式）
	 * 集合对象基本上是同步处理（阻塞式）
	 */
	@Bean
	public RouterFunction<ServerResponse> personFindAll() {
		return RouterFunctions.route(RequestPredicates.GET("/person/findAll"),
				serverRequest -> {
					Collection<User> users = userRepository.findAll();
					Flux<User> userFlux = Flux.fromIterable(users);
					return ServerResponse.ok().body(userFlux, User.class);
				});

	}

}
