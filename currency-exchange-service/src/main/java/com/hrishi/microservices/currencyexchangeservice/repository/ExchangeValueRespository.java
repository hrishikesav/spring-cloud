package com.hrishi.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrishi.microservices.currencyexchangeservice.bean.ExchangeValue;

public interface ExchangeValueRespository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);
}
