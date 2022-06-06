package game.components;

import game.controller.*;

public class Player {

	private String name; //이름 
	private int bCard; // 다리 카드 개수 
	private int[] location = new int[2]; // 현재 위치 
	private int turn; // 자신의 턴 (초기값 : 0) 
	private boolean end; // end 통과 여부 
	private int score; // 점수 
	
	

	// 생성자 
	public Player() {
		
	}
	
	public Player(String name) {
		
		int [] location = new int [2];
		location[0] = 15;
		location[1] = 0;
		
		this.name = name;
		this.bCard = 0;
		this.location = location;
		this.turn = 0;
		this.score = 0;
		this.end = false;
	}
	
	//Getter, Setter 
	 public String getName() {
		 return name;
	 }
	 
	public int getBCard() {
		return bCard;
	}
	
	public int[] getLocation() {
		return location;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public int getScore() {
		return score;
	}
	
	public boolean getEnd() {
		return end;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setBCard(int bCard) {
		this.bCard = bCard;
	}
	public void setLocation(int[] location) {
		this.location = location;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setEnd (boolean end) {
		this.end = end;
	}
	
	
}
