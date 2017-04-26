package module.creator;

import application.GlobalParameter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by ercan on 26.04.2017.
 */
public class LetterLimitedCreator extends Creator {
    private int letterLimit;
    private String forbiddenChars = "oO1234567890";

    public LetterLimitedCreator(SentenceLoader sentenceLoader, int letterLimit){
        this.sentenceLoader = sentenceLoader;
        this.letterLimit = letterLimit;
    }

    public void createFile() {
        try{
            PrintWriter writer = new PrintWriter(GlobalParameter.filenameMap.get("source_file"), "UTF-8");
            List<List<String>> sentences = sentenceLoader.getTokenListsForSentences();

            for(List<String> tokens: sentences){
                for(String token: tokens){
                    if(checkAcceptance(token)){
                        if(token.length() > letterLimit){
                            writer.print(token.substring(0, letterLimit) + " ");
                        } else {
                            writer.print(token + " ");
                        }
                    }
                }
                writer.print(".");
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean checkAcceptance(String token){
        if(token.length() > 1){
            return true;
        } else if(forbiddenChars.contains(token)){
            return true;
        }
        return false;
    }


}
