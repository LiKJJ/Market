package com.tedu.market.services;

import com.tedu.market.pojo.SmbmsBill;

import java.util.List;

public interface BillServices {
    List<SmbmsBill> getAllBillBySize(int no, int size);

    List<SmbmsBill> getBillByBill(SmbmsBill smbmsBill);
}
