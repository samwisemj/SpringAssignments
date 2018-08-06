package com.moneymoney.app.model.factory;

import java.time.LocalDate;
import java.util.Map;

import com.moneymoney.app.model.account.pojo.MMAddress;
import com.moneymoney.app.model.account.pojo.MMCurrentAccount;
import com.moneymoney.app.model.account.pojo.MMCustomer;
import com.moneymoney.app.model.account.pojo.MMSavingsAccount;
import com.moneymoney.framework.account.pojo.CurrentAccount;
import com.moneymoney.framework.account.pojo.SavingsAccount;
import com.moneymoney.framework.factory.BankFactory;

public class MMBankFactory extends BankFactory {

	@Override
	public CurrentAccount createNewCurrentAccount(Map<String, Object> arg0) {
		
		MMAddress address = new MMAddress((String) arg0.get("houseNo"), (String) arg0.get("street"),
				(String) arg0.get("city"), (String) arg0.get("state"), (int) arg0.get("pinCode"));
		return new MMCurrentAccount(
				(new MMCustomer((String) arg0.get("accountHolderName"), (long) arg0.get("contactNo"),
						(LocalDate) arg0.get("dateOfBirth"), address, (String) arg0.get("nationality"),
						(String) arg0.get("gender"))),
				(double) arg0.get("accountBalance"), (double) arg0.get("overdraft"));
	}

	@Override
	public SavingsAccount createNewSavingsAccount(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
		MMAddress address = new MMAddress((String) arg0.get("houseNo"), (String) arg0.get("street"),
				(String) arg0.get("city"), (String) arg0.get("state"), (int) arg0.get("pinCode"));
		
		return new MMSavingsAccount((new MMCustomer((String) arg0.get("accountHolderName"), (long) arg0.get("contactNo"),
						(LocalDate) arg0.get("dateOfBirth"), address, (String) arg0.get("nationality"),
						(String) arg0.get("gender"))),
				(double) arg0.get("accountBalance"), (boolean) arg0.get("salary"));
	}

}
