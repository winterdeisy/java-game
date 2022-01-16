import java.util.Scanner;

public class Game {
	//all method can.
	Scanner sc = new Scanner(System.in);
	Scanner enterSc = new Scanner(System.in);
	int playerHP; 
	String playerWeapon;
	String playerName;
	int choice;
	int monsterHP;
	int silverRing;

	public static void main(String[] args) {
		//every program start this method.
		Game game;
		game = new Game();
		
		//standing method.
		game.playerSetUp();
		game.townGate();
	}
	
	public void playerSetUp() { //ready method.
		playerHP =  10; //put some number
		monsterHP = 15;
		
		playerWeapon = "Knife";
		
		System.out.println("Your HP:"+playerHP);
		System.out.println("Your weapon:"+playerWeapon);
		
		System.out.println("Please enter your name:");
		playerName = sc.nextLine();
		System.out.println("Hello "+playerName +", let's start your adventure!");
		
	}
	public void townGate() {
		System.out.println("\n-------------------------------------------------\n");
		System.out.println("You are at the gets of the town.");
		System.out.println("A guard is standing in front of you.");
		System.out.println("");
		System.out.println("What do you want to do?");
		System.out.println("");
		System.out.println("1. talk to the guard.");
		System.out.println("2. Attack the guard");
		System.out.println("3. Leave");
		System.out.println("\n-------------------------------------------------\n");
		
		choice = sc.nextInt();

		if(choice==1) {
			if(silverRing == 1) {
				ending();
			} else {
			System.out.println("Guard: Hello there, stranger. so your name is " +playerName +"? \nSorry but we cannot let stranger enter our town.");
			enterSc.nextLine(); //엔터를 치면 넘어가도록 함
			townGate(); //again
			}
		} 
		else if(choice==2) {
			System.out.println("Guard: Hey don't be stupid.\n\nThe guard hit you so hard and you gave up.\n(You receive 1 damage)\n");
			playerHP = playerHP-1;
			//줄어들고 늘어나는 변수는 위로 빼놓기 : 변수란 데이터를 담는 컨테이너이며 변하기 마련
			System.out.println("Your HP: "+playerHP);
			enterSc.nextLine();
			townGate();
		}
		if(choice==3) {
			crossRoad();
		}
		else {
			//선택지에 없는 숫자를 입력할 경우
			townGate();
			
		}
	}
	
	public void crossRoad() {
		System.out.println("\n-------------------------------------------------\n");
		System.out.println("You are at a crossroad. If you go south, you will go back to the town\n\n");
		System.out.println("1. Go north");
		System.out.println("2. Go east");
		System.out.println("3. Go south");
		System.out.println("4. Go west");
		System.out.println("\n-------------------------------------------------\n");
		
		choice = sc.nextInt();
		if(choice == 1) {
			north();
		}
		if(choice == 2) {
			east();
		}
		if(choice == 3) {
			south();
		}
		if(choice == 4) {
			west();
		}
		else {
			crossRoad();
		}
	}
	
	public void north() {
		System.out.println("\n-------------------------------------------------\n");
		System.out.println("There is a river. You drink the water and rest at the riveside.");
		System.out.println("Your HP is recovered. ");
		playerHP = playerHP + 1;
		System.out.println("Your HP: "+playerHP);
		System.out.println("\n\n1: Go back to the crossRoad");
		System.out.println("\n-------------------------------------------------\n");

		choice = sc.nextInt();
		if(choice == 1) {
			crossRoad();
		} else {
			north();
		}
	}
	public void east() {
		System.out.println("\n-------------------------------------------------\n");
		System.out.println("You walked into a forest and found a Lond Sword!");
		playerWeapon = "Long Sword";
		System.out.println("Your Weapon: "+playerWeapon);
		System.out.println("\n\n1: Go back to the crossRoad");
		System.out.println("\n-------------------------------------------------\n");

		choice = sc.nextInt();
		if(choice == 1) {
			crossRoad();
		} else {
			east();
		}
	}
	public void west() {
		System.out.println("\n-------------------------------------------------\n");
		System.out.println("You encounter a goblin!\n");
		System.out.println("1: Fight");
		System.out.println("2: Run");
		System.out.println("\n-------------------------------------------------\n");
		choice = sc.nextInt();
		if(choice == 1) {
			fight();
		}
		if (choice == 2) {
			crossRoad();
		}
		else {
			west();
		}
	
	}
	public void fight() {
		System.out.println("\n-------------------------------------------------\n");
		System.out.println("Your HP:"+playerHP);
		System.out.println("Monster HP:"+monsterHP);
		System.out.println("\n1: Attack");
		System.out.println("2: Run");
		System.out.println("\n-------------------------------------------------\n");
		
		choice = sc.nextInt();
		if(choice == 1) {
			attack();
		}
		if(choice == 2) {
			crossRoad();
		}
		else {
			fight();
		}
 	}
	public void attack() {
		//random number
		int playerDamage = 0; //initialize
		
		if(playerWeapon.equals("Knife")) {
			playerDamage = new java.util.Random().nextInt(5);
		}
		if(playerWeapon.equals("Long Sword")) {
			playerDamage = new java.util.Random().nextInt(8);
		}
		System.out.println("You attacked the monster and gave "+playerDamage +" damage!");
		monsterHP = monsterHP - playerDamage;
		System.out.println("MonsterHP :" +monsterHP);
		
		if(monsterHP < 1) {
			win();
		}
		if(monsterHP > 0) {
			int monsterDamage = 0;
			monsterDamage = new java.util.Random().nextInt(4);
			System.out.println("The monster attacked you and gave "+monsterDamage+" damage!");
			playerHP = playerHP - monsterDamage;
			System.out.println("PlayerHP: "+playerHP);
			
			if(playerHP < 1) {
				dead();
			}
			if(playerHP > 0) {
				fight();
			}
		}
	
	}
	public void win() {
		System.out.println("\n-------------------------------------------------\n");
		System.out.println("You killed the monster!");
		System.out.println("The monster dropped a ring!");
		System.out.println("You obtained a silver ring!\n\n");
		System.out.println("1: Go east");
		System.out.println("\n-------------------------------------------------\n");
		
		silverRing = 1;
		
		choice = sc.nextInt();
		if(choice == 1) {
			crossRoad();
		}
		else {
			win();
		}
	}
	public void dead() {
		System.out.println("\n-------------------------------------------------\n");
		System.out.println("You are dead!!!");
		System.out.println("\n\nGAME OVER");
		System.out.println("\n-------------------------------------------------\n");
	}
	public void ending() {
		System.out.println("\n-------------------------------------------------\n");
		System.out.println("Guard: Oh you killed that goblin?? Great!");
		System.out.println("Guard: It seems you are a trustworthy guy. Welcome to our town!");
		enterSc.nextLine();
		System.out.println("\n\n.................THE END..................");
		System.out.println("\n-------------------------------------------------\n");
	}
	public void south() {
		townGate();
	}

}
