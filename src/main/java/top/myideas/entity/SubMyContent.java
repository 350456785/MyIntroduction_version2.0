package top.myideas.entity;

import java.text.SimpleDateFormat;

public class SubMyContent extends MyContent {
        
	/**
	 * 
	 */
	private static final long serialVersionUID = -4652357506406671463L;
	private String formatDate;

	public String changeTime() {
		try {
			this.formatDate = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getFormatDate();
	}

	public String getFormatDate() {
		return formatDate;
	}

	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}
	
}
