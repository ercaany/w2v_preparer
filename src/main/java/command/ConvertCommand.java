package command;

import module.converter.Word2Vec;

/**
 * Created by ercan on 26.04.2017.
 */
public class ConvertCommand implements Command {

    public boolean execute(String[] parameter) {
        try {
            Word2Vec word2Vec = new Word2Vec();
            word2Vec.run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return false;
        }

        return true;
    }
}
