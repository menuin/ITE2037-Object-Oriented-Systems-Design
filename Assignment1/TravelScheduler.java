package assignment1;

import java.util.Scanner;

public class TravelScheduler {
	public static void main (String[] args) {
		
		Schedule[] scheduleList = new Schedule[5];
		Activity[] activityList = new Activity[8];
		
		activityList[0] = new Activity("Hiking", "Mountain", 0);
		activityList[1] = new Activity("Horse Riding", "Hill", 3000);
		activityList[2] = new Activity("Visiting Museum", "Museum", 8000);
		activityList[3] = new Activity("Watching movie", "Theater", 11000);
		activityList[4] = new Activity("Fishing", "Sea", 15000);
		activityList[5] = new Activity("Surfing", "Beach", 20000);
		activityList[6] = new Activity("Camping", "Field", 30000);
		activityList[7] = new Activity("Paragliding", "Mountain", 50000);
		
	
		while (true) {
			System.out.println("1) Select schedule");
			System.out.println("2) Edit schedule");
			System.out.println("3) End Program");
			System.out.print("Select menu : ");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			String dump = scan.nextLine();
			
			

			switch (choice) {
			
			// Select Schedule
			case 1:
				for (int i=0;i<5;i++) {
					if (scheduleList[i] == null)
						System.out.println(i+1 + ") EMPTY SCHEDULE");
					else
						System.out.println(i+1 + ") " + scheduleList[i].getName());
				}
				
				System.out.print("Select a schedule : ");
				int scheduleChoice = scan.nextInt();
				dump = scan.nextLine();
				
				if (scheduleChoice == 0) break;
				
				else if (scheduleList[scheduleChoice-1] != null) {
					while(true) {
					System.out.println("1) Add Activity");
					System.out.println("2) Remove Activity");
					System.out.println("3) Print Schedule");
					System.out.print("Select menu : ");
					choice = scan.nextInt();
					dump = scan.nextLine();
					
					if (choice == 0) break;
					// Add Activity
					else if (choice == 1) { 
						// activity list Ãâ·Â
						for (int i=0;i<8;i++)
							System.out.println(i+1 + ") " + activityList[i].toString());
						
						System.out.print("Select activity to do : ");
						int activityChoice = scan.nextInt();
						dump = scan.nextLine();
						System.out.print("Enter the day to do activity : ");
						int day = scan.nextInt();
						dump = scan.nextLine();
						System.out.print("Enter the time to do activity(9~20): ");
						int time = scan.nextInt();
						dump = scan.nextLine();
						
						scheduleList[scheduleChoice-1].addActivity(day, time, activityList[activityChoice-1]);
					 
					}
					// Remove Activity
					else if (choice == 2) {
						scheduleList[scheduleChoice-1].printActivity();
						System.out.print("Enter the day to remove activity : ");
						int day = scan.nextInt();
						dump = scan.nextLine();
						System.out.print("Enter the time to remove activity : ");
						int time = scan.nextInt();
						dump = scan.nextLine();
						
						scheduleList[scheduleChoice-1].deleteActivity(day,time);
					}
					// Print schedule
					else
						scheduleList[scheduleChoice-1].printActivity();
						
					}
					
				}
				else break;
				break;
			
				
				
				
				
				
				
				
				
				
			// Edit Schedule	
			case 2:
				while(true) {
				System.out.println("1) Make a new schedule");
				System.out.println("2) Copy an existing schedule");
				System.out.print("Select menu : ");
				choice = scan.nextInt();
				dump = scan.nextLine();
				
				if (choice == 0) break;
				
				// Make a new schedule
				else if (choice == 1) {
					System.out.print("Enter a name for the schedule : ");
					String name = scan.nextLine();
					System.out.print("Enter travel days : ");
					int travelDays = scan.nextInt();
					dump = scan.nextLine();
					
					scheduleList[Schedule.scheduleNum] = new Schedule(name, travelDays);
				}
				// Copy an existing schedule
				else {
					for (int i=0;i<5;i++) {
						if (scheduleList[i] == null)
							System.out.println(i+1 + ") EMPTY SCHEDULE");
						else
							System.out.println(i+1 + ") " + scheduleList[i].getName());
					}
					System.out.print("Select the schedule to copy : ");
					choice = scan.nextInt();
					dump = scan.nextLine();
					System.out.print("Enter a schedule name : ");
					String name = scan.nextLine();
					
					scheduleList[Schedule.scheduleNum] = new Schedule(scheduleList[choice-1]);
					scheduleList[Schedule.scheduleNum-1].setName(name);
				}
				}
				break;
				
				
				
				
				
				
				
			// End Program	
			case 3:
				System.exit(0);
				
			}	
		}
	}	
}
