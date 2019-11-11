package top.myideas.Dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import top.myideas.entity.MyContent;
import top.myideas.entity.SubMyContent;

import java.util.List;


public interface ContentDao {
    @Select("select*from my_content where channel=#{channel} order by time desc limit 5")
    List<SubMyContent> findAll(Integer channel);
    @Select("select*from my_content where channel=#{channel} order by time desc limit ${page},5")
    List<SubMyContent> findPagination(Integer page,Integer channel);
    @Select("select count(*) from my_content")
    Integer count();
    @Select("select count(*) from my_content where channel=#{channel} ")
    Integer channelCount(Integer channel);
    
    @Delete("delete from my_content where id=#{contentId}")
    Integer delContent(String contentId);
    
    @Select ("select * from my_content where title like concat('%',#{title},'%') order by time ")
    List<MyContent> findContent(String title);
}
