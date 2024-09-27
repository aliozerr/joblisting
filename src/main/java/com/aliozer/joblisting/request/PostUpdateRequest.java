package com.aliozer.joblisting.request;

import lombok.Data;

@Data
public class PostUpdateRequest {
    private String profile;
    private String desc;
    private int exp;
    private String[] techs;
}
