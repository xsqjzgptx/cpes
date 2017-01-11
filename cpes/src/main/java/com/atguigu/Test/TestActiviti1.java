package com.atguigu.Test;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestActiviti1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/*.xml");
		ProcessEngine bean = context.getBean(ProcessEngine.class);
		System.out.println(bean);
		RepositoryService repositoryService = bean.getRepositoryService();
		repositoryService.createDeployment().addClasspathResource("activitis/MyProces111.bpmn").deploy();
		
		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
		List<ProcessDefinition> list = query.list();
		for (ProcessDefinition processDefinition : list) {
			int version = processDefinition.getVersion();
			System.out.println(version);
		}
	}
	
}
