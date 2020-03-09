package com.spring.biz.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.AmountVO;
import com.spring.biz.board.impl.AmountDAO;

public class AmountController {
	
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(AmountVO vo, AmountDAO amountDAO) {
		amountDAO.insertBoard(vo);
	return "getBoardList.do";
}
}
