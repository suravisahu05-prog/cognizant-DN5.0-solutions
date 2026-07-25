-- Scenario 1: UpdateCustomerLastModified - auto-update LastModified on any update
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/


-- Scenario 2: LogTransaction - insert into AuditLog whenever a transaction is added
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (log_id, transaction_id, log_message, log_date)
    VALUES (audit_log_seq.NEXTVAL, :NEW.transaction_id,
            'New transaction of amount ' || :NEW.amount || ' recorded', SYSDATE);
END;
/


-- Scenario 3: CheckTransactionRules - enforce withdrawal/deposit rules before insert
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    IF :NEW.type = 'WITHDRAWAL' AND :NEW.amount > :NEW.balance THEN
        RAISE_APPLICATION_ERROR(-20010, 'Withdrawal amount exceeds available balance');
    END IF;

    IF :NEW.type = 'DEPOSIT' AND :NEW.amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20011, 'Deposit amount must be positive');
    END IF;
END;
/
