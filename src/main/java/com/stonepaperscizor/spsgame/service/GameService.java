package com.stonepaperscizor.spsgame.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stonepaperscizor.spsgame.exception.InvalidInputException;

@Service
public class GameService {

	public String testRandom = "";

	private static Logger logger = LoggerFactory.getLogger(GameService.class);

	private static final ArrayList<String> options = new ArrayList<>(Arrays.asList("stone", "paper", "scissors"));

	public String play(String p1Choice) {

		p1Choice = p1Choice.toLowerCase();

		logger.info("Player one choice: {}", p1Choice);

		if (!options.contains(p1Choice)) {
			logger.error("An error occured as provided input {} is not one of valid inputs",p1Choice);
			throw new InvalidInputException("The argument " + p1Choice + " doesn't match stone, paper or scissors");
		}

		String cpuChoice = generateCpuChoice();
		testRandom = cpuChoice;

		logger.info("Player two choice: {}", cpuChoice);

		String result = getResult(p1Choice, cpuChoice);

		logger.info("Result: {}", result);

		return "You choose: " + p1Choice + '\n' + "CPU choose: " + cpuChoice + '\n' + "Result: " + result;
	}

	private String generateCpuChoice() {
		Random random = new Random();
		int idx = random.nextInt(options.size());
		return options.get(idx);
	}

	public String getResult(String p1Choice, String p2Choice) {

		if (p1Choice.equals(p2Choice)) {
			return "Tie";
		} else if ((p1Choice.equals("stone") && p2Choice.equals("scissors"))
				|| (p1Choice.equals("paper") && p2Choice.equals("stone"))
				|| (p1Choice.equals("scissors") && p2Choice.equals("paper"))) {
			return "You win";
		} else {
			return "You lose";
		}
	}
}