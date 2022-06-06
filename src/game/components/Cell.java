package game.components;

public class Cell {

	//private String name;
	private char name; //셀 이름 
	private char from; //어디에서 왔는지 
	private char to; // 어디로 가는지 
	private int type; // 1: start, 2: cell, 3: B, 4: b, 5: Philips Driver, 6: Hammer, 7: Saw, 8: end 
	
	

public Cell () {
	
}

public Cell (char name, char from, char to, int type) {
	//this.name = name;
	this.name = name;
	this.from = from;
	this.to = to;
	this.type = type;
}



//Getters (Setters no need)

public char getName() {
	return name;
}

public char getFrome() {
	return from;
}

public char getTo() {
	return to;
}
public int getType() {
	return type;
}


}

