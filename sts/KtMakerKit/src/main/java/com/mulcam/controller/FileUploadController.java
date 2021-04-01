package com.mulcam.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileUploadController {
	@RequestMapping("/upload")
	public void fileUpload(@RequestParam("file") MultipartFile file) throws IllegalAccessException, IOException {
		if (!file.getOriginalFilename().isEmpty()) {
			file.transferTo(new File("C:\\Users\\kyungmin\\git\\K-Digital-AI\\sts"
							+ "\\KtMakerKit", file.getOriginalFilename()));
			System.out.println("File uploaded successfully.");
		} else {
			System.out.println("Please select a valid mediaFile..");
		}
	}
	
	@RequestMapping("/text")
	public void textUpload(@RequestParam("ipaddress") String ip, @RequestParam("msg") String data) {
		System.out.println(ip);
		System.out.println(data);
	}
	
	@RequestMapping("/json")
	public void jsonUpload(HttpServletRequest request) throws ParseException {
		StringBuffer jsonstr = new StringBuffer();
		String line = null;
		
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				jsonstr.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error reading JSON string: " + e.toString());
		}
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonstr.toString());
		JSONObject jsonObj = (JSONObject) obj;
		JSONObject member = (JSONObject) (jsonObj.get("member"));
		String name = (String) member.get("name");
		System.out.println(name);
	}
	
	@RequestMapping("/json1")
	public void jsonUpload(@RequestParam("member") String jsonstr) throws ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonstr);
		JSONObject member = (JSONObject) obj;
		String name = (String) member.get("name");
		System.out.println(name);
	}
}
