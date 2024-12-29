package com.dkd.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.dkd.common.utils.SecurityUtils;
import com.dkd.manage.domain.vo.PartnerVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dkd.common.annotation.Log;
import com.dkd.common.core.controller.BaseController;
import com.dkd.common.core.domain.AjaxResult;
import com.dkd.common.enums.BusinessType;
import com.dkd.manage.domain.Partner;
import com.dkd.manage.service.IPartnerService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 合作管理Controller
 *
 * @author lr
 * @date 2024-12-01
 */
@RestController
@RequestMapping("/manage/partner")
public class PartnerController extends BaseController {
	@Autowired
	private IPartnerService partnerService;

	/**
	 * 查询合作管理列表
	 */
	@PreAuthorize("@ss.hasPermi('manage:partner:list')")
	@GetMapping("/list")
	public TableDataInfo list(Partner partner) {
		startPage();
		List<PartnerVo> voList = partnerService.selectPartnerVoList(partner);
		return getDataTable(voList);
	}

	/**
	 * 导出合作管理列表
	 */
	@PreAuthorize("@ss.hasPermi('manage:partner:export')")
	@Log(title = "合作管理", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	public void export(HttpServletResponse response, Partner partner) {
		List<Partner> list = partnerService.selectPartnerList(partner);
		ExcelUtil<Partner> util = new ExcelUtil<Partner>(Partner.class);
		util.exportExcel(response, list, "合作管理数据");
	}

	/**
	 * 新增合作管理
	 */
	@PreAuthorize("@ss.hasPermi('manage:partner:add')")
	@Log(title = "合作管理", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@RequestBody Partner partner) {
		return toAjax(partnerService.insertPartner(partner));
	}

	/**
	 * 获取合作管理详细信息
	 */
	@PreAuthorize("@ss.hasPermi('manage:partner:query')")
	@GetMapping(value = "/{id}")
	public AjaxResult getInfo(@PathVariable("id") Long id) {
		return success(partnerService.selectPartnerById(id));
	}

	/**
	 * 修改合作管理
	 */
	@PreAuthorize("@ss.hasPermi('manage:partner:edit')")
	@Log(title = "合作管理", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@RequestBody Partner partner) {
		return toAjax(partnerService.updatePartner(partner));
	}

	/**
	 * 删除合作管理
	 */
	@PreAuthorize("@ss.hasPermi('manage:partner:remove')")
	@Log(title = "合作管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable Long[] ids) {
		return toAjax(partnerService.deletePartnerByIds(ids));
	}

	/**
	 * 重置合作商密码
	 */
	@PreAuthorize("@ss.hasPermi('manage:partner:edit')")
	@Log(title = "重置合作商密码", businessType = BusinessType.UPDATE)
	@PutMapping("/resetPwd/{id}")
	public AjaxResult resetpwd(@PathVariable Long id) { // 1. 接收参数    
		// 2. 创建合作商对象    
		Partner partner = new Partner();
		partner.setId(id);// 设置id    
		partner.setPassword(SecurityUtils.encryptPassword("123456"));// 设置加密后的初始密码    
		// 3. 调用service更新密码   
		return toAjax(partnerService.updatePartner(partner));
	}
}
