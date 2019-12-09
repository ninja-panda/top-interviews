package com.tuturself.mix;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Input: [[1,1],2,[1,2]]
 * Output: [1,1,2,1,1]
 * [1,2] , 2 , [1,1]
 */
public class NestedIterator implements Iterator<Integer> {

	Stack<NestedInteger> stack;

	public NestedIterator(List<NestedInteger> nestedList) {
		stack = new Stack<>();
		populate(nestedList);
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		return stack.size() > 0;
	}

	private void populate(List<NestedInteger> nestedList) {
		if (nestedList != null && !nestedList.isEmpty()) {
			for (int i = nestedList.size() - 1; i >= 0; i--) {
				NestedInteger nestedInteger = nestedList.get(i);
				if (nestedInteger.isInteger()) {
					stack.push(nestedInteger);
				} else {
					populate(nestedInteger.getList());
				}
			}
		}
	}
}