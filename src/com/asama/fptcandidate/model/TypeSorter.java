package com.asama.fptcandidate.model;

import java.util.Comparator;

public class TypeSorter implements Comparator<Candidate>{

	@Override
	public int compare(Candidate o1, Candidate o2) {
		// TODO Auto-generated method stub
		return Integer.valueOf(o1.candidateType).compareTo(o2.candidateType);
	}
}
