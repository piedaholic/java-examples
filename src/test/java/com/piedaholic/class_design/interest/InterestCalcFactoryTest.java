/**
 * 
 */
package com.piedaholic.class_design.interest;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.piedaholic.oops.designs.CompoundInterest;
import com.piedaholic.oops.designs.InterestCalc;
import com.piedaholic.oops.designs.InterestCalcFactory;

/**
 * @author HPSINGH
 *
 */
public class InterestCalcFactoryTest {

	private InterestCalc ic;

	@Test
	public void testSimpleInterest() {
		ic = InterestCalcFactory.getInterest("SI");
		assertTrue(ic.calculateInterest(1000.0, 10.0, 2.0) == 200.0);
	}

	@Test
	public void testCompoundInterest() {
		ic = InterestCalcFactory.getInterest("CI");
		assertTrue(ic.calculateInterest(1000.0, 10.0, 2.0) == 210.0);
		if (ic instanceof CompoundInterest) {
			CompoundInterest ci = (CompoundInterest) ic;
			assertTrue(BigDecimal.valueOf(ci.calculateInterestUsingFormula(1000.0, 10.0, 2.5))
					.setScale(2, RoundingMode.HALF_UP).doubleValue() == 269.06);
		}
		

	}

}
