package com.estudo.mongo.Api_StudentManager.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "students")
public class Student {

    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String registration;
    @Indexed(unique = true)
    private String cpf;
}
