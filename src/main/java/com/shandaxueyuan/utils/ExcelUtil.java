package com.shandaxueyuan.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.shandaxueyuan.constant.DeploymentConstant;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
    private static String[] versionHeader = {"版本号", "产品名称", "产品型号", "日期", "核定"};
    private static String[] modifyHeader = {"版本号", "修订人", "修订日期", "修订描述"};
    private static String[] productHeader = {"类别", "料号", "名称", "型号", "单价", "数量", "供应商", "原厂", "负责人", "备注"};

    public static void generateBomExcel(String[] versionBeans, String[][] modifyBeans, String[][] productBeans,String prodName)
            throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Map<String, CellStyle> styles = createStyles(workbook);
        XSSFSheet sheet = workbook.createSheet("BOM");
        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);

        // 设置各行格式
        XSSFRow titleRow = sheet.createRow(0);
        titleRow.setHeightInPoints(45);
        XSSFCell titleCell = titleRow.createCell(0);
        titleCell.setCellValue(prodName+"BOM表");
        titleCell.setCellStyle(styles.get("title"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$J$1"));

        XSSFRow modifyTitle = sheet.createRow(2);
        XSSFCell modifyTile = modifyTitle.createCell(0);
        modifyTile.setCellValue("修订记录");
        modifyTile.setCellStyle(styles.get("modifytitle"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$3:$J$3"));

        XSSFRow versionRow = sheet.createRow(1);
        XSSFCell versionCell;
        // version header
        for (int i = 0; i < versionHeader.length; i++) {
            versionCell = versionRow.createCell(2 * i);
            versionCell.setCellValue(versionHeader[i]);
            versionCell.setCellStyle(styles.get("header"));
            sheet.autoSizeColumn((short) 2 * i, true);
        }
        // version cells
        for (int i = 0; i < versionBeans.length; i++) {
            versionCell = versionRow.createCell(2 * i + 1);
            versionCell.setCellValue(versionBeans[i]);
            versionCell.setCellStyle(styles.get("cell"));
            sheet.autoSizeColumn((short) 2 * i + 1, true);
        }
        // modify header
        XSSFRow modifyRow = sheet.createRow(3);
        XSSFCell modifyCell;
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$4:$B$4"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$C$4:$D$4"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$E$4:$F$4"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$G$4:$J$4"));
        for (int i = 0; i < modifyHeader.length; i++) {
            modifyCell = modifyRow.createCell(2 * i);
            modifyCell.setCellValue(modifyHeader[i]);
            modifyCell.setCellStyle(styles.get("header"));
            sheet.autoSizeColumn((short) 2 * i, true);
            modifyCell = modifyRow.createCell(2 * i + 1);
            modifyCell.setCellValue("");
            modifyCell.setCellStyle(styles.get("header"));
            sheet.autoSizeColumn((short) 2 * i + 1, true);
            modifyCell = modifyRow.createCell(2 * modifyHeader.length);
            modifyCell.setCellValue("");
            modifyCell.setCellStyle(styles.get("header"));
            sheet.autoSizeColumn((short) 2 * modifyHeader.length);
            modifyCell = modifyRow.createCell(2 * modifyHeader.length + 1);
            modifyCell.setCellValue("");
            modifyCell.setCellStyle(styles.get("header"));
            sheet.autoSizeColumn((short) 2 * modifyHeader.length + 1);


        }
        // modifymsg cells
        for (int i = 5; i < modifyBeans.length + 5; i++) {
            XSSFRow modifyEntity = sheet.createRow(i - 1);
            XSSFCell modifyEntityCell;
            sheet.addMergedRegion(CellRangeAddress.valueOf("$A$" + i + ":$B$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$C$" + i + ":$D$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$E$" + i + ":$F$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$G$" + i + ":$J$" + i));
            for (int j = 0; j < modifyBeans[i - 5].length; j++) {
                modifyEntityCell = modifyEntity.createCell(2 * j);
                modifyEntityCell.setCellValue(modifyBeans[i - 5][j]);
                modifyEntityCell.setCellStyle(styles.get("cell"));
                sheet.autoSizeColumn((short) 2 * j, true);
                modifyEntityCell = modifyEntity.createCell(2 * j + 1);
                modifyEntityCell.setCellValue("");
                modifyEntityCell.setCellStyle(styles.get("cell"));
                sheet.autoSizeColumn((short) 2 * j + 1, true);
                modifyEntityCell = modifyEntity.createCell(2 * modifyBeans[i - 5].length);
                modifyEntityCell.setCellValue("");
                modifyEntityCell.setCellStyle(styles.get("cell"));
                sheet.autoSizeColumn((short) 2 * modifyBeans[i - 5].length);
                modifyEntityCell = modifyEntity.createCell(2 * modifyBeans[i - 5].length + 1);
                modifyEntityCell.setCellValue("");
                modifyEntityCell.setCellStyle(styles.get("cell"));
                sheet.autoSizeColumn((short) 2 * modifyBeans[i - 5].length + 1);

            }
        }
        // product header
        XSSFRow productTitle = sheet.createRow(modifyBeans.length + 7);
        XSSFCell productTitleCell;
        for (int i = 0; i < productHeader.length; i++) {
            productTitleCell = productTitle.createCell(i);
            productTitleCell.setCellValue(productHeader[i]);
            productTitleCell.setCellStyle(styles.get("header"));
            sheet.autoSizeColumn((short) i, true);
        }

        // product cells
        for (int i = modifyBeans.length + 8; i < modifyBeans.length + 8 + productBeans.length; i++) {
            XSSFRow productEntity = sheet.createRow(i);
            XSSFCell productEntityCell;
            for (int j = 0; j < productBeans[i - modifyBeans.length - 8].length; j++) {
                productEntityCell = productEntity.createCell(j);
                productEntityCell.setCellValue(productBeans[i - modifyBeans.length - 8][j]);
                productEntityCell.setCellStyle(styles.get("cell"));
                sheet.autoSizeColumn((short) j, true);
            }
        }

        String file =prodName+"BOM表.xlsx";
        String filepath= DeploymentConstant.BOM_EXCEL_LOCATION+file;
        FileOutputStream out = new FileOutputStream(filepath);
        workbook.write(out);
        out.close();
    }

    private static Map<String, CellStyle> createStyles(XSSFWorkbook workbook) {
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        XSSFCellStyle style;
        XSSFFont titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 18);
        titleFont.setBold(true);
        titleFont.setFontName("微软雅黑");
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        styles.put("title", style);

        XSSFFont modifytitleFont = workbook.createFont();
        modifytitleFont.setFontHeightInPoints((short) 14);
        modifytitleFont.setBold(false);
        modifytitleFont.setFontName("微软雅黑");
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(modifytitleFont);
        styles.put("modifytitle", style);

        XSSFFont headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 11);
        headerFont.setFontName("微软雅黑");
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setFont(headerFont);
        style.setWrapText(true);
        styles.put("header", style);

        XSSFFont cellFont = workbook.createFont();
        cellFont.setBold(false);
        cellFont.setFontName("微软雅黑");
        style = workbook.createCellStyle();
        style.setFont(cellFont);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setWrapText(true);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        styles.put("cell", style);

        return styles;
    }
/*    public static String[][] readExcel(File excelFile) throws InvalidFormatException, IOException {
        @SuppressWarnings("resource")
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rownum = sheet.getLastRowNum();
        String[][] Bombeans;
        Bombeans = new String[rownum + 1][BOM_COLUMN_NUM];
        for (int i = 0; i < rownum + 1; i++) {
            for (int j = 0; j < BOM_COLUMN_NUM; j++) {
                String cell = sheet.getRow(i).getCell(j).toString();
                Bombeans[i][j] = new String(cell);
            }
        }
        return Bombeans;

    }*/

}
