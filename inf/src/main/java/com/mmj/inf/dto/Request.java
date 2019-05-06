package com.mmj.inf.dto;

import java.util.Optional;

public interface Request {

    /**
     * 用于检查参数是否合法
     *
     * @return 请求的参数合法时返回<code>Optional.empty()</code>，否则返回具体的错误信息
     */
    Optional<String> validateParam();

}
