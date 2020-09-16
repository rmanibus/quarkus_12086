package org.acme;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@MongoEntity()
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class View extends PanacheMongoEntity {

    public UUID videoId;
    public LocalDateTime createdAt;
}
