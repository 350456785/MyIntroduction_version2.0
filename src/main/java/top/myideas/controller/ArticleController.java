package top.myideas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.myideas.entity.MyContent;
import top.myideas.service.MyContentService;

@RestController
public class ArticleController {
    @Autowired
    private MyContentService myContentService;
    @RequestMapping("/selectArticle")
    public MyContent updateArticle(String contentId){
        return myContentService.selectContent(contentId);
    }
}
