package com.accolite.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@DiscriminatorValue("CONTRACT_EMP")
public class ContractEmployee extends Employee{
	 private int workingDays;
	    private String contractorName;
	 
	    public int getWorkingDays() {
	        return workingDays;
	    }
	 
	    public void setWorkingDays(int workingDays) {
	        this.workingDays = workingDays;
	    }
	 
	    public String getContractorName() {
	        return contractorName;
	    }
	 
	    public void setContractorName(String contractorName) {
	        this.contractorName = contractorName;
	    }
}
