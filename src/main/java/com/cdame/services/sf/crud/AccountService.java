package com.cdame.services.sf.crud;

import org.springframework.stereotype.Service;

import com.cdame.domain.Account;
import com.cdame.domain.sf.SfAccount;

@Service
public class AccountService extends SalesForceGenericCrud<SfAccount, Account>{

	@Override
	public String getSfName() {
		return "Account";
	}
	
}
