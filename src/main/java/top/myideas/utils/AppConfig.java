package top.myideas.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.TreeMap;

/**
 * @author myideas
 * @data 2019/10/2 - 11:36
 */
@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String images;
    private String imageUrl;
    private TreeMap<Integer, String> channels;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public TreeMap<Integer, String> getChannels() {
        return channels;
    }

    public void setChannels(TreeMap<Integer, String> channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "channels=" + channels +
                '}';
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
