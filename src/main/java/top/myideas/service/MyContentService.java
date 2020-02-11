package top.myideas.service;

import org.springframework.stereotype.Service;
import top.myideas.entity.MyContent;
import top.myideas.entity.SubMyContent;

import java.util.List;

@Service
public interface MyContentService {
    int insert(MyContent content);

    int Delete(String id);

    List<SubMyContent> selectAll(Integer channel);

    List<SubMyContent> selectPagination(Integer page, Integer channel);

    Integer count();

    Integer channelCount(Integer channel);

    List<MyContent> findContent(String title);

    MyContent selectContent(String contentId);

    Boolean updateArticle(MyContent myContent);

}
