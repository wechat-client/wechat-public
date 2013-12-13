package com.wechat.event.pojo;

/**
 * @ file_name Event.java
 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
 * @ date 2013年12月13日上午9:25:24
 * @ description 事件
 * @ reviewed_by 
 */
public class Event {

	private Integer eventId;
	private String eventCode;
	private String eventName;
	
	public Event() {

	}
	
	public Integer getEventId() {
		return eventId;
	}
	
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	
	public String getEventCode() {
		return eventCode;
	}
	
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	
}
