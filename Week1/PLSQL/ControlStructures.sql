-- Scenario 1: Apply 1% discount to loan interest rates for customers above 60
BEGIN
    FOR cust_rec IN (SELECT customer_id, age FROM customers) LOOP
        IF cust_rec.age > 60 THEN
            UPDATE loans
            SET interest_rate = interest_rate - (interest_rate * 0.01)
            WHERE customer_id = cust_rec.customer_id;

            DBMS_OUTPUT.PUT_LINE('Discount applied to customer ID: ' || cust_rec.customer_id);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Set IsVIP = TRUE for customers with balance over $10,000
BEGIN
    FOR cust_rec IN (SELECT customer_id, balance FROM customers) LOOP
        IF cust_rec.balance > 10000 THEN
            UPDATE customers
            SET is_vip = 1
            WHERE customer_id = cust_rec.customer_id;

            DBMS_OUTPUT.PUT_LINE('Customer ID ' || cust_rec.customer_id || ' promoted to VIP');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Print reminders for loans due within next 30 days
BEGIN
    FOR loan_rec IN (
        SELECT loan_id, customer_id, due_date
        FROM loans
        WHERE due_date BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_rec.loan_id ||
                              ' for Customer ID ' || loan_rec.customer_id ||
                              ' is due on ' || loan_rec.due_date);
    END LOOP;
END;
/
