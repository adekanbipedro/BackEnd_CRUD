package br.adk.dao;
import br.adk.domain.Customer;
import java.util.Collection;

public interface ICustomerDAO {
    Boolean register(Customer var1);

    void delete(Long var1);

    void change(Customer var1);

    Customer check(Long var1);

    Collection<Customer> showAll();
}
