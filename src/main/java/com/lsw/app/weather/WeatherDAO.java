package com.lsw.app.weather;

import org.springframework.stereotype.Repository;

@Repository
//객체 생성 + Dao
public class WeatherDAO {

	public void getList() {
		System.out.println("dao list");
	}
}
