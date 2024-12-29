package com.dkd.manage.domain.vo;

import com.dkd.manage.domain.Channel;
import com.dkd.manage.domain.TbSku;
import lombok.Data;

/**
 * @author LR
 * @date 2024-12-18 21:25
 */


@Data
public class ChannelVo extends Channel {
	// 商品
	private TbSku sku;
}
