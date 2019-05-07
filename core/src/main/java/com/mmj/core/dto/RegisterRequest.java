package com.mmj.core.dto;

import java.util.Optional;

import com.alibaba.druid.util.StringUtils;
import com.mmj.inf.dto.AbstractRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RegisterRequest extends AbstractRequest {

    private String nickName;

    private String email;

    private String password;

    @Override
    public Optional<String> validateParam() {
        if (StringUtils.isEmpty(nickName)) {
            return Optional.of("昵称");
        }
        if (StringUtils.isEmpty(email)) {
            return Optional.of("邮箱不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return Optional.of("密码不能为空");
        }
        return Optional.empty();
    }
}
