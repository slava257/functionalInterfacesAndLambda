package me.slava.safronov;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Stocks {
    private String nameStocks;
    private int incomeAndLossOfTheStock;


    public Stocks(String nameStocks, int incomeAndLossOfTheStock) {
        this.nameStocks = nameStocks;
        this.incomeAndLossOfTheStock = incomeAndLossOfTheStock;
    }

}
