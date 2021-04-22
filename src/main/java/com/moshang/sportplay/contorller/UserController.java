package com.moshang.sportplay.contorller;

import com.alibaba.fastjson.JSON;
import com.moshang.sportplay.bean.QueryInfo;
import com.moshang.sportplay.bean.User;
import com.moshang.sportplay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Auther: Yu
 * @Date: 2021/4/3 16:39
 */
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo) {
        //获取最大列表数和当前编号
        int numbers =  userDao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum()-1) * queryInfo.getPageSize();

        List<User> users = userDao.getAllUser("%" + queryInfo.getQuery() + "%",pageStart,queryInfo.getPageSize());
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/userState")
    public String updateUserState(@RequestParam("id")Integer id,@RequestParam("state")Boolean state){
        int i = userDao.updateState(id, state);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        user.setRole("普通用户");
        user.setState(false);
        int i = userDao.addUser(user);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        int i = userDao.deleteUser(id);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/getUpdate")
    public String getUpdateUser(Integer id){
        User user = userDao.getUpdateUser(id);
        String string = JSON.toJSONString(user);
        return string;
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user){
        int i = userDao.editUser(user);
        return i > 0 ? "success":"error";
    }
}
