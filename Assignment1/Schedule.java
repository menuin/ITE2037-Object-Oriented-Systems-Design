package assignment1;

public class Schedule {
	private String name;
	private int days;
	private Activity[][] plan;
	private int expense;
	public static int scheduleNum = 0;
	
	// constructor
	public Schedule(String name, int days) {
		this.name = name;
		this.days = days;
		this.plan = new Activity[12][days];
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
	
	
	

	public void addActivity(int day, int time, Activity activity) {
		
		if (checkIfInPlan(activity) == true)
			System.out.println("Fail to add activity");
		 
		else if (plan[time-9][day-1] != null)
			System.out.println("Fail to add activity");
		else {
			plan[time-9][day-1] = new Activity(activity);
			expense += activity.getPrice();
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
		expense -= plan[time-9][day-1].getPrice();
		plan[time-9][day-1] = null;
		System.out.println("Removed successfully");
	}
}
