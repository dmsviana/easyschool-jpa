package usecases.fees;

import java.util.logging.Level;
import java.util.logging.Logger;

import services.FeeService;

public class UpdateFee {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        FeeService feeService = new FeeService();

        System.out.println(
                "=================== ATUALIZANDO MENSALIDADE =================== \nINFORMAÇÕES DA MESMA ANTES DO UPDATE: \n"
                        + feeService.getFeeById(1L) + "\n");

        try {
            feeService.updateFee(feeService.getFeeById(1L));
            System.out.println(
                    "=================== INFORMAÇÕES DA MESMA APÓS O UPDATE =================== \n: \n"
                            + feeService.getFeeById(1L));
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

    }
    
}
