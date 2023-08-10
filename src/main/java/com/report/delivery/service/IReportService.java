package com.report.delivery.service;


import com.report.delivery.config.exception.BadRequestException;
import com.report.delivery.config.report.ReportData;

public interface IReportService {

    ReportData generateRandomReport() throws BadRequestException;

}