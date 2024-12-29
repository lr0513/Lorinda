package com.dkd.manage.domain.vo;

import com.dkd.manage.domain.Task;
import com.dkd.manage.domain.TaskType;
import lombok.Data;

/**
 * @author LR
 * @date 2024-12-21 14:38
 */

@Data
public class TaskVo extends Task {
	// 工单类型
	private TaskType taskType;
}
