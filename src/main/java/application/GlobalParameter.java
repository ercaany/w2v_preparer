package application;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ercan on 26.04.2017.
 */
public class GlobalParameter {
    public static Map<String, Integer> parameterMap;
    public static Map<String, String> filenameMap;

    static {
        parameterMap = new HashMap<String, Integer>();
        parameterMap.put("epoch", 5);
        parameterMap.put("min_word_freq", 1);
        parameterMap.put("iteration", 1);
        parameterMap.put("layer_size", 5);
        parameterMap.put("window_size", 5);
        filenameMap = new HashMap<String, String>();
        filenameMap.put("target_file", "target.txt");
        filenameMap.put("source_file", "source.txt");
    }

}
