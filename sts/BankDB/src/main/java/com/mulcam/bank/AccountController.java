package com.mulcam.bank;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.bank.beans.Account;
import com.mulcam.bank.dao.AccountDAO;

@Controller
public class AccountController {
	AccountDAO accountDao;
	
	public void setAccountDao(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}

	@RequestMapping(value="/makeaccount", method=RequestMethod.GET)
	public String makeAccount(Model model) {
		model.addAttribute("page", "makeaccount_form");
		return "template";
	}
	
	@RequestMapping(value="/makeaccount", method=RequestMethod.POST)
	public String makeAccount(HttpServletRequest request, Model model) {
		Account acc = null;
		try {
			acc = accountDao.queryAccount(request.getParameter("id"));
			model.addAttribute("err", "계좌번호 중복");
			model.addAttribute("page","err");
		} catch (Exception e) {
			try {
				acc = new Account();
				acc.setId(request.getParameter("id"));
				acc.setName(request.getParameter("name"));
				acc.setBalance(Integer.parseInt(request.getParameter("balance")));
				acc.setSect(request.getParameter("sect"));
				acc.setGrade(request.getParameter("grade"));
				accountDao.insertAccount(acc);
				model.addAttribute("page", "makeaccount_success");
			} catch (Exception e1) {
				e1.printStackTrace();
				model.addAttribute("err", "계좌 개설 실패");
				model.addAttribute("page","err");
			}
		}
		return "template";
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.GET)
	public String deposit(Model model) {
		model.addAttribute("page", "deposit_form");
		return "template";
	}

	@RequestMapping(value="/deposit", method=RequestMethod.POST)
	public String deposit(HttpServletRequest request, Model model) {
		try {
			String id = request.getParameter("id");
			int money = Integer.parseInt(request.getParameter("money"));			

			Account acc = accountDao.queryAccount(id); // null값일 경우 예외 반환
			acc.deposit(money);
			accountDao.updateAccBalance(acc);
			// 입금 정보를 알려주기 위해 값을 넘겨줌
			model.addAttribute("accid", id);
			model.addAttribute("money", money);
			model.addAttribute("page", "deposit_success");
		} catch (Exception e) {
			model.addAttribute("err", "입금 오류");
			model.addAttribute("page", "err");
		}
		return "template";
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.GET)
	public String withdraw(Model model) {
		model.addAttribute("page", "withdraw_form");
		return "template";
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.POST)
	public String withdraw(HttpServletRequest request, Model model) {
		try {
			String id = request.getParameter("id");
			int money = Integer.parseInt(request.getParameter("money"));
			
			Account acc = accountDao.queryAccount(id);
			if (acc==null) throw new Exception();
			boolean success = acc.withdraw(money);
			if (success==false) throw new Exception();
			accountDao.updateAccBalance(acc);
			// 출금 정보를 알려주기 위해 값을 넘겨줌
			model.addAttribute("accid", id);
			model.addAttribute("money", money);
			model.addAttribute("page", "withdraw_success");
		} catch (Exception e) {
			model.addAttribute("err", "출금 오류");
			model.addAttribute("page", "err");
		}
		return "template";
	}
	
	@RequestMapping(value="/accinfo", method=RequestMethod.GET)
	public String accinfo(Model model) {
		model.addAttribute("page", "accinfo_form");
		return "template";
	}

	@RequestMapping(value="/accinfo", method=RequestMethod.POST)
	public ModelAndView accinfo(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			String id = request.getParameter("id");
			Account acc = accountDao.queryAccount(id);
			if (acc==null) throw new Exception();
			modelAndView.addObject("acc", acc);
			modelAndView.addObject("page", "accinfo_success");
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("err", "계좌조회 오류");
			modelAndView.addObject("page", "err");
		}
		modelAndView.setViewName("template");
		return modelAndView;
	}
	
	@RequestMapping(value="/allaccinfo", method=RequestMethod.GET)
	public String allaccinfo(Model model) {
		model.addAttribute("page", "allaccinfo_form");
		return "template";
	}
	
	@RequestMapping(value="/allaccinfo", method=RequestMethod.POST)
	public ModelAndView allAccInfo(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<Account> accs = accountDao.queryAccounts();
			modelAndView.addObject("accs", accs);
			modelAndView.addObject("page", "allaccinfo_success");
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("err", "전체계좌조회 오류");
			modelAndView.addObject("page", "err");
		}
		modelAndView.setViewName("template");
		return modelAndView;
	}
}
