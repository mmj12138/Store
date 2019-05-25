package com.mmj.core.dto;

import com.mmj.inf.dto.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

/**
 * Created by Administrator on 2019/5/25.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeleteAdminRequest extends AbstractRequest{

    private Integer id;

    @Override
    public Optional<String> validateParam() {
        return Optional.empty();
    }
}
