package ultils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockData {
    private String code;
    private String name;
    private String lastDone;
    private Double change;
    private String vol;

    @Override
    public String toString() {
        return "Data: [Code: " + code + " | Name: " + name + " | Last Done: " + lastDone + " | Change: " + change + " | Vol: " + vol + "]";
    }

}

