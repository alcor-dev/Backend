package com.example.block5logging;

//Imports importantes o si no no funciona el logger
//Importante usar los imports de SpringFramework
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    //Creamos un logger usando LoggerFactory y cogiendo la propia clase para ello
    Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/test")
    public String index() {
        logger.trace("Mensaje a nivel de TRACE");
        logger.debug("Mensaje a nivel de DEBUG");
        logger.info("Mensaje a nivel de INFO");
        logger.warn("Mensaje a nivel de WARNING");
        logger.error("Mensaje a nivel de ERROR");

        return "Hola! Mira los logs para ver los resultados";
    }
}
