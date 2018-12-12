package zttc.itat.service;

import zttc.itat.model.Pager;
import zttc.itat.model.User;

import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: ChenRuiQing.
 * Create Time:  2018-12-09 下午 8:08
 */
public interface IUserService {
    public void add(User user);
    public void update(User user);
    public void delete(int id);
    public User load(int id);
    public List<User> list();
    public Pager<User> find();
    public User login(String username, String password);
}
