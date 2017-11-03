package com.jarvis.weixin.dao.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by sloan on 2017/5/27.
 */
@Data
@Table(name = "account")
@ApiModel(value = "账号信息")
public class Account {
    @Id
    @ApiModelProperty(value = "ID")
    private Long    id;
    @ApiModelProperty(value = "姓名")
    private String  name;
}
