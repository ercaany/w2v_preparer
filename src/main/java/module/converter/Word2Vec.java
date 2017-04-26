package module.converter;

import application.GlobalParameter;
import org.datavec.api.util.ClassPathResource;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;

/**
 * Created by ercan on 26.04.2017.
 */
public class Word2Vec {

    public void run() throws Exception {

        //String filePath = new ClassPathResource().getFile().getAbsolutePath();
        String filePath = GlobalParameter.filenameMap.get("source_file");

        SentenceIterator iterator = new BasicLineIterator(filePath);
        TokenizerFactory t = new DefaultTokenizerFactory();

        t.setTokenPreProcessor(new CommonPreprocessor());

        org.deeplearning4j.models.word2vec.Word2Vec vec = new org.deeplearning4j.models.word2vec.Word2Vec.Builder()
                .minWordFrequency(GlobalParameter.parameterMap.get("min_word_freq"))
                .iterations(GlobalParameter.parameterMap.get("iteration"))
                .layerSize(GlobalParameter.parameterMap.get("layer_size"))
                .seed(42)
                .windowSize(GlobalParameter.parameterMap.get("window_size"))
                .iterate(iterator)
                .tokenizerFactory(t)
                .build();

        vec.fit();

        WordVectorSerializer.writeWordVectors(vec, GlobalParameter.filenameMap.get("target_file"));
    }
}
