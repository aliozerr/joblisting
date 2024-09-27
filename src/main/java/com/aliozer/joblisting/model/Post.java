package com.aliozer.joblisting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "JobPost")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    @Id
    private String id = UUID.randomUUID().toString();
    private String profile;
    private String desc;
    private int exp;
    private String[] techs;
}
