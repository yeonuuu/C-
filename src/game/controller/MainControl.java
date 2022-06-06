package game.controller;

import game.components.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainControl {
	
	public static int nPPNumber; // 현재 플레이중인 플레이어의 번호 
	public static int [] nPPLocation; // 현재 플레이중인 플레이어의 위치 
	public static boolean nPPPlay; // 현재 플레이어의 쉴지 말지 결정 만다: True, 쉰다: False
	public static int diceNum; // 주사위 굴려 나온 번호 
	public static String direction;
	public static ArrayList<Character> nPPbBCard = new ArrayList<Character>();
	public static ArrayList<Character> nPPScore = new ArrayList<Character>();
	public static int playOrNot; // 1: Play, 2: not
	
	
	
	public MainControl() {
		
	}
	
	public void decideOrder() {
		
		for (int i=0; i< Start.players.size();i++) {
			Start.players.get(i).setTurn(i + 1);
		}
		

		
		
		//랜덤으로 순서 정하기. 나중에 다시 하자 .
		/*System.out.println(Start.players.size());
		
		Random rd = new Random();//랜덤 객체 생성
		ArrayList<Integer> order = new ArrayList<Integer>();
		int orderNum = 0;
		
		for (int i=0; i<Start.players.size(); i++) {
			
			
			orderNum = rd.nextInt(Start.players.size()-1) +1 ;
			order.add(orderNum);	
			
			
		}
		
		
		for (int i=0; i<Start.players.size(); i++) {
			
			Start.players.get(i).setTurn(order.get(i));
			
		}
		
		for (int i=0; i<Start.players.size(); i++) {
			
			System.out.println(Start.players.get(i).getName() + " : " + Start.players.get(i).getTurn() );
			
		}
		*/
		
		
	System.out.println("Decided order is ");
	
	for(int i=0; i< Start.players.size(); i ++ ) {
		System.out.println((i+1)+" : " + Start.players.get(i).getName());
	}
	
	nPPNumber = 0;
	showMap();
	
	}
	
	public static void mainSetting() {
		
	}
	
	
	public static void showMap() {
		
		
		//맵 출력 
		System.out.println("========================================");
		for (int i = 0; i < Start.cells.length; i++) { 
	        for (int j = 0; j < Start.cells.length; j++) {
	           if(Start.cells[i][j] == null) {
	        	   System.out.print("  ");
	       
	           }
	     
	           else
	            System.out.print(Start.cells[i][j].getName()+ " ");
	        }
	        System.out.println();
	    }
		
		//현재 플레이어 정보 출력 
		System.out.println("Now playing : " + Start.players.get(nPPNumber).getName() );
		System.out.println("Number of Bridge card : " + Start.players.get(nPPNumber).getBCard());
		System.out.println("Current score : " + Start.players.get(nPPNumber).getScore());
		
		
		//플레이 할 지 말지 물어봄 
		System.out.println("Play or not ? (Play : 1, Not : 2)");
		Scanner scanner = new Scanner(System.in);
		playOrNot = scanner.nextInt();
		
		
		//플레이 한다고 하면 
		if(playOrNot == 1) {
			rolldice();
			move();
		}
		
		//플레이 안 한다고 하면 
		else {
			if(Start.players.get(nPPNumber).getBCard() > 0) {
				Start.players.get(nPPNumber).setBCard(Start.players.get(nPPNumber).getBCard()-1);
			}
		}
		
		//다음 턴으로 넘김 
		nPPNumber = (nPPNumber +1) % Start.players.size();
		

		//다음 라운드 시작 
		if (true) {
		
			showMap();
		
		}
		
	}
	
	public static void move() {
		
		
		
		nPPLocation = Start.players.get(nPPNumber).getLocation();

		System.out.println("before : " + nPPLocation[0] + ", " + nPPLocation[1] );
		
		System.out.println("Enter your direction");
		Scanner scanner = new Scanner(System.in);
		direction = scanner.next();
		
		if(direction.length() != diceNum) {
			
			
		} 
		
		for(int i=0; i<diceNum;i++) {
			if(direction.charAt(i) == 'u' && Start.cells[(nPPLocation[0]-1)][(nPPLocation[1])]!=null) {
				nPPLocation[0] --;
				
			}
			else if(direction.charAt(i) == 'd' && Start.cells[(nPPLocation[0]+1)][(nPPLocation[1])]!=null) {
				nPPLocation[0] ++ ;
				
				
			}
			
			else if(direction.charAt(i) == 'l' && Start.cells[(nPPLocation[0])][(nPPLocation[1]-1)]!=null) {
				
				nPPLocation[1] --;
				
			}
			
			else if(direction.charAt(i) == 'r' && Start.cells[(nPPLocation[0])][(nPPLocation[1]+1)]!=null) {
	
				nPPLocation[1] ++;
				
				
			}
		}
		
		System.out.println("after : " + nPPLocation[0] + ", " + nPPLocation[1]);
		
		//cell 체크하고 그에 맞게 플레이어 정보 업데이
		checkCell();
		
		
		
		Start.players.get(nPPNumber).setLocation(nPPLocation);
		
	}
	
	public static void checkCell() {
		
		//cell : Start 
		if(Start.cells[(nPPLocation[0])][(nPPLocation[1])].getType() == 1) {
			
		}
		
		//cell : cell
		else if(Start.cells[nPPLocation[0]][nPPLocation[1]].getType() == 2) {
			
		}
		
		//cell : B
		else if(Start.cells[nPPLocation[0]][nPPLocation[1]].getType() == 3) {
			
		}
		
		//cell : b
		else if(Start.cells[nPPLocation[0]][nPPLocation[1]].getType() == 4) {
			
		}
		
		//cell : P
		else if(Start.cells[nPPLocation[0]][nPPLocation[1]].getType() == 5) {
			
		}
		
		
		//cell : H
		else if(Start.cells[nPPLocation[0]][nPPLocation[1]].getType() == 6) {
					
		}
		
		
		//cell : S
		else if(Start.cells[nPPLocation[0]][nPPLocation[1]].getType() == 7) {	
		
		}
		
		//cell : End
		else if(Start.cells[nPPLocation[0]][nPPLocation[1]].getType() == 8) {
					
		}
	}
	
	
	public static void rolldice() {
		
		System.out.println("Rolling the dice . . . ");
		
		Random rd2 = new Random();
		diceNum = rd2.nextInt(5) + 1;
		
		System.out.println("Result : " + diceNum);
		
	}
	
}
