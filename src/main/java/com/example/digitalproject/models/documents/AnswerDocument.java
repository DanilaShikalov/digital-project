package com.example.digitalproject.models.documents;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerDocument {
    @Id
    private String id;
    private byte[] bytes;
}
