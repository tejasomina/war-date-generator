package sts.wardate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class WarDateGeneratorParams {
  static final LocalDate startDate = LocalDate.of(1900, 1, 1);
  static final LocalDate endDate = LocalDate.of(2100, 1, 1);
  static final int sum = 68;

  public static int daysRange(){
    return Math.toIntExact(startDate.until(endDate, ChronoUnit.DAYS));
  }

}
