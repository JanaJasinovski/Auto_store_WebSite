package com.auto_store.auto_store.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarkDTO {
    private Integer id;
    private String name;
    private byte[] sign_blob;
}
