package top.myideas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.myideas.Dao.ContentDao;
import top.myideas.entity.MyContent;
import top.myideas.entity.SubMyContent;
import top.myideas.mapper.MyContentMapper;
import top.myideas.service.MyContentService;
import top.myideas.utils.GeneratorID;

import java.util.Date;
import java.util.List;

@Service
public class MyContentServiceImpl implements MyContentService {
	@Autowired
	private MyContentMapper myContentMapper;
	@Autowired
	private ContentDao contentDao;
	
	public List<MyContent> findContent (String text) {
		return contentDao.findContent (text);
	}
	
	@Override
	public int insert (MyContent content) {
		content.setTime (new Date ());
		content.setId (GeneratorID.getID ());
		return myContentMapper.insert (content);
		
	}
	
	@Override
	public int Delete (String id) {
		
		return contentDao.delContent (id);
	}
	
	@Override
	public List<SubMyContent> selectAll (Integer channel) {
		channel = channel == null ? 1 : channel;
		List<SubMyContent> list = contentDao.findAll (channel);
		list.stream ().forEach (c -> c.changeTime ());
		return list;
	}
	
	@Override
	public Integer count () {
		
		return contentDao.count ();
	}
	
	@Override
	public List<SubMyContent> selectPagination (Integer page, Integer channel) {
		return contentDao.findPagination ((page - 1) * 5, channel);
	}
	
	@Override
	public Integer channelCount (Integer channel) {
		return contentDao.channelCount (channel);
	}
}
