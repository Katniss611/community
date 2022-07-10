package com.tangerine.community.controller;

import com.tangerine.community.entity.DiscussPost;
import com.tangerine.community.entity.Page;
import com.tangerine.community.entity.User;
import com.tangerine.community.service.DiscussPostService;
import com.tangerine.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller // controller路径可以为空
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffSet(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }

        // 在getIndexPage()方法调用前，Spring MVC会自动实例化Model和Page并且将Page注入Model中
        // 因此在thymeleaf中可以直接访问Page对象中的数据
        model.addAttribute("discussPosts", discussPosts);
        //  model.addAttribute("page", page);
        return "/index";
    }

}
