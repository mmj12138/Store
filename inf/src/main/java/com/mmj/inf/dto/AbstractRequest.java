package com.mmj.inf.dto;

import lombok.Data;

@Data
public abstract class AbstractRequest implements Request {

    private Pager pager;
}
