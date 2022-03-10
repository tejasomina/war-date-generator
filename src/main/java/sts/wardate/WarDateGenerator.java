package sts.wardate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListUtils;

public class WarDateGenerator {

  public void generateAndProcessWarDates() {
    Set<String> warDates =
        generateWarDates(WarDateGeneratorParams.startDate, WarDateGeneratorParams.endDate, WarDateGeneratorParams.sum);

    processWarDates(warDates);
  }

  public Set<String> generateWarDates(LocalDate startDateIncl, LocalDate endDateExcl, int sum){
    return startDateIncl.datesUntil(endDateExcl)
        .filter(date -> dateSumsToNumber(date, sum))
        .map(LocalDate::toString)
        .collect(Collectors.toUnmodifiableSet());
  }

  private void processWarDates(Set<String> warDates) {
    int daysRange = WarDateGeneratorParams.daysRange();
    int warDatesSize = warDates.size();

    BigDecimal percentage =
        BigDecimal.TEN.pow(2)
        .multiply(BigDecimal.valueOf(warDatesSize))
            .divide(BigDecimal.valueOf(daysRange), 2, RoundingMode.HALF_UP);

    String format = String.format("Days considered %s, Number of war dates %s, percentage %s",
        daysRange, warDatesSize, percentage);
    System.out.println(format);
  }

  private boolean dateSumsToNumber(LocalDate localDate, int sum){
    return dateSumsToNumber(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(), sum);
  }

  private boolean dateSumsToNumber(int year, int month, int day, int sum){
    Integer sumOfDigits = ListUtils.union(ListUtils.union(populateDigits(year), populateDigits(month)),
            populateDigits(day))
        .stream()
        .reduce(0, Integer::sum);

    return sumOfDigits == sum;
  }

  private List<Integer> populateDigits(int number) {
    // 28-7-1914 becomes 28, 7, 19, 14
    List<Integer> digits = new ArrayList<>();
    while (number > 0){
      digits.add(number%100);
      number /=100;
    }

    return digits;
  }

}
