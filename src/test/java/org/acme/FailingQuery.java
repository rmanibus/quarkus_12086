package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class FailingQuery {

    Logger logger = LoggerFactory.getLogger(FailingQuery.class.getName());

    @BeforeEach
    public void setup(){
        View.deleteAll();
    }
    @Test
    public void failingQuery() {

        UUID videoId = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();
        View view = new View(videoId, now.minusMinutes(10));
        view.persist();

        long count1 = View.count("createdAt > ?1", now.minusMinutes(2));
        logger.info("count 1: {}", count1);
        assertThat(count1).isEqualTo(0);

        long count2 = View.count("createdAt > ?1 and createdAt < ?2", now.minusMinutes(2), now);
        logger.info("count 2: {}", count2);
        assertThat(count2).isEqualTo(0);


    }

}