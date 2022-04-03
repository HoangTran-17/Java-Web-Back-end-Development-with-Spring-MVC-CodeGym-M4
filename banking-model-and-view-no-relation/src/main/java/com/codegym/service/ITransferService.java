package codegym.service;

import com.codegym.model.Transfer;

import java.util.List;

public interface ITransferService {
    List<Transfer> findAll();

    Double totalFeesAmount();
}

