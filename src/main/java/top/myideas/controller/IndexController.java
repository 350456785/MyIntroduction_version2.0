package top.myideas.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.myideas.entity.MyContent;
import top.myideas.service.MyContentService;
import top.myideas.utils.AppConfig;
import top.myideas.utils.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "swagger管理:localhost/swagger-ui.html")
public class IndexController {
    private static Integer articleCount = 0;
    /*private static List<SubMyContent> contents = null;*/
    private static final Integer CHANNEL_INDEX = 1;
    @Autowired
    private AppConfig appConfig;

    @Autowired
    private MyContentService myContentService;

    @RequestMapping("/mySearch")
    @ResponseBody
    private List<MyContent> search(@Param("text") String text) {
        List<MyContent> search = myContentService.findContent(text);
        return search;
    }

    @RequestMapping({"/", "/index"})
    @ApiOperation(value = "主页接口")
    private ModelAndView index() {
        articleCount = myContentService.count();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("articleCount", articleCount != null ? articleCount : 0);
        return mav;
    }

    @RequestMapping("/contentSend")
    @ResponseBody
    private Map<String, Object> contendSend(String title, String str, Integer channel,boolean flag, String id) {
        Map<String, Object> result = new HashMap<>();
        MyContent content = new MyContent();
        content.setContent(str);
        content.setTitle(title);
        content.setChannel(channel);
        content.setId(id);

        System.out.println(flag);
        if (!flag) {
            if (myContentService.updateArticle(content)) {
                result.put("msg", "数据修改成功！");
            } else {
                result.put("msg", "数据修改失败！");
            }
            return result;
        }else if (myContentService.insert(content) > 0) {
            result.put("msg", "保存成功！");
        } else {
            result.put("msg", "保存失败！");
        }
        return result;
    }

    @RequestMapping("/article")
    private ModelAndView finalAllContent(Integer channel) {
        articleCount = myContentService.count();
        ModelAndView mav = new ModelAndView("article");
        mav.addObject("channel", channel != null && channel != 0 ? channel : CHANNEL_INDEX);
        mav.addObject("articleCount", articleCount != null ? articleCount : 0);
        mav.addObject("channels", appConfig.getChannels());
        return mav;
    }

    @RequestMapping("/myCountPage")
    @ResponseBody
    private Map<String, Object> myCountPage(Integer channel) {

        Map<String, Object> map = new HashMap<>();
        Integer count = myContentService.channelCount(channel);
        map.put("page", count == null ? 0 : count);
        return map;
    }

    @RequestMapping("/delContent")
    @ResponseBody
    private Result delContnet(String contentId, Integer channel, String password) {
        Result result = new Result();
        result.setData(1);
        if (contentId == null || channel == null || !("369963".equals(password))) {
            result.setData(0);
            result.setMsg("无法删除！");
            return result;
        }
        myContentService.Delete(contentId);
        result.setMsg("删除成功 ！");
        return result;
    }

    @RequestMapping("/pagination")
    @ResponseBody
    private List Pagination(Integer curr, Integer channel) {
        curr = curr == null ? 0 : curr;
        channel = channel == null ? 1 : channel;
        return myContentService.selectPagination(curr, channel);

    }

    @GetMapping("/photo")
    public ModelAndView photo() {
        ModelAndView mav = new ModelAndView("photo");
        mav.addObject("articleCount", articleCount);
        mav.addObject("project", 0);
        return mav;
    }
}
