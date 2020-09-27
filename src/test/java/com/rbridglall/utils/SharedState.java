package com.rbridglall.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class SharedState {

    private List<Double> sortedProductPrices;
}
