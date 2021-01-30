package com.tedu.market.pojo;

import java.util.Date;

public class SmbmsUser {
    private int id;//主键ID',
    private String userCode;// '用户编码',
    private String userName;//'用户名称',
    private String userPassword;// '用户密码',
    private int gender;// '性别（1:女、 2:男）',
    private String birthday;//'出生日期',
    private String phone;//'手机',
    private String address;// '地址',
    private int userRole;//'用户角色（取自角色表-角色id）',
    private int createdBy;//'创建者（userId）',
    private String creationDate;// '创建时间',
    private int modifyBy;//'更新者（userId）',
    private String modifyDate;// '更新时间',

    public SmbmsUser() {

    }

    public SmbmsUser(int id, String userCode, String userName, String userPassword, int gender, String birthday, String phone, String address, int userRole, int createdBy, String creationDate, int modifyBy, String modifyDate, String roleName, SmbmsRole role) {
        this.id = id;
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.userRole = userRole;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.roleName = roleName;
        this.role = role;
    }

    private  String roleName;
    private SmbmsRole role;



    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public SmbmsRole getRole() {
        return role;
    }

    public void setRole(SmbmsRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SmbmsUser{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", gender=" + gender +
                ", birthday='" + birthday + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userRole=" + userRole +
                ", createdBy=" + createdBy +
                ", creationDate='" + creationDate + '\'' +
                ", modifyBy=" + modifyBy +
                ", modifyDate='" + modifyDate + '\'' +
                ", roleName='" + roleName + '\'' +
                ", role=" + role +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(int modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }
}
