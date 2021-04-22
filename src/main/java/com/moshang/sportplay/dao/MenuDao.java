package com.moshang.sportplay.dao;

import com.moshang.sportplay.bean.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Auther: Yu
 * @Date: 2021/4/2 20:44
 */
@Repository
public interface MenuDao {

    public List<MainMenu> getMenus();
}
