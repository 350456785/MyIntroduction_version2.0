package top.myideas.utils;

import java.io.Serializable;

public class Result implements Serializable{
         
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5559089572741299096L;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		return true;
	}
		@Override
		public String toString() {
			return "Result [msg=" + msg + ", data=" + data + "]";
		}
		private String msg;
          private Integer data;
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public Integer getData() {
			return data;
		}
		public void setData(Integer data) {
			this.data = data;
		}
          
}
