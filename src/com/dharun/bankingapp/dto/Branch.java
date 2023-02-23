package com.dharun.bankingapp.dto;

import java.util.HashMap;
import java.util.Set;

public class Branch {
	static HashMap<String,String> branchcode =new HashMap<>();
	
	static{
		branchcode.put("trichy","YB0013");
		branchcode.put("chennai","YB0014");
		branchcode.put("thanjavur","YB0015");
		branchcode.put("coimbatore","YB0020");
	}

	public static String setIfscode(String address) {
		if(branchcode.containsKey(address))
				return  branchcode.get(address);
		return null;		
	}
	public static  String getBranch(String ifsCode) {
		Set<String> branches = branchcode.keySet();
		for(String branch:branches) {
			if(branchcode.get(branch).equals(ifsCode)) {
				return branch;
			}
		}
		return null;
	}
}
