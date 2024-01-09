package com.bigdata;

import com.bigdata.pojo.Phone;
import com.bigdata.service.PhoneServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * @author maomao
 * @date 2024/1/8 17:29
 * @description Main
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneServiceImpl ps = new PhoneServiceImpl();
        System.out.println("欢迎来到我的电话本");
        while (true){
            System.out.println("请输入: 1、查询所有联系人 2、查询单个联系人 3、添加联系人 4、修改联系人 5、删除联系人（输入-1退出电话本）");
            String n =scanner.nextLine();
            switch (n){
                case "1":
                    List<Phone> list1 = ps.queryAll();
                    for (Phone phone : list1) {
                        System.out.println(phone);
                    }
                    break;
                case "2":
                    System.out.println("请输入联系人的电话号码:");
                    String number = scanner.nextLine();
                    Phone phone1 = ps.queryByPhone(number);
                    System.out.println(phone1);
                    break;
                case "3":
                    Phone phone2 = new Phone();
                    System.out.println("请输入要添加的电话号码:");
                    phone2.setNumber(scanner.nextLine());
                    System.out.println("请输入要添加的性别:");
                    phone2.setSex(scanner.nextLine());
                    System.out.println("请输入要添加的年龄:");
                    phone2.setAge(Integer.parseInt(scanner.nextLine()));
                    if(ps.add(phone2)){
                        System.out.println("添加成功！");
                    }else {
                        System.out.println("添加失败！");
                    }
                    break;
                case "4":
                    Phone phone3 = new Phone();
                    System.out.println("请输入要修改联系人的电话号码:");
                    String number1 = scanner.nextLine();
                    System.out.println("请输入修改后的电话号码:");
                    phone3.setNumber(scanner.nextLine());
                    System.out.println("请输入修改后的性别:");
                    phone3.setSex(scanner.nextLine());
                    System.out.println("请输入修改后的年龄:");
                    phone3.setAge(Integer.parseInt(scanner.nextLine()));
                    if(ps.update(phone3,number1)){
                        System.out.println("修改成功！");
                    }else {
                        System.out.println("修改失败！");
                    }
                    break;
                case "5":
                    System.out.println("请输入要删除联系人的电话号码:");
                    String number2 = scanner.nextLine();
                    if(ps.delete(number2)){
                        System.out.println("删除成功！");
                    }else {
                        System.out.println("删除失败！");
                    }
                    break;
                case "-1":
                    System.out.println("ByeBye！！！");
                    return;
                default:
                    System.out.println("功能暂未开放！！！");

            }
        }

    }
}
