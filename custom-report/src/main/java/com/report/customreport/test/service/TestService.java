package com.report.customreport.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.customreport.test.dao.mysql.TestDao;
import com.report.customreport.test.vo.TestVO;


@Service
public class TestService {

	@Autowired
	private TestDao testDao;
	
	public List<TestVO> findTestVO(){
		return testDao.findTestVO();
	}
	
}
