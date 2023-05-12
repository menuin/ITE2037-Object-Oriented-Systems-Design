package assignment2;

public class Schedule {
	private String name;
	private int days;
	private Activity[][] plan;
	private int expense;
	public static int scheduleNum = 0;
	private Person[] member;
	
	// constructor
	public Schedule(String name, int days, Person[] member) {
		this.name = name;
		this.days = days;
		this.plan = new Activity[12][days];
		this.member = new Person[member.length];
		for (int i=0;i<member.length;i++)
			this.member[i] = new Person(member[i]);
		scheduleNum ++;
	}
	
	// copy constructor
	public Schedule(Schedule schedule) {
		this.name = schedule.name;
		this.days = schedule.days;
		this.plan = new Activity[12][days];
		
		for (int i=0;i<12;i++) {
			for (int j=0;j<days;j++) {
				if (schedule.plan[i][j] == null)
					this.plan[i][j] = null;
				else
					this.plan[i][j] = new Activity(schedule.plan[i][j]);
			}
		}
		this.expense = schedule.expense;
		scheduleNum ++;
	}
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

	public void addActivity(int day, int time, Activity activity, Person[] member) {
		try {
			if (checkIfInPlan(activity) == true) {
				System.out.println("Fail to add activity");
				throw new InvalidAccessException();
			}
			else if (plan[time-9][day-1] != null) {
				System.out.println("Fail to add activity");
				throw new InvalidAccessException();
			}
			else {
				if (activity instanceof ExtremeActivity)
					plan[time-9][day-1] = new ExtremeActivity((ExtremeActivity)activity);
				else if (activity instanceof ShowActivity)
					plan[time-9][day-1] = new ShowActivity((ShowActivity)activity);
				else
					plan[time-9][day-1] = new Activity(activity);
				
				for (int i=0;i<member.length;i++) {
					expense += activity.getActualPrice(member[i]);
				}
			}
		}catch(InvalidAccessException e) {
			System.out.println(e.getMessage());
			return;
		}
	}
	
	
	public Boolean checkIfInPlan(Activity activity) {
		for (int i=0;i<12;i++) {
			for (int j=0;j<days;j++) {
				if (activity.equals(plan[i][j]))
					return true;
			}
		}
		return false;
	}
	
	public void printActivity() {
		System.out.println("----------------".repeat(6));
		System.out.printf("%-16s","");
		for (int i=0;i<days;i++)
			System.out.printf("%-16s","Day " + (int)(i+1));
		System.out.println();
		for (int i=0; i<12;i++) {
			System.out.printf("%-16s",i+9 +":00");
			for (int j=0;j<days;j++) {
				if (plan[i][j] == null)
					System.out.printf("%-16s","----");
				else
					System.out.printf("%-16s",plan[i][j].getName());
			
			}
			System.out.println();
		}
		System.out.println("----------------".repeat(6));
		System.out.println("Total expenses : " + expense);
		System.out.println("----------------".repeat(6));
	}
	
	public void deleteActivity(int day, int time) {
		try {
		
		if (plan[time-9][day-1] == null)
			throw new InvalidAccessException();
		for (int i=0;i<member.length;i++) {
			expense -= plan[time-9][day-1].getActualPrice(member[i]);
		}
		plan[time-9][day-1] = null;
		System.out.println("Removed successfully");
		} catch (InvalidAccessException e) {
			System.out.println(e.getMessage());
			return;
		}
	}
	
	public void printMember() {
		for (int i=0;i<member.length;i++) {
			System.out.println(member[i].getName() +", " + member[i].getAge() + ", " + member[i].getHeight() + ", " + member[i].getWeight());
		}
	}
	
	public Person[] getMember() {
		Person[] temp = new Person[member.length];
		for (int i=0;i<member.length;i++)
			temp[i] = new Person(member[i]);
		
		return temp;
	}
	
	
}
