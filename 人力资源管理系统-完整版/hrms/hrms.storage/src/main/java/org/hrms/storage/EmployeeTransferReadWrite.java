package org.hrms.storage;

import java.util.List;

import org.hrms.common.search.BetweenDate;
import org.hrms.domain.EmployeeTransfer;

public interface EmployeeTransferReadWrite extends IDatabaseReadWrite<EmployeeTransfer,Integer> {

	List<EmployeeTransfer> selectByMonth(BetweenDate betweenDate);
	
}