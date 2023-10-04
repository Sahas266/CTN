package org.ccode.asset.ctn.image.rest.models;

import java.io.Serializable;
import java.util.Arrays;

public class Data implements Serializable {
	private Long id;
	private byte[] data;

	public Data() {
	}

	public Data(Long id, byte[] data) {
		this.id = id;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Data{" + "id=" + id + ", data=" + Arrays.toString(data) + '}';
	}
}