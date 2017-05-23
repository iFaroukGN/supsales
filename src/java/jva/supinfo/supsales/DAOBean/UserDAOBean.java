/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jva.supinfo.supsales.DAOBean;

import jva.supinfo.supsales.entities.Users;

/**
 *
 * @author Fairuz
 */
public class UserDAOBean extends BaseEntity<Users, Long> {
    
    public UserDAOBean(){
        super(Users.class);
    }
}
