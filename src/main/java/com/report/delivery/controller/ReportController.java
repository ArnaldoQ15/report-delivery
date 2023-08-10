package com.report.delivery.controller;

import com.report.delivery.config.exception.BadRequestException;
import com.report.delivery.service.IReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static net.sf.jasperreports.engine.JasperCompileManager.compileReportToFile;

@RestController
@RequestMapping("/reports")
@Tag(name = "Reports")
@RequiredArgsConstructor
public class ReportController {

    private final IReportService reportService;

    @PostMapping("/compile")
    @Operation(description = "Compile .jrxml file to generate .jasper on the same path")
    public void compile(final String pathFile) throws JRException {
        final String pathWithoutExtension = pathFile.substring(0, pathFile.lastIndexOf("."));
        compileReportToFile(pathWithoutExtension + ".jrxml", pathWithoutExtension + ".jasper");
    }

    @GetMapping("/new")
    @Operation(description = "Generates a report based on random information")
    public ResponseEntity<Resource> generateRandomReport() throws BadRequestException {
        return reportService.generateRandomReport().toResponseEntity();
    }

}