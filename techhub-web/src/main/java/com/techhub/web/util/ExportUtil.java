/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.web.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.techhub.common.dto.UserDto;

/**
 * Utility class for exporting the data in excel format.
 * 
 * @author a120065
 */
public final class ExportUtil implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -7339754670224959818L;

    /**
     * Date format to be used to format date.
     */
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("ddMMYYYY_HHmmss");

    /**
     * Method to create file header.
     * 
     * @param workbook
     *            <code>org.apache.poi.xssf.usermodel.Workbook</code>.
     * @param sheet
     *            <code>org.apache.poi.xssf.usermodel.Sheet</code>.
     */
    public static void writeHeader(final Workbook workbook, final Sheet sheet) {

        final CellStyle cellStyle = createCellStyle(workbook);

        // Create a row to set file header columns.
        final Row row = sheet.createRow(0);

        // Add all column headers to the row.
        createCellAndSetValue(row, cellStyle, 0, "First Name");
        createCellAndSetValue(row, cellStyle, 1, "Last Name");
        createCellAndSetValue(row, cellStyle, 2, "DAS ID");
        createCellAndSetValue(row, cellStyle, 3, "Signature");
    }

    /**
     * Write user data to the sheet.
     * 
     * @param sheet
     *            <code>org.apache.poi.xssf.usermodel.Sheet</code>.
     * @param user
     *            <code>net.atos.wl.odc.techhub.common.dto.UserDto</code>
     */
    public static void writeRow(final Sheet sheet, final UserDto user) {
        // Get last row number within the sheet
        int rowNumber = (sheet.getLastRowNum() + 1);

        // Create the row.
        sheet.createRow(rowNumber);

        // Set the given value as string with given row and column
        // number.
        createCellAndSetValue(sheet.getRow(rowNumber), null, 0, user.getFirstName());
        createCellAndSetValue(sheet.getRow(rowNumber), null, 1, user.getLastName());
        createCellAndSetValue(sheet.getRow(rowNumber), null, 2, user.getUserId());
        createCellAndSetValue(sheet.getRow(rowNumber), null, 3, "");
    }

    /**
     * Method to create a cell for the given row and column number and then set
     * the given value for the same.
     * 
     * @param row
     *            <code>org.apache.poi.xssf.usermodel.Row</code>.
     * @param cellStyle
     *            <code>org.apache.poi.xssf.usermodel.CellStyle</code>
     * @param column
     *            int column number for the cell.
     * @param value
     *            String value to be set for the cell.
     */
    public static void createCellAndSetValue(final Row row, final CellStyle cellStyle, final int column,
                                             final String value) {
        if (row != null) {
            row.createCell(column, CellType.STRING).setCellValue(value);
            if (cellStyle != null) {
                row.getCell(column).setCellStyle(cellStyle);
            }
        }
    }

    /**
     * Method to construct the file to be used for exporting the data.
     * 
     * @return String.
     */
    public static String exportFileName() {
        final StringBuffer sb = new StringBuffer();
        sb.append("attendance_");
        sb.append(DATE_FORMAT.format(new Date()));
        return sb.toString();
    }

    /**
     * Create the style for table header cells.
     * 
     * @param workbook
     *            <code>org.apache.poi.xssf.usermodel.Workbook</code>.
     * @return <code>org.apache.poi.ss.usermodel.CellStyle</code>.
     */
    private static CellStyle createCellStyle(final Workbook workbook) {
        final CellStyle style = workbook.createCellStyle();
        final Font font = workbook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setFontName("Arial");
        font.setBold(true);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(font);

        return style;
    }
}
