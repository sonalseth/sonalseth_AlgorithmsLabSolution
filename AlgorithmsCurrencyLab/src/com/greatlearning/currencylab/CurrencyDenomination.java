package com.greatlearning.currencylab;

import java.util.Scanner;

import com.greatlearning.sort.MergeSort;

public class CurrencyDenomination {
	static int[] Counter;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int finalAmt = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of currency denominations");
		int size = sc.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter the currency denominations value");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		MergeSort ms = new MergeSort();
		int[] notes = ms.sort(arr, 0, arr.length - 1);
		System.out.println("Enter the amount you want to pay");
		int amount = sc.nextInt();

		finalAmt = notesCount(notes, amount);

		if (finalAmt > 0) {
			System.out.println("Cannot generate amount as denomination is higher than amount to be paid");
		} else if (finalAmt == -1) {
			System.out.println("Invalid Amount Entered");
		} else if (finalAmt == -2) {
			System.out.println("Notes of 0 denominations are invalid");
		} else {
			System.out.println("Your payment approach in order to give min no of notes will be");
			for (int i = 0; i < size; i++) {
				if (Counter[i] != 0)
					System.out.println(notes[i] + ":" + Counter[i]);
			}
		}

	}

	public static int notesCount(int notes[], int amount) {
		if (amount == 0)
			return -1;
		Counter = new int[notes.length];
		try {
			for (int i = 0; i < notes.length; i++) {
				if (amount >= notes[i]) {
					Counter[i] = amount / notes[i];
					amount = amount - (Counter[i] * notes[i]);
				}
			}

		} catch (ArithmeticException ae) {
			System.out.println(ae);
			return -2;
		}
		return amount;
	}

}
