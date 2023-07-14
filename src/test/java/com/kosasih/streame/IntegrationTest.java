package com.kosasih.streame;

import com.kosasih.streame.StreaMeApp;
import com.kosasih.streame.config.AsyncSyncConfiguration;
import com.kosasih.streame.config.EmbeddedElasticsearch;
import com.kosasih.streame.config.EmbeddedKafka;
import com.kosasih.streame.config.EmbeddedSQL;
import com.kosasih.streame.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { StreaMeApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}
