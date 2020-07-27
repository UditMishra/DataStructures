package com.udit.general;

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerImpl implements NestedInteger {

	private Integer val;
	private List<NestedInteger> list;

	public NestedIntegerImpl() {
		list = new ArrayList<>();
	}

	public NestedIntegerImpl(int val) {
		this.val = val;
	}

	@Override
	public boolean isInteger() {
		return list == null || list.isEmpty();
	}

	@Override
	public Integer getInteger() {
		return val;
	}

	@Override
	public void setInteger(int value) {
		this.val = value;
	}

	@Override
	public void add(NestedInteger ni) {
		if(ni.isInteger()) {
			setInteger(ni.getInteger());
		}
		else {			
			list.add(ni);
		}
	}

	@Override
	public List<NestedInteger> getList() {
		return list;
	}

}
