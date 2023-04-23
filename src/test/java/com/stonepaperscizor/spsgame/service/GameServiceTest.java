package com.stonepaperscizor.spsgame.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

class GameServiceTest {

	GameService gameService = new GameService();

	@Test
	void testPlay() {

		String result1 = gameService.play("paper");

		//System.out.println(gameService.testRandom);

		if (gameService.testRandom.equals("stone")) {
			assertEquals(result1,
					"You choose: " + "paper" + '\n' + "CPU choose: " + "stone" + '\n' + "Result: " + "You win");
		} else if (gameService.testRandom.equals("paper")) {
			assertEquals(result1,
					"You choose: " + "paper" + '\n' + "CPU choose: " + "paper" + '\n' + "Result: " + "Tie");
		} else {
			assertEquals(result1,
					"You choose: " + "paper" + '\n' + "CPU choose: " + "scissors" + '\n' + "Result: " + "You lose");
		}

	}

	@Test
	public void testGetResult() {

		String result1 = gameService.getResult("stone", "stone");
		assertEquals(result1, "Tie");

		String result2 = gameService.getResult("scissors", "stone");
		assertEquals(result2, "You lose");

		String result3 = gameService.getResult("stone", "paper");
		assertEquals(result3, "You lose");

		String result4 = gameService.getResult("stone", "scissors");
		assertEquals(result4, "You win");

		String result5 = gameService.getResult("scissors", "paper");
		assertEquals(result5, "You win");

		String result6 = gameService.getResult("paper", "scissors");
		assertEquals(result6, "You lose");

		String result7 = gameService.getResult("paper", "stone");
		assertEquals(result7, "You win");

	}

}
