/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jva.supinfo.supsales.Beans;

import java.util.ArrayList;
import java.util.List;
import jva.supinfo.supsales.DAOBean.ProductDAOBean;
import jva.supinfo.supsales.DAOBean.UserDAOBean;
import jva.supinfo.supsales.entities.Product;
import jva.supinfo.supsales.entities.Users;

/**
 *
 * @author Fairuz
 */
public class UserBean {

    private Users _User;
    private List<Users> _UserList;
    private UserDAOBean _UserDaoBean;

    public UserBean() {
        this._User = new Users();
    }

    public Users getUser() {
        return _User;
    }

    public List<Users> getUsersList() {
        _UserList = new ArrayList<Users>();
        _UserDaoBean = new UserDAOBean();
        _UserList = _UserDaoBean.getAll();
        return _UserList;
    }

    public void setUser(Users _User) {
        this._User = _User;
    }

    public List<Users> getUserBy(String id) {
        _UserList = new ArrayList<Users>();
        _UserDaoBean = new UserDAOBean();
        return _UserList = _UserDaoBean.getById(Long.parseLong(id));
    }

    public UserDAOBean getUserDaoBean() {
        return _UserDaoBean;
    }

    public void setUserDaoBean(UserDAOBean _UserDaoBean) {
        this._UserDaoBean = _UserDaoBean;
    }

}
