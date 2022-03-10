package sts.wardate;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import org.junit.jupiter.api.Test;

class WarDateGeneratorTest {

  @Test
  void whenDate19140728_thenMatchSum68() {
    LocalDate date = LocalDate.of(1914, 7, 28);
    int sumToMatch = 68;

    WarDateGenerator warDateGenerator = new WarDateGenerator();
    Set<String> warDates = warDateGenerator.generateWarDates(date, date.plus(1, ChronoUnit.DAYS),
        sumToMatch);

    assertTrue(()-> warDates.size() == 1);
    assertTrue(() -> warDates.contains("1914-07-28"));

  }

  @Test
  void whenDate19390901_thenMatchSum68() {
    LocalDate date = LocalDate.of(1939, 9, 1);
    int sumToMatch = 68;

    WarDateGenerator warDateGenerator = new WarDateGenerator();
    Set<String> warDates = warDateGenerator.generateWarDates(date, date.plus(1, ChronoUnit.DAYS),
        sumToMatch);

    assertTrue(()-> warDates.size() == 1);
    assertTrue(() -> warDates.contains("1939-09-01"));

  }

  @Test
  void whenDate20220224_thenMatchSum68() {
    LocalDate date = LocalDate.of(2022, 2, 24);
    int sumToMatch = 68;

    WarDateGenerator warDateGenerator = new WarDateGenerator();
    Set<String> warDates = warDateGenerator.generateWarDates(date, date.plus(1, ChronoUnit.DAYS),
        sumToMatch);

    assertTrue(()-> warDates.size() == 1);
    assertTrue(() -> warDates.contains("2022-02-24"));

  }

  @Test
  void whenDate20220224_thenDoNotMatchSum67() {
    LocalDate date = LocalDate.of(2022, 2, 24);
    int sumToMatch = 67;

    WarDateGenerator warDateGenerator = new WarDateGenerator();
    Set<String> warDates = warDateGenerator.generateWarDates(date, date.plus(1, ChronoUnit.DAYS),
        sumToMatch);

    assertTrue(()-> warDates.size() == 0);

  }

}