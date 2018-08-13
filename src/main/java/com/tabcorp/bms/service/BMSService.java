package com.tabcorp.bms.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.tabcorp.bms.model.BMSDetails;
import com.tabcorp.bms.repository.BMSRepository;

@Component
public class BMSService {

	private static final Logger LOGGER = Logger.getLogger(BMSService.class.getName());

	@Autowired
	private BMSRepository bmsRepository;

	private DecimalFormat formatter = new DecimalFormat("#0.00");

	public Iterable<BMSDetails> retrieveAllBets() {
		return bmsRepository.findAll();
	}

	public BMSDetails saveBets(@RequestBody BMSDetails BMSDetails) {

		BMSDetails savedStudent = bmsRepository.save(BMSDetails);
		return savedStudent;
	}

	public List<BMSDetails> saveBets(@RequestBody List<BMSDetails> BMSDetails) {

		List<BMSDetails> savedBets = (List<BMSDetails>) bmsRepository.saveAll(BMSDetails);
		return savedBets;

	}

	public Map<String, String> TotalInvestmentsByBetType() {

		Map<String, String> totInvestments = new HashMap<String, String>();

		List<String> betTypes = bmsRepository.findDistinctBetType();
		LOGGER.info("" + betTypes);

		for (String betType : betTypes) {

			List<BMSDetails> savedBets = (List<BMSDetails>) bmsRepository.findByBetType(betType);

			double total = savedBets.stream().collect(Collectors.summingDouble(BMSDetails::getInvestment));
			LOGGER.info("" + total);

			totInvestments.put("Bet Type " + betType, formatter.format(total));

		}

		return totInvestments;
	}

	public Map<String, String> TotalInvestmentsByCustomerID() {

		Map<String, String> totInvestments = new HashMap<String, String>();

		List<Long> customerIds = bmsRepository.findDistinctCustomerId();
		LOGGER.info("" + customerIds);

		for (Long customerId : customerIds) {

			List<BMSDetails> savedBets = (List<BMSDetails>) bmsRepository.findByCustomerId(customerId);

			double total = savedBets.stream().collect(Collectors.summingDouble(BMSDetails::getInvestment));
			LOGGER.info("" + total);

			totInvestments.put("Customer ID " + customerId, formatter.format(total));

		}

		return totInvestments;
	}

	public Long totalBetsPerHour() {

		Long totalBets = bmsRepository.findTotalBetsPerHour();

		LOGGER.info("TotalBets" + totalBets);

		return totalBets;

	}

	public Map<String, String> TotalSoldBetsPerBetType() {

		Map<String, String> totSoldBets = new HashMap<String, String>();

		List<String> betTypes = bmsRepository.findDistinctBetType();
		LOGGER.info("" + betTypes);

		for (String betType : betTypes) {

			Long totalSoldBetsPerType = bmsRepository.findTotalBetsPerBetType(betType);
			LOGGER.info("TotalSoldBetsType" + totalSoldBetsPerType);

			totSoldBets.put("Total sold bets per bet type  " + betType, " " + totalSoldBetsPerType);

		}

		return totSoldBets;
	}

}
