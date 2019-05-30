package com.mmj.core.dto;

import com.mmj.inf.dto.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

/**
 * Created by Administrator on 2019/5/29.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SaveBigRequest extends AbstractRequest {


    private String bigKindName;

    private String bigKindMsg;

    private String bigKindImg;

    @Override
    public Optional<String> validateParam() {
        return Optional.empty();
    }

}