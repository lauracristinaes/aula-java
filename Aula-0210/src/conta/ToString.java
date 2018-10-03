package conta;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ToString {

	public static void main(String[] args) {
		Integer i = Integer.parseInt("1");
		Double d = Double.parseDouble("2");
		
		BigDecimal bd1 = new BigDecimal("0");
		BigDecimal bd2 = new BigDecimal("0");
		bd1.add(bd2);
		bd1.subtract(bd2);
		bd1.divide(bd2, RoundingMode.HALF_EVEN).setScale(2, RoundingMode.HALF_EVEN);
		bd1.multiply(bd2);
		bd1.compareTo(bd2);
		
	}

}
