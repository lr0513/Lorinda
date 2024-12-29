package com.dkd.manage.domain.vo;

import com.dkd.manage.domain.Region;
import lombok.Data;

/**
 * @author Author
 * @date 2024-12-02 13:43
 */

@Data
public class RegionVo extends Region {
	// 点位数量
	private Integer nodeCount;
}
