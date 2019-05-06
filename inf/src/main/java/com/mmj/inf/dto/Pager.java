package com.mmj.inf.dto;

import org.springframework.beans.BeanUtils;

import lombok.Data;

@Data
public class Pager {

    public static final int DEFAULT_PAGE_NUM = 1;
    public static final int DEFAULT_PAGE_SIZE = 20;

    private int pageSize;
    private int pageNum;
    private int count;

    public static Pager defaultPager() {
        Pager pager = new Pager();
        pager.pageNum = DEFAULT_PAGE_NUM;
        pager.pageSize = DEFAULT_PAGE_SIZE;
        return pager;
    }

    public Pager newResultPager(int count){
        Pager pager = new Pager();
        BeanUtils.copyProperties(this, pager);
        pager.setCount(count);
        return pager;
    }

}
