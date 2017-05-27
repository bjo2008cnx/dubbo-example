package net.aimeizi.dubbo.context;

import lombok.Data;

import java.util.Date;

/**
 * @descirption
 * @Author meng.wang
 * @Date 2017-04-25
 **/
@Data
public class SessionInfo {
    /** 商户Id */
    private Integer bId;
    /** 用户名 */
    private String userName;
    /** 用户Id */
    private Long userId;
    /** 状态 */
    private Integer status;
    /** 小程序帐号Id */
    private Long merchantId;
    /** 商户套餐过期时间*/
    private Date expireTime;
    /** 手机号 */
    private String phone;
    /** 是否需要重置密码 */
    private Boolean isNeedReset;
    /** 是否需要签署协议 */
    private Boolean isNeedSign;
    /** 是否超管 */
    private Boolean isSuperAdmin;
    /** 登录过期时间 */
    private Date loginExpireTime;

    private String openId;

    private String unionId;
}
