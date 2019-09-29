package top.myideas.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import top.myideas.entity.SubMyContent;


public interface ContentDao {
    @Select("select*from my_content where channel=#{channel} order by time desc")
   List<SubMyContent> findAll(Integer channel);
    
    @Select("select count(*) from my_content")
   Integer count();
    @Delete("delete from my_content where id=#{contentId}")
    Integer delContent(String contentId);
}
