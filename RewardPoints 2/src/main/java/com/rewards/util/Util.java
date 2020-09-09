package com.rewards.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.rewards.model.Rewards;

public class Util {
	
	public static List<Rewards> getDataSet() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		// 1st Customer
		Rewards r1 = new Rewards();
		r1.setCustomerName("customer1");
		r1.setPurchaseAmount(60);
		r1.setCreatedDate(sdf.parse("13/07/2020"));
		
		Rewards r2 = new Rewards();
		r2.setCustomerName("customer1");
		r2.setPurchaseAmount(80);
		r2.setCreatedDate(sdf.parse("11/08/2020"));
		
		Rewards r3 = new Rewards();
		r3.setCustomerName("customer1");
		r3.setPurchaseAmount(120);
		r3.setCreatedDate(sdf.parse("08/09/2020"));
		
		Rewards r4 = new Rewards();
		r4.setCustomerName("customer1");
		r4.setPurchaseAmount(40);
		r4.setCreatedDate(sdf.parse("09/09/2020"));
		
		// 2nd Customer
		Rewards c1 = new Rewards();
		c1.setCustomerName("customer2");
		c1.setPurchaseAmount(150);
		c1.setCreatedDate(sdf.parse("12/07/2020"));
		
		Rewards c2 = new Rewards();
		c2.setCustomerName("customer2");
		c2.setPurchaseAmount(110);
		c2.setCreatedDate(sdf.parse("15/08/2020"));
		
		List<Rewards> list = new ArrayList<>();
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(c1);
		list.add(c2);
		
		return list;
	}

}
