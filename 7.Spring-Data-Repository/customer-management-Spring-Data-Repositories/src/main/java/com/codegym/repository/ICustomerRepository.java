package com.codegym.repository;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

//public interface ICustomerRepository extends IGeneralRepository<Customer> {
//}

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Page<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

//    @Query(value = "SELECT u FROM Customers u WHERE u.firstName LIKE :keySearch OR u.lastName LIKE :keySearch  ", nativeQuery = true)
//    Iterable<Customer> searchByAll(@Param("keySearch") String s);

    Page<Customer> findAllByFirstNameContainingOrLastNameContaining(String f, String l);

    Page<Customer> findAllByFirstNameContainingOrLastNameContainingOrIdIsLike(String f, String l,long id);


}