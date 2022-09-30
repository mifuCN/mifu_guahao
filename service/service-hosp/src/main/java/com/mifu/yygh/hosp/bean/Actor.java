package com.mifu.yygh.hosp.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor //pojo类对应的集合(首字母小写):
//@Document(value = "Actor")
//@Document 注解就是指定mongo的集合  类似MP的  让他对应起来
public class Actor {

//    @Id //当前属性和mongodb集合中的主键是对应的  普通字段是加@Field   比如@Field(value = "actor_name")
//    private String aaaid; //id 对应mongodb中集合的_id字段有一个对应关系:mongotemplate

    private String id;
    private String actorName;
    private Boolean gender;
    private Date birth;
    private Integer age;
}
