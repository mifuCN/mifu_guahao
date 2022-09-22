package com.mifu.yygh.vo.acl;

import lombok.Data;

/**
 * @author mifu
 */
@Data
public class AssignVo {

    private Long roleId;

    private Long[] permissionId;
}
