package customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Represents farm customers info
 *
 */
public class CustomersInfo {
    private double payment  = 0;
    public static List<Customer> cust = new ArrayList<>();

    public List<VipCustomer> getVipCustomers() {
        return cust
                .stream()
                .collect(Collectors.groupingBy(Customer::getName))
                .entrySet().stream()
                .filter(c -> c.getValue().size() > 1)
                .flatMap(c -> c.getValue().stream())
                .filter(distinctByKey(p -> p.getName()))
                .map(c -> new VipCustomer(c.getName(), getOverallCustomerPayment(c), c.getBought()))
                .collect(Collectors.toList());
    }
    public double getOverallCustomerPayment(Customer cus) {
        this.payment = 0;
        for (int i = 0; i < cust.size(); i++) {
            if(cust.get(i).getName().equals(cus.getName())) {
                this.payment = payment + cus.getPayment();
            }
        }
        return payment;
    }
    public static <T>Predicate<T> distinctByKey(Function<? super T, Object> key) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(key.apply(t), Boolean.TRUE) == null;
    }
    public List<Customer> getMostValuableCustomers() {
        return cust
                .stream()
                .filter(c -> c.getPayment() > getAveragePayment())
                .collect(toList());
    }
    public double getAveragePayment() {
        return cust
                .stream()
                .collect(Collectors.averagingDouble(c -> c.getPayment()));
    }
    public Customer getLastPayment() {
        return cust.get(cust.size()-1);
    }
}
