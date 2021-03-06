package module.creator;

import application.GlobalParameter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by ercan on 26.04.2017.
 */
public class DefaultCreator extends Creator {

    public DefaultCreator(SentenceLoader sentenceLoader){
        this.sentenceLoader = sentenceLoader;
    }

    public void createFile() {
        try{
            PrintWriter writer = new PrintWriter(GlobalParameter.filenameMap.get("source_file"), "UTF-8");
            List<List<String>> sentences = sentenceLoader.getTokenListsForSentences();

            for(List<String> tokens: sentences){
                for(String token: tokens){
                    writer.print(token + " ");
                }
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
