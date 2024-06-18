package com.lsw.app.weather;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 설명과 실행
//객체 생성 + controller 역할 수행
public class WeatherController {

	@Autowired // 만든것을 주입
	private WeatherService weatherservice;

	@RequestMapping("/weather/list") // web.xml 참고
	public String getList(HttpServletRequest request) {
		// dispatcherservlet > request 호출함

		request.getParameter("");
		System.out.println("go");

		weatherservice.getList();

		//redirect:url
		return "redirect:/WEB-INF/views/weather/list";
	}

	@RequestMapping("/weather/detail") // url요청할 때
	public String getDetail() {

		return "redirect:/WEB-INF/views/weather/detail";
	}
	
	
	
	@RequestMapping(value = "/weather/add", method = RequestMethod.GET)
	public void add() {
		
	}
	
	@RequestMapping(value = "/weather/add", method = RequestMethod.POST)
	public void add2() {
		
	}
	
	
	
	
	
}
