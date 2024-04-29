/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

import model.User;

/**
 *
 * @author TechCare
 */
public class UserDto extends User{
    private int roleId;

    public UserDto() {
    }

    public UserDto(int roleId, int id, String username, String password) {
        super(id, username, password);
        this.roleId = roleId;
    }

    public UserDto(int roleId) {
        this.roleId = roleId;
    }

    public UserDto(int roleId, String username, String password) {
        super(username, password);
        this.roleId = roleId;
    }
    

    public UserDto( String username, String password,int roleId) {
        super(username, password);
        this.roleId = roleId;
    }
    

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

   
}
