package com.piedaholic.enumerations;

import static org.junit.Assert.assertEquals;

import java.util.EnumSet;
import org.junit.Test;

public class DaysOfWeekEnumTest {

  public DaysOfWeekEnumTest() {
  }

  @Test
  public void test_howItFeelsLike() {
    EnumSet.allOf(DaysOfWeekEnum.class).forEach(x -> {
      DaysOfWeekEnum.howItFeelsLike(x);
    });
  }

  @Test
  public void checkCount_DaysOfWeekEnum() {
    assertEquals(DaysOfWeekEnum.getDaysOfWeekAsList().stream().count(), 7);
    //List.of(DaysOfWeekEnum.values()).stream().collect(Collectors.toMap());
  }

}
