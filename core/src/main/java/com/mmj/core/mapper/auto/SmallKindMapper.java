package com.mmj.core.mapper.auto;

import com.mmj.core.model.auto.SmallKind;
import com.mmj.core.model.auto.SmallKindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmallKindMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table small_kind
     *
     * @mbg.generated Fri May 31 18:49:53 CST 2019
     */
    long countByExample(SmallKindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table small_kind
     *
     * @mbg.generated Fri May 31 18:49:53 CST 2019
     */
    int deleteByExample(SmallKindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table small_kind
     *
     * @mbg.generated Fri May 31 18:49:53 CST 2019
     */
    int insert(SmallKind record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table small_kind
     *
     * @mbg.generated Fri May 31 18:49:53 CST 2019
     */
    int insertSelective(SmallKind record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table small_kind
     *
     * @mbg.generated Fri May 31 18:49:53 CST 2019
     */
    List<SmallKind> selectByExample(SmallKindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table small_kind
     *
     * @mbg.generated Fri May 31 18:49:53 CST 2019
     */
    int updateByExampleSelective(@Param("record") SmallKind record, @Param("example") SmallKindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table small_kind
     *
     * @mbg.generated Fri May 31 18:49:53 CST 2019
     */
    int updateByExample(@Param("record") SmallKind record, @Param("example") SmallKindExample example);
}