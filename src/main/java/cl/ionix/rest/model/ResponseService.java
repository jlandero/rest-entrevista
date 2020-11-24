package cl.ionix.rest.model;

import com.google.gson.JsonObject;


public class ResponseService {
	
	public ResponseService(int responseCode, String description, long elapsedTime, JsonObject result) {
		super();
		this.responseCode = responseCode;
		this.description = description;
		this.elapsedTime = elapsedTime;
		this.result = result;
	}
	private int responseCode;
	private String description;
	private long elapsedTime;
	private JsonObject result;
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	public JsonObject getResult() {
		return result;
	}
	public void setResult(JsonObject result) {
		this.result = result;
	}

	
	
}
