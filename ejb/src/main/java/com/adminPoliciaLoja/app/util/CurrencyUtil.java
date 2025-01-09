package com.adminPoliciaLoja.app.util;

import java.math.BigDecimal;

public class CurrencyUtil {
	public static BigDecimal redondearMoney(BigDecimal  money) {
		money= money.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		return money;
	}
	
	public static BigDecimal formatearMoney(BigDecimal  money){
		return money;
	}

}
