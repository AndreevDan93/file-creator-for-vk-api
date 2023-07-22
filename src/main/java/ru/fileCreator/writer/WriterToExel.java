package ru.fileCreator.writer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.fileCreator.model.VkUserDto;
import ru.fileCreator.utils.Config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class WriterToExel {
    public static void write(List<VkUserDto> vkUserDtoList) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        Row headerRow = sheet.createRow(0);
        Field[] fields = VkUserDto.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Cell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(fields[i].getName());
        }

        for (int i = 0; i < vkUserDtoList.size(); i++) {
            Row row = sheet.createRow(i + 1);

            VkUserDto vkUserDto = vkUserDtoList.get(i);
            Cell nameCell = row.createCell(0);
            nameCell.setCellValue(vkUserDto.getId());

            Cell ageCell = row.createCell(1);
            ageCell.setCellValue(vkUserDto.getVkId());

            Cell streetCell = row.createCell(2);
            streetCell.setCellValue(vkUserDto.getFirstName());

            Cell cityCell = row.createCell(3);
            cityCell.setCellValue(vkUserDto.getLastName());

            Cell stateCell = row.createCell(4);
            stateCell.setCellValue(vkUserDto.getDate());

            Cell zipCell = row.createCell(5);
            zipCell.setCellValue(vkUserDto.getCity());

            Cell phoneCell = row.createCell(6);
            phoneCell.setCellValue(vkUserDto.getPhone());
        }


        try {
            FileOutputStream outputStream = new FileOutputStream(Config.get("write-path"));
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
