package assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TravelScheduler {
	public static void main (String[] args) {
		
		Schedule[] scheduleList = new Schedule[5];
	
		// Create Activity List
		Scanner inputStream = null;
		try {
			inputStream  = new Scanner(new FileInputStream("src/assignment2/ActivityList.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		int listSize = inputStream.nextInt();
		Activity[] activityList = new Activity[listSize];
		inputStream.nextLine();
		for (int i=0;i<listSize;i++) {
			String line = inputStream.nextLine();
			String[] temp = line.split(", ");
			
			String name = temp[1];
			String location = temp[2];
			int price = Integer.parseInt(temp[3]);
			
			if (temp[0].equals("Show")) {
				int minAge = Integer.parseInt(temp[4]);
				
				activityList[i] = new ShowActivity(name, location, price, minAge);
			}
			else if (temp[0].equals("Extreme")) {
				
				int minHeight = Integer.parseInt(temp[4]);
				int minWeight = Integer.parseInt(temp[5]);
				
				activityList[i] = new ExtremeActivity(name,location, price, minHeight, minWeight);
			}
			else
				activityList[i] = new Activity(name, location, price);
		}
		
		
		// Create Person List
		try {
			inputStream  = new Scanner(new FileInputStream("src/assignment2/MemberList.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		listSize = inputStream.nextInt();
		Person[] PersonList = new Person[listSize];
		inputStream.nextLine();
		
		for (int i=0;i<listSize;i++) {
			String line = inputStream.nextLine();
			String[] temp = line.split(", ");
			String name = temp[0];
			int age = Integer.parseInt(temp[1]);
			int height = Integer.parseInt(temp[2]);
			int weight = Integer.parseInt(temp[3]);
			
			PersonList[i] = new Person(name, age, height, weight);
		}
		

		
		
		
		
		
		
		
		
		
		while (true) {
			try {
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
					while(true) {
						
					try {
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
					else if (!(scheduleChoice >=1 && scheduleChoice <=5))
						throw new InvalidAccessException();
					Schedule schedule = scheduleList[scheduleChoice-1];
					
					if (schedule != null) {
						while(true) {
							try {
							System.out.println("1) Add Activity");
							System.out.println("2) Remove Activity");
							System.out.println("3) Print Schedule");
							System.out.print("Select menu : ");
							choice = scan.nextInt();
							dump = scan.nextLine();
							
							if (choice == 0) break;
							// Add Activity
							else if (choice == 1) { 
								while (true) {								
								try {
								// activity list 출력
								for (int i=0;i<activityList.length;i++)
									System.out.println(i+1 + ") " + activityList[i].toString());
								
								
										System.out.print("Select activity to do : ");
										int activityChoice = scan.nextInt();
										dump = scan.nextLine();
										
										if (!(activityChoice >=0 && activityChoice <= activityList.length))
											throw new InvalidAccessException();
										if (activityChoice == 0)
											break;
										Activity activity = activityList[activityChoice-1];
										Person[] member = schedule.getMember();
										
										// Extreme activity일 경우 조건에 맞는 지 체크
										if (activity instanceof ExtremeActivity) {
											
											ExtremeActivity extremeActivity = (ExtremeActivity)activity;
											for (int i=0;i<member.length;i++) {
												if (member[i].getHeight() < extremeActivity.getMinHeight()
														|| member[i].getWeight() < extremeActivity.getMinWeight())
													throw new InsufficientConditionException();
											}
										}
										
										// Show activity 일 경우 조건에 맞는지 체크
										else if (activity instanceof ShowActivity) {
											ShowActivity showActivity = (ShowActivity)activity;
											for (int i=0;i<member.length;i++) {
												if (member[i].getAge() < showActivity.getMinAge())
													throw new InsufficientConditionException();
											}
										}
										
										
										System.out.print("Enter the day to do activity : ");
										int day = scan.nextInt();
										dump = scan.nextLine();
										System.out.print("Enter the time to do activity(9~20): ");
										int time = scan.nextInt();
										dump = scan.nextLine();
										
										schedule.addActivity(day, time, activity, member);
										break;
										
										
									}
									catch (InsufficientConditionException e) {
										System.out.println(e.getMessage());
									}
									catch (InvalidAccessException e) {
										System.out.println(e.getMessage());
									}
									catch (InputMismatchException e) {
										System.out.println("Input mismatch");
										scan.nextLine();
									}
								}
								
							}
							
							// Remove Activity
							else if (choice == 2) {
								schedule.printActivity();
								System.out.print("Enter the day to remove activity : ");
								int day = scan.nextInt();
								dump = scan.nextLine();
								System.out.print("Enter the time to remove activity : ");
								int time = scan.nextInt();
								dump = scan.nextLine();
								
								schedule.deleteActivity(day,time);
							}
							// Print schedule
							else if (choice == 3) {
								schedule.printActivity();
								schedule.printMember();
							}
							else
								throw new InvalidAccessException();
							} catch (InvalidAccessException e) {
								System.out.println(e.getMessage());
							} catch (InputMismatchException e) {
								System.out.println("Input mismatch");
								scan.nextLine();
							}
						}
						}
						// 선택한 schedule이 null
						else
							throw new InvalidAccessException();
						break;
						
					} catch(InvalidAccessException e) {
						System.out.println(e.getMessage());
					} catch (InputMismatchException e) {
						System.out.println("Input mismatch");
						scan.nextLine();
					}				
					}
					break;
					
				
					
					
					
					
					
					
					
					
					
				// Edit Schedule	
				case 2:
					while(true) {
					try {
						System.out.println("1) Make a new schedule");
						System.out.println("2) Copy an existing schedule");
						System.out.print("Select menu : ");
						choice = scan.nextInt();
						dump = scan.nextLine();
						
						if (choice == 0) break;
						
						// Make a new schedule
						else if (choice == 1) {
							while(true) {
							try {
								// schedule array is full
								if (scheduleList[4] != null)
									throw new ArrayFullException();
								
								System.out.print("Enter a name for the schedule : ");
								String name = scan.nextLine();
								System.out.print("Enter travel days : ");
								int travelDays = scan.nextInt();
								dump = scan.nextLine();
								
								// Person의 list 출력, 원하는 member 선택
								for (int i=0;i<PersonList.length;i++) {
									System.out.println(i+1 +") " + PersonList[i].getName());
								}
								System.out.print("Choose member(ex. 1, 2, 3) : ");
								String[] temp = scan.nextLine().split(", ");
								Person[] memberList = new Person[temp.length];
								for (int i =0;i<temp.length;i++) {
										memberList[i] = new Person(PersonList[Integer.parseInt(temp[i])-1]);
								}
															
								scheduleList[Schedule.scheduleNum] = new Schedule(name, travelDays, memberList);
								break;
							}
							catch (ArrayFullException e) {
								System.out.println(e.getMessage());		
								break;
							}
							catch (InputMismatchException e) {
								System.out.println("Input mismatch");
								scan.nextLine();	
							}
						}
					}
						// Copy an existing schedule
						else if (choice ==2) {
							if (scheduleList[4] != null )
								throw new ArrayFullException();
							for (int i=0;i<5;i++) {
								if (scheduleList[i] == null)
									System.out.println(i+1 + ") EMPTY SCHEDULE");
								else
									System.out.println(i+1 + ") " + scheduleList[i].getName());
							}
							System.out.print("Select the schedule to copy : ");
							choice = scan.nextInt();
							dump = scan.nextLine();
							if (!(choice >=1 && choice <=5))
								throw new InvalidAccessException();
							else if (choice == 0) break;
							else if (scheduleList[choice-1] == null)
									throw new InvalidAccessException();
							
							System.out.print("Enter a schedule name : ");
							String name = scan.nextLine();
							
							scheduleList[Schedule.scheduleNum] = new Schedule(scheduleList[choice-1]);
							scheduleList[Schedule.scheduleNum-1].setName(name);
						
							
				
						}
						else
							throw new InvalidAccessException();
						
					} catch (InvalidAccessException e) {
						System.out.println(e.getMessage());
					} catch (InputMismatchException e) {
						System.out.println("Input mismatch");
						scan.nextLine();
					} catch (ArrayFullException e) {
						System.out.println(e.getMessage());
					}
					
				}
					break;
					
					
					
					
					
					
					
					
				// End Program	
				case 3:
					System.exit(0);
					
				default :
					throw new InvalidAccessException();
					
			}
		}
			catch (InvalidAccessException e){
				System.out.println(e.getMessage());
			}
			catch (InputMismatchException e) {
				System.out.println("Input mismatch");
			}
		}
	}	
}
