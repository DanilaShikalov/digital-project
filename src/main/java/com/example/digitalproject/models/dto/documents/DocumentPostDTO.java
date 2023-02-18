package com.example.digitalproject.models.dto.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentPostDTO {
    private String description;
    private String documentMongoId;
}
