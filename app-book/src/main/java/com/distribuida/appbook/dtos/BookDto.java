package com.distribuida.appbook.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {

    private Integer id;
    private String isbn;
    private String title;
    private BigDecimal price;
    private String authorName;


}
