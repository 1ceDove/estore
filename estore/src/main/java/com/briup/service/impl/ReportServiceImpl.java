package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Report;
import com.briup.dao.ReportDao;
import com.briup.service.IReportService;
import com.briup.util.MybatisSqlSessionFactory;

public class ReportServiceImpl implements IReportService {
	private ReportDao reportDao = null;
	private SqlSession sqlSession = null;
	{
		sqlSession = MybatisSqlSessionFactory.openSession();
		reportDao = sqlSession.getMapper(ReportDao.class);
	}

	@Override
	public void saveReport(Report report) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateReport(Report report) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delReport(Long reportId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Report> listReport() {
		return reportDao.listReport();
	}

	@Override
	public Report selectReportById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
