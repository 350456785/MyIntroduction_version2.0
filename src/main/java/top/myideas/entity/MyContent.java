package top.myideas.entity;

import java.io.Serializable;
import java.util.Date;

public class MyContent implements Serializable {

	private String id;

	private String content;

	private Date time;

	private String title;

	private Integer channel=1;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getChannel() {
		return channel;
	}

	public void setChannel(Integer channel) {
		this.channel = channel;
	}

	private static final long serialVersionUID = 2380537165489009767L;

	@Override
	public String toString() {
		return "MyContent [id=" + id + ", content=" + content + ", time=" + time + ", title=" + title + "]";
	}

}