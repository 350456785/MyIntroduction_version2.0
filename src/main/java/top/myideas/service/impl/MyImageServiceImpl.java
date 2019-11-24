package top.myideas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.myideas.Dao.ImageDao;
import top.myideas.entity.Image;
import top.myideas.service.MyImageService;

import java.util.List;

/**
 * @author myideas
 * @data 2019/11/24 - 11:22
 */
@Service
public class MyImageServiceImpl implements MyImageService {
	@Autowired
	private ImageDao imageDao;
	@Override
	public Boolean saveImage (Image image) {
		int flag=imageDao.saveImae(image);
		return flag>0?true:false;
	}
	
	@Override
	public Integer findAll () {
		return imageDao.findAll();
	}
	
	@Override
	public List<Image> getList () {
		return imageDao.getList();
	}
}
