package net.aimeizi.dubbo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto implements Serializable {

    private Long id;
    private Long merchantId;
    private Long bid;
    private Date createTime;
    private Date updateTime;
}
