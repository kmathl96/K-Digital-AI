package com.mulcam.clova.controller;

import java.io.File;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
public class ClovaSpeech {
	
	@RequestMapping(value="/speech")
	public String main(String[] args) {
		final ClovaSpeechClient clovaSpeechClient = new ClovaSpeechClient();
		final String result = clovaSpeechClient.upload(new File("voice.mp3"), "sync", null, null, null, null);
		//final String result = clovaSpeechClient.url("file URL", "sync", null, null, "", null);
		//final String result = clovaSpeechClient.objectStorage("Object Storage key", "sync", null, null, "", null);
		JsonParser jsonParser = new JsonParser();
		JsonObject object = (JsonObject) jsonParser.parse(result);
		return object.get("text").getAsString();
	}

}
