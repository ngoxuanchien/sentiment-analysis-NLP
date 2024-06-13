//package hcmus.zingmp3.dataservice;
//
//import hcmus.zingmp3.dataservice.sentiment.SentimentAnalyzer;
//import hcmus.zingmp3.dataservice.sentiment.SentimentResult;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//
//public class SentimentTest {
//
//    @Test
//    void test() throws IOException {
//        String text = "This movie is very good. I love it.";
//
//        SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
////        sentimentAnalyzer.initialize();
//        SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(text);
//
//        System.out.println("Sentiment Score: " + sentimentResult.getSentimentScore());
//        System.out.println("Sentiment Type: " + sentimentResult.getSentimentType());
//        System.out.println("Very positive: " + sentimentResult.getSentimentClass().getVeryPositive()+"%");
//        System.out.println("Positive: " + sentimentResult.getSentimentClass().getPositive()+"%");
//        System.out.println("Neutral: " + sentimentResult.getSentimentClass().getNeutral()+"%");
//        System.out.println("Negative: " + sentimentResult.getSentimentClass().getNegative()+"%");
//        System.out.println("Very negative: " + sentimentResult.getSentimentClass().getVeryNegative()+"%");
//
//    }
//}