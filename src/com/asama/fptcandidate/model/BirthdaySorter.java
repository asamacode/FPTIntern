package com.asama.fptcandidate.model;

import java.util.Comparator;

import com.asama.fptcandidate.utils.CandidateUtils;

public class BirthdaySorter implements Comparator<Candidate> {

	@Override
	public int compare(Candidate o1, Candidate o2) {
		// TODO Auto-generated method stub
		return Long.valueOf(CandidateUtils.dateToMilis(o2.birthday)).compareTo(CandidateUtils.dateToMilis(o1.birthday));
	}

}
