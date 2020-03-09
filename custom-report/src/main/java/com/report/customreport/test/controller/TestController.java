package com.report.customreport.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.report.customreport.test.service.TestService;
import com.report.customreport.test.vo.TestVO;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("test")
	public List<TestVO> findTestVO(){
		return testService.findTestVO();
	}
}
