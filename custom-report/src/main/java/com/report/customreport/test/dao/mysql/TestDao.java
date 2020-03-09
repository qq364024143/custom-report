package com.report.customreport.test.dao.mysql;

import java.util.List;

import com.report.customreport.test.vo.TestVO;

public interface TestDao {
	
	List<TestVO> findTestVO();
}
