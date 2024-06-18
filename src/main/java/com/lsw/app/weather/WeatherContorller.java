package com.lsw.app.weather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeatherContorller {

	@RequestMapping("/weather/list")
	public String getList() {

		return "/weather/list";
	}
}
