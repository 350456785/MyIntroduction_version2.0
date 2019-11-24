package top.myideas.entity;


import java.io.Serializable;

public class Image implements Serializable {
  
  private static final long serialVersionUID = 7170681794915286210L;
  private String imageId;
  private String imageUrl;
  private long isDelete;
  private java.sql.Timestamp createDate;
  private String imageDesc;

  
  public String getImageId() {
    return imageId;
  }

  public void setImageId(String imageId) {
    this.imageId = imageId;
  }


  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }


  public long getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(long isDelete) {
    this.isDelete = isDelete;
  }


  public java.sql.Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.sql.Timestamp createDate) {
    this.createDate = createDate;
  }


  public String getImageDesc() {
    return imageDesc;
  }

  public void setImageDesc(String imageDesc) {
    this.imageDesc = imageDesc;
  }

}
