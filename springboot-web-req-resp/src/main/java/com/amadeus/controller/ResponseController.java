package com.amadeus.controller;

import com.amadeus.pojo.Address;
import com.amadeus.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
    测试响应数据
    @RestController = @Controller +  @ResponseBody
 */
@RestController
public class ResponseController {

//    @RequestMapping("/hello")
//    public String hello() {
//        System.out.println("hello world");
//        return "hello world";
//    }
//
//    @RequestMapping("/getAddr")
//    public Address getAddr() {
//        Address addr = new Address();
//        addr.setProvince("广东");
//        addr.setCity("深圳");
//        return addr;
//    }
//
//    @RequestMapping("/listAddr")
//    public List<Address> listAddr() {
//        List<Address> list = new ArrayList<>();
//
//        Address addr = new Address();
//        addr.setProvince("广东");
//        addr.setCity("深圳");
//
//        Address addr2 = new Address();
//        addr.setProvince("陕西");
//        addr.setCity("西安");
//
//        list.add(addr);
//        list.add(addr2);
//        return list;
//    }

    @RequestMapping("/hello")
    public Result hello() {
        System.out.println("hello world");
        return Result.success("hello world");
    }

    @RequestMapping("/getAddr")
    public Result getAddr() {
        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");
        return Result.success(addr);
    }

    @RequestMapping("/listAddr")
    public Result listAddr() {
        List<Address> list = new ArrayList<>();

        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");

        Address addr2 = new Address();
        addr.setProvince("陕西");
        addr.setCity("西安");

        list.add(addr);
        list.add(addr2);
        return Result.success(list);
    }
}
