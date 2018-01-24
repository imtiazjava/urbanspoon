package com.ts.us.dao;


import java.util.List;

import com.ts.us.dto.Branch;
import com.ts.us.exception.UrbanSpoonException;


 public class BranchDAO {


	public Branch insert(long restaurantId, Branch branch) throws UrbanSpoonException {

		return null;
	}

	
	public Branch getBranch(int branchId, boolean includeCuisines) throws UrbanSpoonException {


		return null;
	}

	public List<Branch> getBranches(long restaurantId, boolean includeCuisines,boolean includeFeedbacks) throws UrbanSpoonException {

		return null;
	}


	
	public boolean addImage(long branchId, String fileName) throws UrbanSpoonException {

		return false;
	}

	public List<String> getBranchImages(int branchId) throws UrbanSpoonException {

		return null;
	}

}
