package org.ccode.asset.ctn.image.rest.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Observation implements Serializable {
	private Long id;
	private Long telescopeId;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Target target;
	private Data data;

	public Observation() {
	}

	public Observation(Long id, Long telescopeId, LocalDateTime startTime, LocalDateTime endTime, Target target, Data data) { 
		this.id = id;
		this.telescopeId = telescopeId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.target = target;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTelescopeId() {
		return telescopeId;
	}

	public void setTelescopeId(Long telescopeId) {
		this.telescopeId = telescopeId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Observation{" + "id=" + id + ", telescopeId=" + telescopeId + ", startTime=" + startTime + ", endTime="
				+ endTime + ", target=" + target + ", data=" + data + '}';
	}
}