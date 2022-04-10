package com.greatlearning.algorithmlab;

import java.util.Scanner;

public class PayMoneyTransactions {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of transaction array");
		int size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter the values of array");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the total no of targets that needs to be achieved");
		int total = sc.nextInt();
		for (int j = 0; j < total; j++) {
			int count = 0;
			System.out.println("Enter the value of target");
			int target = sc.nextInt();
			if (target > 0) {
				count = checkTransactions(arr, size, target);
				if (count > 0)
					System.out.println("Target achieved after " + count + " transactions\n");
				else
					System.out.println("Target not achieved\n");
			} else
				System.out.println("Target is invalid\n");
		}
	}

	static int checkTransactions(int[] elements, int size, int target) {
		int sum = 0, transactions = 0;
		for (int k = 0; k < size; k++) {
			sum = sum + elements[k];
			if (sum >= target) {
				transactions = k + 1;
				break;
			}
		}
		if (sum < target)
			transactions = 0;
		return transactions;
	}
}
