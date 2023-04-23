package com.stonepaperscizor.spsgame.entity;

import org.springframework.stereotype.Component;

@Component
public class Game {

	private String p1Choice;
	private String p2Choice;

	public Game() {
		super();
	}

	public Game(String p1Choice, String p2Choice, String result) {
		this.p1Choice = p1Choice;
		this.p2Choice = p2Choice;
	}

	public String getp1Choice() {
		return p1Choice;
	}

	public void setp1Choice(String p1Choice) {
		this.p1Choice = p1Choice;
	}

	public String getp2Choice() {
		return p2Choice;
	}

	public void setp2Choice(String p2Choice) {
		this.p2Choice = p2Choice;
	}

	@Override
	public String toString() {
		return "Game [p1Choice=" + p1Choice + ", p2Choice=" + p2Choice + "]";
	}
	
	

}