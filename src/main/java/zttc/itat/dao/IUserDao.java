package zttc.itat.dao;

import zttc.itat.model.Pager;
import zttc.itat.model.User;

import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: ChenRuiQing.
 * Create Time:  2018-12-09 下午 6:23
 */
public interface IUserDao {
    public void add(User user);
    public void update(User user);
    public void delete(int id);
    public User load(int id);
    public List<User> list();
    public Pager<User> find();
    public User loadByUsername(String username);
}
