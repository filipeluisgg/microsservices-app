package com.felipe.hrworker.resources;

import com.felipe.hrworker.entities.Worker;
import com.felipe.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource
{
    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        logger.info("CONFIG = "+ testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        Optional<Worker> worker = repository.findById(id);

        /*
        //The commented code below, can practically test the configured connection time in hr-payroll service.
        try {
            Thread.sleep(3000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        return worker
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
