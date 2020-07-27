package com.udit.general;

import java.util.Arrays;
import java.util.List;

public class NestedSumTest {

	public static void main(String[] args) {

		//		[[1,1],2,[1,1]]
		
		NestedInteger l2AA = new NestedIntegerImpl(1);
		NestedInteger l2BB = new NestedIntegerImpl(1);
		
		NestedInteger l2A = new NestedIntegerImpl();
		l2A.getList().add(l2AA);
		l2A.getList().add(l2BB);
		
		NestedInteger l2CC = new NestedIntegerImpl(1);
		NestedInteger l2DD = new NestedIntegerImpl(1);
		
		NestedInteger l2B = new NestedIntegerImpl();
		l2B.getList().add(l2CC);
		l2B.getList().add(l2DD);
		
		NestedInteger l1 = new NestedIntegerImpl();
		l1.getList().add(l2A);
		l1.getList().add(l2B);
		l1.setInteger(2);		

		System.out.println("Sum : " + depthSumInverse(Arrays.asList(l1)));

	}

	private static int depthSumInverse(List<NestedInteger> nestedList) {
		int maxLevel = getMaxLevel(nestedList, 0);
		System.out.println(maxLevel);
		int sum = getSum(nestedList, maxLevel, maxLevel);
		return sum;
	}

	private static int getSum(List<NestedInteger> nestedList, int maxLevel, int currentLevel) {
		int sum = 0;
		for (NestedInteger n : nestedList) {
			if (!n.isInteger()) {
				sum += getSum(n.getList(), maxLevel, currentLevel - 1);
			}
			if(n.getInteger() != null) {				
				sum += n.getInteger() * currentLevel;
				System.out.println(n.getInteger() + " * " + currentLevel + " = " + (n.getInteger() * currentLevel));
			}
		}
		return sum;

	}

	private static int getMaxLevel(List<NestedInteger> nestedList, int level) {
		for (NestedInteger n : nestedList) {
			if (!n.isInteger()) {
				return getMaxLevel(n.getList(), level + 1);
			}
		}
		return level;
	}
}
