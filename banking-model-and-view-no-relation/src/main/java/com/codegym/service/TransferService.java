package codegym.service;

import com.codegym.model.Transfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransferService implements ITransferService{
    private static final Map<Integer, Transfer> transfers;

    static {
        transfers = new HashMap<>();
        transfers.put(1, new Transfer(1,1,"Na Ho",
                2,"Hoang Tran", 500.0,10, 50.0));
    }
    @Override
    public List<Transfer> findAll() {
        return new ArrayList<>(transfers.values());
    }

    @Override
    public Double totalFeesAmount(){
        List<Transfer> transferList = findAll();
        Double totalFeesAmount = 0.0;
              for (Transfer transfer : transferList) {
                  totalFeesAmount += transfer.getFeesAmount();
              }
        return totalFeesAmount;
    }

}
