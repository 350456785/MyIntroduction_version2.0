package top.myideas.service;

import top.myideas.entity.Image;

import java.util.List;

/**
 * @author myideas
 * @data 2019/11/24 - 11:22
 */
public interface MyImageService {
	Boolean saveImage (Image image);
	
	Integer findAll ();
	
	List<Image> getList ();
}
