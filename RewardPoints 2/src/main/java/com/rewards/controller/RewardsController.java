package com.rewards.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.dto.CustomerRewardsDTO;
import com.rewards.service.RewardsService;
import com.rewards.util.Util;

@RestController
public class RewardsController {
	@Autowired
	private RewardsService rewardsService;
	
	@GetMapping("/createData")
	public String createData() throws ParseException{
		rewardsService.insertData(Util.getDataSet());
		return "Sample Data is inserted";
	}
	@GetMapping("/getRewardPoints")
	public CustomerRewardsDTO getRewardPoints(@RequestParam("customerName") String customerName) throws ParseException{
		return rewardsService.getRewardPoints(customerName);
	}
}
