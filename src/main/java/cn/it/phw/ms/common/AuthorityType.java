package cn.it.phw.ms.common;

public enum AuthorityType {

    /**
     * 登录和权限都验证
     */
    Validate,

    /**
     * 登录和权限都不验证
     */
    NoValidate,

    /**
     * 只验证登录
     */
    NoAuthority

}
