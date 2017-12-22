package com.dhee.action;

import com.dhee.dao.EmpDao;
import com.dhee.vo.EmpVo;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private EmpDao empDao;

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	public EmpDao getEmpDao() {
		return empDao;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		EmpVo evo=new EmpVo();
		evo.setEmpno("8888");
		evo.setEname("tom");
		empDao.save(evo);
		System.out.println("success");
		return super.execute();
	}
}
