package com.atguigu.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestActiviti2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/*.xml");
		ProcessEngine enngine = context.getBean(ProcessEngine.class);
		//创建相关需要的服务对象: 
		RepositoryService reService = enngine.getRepositoryService();
		RuntimeService ruService = enngine.getRuntimeService();
		HistoryService hiService = enngine.getHistoryService();
		TaskService taskService = enngine.getTaskService();
		
		
  //创建流程对象 (启动流程实例: 启动同时 要为变量赋值)
		
		//加载最新的流程定义
		Deployment deploy = reService.createDeployment().addClasspathResource("activitis/cpesmail.bpmn").deploy();
		ProcessDefinitionQuery processQuery = reService.createProcessDefinitionQuery();
		ProcessDefinition pD = processQuery.latestVersion().singleResult();
		//根据Id获取就报错
//		ProcessInstance pInstance = ruService.startProcessInstanceByKey(processDefinition.getId());
		//启动流程时 同时为变量传值, Map
		
		ProcessInstance pInstance = ruService.startProcessInstanceByKey(pD.getKey());
		
		
//		查询任务 || 完成任务
		
	}
	
}
