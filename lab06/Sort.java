package lab06;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {7,4,5,1,3};
		printArr(arr);
		bubbleSort(arr,arr.length);
		printArr(arr);
	}
	
	public static void bubbleSort(int arr[], int n) {
		
		while (n>1) {
			for (int i=0;i<n-1;i++) {
				if (arr[i]>arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
			n--;
		}
	}
	
	public static void printArr(int arr[]) {
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
		System.out.print("\n");
	}
}
