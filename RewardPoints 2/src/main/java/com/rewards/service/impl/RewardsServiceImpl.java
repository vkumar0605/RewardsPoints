package com.rewards.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewards.dto.CustomerRewardsDTO;
import com.rewards.dto.RewardsDTO;
import com.rewards.model.Rewards;
import com.rewards.repository.RewardsRepository;
import com.rewards.service.RewardsService;

@Service
public class RewardsServiceImpl implements RewardsService{
	
	@Autowired
	private RewardsRepository repositoy;

	@Override
	public CustomerRewardsDTO getRewardPoints(String customerName) {
		List<Rewards> rewards = repositoy.findByCustomerName(customerName);
		Map<Object, Long> months = rewards.stream()
				.collect(Collectors.groupingBy(
						element -> element.getCreatedDate().getMonth(), 
						Collectors.summingLong(element->element.getPoints())));

		List<RewardsDTO> rewardsDTO = new ArrayList<RewardsDTO>(); 
		Long total = 0l;
		for (Entry<Object, Long> entry : months.entrySet()) {
			RewardsDTO dto = new RewardsDTO();
			dto.setMonth(((Integer)entry.getKey()+1));
			Long monthTotal = entry.getValue();
			total += monthTotal;
			dto.setMonthPoints(monthTotal);
			
			rewardsDTO.add(dto);
		}
		
		CustomerRewardsDTO customerDetails = new CustomerRewardsDTO();
		customerDetails.setTotalPoints(total);
		customerDetails.setRewards(rewardsDTO);
		return customerDetails;
	}

	private Integer getPoints(Rewards r) {
		Integer amount = r.getPurchaseAmount();
		if(amount<=50){
			return 0;
		}else if(amount<=100){
			 return (amount-50)*1;
		}else{
			return 50+(amount%100)*2;
		}
	}

	@Override
	public void insertData(List<Rewards> list) {
		for(Rewards r :  list){
			Integer points = getPoints(r);
			r.setPoints(points);
			repositoy.save(r);
		}
	}

	

}
