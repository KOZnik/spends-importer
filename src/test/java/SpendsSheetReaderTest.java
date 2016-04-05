import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

public class SpendsSheetReaderTest {

    @Test
    public void readTest() throws IOException, InvalidFormatException {
        Date sheetDate = Date.from(LocalDate.of(2016, Month.APRIL, 5).atStartOfDay().toInstant(ZoneOffset.UTC));
        List<Spend> spends = new SpendsSheetReader().read(1, sheetDate);

        spends.forEach(System.out::println);
    }

}