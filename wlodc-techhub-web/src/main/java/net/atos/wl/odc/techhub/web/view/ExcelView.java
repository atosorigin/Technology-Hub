/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.web.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import net.atos.wl.odc.techhub.common.dto.UserDto;
import net.atos.wl.odc.techhub.web.util.ExportUtil;

/**
 * Excel export view.
 * 
 * @author a120065
 */
public class ExcelView extends AbstractXlsView {

    private static Logger log = LoggerFactory.getLogger(ExcelView.class);

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.view.document.AbstractXlsView#
     * buildExcelDocument(java.util.Map, org.apache.poi.ss.usermodel.Workbook,
     * javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    @SuppressWarnings("unchecked")
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        final String fileName = ExportUtil.exportFileName();
        log.info("Export File Name: " + fileName);
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xls");
        response.setContentType("application/vnd.ms-excel");

        final Map<String, List<UserDto>> attendance = (Map<String, List<UserDto>>) model.get("attendance");

        for (final String topicName : attendance.keySet()) {
            log.info("Topic Name: " + topicName);
            final Sheet sheet = workbook.createSheet(topicName);
            sheet.setDefaultColumnWidth(30);
            ExportUtil.writeHeader(workbook, sheet);
            for (final UserDto user : attendance.get(topicName)) {
                ExportUtil.writeRow(sheet, user);
            }
        }
    }
}
