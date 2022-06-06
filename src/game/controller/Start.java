package game.controller;


import model.vo.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Start {

	
	
	
	
	
	//플레이어, 셀, 플레이어 수 선
	
	int numPlayers = 0;
	public static Cell[][] cells = new Cell[30][30];
	public static ArrayList<Player> players = new ArrayList<Player>();
	
	
	
	
public Start() {
	
	//시작 멘트 출력 
	
		System.out.println("Welcome to the game!");
	
	//플레이어 초기 설정 
	
	System.out.println("Enter the number of players (2~4)");
	Scanner scan = new Scanner(System.in);
	numPlayers = scan.nextInt();
	
	for(int i=0; i<numPlayers; i++) { 
	System.out.println("enter the " + (i+1) + " player's name");
		
	Scanner scanner = new Scanner(System.in);
	String name = scanner.next();
	players.add(new Player(name));
	
	}
		
		
		//플레이어들 이름 출력 
		/*
		for (int i=0;i<players.size();i++) {
			System.out.println((i+1) + " " + players.get(i).getName());
		}
	*/
	
	File file = new File("txt/defualt.map");
	if(file.exists()) {
		
		
		BufferedReader inFile = null;
		
		try {
			inFile = new BufferedReader (new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("file not found");
			e1.printStackTrace();
		}
		String sLine = null;
		try {
			
			//start 위치 
			int i = 15; 
			int j = 0; 
			
			char name = 0;
			char from = 0;
			char to = 0;
			int type = 0;
			
			while((sLine = inFile.readLine()) != null) {
				
				//Start
				if( sLine.length()==3) {
					name = sLine.charAt(0);
					from = ' ';
					to = sLine.charAt(2);
					type = 1;
				}
				
				//End
				else if (sLine.length() ==1) {
					name = sLine.charAt(0);
					from = ' ';
					to = ' ';
					type = 8;
				}
				
				//Else
				else {
					name = sLine.charAt(0);
					from = sLine.charAt(2);
					to = sLine.charAt(4);
					
					if(name == 'C') {
						type = 2;
					}
					else if(name == 'B') {
						type = 3;
					}
					else if(name == 'b') {
						type = 4;
					}
					else if(name == 'P') {
						type = 5;
					}
					else if(name == 'H') {
						type = 6;
					}
					else if(name == 'S') {
						type = 7;
					}
					
			
				} //type, from, to, type 값 파싱해서 저장 
				
				
				//셀 생성해서 배열에 추가 
				
				cells[i][j] = new Cell (name, from, to, type);
				
				if(to == 'R') {
					j ++;
				}
				
				else if(to == 'D') {
					
					i ++;
				}
				
				else if(to == 'U') {
					i --;
				}
				
				
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("file could'nt be opened");
			e.printStackTrace();
		}
		
	}
	
	else 
		System.out.println("file does not exist");
	//맵 텍스트 파일 한 줄씩 읽어옴 
	
	//맵 2차원 배열에 저장 완료. 
	

	

	//맵 출력 
	/*for (int i = 0; i < cells.length; i++) { 
        for (int j = 0; j < cells.length; j++) {
           if(cells[i][j] == null) {
        	   System.out.print("  ");
       
           }
     
           else
            System.out.print(cells[i][j].getName()+ " ");
        }
        System.out.println();
    }

	*/
	
	MainControl mc = new MainControl();
	mc.decideOrder();
	
	}
}
	

