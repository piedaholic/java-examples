/**
 * 
 */
package com.piedaholic.oops.designs;

/**
 * @author HPSINGH
 *
 */
public class InterestCalcFactory {
	private enum InterestCompMethods {
		SIMPLE_INTEREST("SI"),
		COMPOUND_INTEREST("CI");
		
		private String text;
		
		InterestCompMethods(final String text){
			this.text = text;
		};
		
		public String toString() {
			return this.text;
		}
	}
	public static InterestCalc getInterest(String compMethod) {
		InterestCalc ic = null;
		if (compMethod.equals(InterestCompMethods.SIMPLE_INTEREST.toString()))
			ic = new SimpleInterest();
		else if (compMethod.equals(InterestCompMethods.COMPOUND_INTEREST.toString()))
			ic = new CompoundInterest();
		return ic;
	}

}
