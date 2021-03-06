package ch9_specification.verification;

import java.time.LocalDate;

// TODO このクラスはドメインサービスであっている？
public class DelinquentService {

    /**
     * 口座に延滞請求書があるかを判定する
     * @param customer 顧客
     * @return 延滞した請求書があればtrue
     */
    public boolean accountIsDelinquent(Customer customer, LocalDate referenceDate) {
        InvoiceSpecification delinquentSpec = new DelinquentInvoiceSpecification(referenceDate);
        return customer.getInvoices().stream()
                .anyMatch(delinquentSpec::isSatisifiedBy);
    }
}
