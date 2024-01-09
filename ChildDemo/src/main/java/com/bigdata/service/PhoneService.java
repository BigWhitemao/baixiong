package com.bigdata.service;

import com.bigdata.pojo.Phone;
import java.util.List;

/**
 * @author maomao
 * @date 2024/1/8 18:41
 * @description PhoneService
 */

public interface PhoneService {
    List<Phone> queryAll(); // 查看所有联系人
    Phone queryByPhone(String number); // 根据手机号查询联系人
    boolean add(Phone phone); // 添加联系人
    boolean update(Phone phone,String number); // 修改联系人
    boolean delete(String number); // 删除联系人
}
