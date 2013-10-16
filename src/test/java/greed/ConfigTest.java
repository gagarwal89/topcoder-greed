package greed;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;

public class ConfigTest {
    public static void main(String[] args) {
        Config conf = ConfigFactory.load("test");
        if (conf.hasPath("greed"))
            System.out.println(conf.getConfig("greed").toString());
        System.out.println(conf.getConfig("greed.lang.cpp").resolve().toString());
        Config config = conf.getConfig("greed.templateDefs.testcases.afterGen").resolve();
        for (String s: config.getStringList("arguments")) {
            System.out.println(s);
        }


        conf = ConfigFactory.parseFile(new File(System.getProperty("user.dir") + "/src/main/resources/default.conf")).resolve();
        if (conf.hasPath("greed"))
            System.out.println(conf.getConfig("greed").toString());
    }
}
