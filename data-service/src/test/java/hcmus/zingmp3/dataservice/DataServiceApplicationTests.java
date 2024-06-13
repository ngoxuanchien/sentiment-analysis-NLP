//package hcmus.zingmp3.dataservice;
//
//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;
//import hcmus.zingmp3.dataservice.dto.SentimentDataDTO;
//import hcmus.zingmp3.dataservice.repository.SentimentDataRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Flux;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//class DataServiceApplicationTests {
//    private final String host = "http://nxc-hcmus.me:8888";
//
//    @Test
//    void loadDataCSV() {
//        String currentWorkingDirectory = System.getProperty("user.dir");
//        System.out.println("Current working directory: " + currentWorkingDirectory);
//        String csvFile = "../data.csv";
//        CSVReader reader = null;
//        try {
//            reader = new CSVReader(new FileReader(csvFile));
//            String[] line;
//            reader.readNext();
//            WebClient webClient = WebClient.builder().build();
//            List<SentimentDataDTO> listSentimentDataDTOS = new ArrayList<>();
//            while ((line = reader.readNext()) != null) {
//                SentimentDataDTO sentimentDataDTO = SentimentDataDTO
//                        .builder()
//                        .review(line[0])
//                        .sentiment(line[1])
//                        .language("English")
//                        .build();
//                listSentimentDataDTOS.add(sentimentDataDTO);
//            }
//            Flux.fromIterable(listSentimentDataDTOS)
//                    .flatMap(sentimentDataDTO -> webClient
//                            .post()
//                            .uri(host + "/api/sentiment-data")
//                            .bodyValue(sentimentDataDTO)
//                            .retrieve()
//                            .bodyToMono(SentimentDataDTO.class)
//                            .doOnNext(sentimentData -> {
//                                System.out.println("Sentiment data created: " + sentimentData.getId());
//                            })
//                    )
//                    .blockLast();
//        } catch (IOException | CsvValidationException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    @Test
//    void loadNegative() {
//        String negativeFile = "../train_negative_tokenized.txt";
//
//        try (BufferedReader br = new BufferedReader(new FileReader(negativeFile))) {
//            String line;
//            WebClient webClient = WebClient.builder().build();
//            List<SentimentDataDTO> sentimentDataDTOList = new ArrayList<>();
//
//            while ((line = br.readLine()) != null) {
//
//                if (line.isEmpty()) {
//                    continue;
//                }
//                SentimentDataDTO sentimentDataDTO = SentimentDataDTO
//                        .builder()
//                        .review(line)
//                        .sentiment("negative")
//                        .language("Vietnamese")
//                        .build();
//                sentimentDataDTOList.add(sentimentDataDTO);
//            }
//            System.out.println(sentimentDataDTOList.size());
//            Flux.fromIterable(sentimentDataDTOList)
//                    .flatMap(sentimentDataDTO -> webClient
//                            .post()
//                            .uri(host + "/api/sentiment-data")
//                            .bodyValue(sentimentDataDTO)
//                            .retrieve()
//                            .bodyToMono(SentimentDataDTO.class)
//                            .doOnNext(sentimentData -> {
//                                System.out.println("Sentiment data created: " + sentimentData.getId());
//                            })
//                    )
//                    .blockLast();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    void loadPositive() {
//        String positiveFile = "../train_positive_tokenized.txt";
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(positiveFile))) {
//            String line;
//            WebClient webClient = WebClient.builder().build();
//            List<SentimentDataDTO> sentimentDataDTOList = new ArrayList<>();
//            while ((line = bufferedReader.readLine()) != null) {
//                if (line.isEmpty()) {
//                    continue;
//                }
//                SentimentDataDTO sentimentDataDTO = SentimentDataDTO
//                        .builder()
//                        .review(line)
//                        .sentiment("positive")
//                        .language("Vietnamese")
//                        .build();
//                sentimentDataDTOList.add(sentimentDataDTO);
//            }
//            System.out.println(sentimentDataDTOList.size());
//            Flux.fromIterable(sentimentDataDTOList)
//                    .flatMap(sentimentDataDTO -> webClient
//                            .post()
//                            .uri(host + "/api/sentiment-data")
//                            .bodyValue(sentimentDataDTO)
//                            .retrieve()
//                            .bodyToMono(SentimentDataDTO.class)
//                            .doOnNext(sentimentData -> {
//                                System.out.println("Sentiment data created: " + sentimentData.getId());
//                            })
//                    )
//                    .blockLast();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    void loadNeutral() {
//        String neutralFile = "../train_neutral_tokenized.txt";
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(neutralFile))) {
//            String line;
//            WebClient webClient = WebClient.builder().build();
//            List<SentimentDataDTO> sentimentDataDTOList = new ArrayList<>();
//            while ((line = bufferedReader.readLine()) != null) {
//                if (line.isEmpty()) {
//                    continue;
//                }
//                SentimentDataDTO sentimentDataDTO = SentimentDataDTO
//                        .builder()
//                        .review(line)
//                        .sentiment("neutral")
//                        .language("Vietnamese")
//                        .build();
//                sentimentDataDTOList.add(sentimentDataDTO);
//            }
//            System.out.println(sentimentDataDTOList.size());
//            Flux.fromIterable(sentimentDataDTOList)
//                    .flatMap(sentimentDataDTO -> webClient
//                            .post()
//                            .uri(host + "/api/sentiment-data")
//                            .bodyValue(sentimentDataDTO)
//                            .retrieve()
//                            .bodyToMono(SentimentDataDTO.class)
//                            .doOnNext(sentimentData -> {
//                                System.out.println("Sentiment data created: " + sentimentData.getId());
//                            })
//                    )
//                    .blockLast();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
