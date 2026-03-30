package ma.ens.tp8monitoring.service;

import io.micrometer.core.instrument.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SupervisionService {
    private static final Logger log = LoggerFactory.getLogger(SupervisionService.class);

    public String runDataProcessing() {
        Metrics.counter("app.execution.total").increment();
        log.info("Lancement du cycle de traitement");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error("Interruption du flux de travail", e);
        }
        log.info("Cycle de traitement finalise");
        return "Operation reussie";
    }
}
