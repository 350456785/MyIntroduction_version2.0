package top.myideas.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.myideas.entity.Image;
import top.myideas.service.MyImageService;
import top.myideas.utils.AppConfig;
import top.myideas.utils.Result;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * @author myideas
 * @data 2019/11/15 - 20:53
 */
@Controller
public class PhotoController {
    @Resource
    private AppConfig appConfig;
    @Resource
    private MyImageService myImageService;

    @PostMapping("imageUpload")
    @ResponseBody
    public Result imageUpload(@RequestParam("files") MultipartFile[] files, HttpServletRequest req) {
        Result result = new Result();
        String images = appConfig.getImages();
        Boolean flag = false;
        if (files != null && files.length > 0) {
            FileOutputStream fos = null;
            InputStream fis = null;
            try {
                for (MultipartFile f : files) {
                    String imageName = f.getOriginalFilename();
                    String imagePath = images + imageName;
                    fis = f.getInputStream();
                    fos = new FileOutputStream(new File(imagePath));
                    byte[] b = new byte[1024];
                    int length;
                    while ((length = fis.read(b)) != -1) fos.write(b, 0, length);
                    Image image = new Image();
                    image.setImageId(UUID.randomUUID().toString().replace("-", ""));
                    image.setImageUrl(appConfig.getImageUrl() + imageName);
                    flag = myImageService.saveImage(image);
                    if (!flag) {
                        result.setCode(1);
                        return result;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fos != null || fis != null) {
                    try {
                        fos.close();
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (flag) {
                result.setCode(0);
                return result;
            }
        }
        result.setCode(1);
        return result;
    }

    @RequestMapping("/imagePage")
    @ResponseBody
    public Result imagePage(Integer page, Integer limit) {
        Page<Image> pageHelper = PageHelper.startPage(page, limit);
        List<Image> imageList = myImageService.getList();

        Result result = new Result();
        result.setData(imageList);
        return result;
    }

    @RequestMapping("/imageCount")
    @ResponseBody
    public Result imageCount() {
        Result result = new Result();
        result.setData(myImageService.findAll());
        return result;
    }

    @PostMapping("/deleteImage")
    @ResponseBody
    public Result deleteImage(String imageId) {
        Result result = new Result();
        if (myImageService.deleteById(imageId)) {
            result.setMsg("图片删除成功！");
        } else {
            result.setMsg("图片删除失败！请尝试...");
        }
        return result;
    }
}
