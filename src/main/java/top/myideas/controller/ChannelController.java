package top.myideas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.myideas.utils.AppConfig;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author myideas
 * @data 2019/10/4 - 23:52
 */
@RestController
public class ChannelController {
	@Resource
	private AppConfig appConfig;
	   @RequestMapping("/channels")
	private Map<Integer,String> getChannels(){
		  
	   	return appConfig.getChannels ();
	   }
}
