package top.myideas.utils;

import java.util.UUID;

public class GeneratorID {
       public static String getID() {
    	 return   UUID.randomUUID().toString().replace("-", "");
       }
}
