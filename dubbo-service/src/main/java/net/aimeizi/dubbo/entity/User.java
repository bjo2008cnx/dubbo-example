package net.aimeizi.dubbo.entity;


import lombok.Data;

@Data
public class User extends BaseDto {

    private Long userId;

    private String userName;

    private String userEnName;

    private String country;

    private String company;

    private int age;


}
