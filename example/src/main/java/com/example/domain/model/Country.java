package com.example.domain.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author LRJ
 * @since 2021-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Country implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("Code")
    private String Code;

    @TableField("Name")
    private String Name;

    @TableField("Continent")
    private String Continent;

    @TableField("Region")
    private String Region;

    @TableField("SurfaceArea")
    private Float SurfaceArea;

    @TableField("IndepYear")
    private Integer IndepYear;

    @TableField("Population")
    private Integer Population;

    @TableField("LifeExpectancy")
    private Float LifeExpectancy;

    @TableField("GNP")
    private Float gnp;

    @TableField("GNPOld")
    private Float GNPOld;

    @TableField("LocalName")
    private String LocalName;

    @TableField("GovernmentForm")
    private String GovernmentForm;

    @TableField("HeadOfState")
    private String HeadOfState;

    @TableField("Capital")
    private Integer Capital;

    @TableField("Code2")
    private String Code2;


}
