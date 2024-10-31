//package top.guke.springboot.task.jobs;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import top.guke.springboot.task.entity.StockPrice;
//import top.guke.springboot.task.mapper.StockPriceMapper;
//
//import java.time.LocalDateTime;
//import java.util.Random;
//
////@Component
//@AllArgsConstructor
//@Slf4j
//public class StockPriceTask {
//    private final StockPriceMapper stockPriceMapper;
//
//    private final Random random = new Random();
//
//    @Scheduled(fixedRate = 5000)
//    public void updateStockPrice() {
//        double price = 100 + random.nextDouble() * 50;
//        double roundedValue = Math.round(price * 100) / 100.0;
//
//        StockPrice stockPrice = new StockPrice();
//        stockPrice.setPrice(price);
//        stockPrice.setName("小米");
//        stockPrice.setUpdateTime(LocalDateTime.now());
//
//        stockPriceMapper.insert(stockPrice);
//        log.info("股票价格已更新：{}，时间：{}", roundedValue, LocalDateTime.now());
//    }
//}