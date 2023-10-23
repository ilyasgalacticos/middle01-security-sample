package kz.bitlab.middle.middlesecurity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemDto {

    private Long id;
    private String name;
    private double price;
    private int amount;

}
