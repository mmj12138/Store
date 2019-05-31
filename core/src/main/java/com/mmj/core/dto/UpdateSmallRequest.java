package com.mmj.core.dto;

import com.mmj.inf.dto.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

/**
 * Created by Administrator on 2019/5/31.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateSmallRequest extends AbstractRequest {

    private Integer id;

    private Integer bigId;

    private String bigKindName;

    private String smallKindName;

    private String smallKindMsg;

    private String smallKindImg;

    @Override
    public Optional<String> validateParam() {
        return Optional.empty();
    }

}
