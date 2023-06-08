package com.briup.dao;

import java.util.List;

import com.briup.bean.Report;


public interface ReportDao {
	/**
	 * 添加公告
	 * */
	void saveReport(Report report);
	/**
	 * 修改公告
	 * */
	void updateReport(Report report);
	/**
	 * 删除公告
	 * */
	void delReport(Long reportId);
	/**
	 * 获取所有公告
	 * */
	List<Report> listReport();
	/**
	 * 查看公告
	 * */
	Report selectReportById(long id);
	
}