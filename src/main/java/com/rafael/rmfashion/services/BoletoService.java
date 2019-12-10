package com.rafael.rmfashion.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.rafael.rmfashion.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	public void  preemcherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido){
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 4);
		pagto.setDataVencimento(cal.getTime());
	}
}
