package com.udit.stack;

import java.util.Stack;

public class ValidateStackASequences {

	public static void main(String[] args) {

		ValidateStackASequences obj = new ValidateStackASequences();

		int[] pushed = { 0, 1, 2 };
		int[] popped = { 0, 2, 1 };

		/**
		 * push 3 pop 3 push 4 push 2 push 5 pop 5 push 6 pop 6 pop 2 pop 4 push 7 pop 7
		 */

		boolean result = obj.validateStackSequences(pushed, popped);
		System.out.println("Result : " + result);
	}

	public boolean validateStackSequences(int[] pushed, int[] popped) {

		if (pushed.length == 0 && popped.length == 0) {
			return true;
		}
		if (pushed.length != popped.length) {
			return false;
		}

		Stack<Integer> stack = new Stack<>();

		int i = 0, j = 0;

		while (i < pushed.length) {

			if (pushed[i] == popped[j]) {
				while (i < pushed.length && j < popped.length && pushed[i] == popped[j]) {
					i++;
					j++;
				}
				while (!stack.isEmpty() && popped[j] == stack.peek()) {
					j++;
					stack.pop();
				}
			} else {
				stack.push(pushed[i]);
				i++;
			}
		}

		return stack.isEmpty();
	}
}
