package com.tabcorp.bms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tabcorp.bms.model.BMSDetails;
import com.tabcorp.bms.service.BMSService;

@RestController
@RequestMapping("v1")
public class BMSController {

	@Autowired
	private BMSService bmsService;
	
	@GetMapping("/bets")
	public Iterable<BMSDetails> retrieveAllBets() {
		return bmsService.retrieveAllBets();
	}

	@PostMapping("/save")
	public BMSDetails saveBet(@RequestBody BMSDetails BMSDetails) {

		BMSDetails savedBet = bmsService.saveBets(BMSDetails);
		return savedBet;

	}

	@PostMapping("/saveall")
	public List<BMSDetails> saveBets(@RequestBody List<BMSDetails> BMSDetails) {

		List<BMSDetails> savedBets = (List<BMSDetails>) bmsService.saveBets(BMSDetails);
		return savedBets;

	}

	/*
	 * @GetMapping("/totalInvestments/{type}") public Map<String, Double>
	 * totalInvestmentsByType(@PathVariable String type) {
	 * 
	 * Map<String, Double> totInvestments =
	 * bmsService.TotalInvestmentsByBetType(type); return totInvestments;
	 * 
	 * }
	 */

	@GetMapping("/totalInvestmentsByBetTypes")
	public Map<String, String> totalInvestmentsByType() {

		Map<String, String> totalInvestments = bmsService.TotalInvestmentsByBetType();
		return totalInvestments;

	}

	/*
	 * @GetMapping("/totalInvestmentsCustomer/{customerId}") public Map<String,
	 * Double> totalInvestmentsByCustomer(@PathVariable Long customerId) {
	 * 
	 * Map<String, Double> totInvestments =
	 * bmsService.TotalInvestmentsByCustomerID(customerId); return
	 * totInvestments;
	 * 
	 * }
	 */

	@GetMapping("/totalInvestmentsByCustomers")
	public Map<String, String> totalInvestmentsByCustomer() {

		Map<String, String> totalInvestments = bmsService.TotalInvestmentsByCustomerID();
		return totalInvestments;

	}
	
	@GetMapping("/totalBetsPerHour")
	public String totalBetsByHour() {

		Long totalBets = bmsService.totalBetsPerHour();
		return "Total Bets per hour :  " + totalBets;

	}
	
	@GetMapping("/totalSoldBetsPerBetType")
	public  Map<String, String> totalSoldBetsPerBetType() {
		
		Map<String, String> totalSoldBets = bmsService.TotalSoldBetsPerBetType();
		return totalSoldBets;	

	}
	
	
	

	@GetMapping("/Test")
	public String retrieveTest() {
		return "Test";
	}

}
