package com.oliveyoung.oracle23ai.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@Table("SAMPLE_TABLE")
public class Sample {

    /* getters / setters 생략 (record 로 바꿔도 OK) */
   private String name;

    public Sample(String name) { this.name = name; }

}
