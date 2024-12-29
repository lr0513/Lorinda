package com.dkd.manage.mapper;

import java.util.List;

import com.dkd.manage.domain.Channel;
import com.dkd.manage.domain.vo.ChannelVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 售货机货道Mapper接口
 *
 * @author lr
 * @date 2024-12-06
 */
public interface ChannelMapper {
	/**
	 * 查询售货机货道
	 *
	 * @param id 售货机货道主键
	 * @return 售货机货道
	 */
	public Channel selectChannelById(Long id);

	/**
	 * 查询售货机货道列表
	 *
	 * @param channel 售货机货道
	 * @return 售货机货道集合
	 */
	public List<Channel> selectChannelList(Channel channel);

	/**
	 * 新增售货机货道
	 *
	 * @param channel 售货机货道
	 * @return 结果
	 */
	public int insertChannel(Channel channel);

	/**
	 * 批量新增售货机货道
	 *
	 * @param channelList
	 * @return
	 */
	public int batchInsertChannel(List<Channel> channelList);

	/**
	 * 修改售货机货道
	 *
	 * @param channel 售货机货道
	 * @return 结果
	 */
	public int updateChannel(Channel channel);

	/**
	 * 删除售货机货道
	 *
	 * @param id 售货机货道主键
	 * @return 结果
	 */
	public int deleteChannelById(Long id);

	/**
	 * 批量删除售货机货道
	 *
	 * @param ids 需要删除的数据主键集合
	 * @return 结果
	 */
	public int deleteChannelByIds(Long[] ids);

	/**
	 * 根据商品id集合统计货道数量
	 *
	 * @param skuIds
	 * @return
	 */
	int countChannelBySkuIds(Long[] skuIds);

	/**
	 * 根据售货机编号查询货道列表
	 *
	 * @param innerCode
	 * @return
	 */
	List<ChannelVo> selectChannelVoListByInnerCode(String innerCode);

	/**
	 * 根据货道编号和售货机编号查询货道信息
	 * @param channelCode
	 * @param innerCode
	 * @return
	 */
	@Select("select  * from tb_channel where channel_code = #{channelCode} and inner_code = #{innerCode}")
	Channel getChannelInfo(@Param("channelCode")String channelCode, @Param("innerCode") String innerCode);

	 /**
	 * 批量修改货道
	 * @param channelList
	 * @return
	 */
	int batchUpdateChannel(@Param("channelList") List<Channel> channelList);
}
