package com.mmj.inf.enums;

import java.util.stream.Stream;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ContentEnums {

    /**
     * 注册时的文案
     */
    REGISTER("欢迎注册新时代！","<!DOCTYPE>"+
                     "<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; " + "font-size:28px; " +
                     "line-height:30px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span " +
                     "style='font-weight:bold;'>温馨提示：</span>"
                     + "<div style='width:950px;font-family:arial;'>欢迎注册新时代图书在线销售系统，您的注册码为：<br/><div " +
                     "font-size:60px; " + "line-height:66px; > "),
    /**
     * 忘记密码时的文案
     */
    UPDATE("新时代","<!DOCTYPE>"+
                   "<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; " + "font-size:28px; " +
                   "line-height:30px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span " +
                   "style='font-weight:bold;'>温馨提示：</span>"
                   + "<div style='width:950px;font-family:arial;'>您的验证码为：<br/><div " +
                   "font-size:60px; " + "line-height:66px; > ");

    @Getter
    private String subject;

    @Getter
    private String display;



}
