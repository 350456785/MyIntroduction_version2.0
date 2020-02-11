package top.myideas.Dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import top.myideas.entity.Image;

import java.util.List;

/**
 * @author myideas
 * @data 2019/11/24 - 11:35
 */
public interface ImageDao {
    @Insert("<script>" +
            "insert into image (image_id,image_url,image_desc,is_delete ) values" +
            "(#{imageId},#{imageUrl},#{imageDesc},#{isDelete} ) " +
            "</script>")
    int saveImae(Image image);

    @Select("select count(*) from image")
    int findAll();

    @Select("select * from image order by create_date desc")
    List<Image> getList();

    @Delete("delete from image where image_id=#{_parameter}")
    int deleteById(String imageId);
}
