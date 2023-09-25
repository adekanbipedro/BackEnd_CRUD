package br.adk.dao;

import br.adk.domain.Customer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerMapDAO implements ICustomerDAO {
    private Map<Long, Customer> map = new HashMap();

    public CustomerMapDAO() {
    }

    public Boolean register(Customer customer) {
        if (this.map.containsKey(customer.getId())) {
            return false;
        } else {
            this.map.put(customer.getId(), customer);
            return true;
        }
    }

    public void delete(Long id) {
        Customer registeredCustomer = (Customer)this.map.get(id);
        if (registeredCustomer != null) {
            this.map.remove(registeredCustomer.getId(), registeredCustomer);
        }

    }

    public void change(Customer customer) {
        Customer registeredCustomer = (Customer)this.map.get(customer.getId());
        if (registeredCustomer != null) {
            registeredCustomer.setName(customer.getName());
            registeredCustomer.setTel(customer.getTel());
            registeredCustomer.setAdress(customer.getAdress());
            registeredCustomer.setNumber(customer.getNumber());
            registeredCustomer.setCity(customer.getCity());
            registeredCustomer.setState(customer.getState());
        }

    }

    public Customer check(Long id) {
        return (Customer)this.map.get(id);
    }

    public Collection<Customer> showAll() {
        return this.map.values();
    }
}