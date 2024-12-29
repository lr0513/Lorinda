package com.dkd.manage.domain.dto;

import lombok.Data;

/**
 * @author LR
 * @date 2024-12-19 11:40
 */


// 某个货道对应的sku信息
@Data
public class ChannelSkuDto {
	private String innerCode; // 设备编号
	private String channelCode; // 货道编号
	private Long skuId; // 商品id
}
