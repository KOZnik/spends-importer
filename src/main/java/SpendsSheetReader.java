import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpendsSheetReader {

    public List<Spend> read(int sheetNumber, Date sheetDate) throws IOException, InvalidFormatException {
        List<Spend> list = new ArrayList<>();
        Workbook wb = WorkbookFactory.create(new File("Wydatki.xlsx"));
        Sheet sheet = wb.getSheetAt(sheetNumber);
        for (int i = 1; i < 35; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < 14; j += 2) {
                Cell cell = row.getCell(j);
                if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                    list.add(new Spend(SpendCategory.fromIndex(j).name(), cell.getNumericCellValue(), row.getCell(j + 1).getRichStringCellValue().getString(), sheetDate));
                }
            }
        }
        return list;
    }

}
