-- Scenario 1: SafeTransferFunds - transfer between accounts with rollback on error
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check sender's balance
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_from_account;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in account ' || p_from_account);
    END IF;

    -- Deduct from sender
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account;

    -- Add to receiver
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer successful: ' || p_amount || ' from ' || p_from_account || ' to ' || p_to_account);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO error_log (log_id, error_message, log_date)
        VALUES (error_log_seq.NEXTVAL, SQLERRM, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/


-- Scenario 2: UpdateSalary - increase salary by percentage, handle missing employee
CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) AS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM employees
    WHERE employee_id = p_employee_id;

    IF v_count = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Employee ID ' || p_employee_id || ' does not exist');
    END IF;

    UPDATE employees
    SET salary = salary + (salary * p_percentage / 100)
    WHERE employee_id = p_employee_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated for employee ID: ' || p_employee_id);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO error_log (log_id, error_message, log_date)
        VALUES (error_log_seq.NEXTVAL, SQLERRM, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Salary update failed: ' || SQLERRM);
END;
/


-- Scenario 3: AddNewCustomer - insert customer, prevent duplicate ID
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2
) AS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM customers
    WHERE customer_id = p_customer_id;

    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'Customer ID ' || p_customer_id || ' already exists');
    END IF;

    INSERT INTO customers (customer_id, name)
    VALUES (p_customer_id, p_name);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_customer_id);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO error_log (log_id, error_message, log_date)
        VALUES (error_log_seq.NEXTVAL, SQLERRM, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Insert failed: ' || SQLERRM);
END;
/
