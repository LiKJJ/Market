package com.tedu.market.pojo;

import java.util.List;

public class SmbmsProvider {
    private int id;//主键ID',
    private String proCode;// '供应商编码',
    private String proName;// '供应商名称',
    private String proDesc;// '供应商详细描述',
    private String proContact;// '供应商联系人',
    private String proPhone;// '联系电话',
    private String proAddress;// '地址',
    private String proFax;//'传真',
    private int createdBy;//'创建者（userId）',
    private String creationDate;//'创建时间',
    private String modifyDate;// '更新时间',
    private int modifyBy;//'更新者（userId）',

    private List<SmbmsBill> bills ;//订单列表

    @Override
    public String toString() {
        return "SmbmsProvider{" +
                "id=" + id +
                ", proCode='" + proCode + '\'' +
                ", proName='" + proName + '\'' +
                ", proDesc='" + proDesc + '\'' +
                ", proContact='" + proContact + '\'' +
                ", proPhone='" + proPhone + '\'' +
                ", proAddress='" + proAddress + '\'' +
                ", proFax='" + proFax + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate='" + creationDate + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                ", modifyBy=" + modifyBy +
                ", bills=" + bills +
                '}';
    }

    public List<SmbmsBill> getBills() {
        return bills;
    }

    public void setBills(List<SmbmsBill> bills) {
        this.bills = bills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public String getProContact() {
        return proContact;
    }

    public void setProContact(String proContact) {
        this.proContact = proContact;
    }

    public String getProPhone() {
        return proPhone;
    }

    public void setProPhone(String proPhone) {
        this.proPhone = proPhone;
    }

    public String getProAddress() {
        return proAddress;
    }

    public void setProAddress(String proAddress) {
        this.proAddress = proAddress;
    }

    public String getProFax() {
        return proFax;
    }

    public void setProFax(String proFax) {
        this.proFax = proFax;
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

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(int modifyBy) {
        this.modifyBy = modifyBy;
    }
}
