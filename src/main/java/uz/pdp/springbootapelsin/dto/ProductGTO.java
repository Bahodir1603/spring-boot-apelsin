package uz.pdp.springbootapelsin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductGTO {
    private String  name;
    private Double price;
    private String photo;
    private String description;
    private Integer catId;
}
