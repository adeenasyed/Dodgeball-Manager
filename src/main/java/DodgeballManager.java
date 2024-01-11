import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DodgeballManager {

	private DodgeballNode throwerList;
	private DodgeballNode dodgerList;
	private DodgeballNode benchList;

    public DodgeballManager(List<String> throwers, List<String> dodgers) {
		
		if (throwers == null || throwers.size() == 0 || dodgers == null || dodgers.size() == 0) { // checks if parameters are valid
			throw new IllegalArgumentException(); // throws IllegalArgumentException if parameters are not valid
		} else {

			
			for (int i = 0; i < throwers.size(); i++) { // iterates through length of throwers list
				if (this.throwerList == null) { // checks if first node of throwerList is null
					this.throwerList = new DodgeballNode(throwers.get(i)); // creates first node with thrower name at index i if first node is null
				} else { 
					DodgeballNode currentThrowerList = this.throwerList; // temporary DodgeballNode for iterating through throwerList
					while (currentThrowerList.next != null) { // iterates through throwerList to obtain last node
						currentThrowerList = currentThrowerList.next; // increments temporary DodgeballNode to next node
					}
					currentThrowerList.next = new DodgeballNode(throwers.get(i)); // adds new DodgeballNode w/ thrower name at index i to the end of throwerList
				}
			}
			
			for (int i = 0; i < dodgers.size(); i++) { // iterates through length of dodgers list
				if (this.dodgerList == null) { // checks if first node of dodgerList is null
					this.dodgerList = new DodgeballNode(dodgers.get(i)); // creates first node with dodger name at index i if first node is null
				} else { 
					DodgeballNode currentDodgerList = this.dodgerList; // temporary DodgeballNode for iterating through dodgerList
					while (currentDodgerList.next != null) { // iterates through dodgerList to obtain last node
						currentDodgerList = currentDodgerList.next; // increments temporary DodgeballNode to next node
					}
					currentDodgerList.next = new DodgeballNode(dodgers.get(i)); // adds new DodgeballNode with dodger name at index i to the end of dodgerList
				}
			}

		}

    }

	
	///////////////////////
	// Boolean Accessors //
	///////////////////////

	public boolean isThrower(String name) {
		boolean x = false; // sets x to false

		DodgeballNode current = this.throwerList; // temporary DodgeballNode for iterating through throwerList
		while (current != null) { // iterates through throwerList
			if (current.name.equals(name)) { // checks if current node name is equal to given name
				x = true; // sets x to true if current node name is equal to given name
			}
			current = current.next; // increments temporary DodgeballNode to next node
		}

		return x;
	}

	public boolean isActiveDodger(String name) {
		boolean x = false; // sets x to false

		DodgeballNode current = this.dodgerList; // temporary DodgeballNode for iterating through dodgerList
		while (current != null) { // iterates through dodgerList
			if (current.name.equals(name)) { // checks if current node name is equal to given name
				x = true; // sets x to true if current node name is equal to given name
			}
			current = current.next; // increments temporary DodgeballNode to next node
		}

		return x;
	}

	public boolean isBenchedPlayer(String name) {
		boolean x = false; // sets x to false

		DodgeballNode current = this.benchList; // temporary DodgeballNode for iterating through benchList
		while (current != null) { // iterates through benchList
			if (current.name.equals(name)) { // checks if current node name is equal to given name
				x = true; // sets x to true if current node name is equal to given name
			}
			current = current.next; // increments temporary DodgeballNode to next node
		}

		return x;
	}


	/////////////////////
	// Count Accessors //
	/////////////////////

	public int nBenchedPlayers() {
		int num = 0; // set counter to 0

		DodgeballNode current = this.benchList; // temporary DodgeballNode for iterating through benchList
		while (current != null) { // iterates through benchList
			num++; // increment counter by 1
			current = current.next; // increments temporary DodgeballNode to next node
		}

		return num;
	}

	public int nActiveDodgers() {
		int num = 0; // set counter to 0

		DodgeballNode current = this.dodgerList; // temporary DodgeballNode for iterating through dodgerList
		while (current != null) { // iterates through dodgerList
			num++; // increment counter by 1
			current = current.next; // increments temporary DodgeballNode to next node
		}

		return num;
	}


	////////////////
	// Main Logic //
	////////////////

	public void dodge(String throwerName, String dodgerName) {
		if (this.isThrower(throwerName) == false || this.isActiveDodger(dodgerName) == false || throwerName.isEmpty() || dodgerName.isEmpty() 
		|| throwerName == null || dodgerName == null) { // checks if parameters are valid
			throw new IllegalArgumentException(); // throws IllegalArgumentException if parameters are not valid
		} else { 
			DodgeballNode current = this.dodgerList; // temporary DodgeballNode for iterating through dodgerList
			while (!current.name.equals(dodgerName)) { // iterates through dodgerList to obtain node with dodgerName
				current = current.next; // increments temporary DodgeballNode to next node
			}
			current.score++; // increments dodgerName node score by 1
		}
	}

    public void hit(String throwerName, String dodgerName) {
		if (this.isThrower(throwerName) == false || this.isActiveDodger(dodgerName) == false || throwerName.isEmpty() || dodgerName.isEmpty() 
		|| throwerName == null || dodgerName == null) { // checks if parameters are valid
			throw new IllegalArgumentException(); // throws IllegalArgumentException if parameters are not valid
		} else {
			DodgeballNode currentThrower = this.throwerList; // temporary DodgeballNode for iterating through throwerList
			while (!currentThrower.name.equals(throwerName)) { // iterates through throwerList to obtain node with throwerName
				currentThrower = currentThrower.next; // increments temporary DodgeballNode to next node
			}
			currentThrower.score++; // increments throwerName node score by 1

			DodgeballNode currentDodger = this.dodgerList; // temporary DodgeballNode for iterating through dodgerList
			if (currentDodger.name.equals(dodgerName)) { // checks if current node name is equal to dodgerName 
				if (this.benchList == null) { // checks if first node of benchList is null
					benchList = new DodgeballNode(dodgerName); // creates first node with dodgerName if first node is null
					benchList.score = currentDodger.score; // sets score for benchList node with dodgerName
				} else { 
					DodgeballNode currentBench = this.benchList; // temporary DodgeballNode for iterating through benchList
					while (currentBench.next != null) { // iterates through benchList to obtain last node
						currentBench = currentBench.next; // increments temporary DodgeballNode to next node
					}
					currentBench.next = new DodgeballNode(dodgerName); // adds new DodgeballNode with dodgerName to the end of benchList
					currentBench.next.score = currentDodger.score; // sets score for benchList node with dodgerName
				}
				this.dodgerList = this.dodgerList.next; // removes node with dodgerName from dodgerList
			} else {
				while (!currentDodger.next.name.equals(dodgerName)) { // iterates through dodgerList to obtain node with dodgerName
					currentDodger = currentDodger.next; // increments temporary DodgeballNode to next node
				}
				if (this.benchList == null) { // checks if first node of benchList is null
					benchList = new DodgeballNode(dodgerName); // creates first node with dodgerName if first node is null
					benchList.score = currentDodger.next.score; // sets score for benchList node with dodgerName
				} else { 
					DodgeballNode currentBench = this.benchList; // temporary DodgeballNode for iterating through benchList
					while (currentBench.next != null) { // iterates through benchList to obtain last node
						currentBench = currentBench.next; // increments temporary DodgeballNode to next node
					}
					currentBench.next = new DodgeballNode(dodgerName); // adds new DodgeballNode with dodgerName to the end of benchList
					currentBench.next.score = currentDodger.next.score; // sets score for benchList node with dodgerName
				}
				currentDodger.next = currentDodger.next.next; // removes node with dodgerName from dodgerList
			}
		}		
    }

	public void catchBall(String throwerName, String dodgerName) {
		if (this.isThrower(throwerName) == false || this.isActiveDodger(dodgerName) == false || throwerName.isEmpty() || dodgerName.isEmpty() 
		|| throwerName == null || dodgerName == null) { // checks if parameters are valid
			throw new IllegalArgumentException(); // throws IllegalArgumentException if parameters are not valid
		} else { 
			DodgeballNode current = this.dodgerList; // temporary DodgeballNode for iterating through dodgerList
				while (!current.name.equals(dodgerName)) { // iterates through dodgerList to obtain node with dodgerName
					current = current.next; // increments temporary DodgeballNode to next node
				}
			current.score++; // increments dodgerName node score by 1
		}		
	}

	public void catchBall(String throwerName, String dodgerName, String benchBackName) {
		if (this.isThrower(throwerName) == false || this.isActiveDodger(dodgerName) == false || this.isBenchedPlayer(benchBackName) == false 
		|| throwerName.isEmpty() || dodgerName.isEmpty() || benchBackName.isEmpty() || throwerName == null || dodgerName == null 
		|| benchBackName == null) { // checks if parameters are valid
			throw new IllegalArgumentException(); // throws IllegalArgumentException if parameters are not valid
		} else {

			DodgeballNode currentDodger = this.dodgerList; // temporary DodgeballNode for iterating through dodgerList
			while (!currentDodger.name.equals(dodgerName)) { // iterates through dodgerList to obtain node with dodgerName
				currentDodger = currentDodger.next; // increments temporary DodgeballNode to next node
			}
			currentDodger.score++; // increments dodgerName node score by 1
			currentDodger.next = new DodgeballNode(benchBackName, currentDodger.next);// adds new DodgeballNode with benchBackName after node with dodgerName
			

			DodgeballNode currentBench = this.benchList; // temporary DodgeballNode for iterating through benchList
			if (currentBench.name.equals(benchBackName)) { // check if current node name is equal to benchBackName
				currentDodger.next.score = currentBench.score; // sets score for dodgerList node with benchBackName
				this.benchList = this.benchList.next; // removes node with benchBackName from benchList
			} else {
				while (!currentBench.next.name.equals(benchBackName)) {  // iterates through benchList to obtain node with benchBackName
					currentBench = currentBench.next; // increments temporary DodgeballNode to next node
				}
				currentDodger.next.score = currentBench.next.score; // sets score for dodgerList node with benchBackName
				currentBench.next = currentBench.next.next; // removes node with benchBackName from benchList
			}
		}		
	}


	///////////////////
	// Main Printing //
	///////////////////

	public void printThrowers(PrintStream stream) {

		DodgeballNode current = this.throwerList; // temporary DodgeballNode for iterating through throwerList
		while (current != null) { // iterates through entire throwerList
			if (current.next == null) { // checks if next node is null
				stream.print(current.name + " " + current.score); // prints thrower name and score if next node is null
			} else { 
				stream.print(current.name + " " + current.score + ", "); // prints thrower name and score with comma if next node is not null
			}
			current = current.next; // increments temporary DodgeballNode to next node
		}
	}

	public void printDodgers(PrintStream stream) {
		DodgeballNode current = this.dodgerList; // temporary DodgeballNode for iterating through dodgerList
		if (current == null) { // checks if first node is null
			stream.print("empty"); // prints empty is first node is null
		} else {
			while (current != null) { // iterates through entire dodgerList
				if (current.next == null) { // checks if next node is null
					stream.print(current.name + " " + current.score); // prints dodger name and score if next node is null
				} else { 
					stream.print(current.name + " " + current.score + ", "); // prints dodger name and score with comma if next node is not null
				}
				current = current.next; // increments temporary DodgeballNode to next node
			}
		}
	}

	public void printBench(PrintStream stream) {
		DodgeballNode current = this.benchList; // temporary DodgeballNode for iterating through benchList
		if (current == null) { // checks if first node is null
			stream.print("empty"); // prints empty is first node is null
		} else {
			while (current != null) { // iterates through entire benchList
				if (current.next == null) { // checks if next node is null
					stream.print(current.name + " " + current.score); // prints dodger name and score if next node is null
				} else { 
					stream.print(current.name + " " + current.score + ", "); // prints dodger name and score with comma if next node is not null
				}
				current = current.next; // increments temporary DodgeballNode to next node
			}
		}
	}

	//////////////////
	// Printing MVP //
	//////////////////
	public void printMVP(PrintStream stream) { 
		Map<String, Integer> map = new TreeMap<>(); // create map for players and their scores

		DodgeballNode currentThrower = this.throwerList; // temporary DodgeballNode for iterating through throwerList
		while (currentThrower != null) { // iterates through entire throwerList
			map.put(currentThrower.name, currentThrower.score); // adds player name and score to map
			currentThrower = currentThrower.next; // increments temporary DodgeballNode to next node
		}

		DodgeballNode currentDodger = this.benchList; // temporary DodgeballNode for iterating through benchList
		while (currentDodger != null) { // iterates through entire benchList
			map.put(currentDodger.name, currentDodger.score); // adds player name and score to map
			currentDodger = currentDodger.next; // increments temporary DodgeballNode to next node
		}
		
		String MVP_Str = ""; // create MVP string to be printed
		int MVP_Score = 0; // initialize MVP score to 0

		for (String name : map.keySet()) { // iterates through every player
			if (map.get(name) > MVP_Score) { // checks if player's score is greater than MVP score
				MVP_Score = map.get(name); // sets MVP score to player's score if player's score is greater than MVP score
				MVP_Str = name + " " + MVP_Score; // sets MVP string to player's name and score
			} else if (map.get(name) == MVP_Score) {  // checks if player's score is equal to MVP score
				MVP_Str += (", " + name + " " + MVP_Score); // adds player's name and score to MVP string
			}
		}

		stream.print(MVP_Str); // prints MVP string
    }

}