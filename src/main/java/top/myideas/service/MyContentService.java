package top.myideas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import top.myideas.entity.MyContent;
import top.myideas.entity.SubMyContent;

@Service
public interface MyContentService {
     int insert(MyContent content);
     int Delete(String id);
     List<SubMyContent> selectAll(Integer channel);
     Integer count();
     
}
