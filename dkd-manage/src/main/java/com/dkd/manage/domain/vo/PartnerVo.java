package com.dkd.manage.domain.vo;

import com.dkd.manage.domain.Partner;
import lombok.Data;

/**
 * @author Author
 * @date 2024-12-02 15:23
 */

@Data
public class PartnerVo extends Partner {
	// 点位数量
	private Integer nodeCount;
}
