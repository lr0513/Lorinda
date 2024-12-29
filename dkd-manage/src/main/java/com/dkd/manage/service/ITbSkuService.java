package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.TbSku;

/**
 * 商品Service接口
 * 
 * @author ruoyi
 * @date 2024-12-11
 */
public interface ITbSkuService 
{
    /**
     * 查询商品
     * 
     * @param skuId 商品主键
     * @return 商品
     */
    public TbSku selectTbSkuBySkuId(Long skuId);

    /**
     * 查询商品列表
     * 
     * @param tbSku 商品
     * @return 商品集合
     */
    public List<TbSku> selectTbSkuList(TbSku tbSku);

    /**
     * 新增商品
     * 
     * @param tbSku 商品
     * @return 结果
     */
    public int insertTbSku(TbSku tbSku);

    /**
     * 修改商品
     * 
     * @param tbSku 商品
     * @return 结果
     */
    public int updateTbSku(TbSku tbSku);

    /**
     * 批量删除商品
     * 
     * @param skuIds 需要删除的商品主键集合
     * @return 结果
     */
    public int deleteTbSkuBySkuIds(Long[] skuIds);

    /**
     * 删除商品信息
     * 
     * @param skuId 商品主键
     * @return 结果
     */
    public int deleteTbSkuBySkuId(Long skuId);

    /**
     * 批量新增商品管理
     * @param skuList
     * @return
     */
    int insertTbSkus(List<TbSku> skuList);
}
