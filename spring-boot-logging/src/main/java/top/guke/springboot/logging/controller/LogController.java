package top.guke.springboot.logging.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/log")
    public String logDemo() {
      logger.trace("trace log");
      logger.debug("debug log");
      logger.info("info log");
      logger.warn("warn log");
      logger.error("error log");
      return "Logs have been generated!";
    }
}
