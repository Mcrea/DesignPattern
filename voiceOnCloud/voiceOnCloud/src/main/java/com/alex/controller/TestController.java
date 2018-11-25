package com.alex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alex.access.dao.DataAccessDAO;

@Controller
public class TestController {
	@Autowired
	private DataAccessDAO dao;
	
	@RequestMapping("/test")
	public String test()
	{
		return "test";
	}
	@RequestMapping("/main")
	public String mainPage()
	{
		return "main";
	}
	@RequestMapping("/word2Voice")
	@ResponseBody
	public String word2Voice(@RequestParam("text") String text)
	{
		this.voiceLog();
		return "{result : success2}";
	}
	private void voiceLog()
	{
		String sql = "insert into voice_log(name,context,logtime) values('Alex','链接数据库测试',sysdate());";
		this.dao.insert(sql);
	}

}
