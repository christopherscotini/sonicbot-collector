package com.gamaset.sonicbot.collector.infra.utils;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class TimerUtils {

	private Instant firstInstant;
	private Instant lastInstant;

	public TimerUtils() {
		firstInstant = null;
		lastInstant = null;
	}
	
	public void start(){
		firstInstant = Instant.now();
	}

	public Map<String, Long> stop(){
		Map<String, Long> timers = new HashMap<String, Long>();
		lastInstant = Instant.now();
		Duration between = Duration.between(firstInstant, lastInstant);
		long seconds = between.getSeconds();
		long millisec = between.toMillis();
		timers.put("seconds", seconds);
		timers.put("millisec", millisec);
		return timers;
	}
}
