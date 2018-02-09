// created by Kurt Bopst 4/17/2017
/* This program is a game where you create a hero and battle 
monsters for no apparent reason except to level up and Defeat the Templar Knight */




import java.util.Random;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class TemplarKnight {
	// Global Hero Variables
	static String heroName = null;
	static String heroClass = null;
	static String sigMove = null;
	static String heroElmnt = null;
	static String heroWpn = null;
	static int heroMaxHlth = 50;
	static int currentHlth = 50;
	static int heroStr = 10;
	static int heroDef = 10;
	static int heroExp = 0;
	static int heroLvl = 1;
	
	//Define Scanner
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		startGame();
		toTown();
		
	
	}
	
   //HERO CREATION
	public static void createHero(){
		//Declare Variables!
		String playAgain = "yes";
		PrintWriter heroFileOut = null;
		Scanner heroFile = null;
		
		


	// Write Hero information into a .txt file name "Hero.txt"	
		while (playAgain.equals("yes")){
			heroName = JOptionPane.showInputDialog("Enter your Hero's name ");
			heroClass = JOptionPane.showInputDialog("Enter your Hero's class ");
			sigMove = JOptionPane.showInputDialog("Enter your Hero's signature move ");
			heroWpn = JOptionPane.showInputDialog("Enter your Hero's weapon ");
			heroElmnt = JOptionPane.showInputDialog("Enter your Hero's element ");
		//Add newly created Hero to the Hero.txt
			try {
			heroFile = new Scanner (new File("Hero.txt"));
			} catch (FileNotFoundException e) {
			e.printStackTrace();    }
			
			try {
				heroFileOut = new PrintWriter("Hero.txt");
			} catch (FileNotFoundException e) {
				e.printStackTrace();    }
			heroFileOut.println(heroName);
			heroFileOut.println(heroClass);
			heroFileOut.println(heroLvl);
			heroFileOut.println(sigMove);
			heroFileOut.println(heroWpn);
			heroFileOut.println(heroElmnt);
			heroFileOut.println(heroMaxHlth);
			heroFileOut.println(heroStr);
			heroFileOut.println(heroDef);
			heroFileOut.println(heroExp);
			heroFileOut.close();
		
			heroFile.close();
	//Display Hero information then prompt to adjust info	
			System.out.println("Name: " + heroName);
			System.out.println("Lvl - " + heroLvl + " " + heroClass);
			System.out.println("Signature Move: " + sigMove);
			System.out.println("Weapon: " + heroWpn);
			System.out.println("Element: " + heroElmnt);
			System.out.println("Max Health: " + heroMaxHlth);
			System.out.println("Strength: " + heroStr);
			System.out.println("Defense: " + heroDef);
			System.out.println("Current Experience: " + heroExp);
			System.out.println("");
			//Change Your new hero Loop
			playAgain = JOptionPane.showInputDialog("Would like to change anything about your hero?(yes or no)");
		}
			
			
		
		
		
	}
	
   //START GAME
	public static void startGame(){
		String gameChoice = "null";
		
		System.out.println("Welcome to Templar Knight: Edition 1.1.0!");
		System.out.print("Would you like to load a hero or create a new hero?(Enter load or new):");
		gameChoice = keyboard.next();
		System.out.print("");
		
	// Input Validation
		while ( !(gameChoice.equalsIgnoreCase("load")) && !(gameChoice.equalsIgnoreCase("new"))){
			System.out.print("Please enter 'load' or 'new' :");
			gameChoice = keyboard.next();
		}
		
	// Get a Hero!		
		if (gameChoice.equalsIgnoreCase("load")){
			loadHero();
		}
		if (gameChoice.equalsIgnoreCase("new")) {
			createHero();
		}
	
	}
//COMPLETE	
	public static void loadHero(){
		// Read hero variables from "Hero.txt" in this order Name/LVL/SigMOve/MaxHealth/Strength/Defense/Exp
		Scanner heroFile = null;
		
		
		
		
		
		try {
			 heroFile = new Scanner( new File("Hero.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace(); }
		heroName = heroFile.nextLine();
		heroClass = heroFile.nextLine();
		heroLvl = Integer.parseInt(heroFile.nextLine());
		 
		sigMove = heroFile.nextLine();
		heroWpn = heroFile.nextLine();
		heroElmnt = heroFile.nextLine();
		heroMaxHlth = Integer.parseInt(heroFile.nextLine());
		heroStr = Integer.parseInt(heroFile.nextLine());
		heroDef = Integer.parseInt(heroFile.nextLine());
		heroExp = Integer.parseInt(heroFile.nextLine());
		
		heroFile.close();
      
      //Display loaded hero
		System.out.println("");
		System.out.println("--The Loaded Hero--");
		System.out.println("Name: " + heroName);
		System.out.println("Lvl - " + heroLvl + " " + heroClass);
		System.out.println("Signature Move: " + sigMove);
		System.out.println("Weapon: " + heroWpn);			System.out.println("Element: " + heroElmnt);
		System.out.println("Max Health: " + heroMaxHlth);
		System.out.println("Strength: " + heroStr);
		System.out.println("Defense: " + heroDef);
		System.out.println("Current Experience: " + heroExp);
		System.out.println("");
	
	}
	
	
	
// BREAD AND BUTTER	
	
	public static void toTown(){
		// This is the town Hub the beginning screen almost!
		/* OPTIONS:
			WILDERNESS: Look for trouble/ travel further/ head back to town
			INN: Gossip/Sleep/back
			ARMORY: saveHero/back 
			END GAME: */
		String endGame = "no";
		String townChoice = "null";
		
		while (endGame.equals("no")){
         System.out.println("");
			System.out.println("Montgemory Village -- Pop: 3");
         System.out.println("");
			townChoice = JOptionPane.showInputDialog("1: Enter Wilderness 2: Go to Inn 3: Go to Armory 4: Go to Mystic 5: Leave Game ");
			
			switch (townChoice){
				case "1":
					wilderness();
					break;
				case "2":
					townInn();
					break;
				case "3":
					townArmory();
					break;
				case "4":
					townMystic();
					break;
				case "5":
					endGame = "yes";
					break;
			}
		}
	}
	
	public static void townArmory(){
		String option = null;
		Scanner heroFile = null;
		PrintWriter heroFileOut = null;
		String endProgram = "no";
	
		while (endProgram.equals("no")){
			option = JOptionPane.showInputDialog("1: View Hero 2: Save Hero 3: Back");
			switch (option){
				
				case "1":// View Hero
					System.out.println("Name: " + heroName);
					System.out.println("Lvl - " + heroLvl + " " + heroClass);
					System.out.println("Signature Move: " + sigMove);
					System.out.println("Weapon: " + heroWpn);
					System.out.println("Element: " + heroElmnt);
					System.out.println("Max Health: " + heroMaxHlth);
					System.out.println("Strength: " + heroStr);
					System.out.println("Defense: " + heroDef);
					System.out.println("Current Experience: " + heroExp);
					break;
				case "2"://Write to File
				
					try {
						heroFile = new Scanner (new File("Hero.txt"));
					} catch (FileNotFoundException e) {
						e.printStackTrace();    }
			
					try {
						heroFileOut = new PrintWriter("Hero.txt");
					} catch (FileNotFoundException e) {
						e.printStackTrace();    }
					heroFileOut.println(heroName);
					heroFileOut.println(heroClass);
					heroFileOut.println(heroLvl);
					heroFileOut.println(sigMove);
					heroFileOut.println(heroWpn);
					heroFileOut.println(heroElmnt);
					heroFileOut.println(heroMaxHlth);
					heroFileOut.println(heroStr);
					heroFileOut.println(heroDef);
					heroFileOut.println(heroExp);
					heroFileOut.close();
		
					heroFile.close();
					break;
				case "3"://Back
					endProgram = "yes";
					break;
			}
		}
	}
	
	public static void townInn(){
		//Declare variables
		String option = null;
		String endProgram = "no";
		int deathCtr = 0;
		
		if (currentHlth < 1){
			currentHlth = heroMaxHlth;
			System.out.println("Gustav: You didn't look too well friend. I barely nursed you back to health! Don't be reckless...");
			deathCtr++;
			if (deathCtr == 3){
				System.out.println("You are dead...");
				
			}
				
		}
		
		//Inn options
		while (endProgram.equals("no")){
			option = JOptionPane.showInputDialog("1: Sleep at Inn 2: Talk to InnKeeper 3: Back");
			
			switch (option){
				case "1":
					currentHlth = heroMaxHlth;
					System.out.println("You feel well rested!");
					break;
				case "2":
					townInnKeeper();
					break;
				case "3":
					endProgram = "yes";
					break;
			}
		}
	}
	
   
   
	public static void wilderness(){
		//Declare Variables
		String endProgram = "no";
		String wildOption = null;
			
		
		
		while (endProgram.equals("no")){
         //Once Herolvl = 10 You can enter the caves!
         if(heroLvl < 10){
   			wildOption = JOptionPane.showInputDialog("1: Fight Goblin 2: Fight Ogre 3:[Locked] 4: Return to Town");
         }

			if(heroLvl >= 10){
         
            wildOption = JOptionPane.showInputDialog("1: Fight Goblin 2: Fight Ogre 3:Enter the Caves 4:Return to Town");
         }   
            //wildOption
   			switch (wildOption){
   				case "1":
   					toBattle(0);
   					break;
   				case "2":
   					toBattle(1);
   					break;
   				case "3":
                  if(heroLvl >= 10){ theCaves(); 
                  }
                  if(heroLvl < 10){ System.out.println("Area unlocked at Hero Level 10");
                  }
                  
                  break;
               case "4":
   					endProgram = "yes";
   					break;
   			}		
			
		}
			
			
		
	}
   
   public static void theCaves(){
      
      boolean endProgram = false;
      String cavesOption = null;
   
   
      while(!endProgram){
         if(heroLvl < 20){
            cavesOption = JOptionPane.showInputDialog("1: Fight Warlock 2: Fight Vampire 3:[Locked] 4:Back to the Wilderness");
         }
         if(heroLvl >= 20){
            cavesOption = JOptionPane.showInputDialog("1: Fight Warlock 2: Fight Vampire 3:Enter Black Castle 4:Back to the Wilderness");
         }
         //caveOption
         switch(cavesOption){
            case "1":
               toBattle(2);
            break;
            case "2":
               toBattle(3);
            break;
            case "3":
            if(heroLvl < 20){
               System.out.println("Area unlocked at Hero Level 20.");
            }
            if(heroLvl >= 20){
               blackCastle();
            }
            break;
            case "4":
               endProgram = true;
            break;
         } 
      }
   
   
   }
   
	public static void blackCastle(){
   
   
   
   
   }
   
   
	public static void townInnKeeper(){
      System.out.println("Hello there! What kind of name is " +  heroName + " anyway?");
   
   
		
	}
/*	
	public static void levelUp(){
		
	}
*/



// BATTLE MECHANICS
	public static void toBattle(int monNum){
		//Monster Gallery
		String[] monsterNames = new String[7];
			int[][] monsterStats = new int [7][4];
			/*{
				{ 30, 5 , 5, 10 },
				{ 75, 15, 30, 30},
				{ 150, 45, 20, 100},
				{ 300, 60, 60, 250},
				{ 500, 80, 100, 500},
				{ 2500, 150, 150, 1000}      };*/
		//MONSTER NAMES
		monsterNames[0] = "Goblin"; monsterNames[1] = "Ogre"; monsterNames[2] = "Warlock"; monsterNames[3] = "Vampire Lord"; monsterNames[4] = "Dark Knight";
		monsterNames[5] = "Dragon"; monsterNames[6] = "Templar Knight";
		//MONSTER STATS
		//Health                //Strength                 //Defense               //Experience
		//Goblin Statz
		monsterStats[0][0] = 30; monsterStats[0][1] = 5; monsterStats[0][2] = 5; monsterStats[0][3] = 10;
		
		//Ogre
		monsterStats[1][0] = 75; monsterStats[1][1] = 15; monsterStats[1][2] = 30; monsterStats[1][3] = 30;
		
		//Warlock
   	monsterStats[2][0] = 120; monsterStats[2][1] = 30; monsterStats[2][2] = 60; monsterStats[2][3] = 60;
		
		//Vampire Lord
		monsterStats[3][0] = 250; monsterStats[3][1] = 50; monsterStats[3][2] = 90; monsterStats[3][3] = 120;
		
		//Black Knight
		//monsterStats[4][0] = xx; monsterStats[4][1] = xx; monsterStats[4][2] = xx; monsterStats[4][3] = xx;
		
		//Dragon
		//monsterStats[5][0] = xx; monsterStats[5][1] = xx; monsterStats[5][2] = xx; monsterStats[5][3] = xx;
      
		//Templar Knight
      //monsterStats[6][0] = xx; monsterStats[6][1] = xx; monsterStats[6][2] = xx; monsterStats[6][3] = xx;
		//Declare Variables
		String inBattle = "yes";
		String battleOption = null;
		int monsterHlth = 0;
		int monsterDmg = 0;
		int monCritChance = 0;
		int heroCritChance = 0;
		int heroDmg = 0;
      boolean intro = true;
      boolean moveFatigue = false;
		
		//Lets battle
		monsterHlth = monsterStats[monNum][0];
		while (inBattle.equals("yes")){
			if (currentHlth < 1) {
				System.out.println("You pass out...");
				townInn();
			}
			if (monsterHlth < 1){
				inBattle = "no";
				System.out.println("The " + monsterNames[monNum] + " lies lifeless at your feet...");
				System.out.println("You've gained " + monsterStats[monNum][3] + " experience! ");
				heroExp = heroExp + monsterStats[monNum][3];
            break;
				/* LEVEL UP PROGRAMMING
				if ( TBD ){
					levelUp();
				}
					
				*/
			}
         
         //Monster Intro
         if(intro){
         System.out.println("");
         System.out.println("A dangerous " + monsterNames[monNum] + " appears before you! Take up arms!");
         
         
         System.out.println("Enemy " + monsterNames[monNum] + "'s health: " + monsterHlth);
			System.out.println("Current Health: " + currentHlth + "/" + heroMaxHlth);
         
         intro = false;
         }
         
			battleOption = JOptionPane.showInputDialog("1: Use " + heroWpn + " 2: Use " +sigMove + "3: Flee");
			switch (battleOption){
				case "1":
				//Monster Calculations
					monCritChance=(int)(Math.random()*1000+1);
					if (monCritChance < 2){
						monsterDmg = ((monsterStats[monNum][1])-(int)(.4*(heroDef)))*2;
					}
					else {
						monsterDmg = ((monsterStats[monNum][1])-(int)(.4*(heroDef)));
					}
					currentHlth = currentHlth - monsterDmg;
					if (currentHlth < 1){
						currentHlth = 0;
					}
					
				//Hero Calculations
					heroCritChance=(int)(Math.random()*1000 + 1);
					if (heroCritChance < 30){
						heroDmg = ((heroStr)-(int)(.4*(monsterStats[monNum][2])))*2;
					}
					else {
						heroDmg = ((heroStr)-(int)(.4*(monsterStats[monNum][2])));
					}
					monsterHlth = monsterHlth - heroDmg;
				
					
					
					if (monCritChance < 2){
						System.out.println("Euruka! The " + monsterNames[monNum] + "crit!!");
					}
					System.out.println("The " + monsterNames[monNum] + " dealt " + monsterDmg + " DAMAGE!");
						if (heroCritChance < 30){
						System.out.println("WAS THAT DON CHEADLE JR!? oh.. nevermind.. YOU CRIT!");
					}
					System.out.println("You dealt " + heroDmg + " DAMAGE!");
					System.out.println("");
					if ( monsterHlth < 1){
						break;
					}
					System.out.println("Enemy " + monsterNames[monNum] + "'s health: " + monsterHlth + " / " + monsterStats[monNum][0]);
					System.out.println("Current Health: " + currentHlth + "/" + heroMaxHlth);
					
					break;
               
               //SIGNATURE MOVE
				case "2":
               //Monster Dmg
               if(moveFatigue){
               System.out.println("You're too tired to use that again!");
               break;
               }
               monCritChance=(int)(Math.random()*1000+1);
					if (monCritChance < 2){
						monsterDmg = ((monsterStats[monNum][1])-(int)(.4*(heroDef)))*2;
					}
					else {
						monsterDmg = ((monsterStats[monNum][1])-(int)(.4*(heroDef)));
					}
					currentHlth = currentHlth - monsterDmg;
					if (currentHlth < 1){
						currentHlth = 0;
					}

    
               //Hero Dmg
               heroDmg = ((heroStr)-(int)(.4*(monsterStats[monNum][2])))*2;
               monsterHlth -= heroDmg;
               
               
               //Display Combat Dialog
               	if (monCritChance < 2){
						System.out.println("Euruka! The " + monsterNames[monNum] + "crit!!");
					}
					System.out.println("The " + monsterNames[monNum] + " dealt " + monsterDmg + " DAMAGE!");
						
					System.out.println("You use your signature move " + sigMove + " making you CRIT!");
					
					System.out.println("You dealt " + heroDmg + " DAMAGE!");
					System.out.println("");
					if ( monsterHlth < 1){
						break;
					}
               
               //Display health
               System.out.println("Enemy " + monsterNames[monNum] + "'s health: " + monsterHlth + " / " + monsterStats[monNum][0]);
					System.out.println("Current Health: " + currentHlth + "/" + heroMaxHlth);
					
               moveFatigue = true;
               
					System.out.println("");
					break;
				case "3":
					monsterDmg = ((monsterStats[monNum][1])-(int)(.4*(heroDef)));//NO CRIT CHANCE
					System.out.println("As you flee the " + monsterNames[monNum] + " hurts you for " + monsterDmg + " DAMAGE!");
					currentHlth = currentHlth - monsterDmg;
					if (currentHlth < 1){
						currentHlth = 0;
					}
					System.out.println("Current Health: " + currentHlth + "/" + heroMaxHlth);
						
					inBattle = "no";
					break;
			}
			
			
		}
				
				
				
		
	}

public static void townMystic(){
	// This is where you spend Experience in order to buff stats 
	// 
   String mysticOption = null;
   boolean leaveMystic = false;
   int expCost, expToLvl;
   
   
	System.out.println("");
	System.out.println("The Hag: Welcome! How may the spirits aid you?");
	System.out.println("");
	
   while(!(leaveMystic)){
   
      expCost = heroLvl * 30;
      expToLvl = expCost - heroLvl;
      
      mysticOption = JOptionPane.showInputDialog("1:Increase Health[" + expCost + "] 2:Increase Strength[" + expCost + "] 3:Increase Defense[" + expCost + "] 4:Leave");
   	switch(mysticOption){
         case "1"://HEALTH UP
            if(heroExp < expCost){
            System.out.println("The Hag: You don't have the required experience. You need " + expToLvl + " more exp!" );
            break;
            }

            heroMaxHlth += 10;
            heroExp -= expCost;
            heroLvl += 1;
            
            System.out.println("");
            System.out.println("You feel healthier..");
            System.out.println("");
            System.out.println("The Hag: Do you desire anything else?");
         break;
         case "2"://STRENGTH UP
            if(heroExp < expCost){
            System.out.println("The Hag: You don't have the required experience. You need " + expToLvl + " more exp!" );
            break;
            }

            heroStr += 10;
            heroExp -= expCost;
            heroLvl += 1;
            
            System.out.println("");
            System.out.println("You feel stronger..");
            System.out.println("");
            System.out.println("The Hag: Do you desire anything else?");
         break;
         case "3"://DEFENSE UP
         if(heroExp < expCost){
            System.out.println("The Hag: You don't have the required experience. You need " + expToLvl + " more exp!" );
            break;
            }
            
            heroDef += 10;
            heroExp -= expCost;
            heroLvl += 1;
            
            System.out.println("");
            System.out.println("You feel more like a brick wall..");
            System.out.println("The Hag: Do you desire anything else?");
         break;
         case "4":
            leaveMystic = true;
         break;
	   }
   }
}






	
public static void clearFile(){
		//Define Printwriter
		PrintWriter heroFileOut = null;
		
		
			try {
						heroFileOut = new PrintWriter("Hero.txt");
					} catch (FileNotFoundException e) {
						e.printStackTrace();    }
					heroFileOut.println("");
					heroFileOut.println("");
					heroFileOut.println("");
					heroFileOut.println("");
					heroFileOut.println("");
					heroFileOut.println("");
					heroFileOut.println("");
					heroFileOut.println("");
					heroFileOut.println("");
					heroFileOut.println("");
					heroFileOut.close();
	}
}

