package com.springbootdemo.controller;

import com.springbootdemo.domain.User;
import com.springbootdemo.repository.UserBookRepository;
import com.springbootdemo.repository.UserRepository;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述:
 *
 * @author 002864
 * @created 2018/5/24 14:55
 * @since v1.0.0
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository     userRepository;

    @Autowired
    private UserBookRepository userBookRepository;

    @PostMapping("/person/save")
    public User save(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        if (userRepository.save(user)) {
            System.out.println("保存成功：" + user);
        }
        return user;
    }

    @PostMapping("/queryBook")
    public String queryBook(@RequestParam Integer userId) {
        List list = userBookRepository.queryBook(userId);
        System.out.println("-----list size:" + list.size());
        System.out.println("-----return:" + JSONArray.fromObject(list));
        return list.toString();
    }

}
