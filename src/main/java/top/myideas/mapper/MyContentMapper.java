package top.myideas.mapper;

import top.myideas.entity.MyContent;


public interface MyContentMapper {
 
	int insert(MyContent record);

	int insertSelective(MyContent record);

	int delete(String id);
	
	
}
