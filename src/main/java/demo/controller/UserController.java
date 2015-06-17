package demo.controller;

import demo.model.User;
import demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Quan Do on 6/17/2015.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value ="/get",method= RequestMethod.GET)
    public User getUser(@RequestParam("id")Integer id) {
        User user = userRepository.findOne(id);
        return user;
    }


    @RequestMapping(value ="/login",method= RequestMethod.POST)
    public User getUser(@RequestParam("name")String name,
                        @RequestParam("password")String password) {

        User user = new User();

        return user;
    }

    @RequestMapping(value="/update",method=RequestMethod.PUT)
    public User updateUser(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("info") String info,
                        @RequestParam("password") String password,
                        @RequestParam("age") Integer age,
                        Model model){
        User user = userRepository.findOne(id);
        user.setId(id);
        user.setName(name);
        user.setInfo(info);
        user.setPassword(password);
        user.setAge(age);

        return user;
    }

    @RequestMapping(value="/add",method=RequestMethod.POST)
    public User addUser(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("info") String info,
                        @RequestParam("password") String password,
                        @RequestParam("age") Integer age,
                        Model model){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setInfo(info);
        user.setPassword(password);
        user.setAge(age);
        userRepository.save(user);
        return user;
    }

    @RequestMapping(value="/del",method=RequestMethod.DELETE)
    public void delUser(@RequestParam("id") Integer id){
        User user = userRepository.findOne(id);
        userRepository.delete(user);
    }


}
