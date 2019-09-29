package top.myideas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import top.myideas.entity.MyContent;
import top.myideas.entity.SubMyContent;
import top.myideas.service.MyContentService;
import top.myideas.utils.Result;

@Controller
public class IndexController {
	private static Integer articleCount = 0;
	private static List<SubMyContent> contents = null;
	private static final Integer CHANNEL_INDEX = 1;

	@Autowired
	private MyContentService MyContentService;

	@RequestMapping({ "/", "/index" })
	private ModelAndView index() {
		articleCount = MyContentService.count();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("articleCount", articleCount != null ? articleCount : 0);
		return mav;
	}

	@RequestMapping("/contentSend")
	@ResponseBody
	private Map<String, Object> contendSend(String title, String str, Integer channel) {
		Map<String, Object> result = new HashMap<>();
		MyContent content = new MyContent();
		content.setContent(str);
		content.setTitle(title);
		content.setChannel(channel);
		if (MyContentService.insert(content) > 0) {
			result.put("msg", "保存成功！");
		} else {
			result.put("msg", "保存失败！");
		}
		return result;
	}

	@RequestMapping("/article")
	private ModelAndView finalAllContent(Integer channel) {
		contents = MyContentService.selectAll(channel);
		articleCount = MyContentService.count();
		ModelAndView mav = new ModelAndView("article");
		if (!contents.isEmpty()) {
			mav.addObject("contents", contents);
		}
		mav.addObject("channel", channel != null && channel != 0 ? channel : CHANNEL_INDEX);
		mav.addObject("articleCount", articleCount != null ? articleCount : 0);
		return mav;
	}

	@RequestMapping("/myCountPage")
	@ResponseBody
	private Map<String, Object> myCountPage() {
		Map<String, Object> map = new HashMap<>();
		if (contents.isEmpty() || contents == null) {
			map.put("page", 0);
		} else {
			map.put("page", contents.size());
		}
		return map;
	}

	@RequestMapping("/delContent")
	@ResponseBody
	private Result delContnet(String contentId, Integer channel, String password, HttpServletRequest request,HttpServletResponse response) {
		Result result=new Result();
		result.setData(1);
		if (contentId == null || channel == null || !("369963".equals(password))) {
			result.setData(0);
			result.setMsg("无法删除！");
			return result;
		}
		MyContentService.Delete(contentId);
		result.setMsg("删除成功 ！");
		return result;
	}
}
