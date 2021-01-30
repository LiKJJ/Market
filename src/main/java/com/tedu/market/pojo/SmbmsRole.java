package com.tedu.market.pojo;

import java.util.List;

public class SmbmsRole {
    private int id;// '主键ID',
    private String roleCode;// '角色编码',
    private String roleName;// '角色名称',
    private int createdBy;//创建者',
    private String creationDate;// '创建时间',
    private int modifyBy;// '修改者',
    private String modifyDate;//修改时间',

    private List<SmbmsUser> users;//该角色下的全部用户

    @Override
    public String toString() {
        return "SmbmsRole{" +
                "id=" + id +
                ", roleCode='" + roleCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate='" + creationDate + '\'' +
                ", modifyBy=" + modifyBy +
                ", modifyDate='" + modifyDate + '\'' +
                ", users=" + users +
                '}';
    }

    public List<SmbmsUser> getUsers() {
        return users;
    }

    public void setUsers(List<SmbmsUser> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
