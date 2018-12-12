package zttc.itat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import zttc.itat.model.User;
import zttc.itat.service.IUserService;

import javax.servlet.http.HttpSession;

/**
 * @version 1.0
 * @Description:
 * @author: ChenRuiQing.
 * Create Time:  2018-12-11 下午 5:05
 */
@Controller
@SessionAttributes("loginUser")
public class IndexController {
    @Autowired
    IUserService   userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String username,String password,Model model){
        User user = userService.login(username,password);
        model.addAttribute("loginUser",user);
        return "redirect:/user/users";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(Model model,HttpSession session){ //登出并销毁session中的值：方式一
        model.asMap().remove("loginUser");
        session.invalidate();
        return "redirect:/login";
    }
}
