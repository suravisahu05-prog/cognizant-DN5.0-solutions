-- Scenario 1: GenerateMonthlyStatements - explicit cursor over current month's transactions
DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT t.transaction_id, t.account_id, t.amount, t.transaction_date, c.name
        FROM Transactions t
        JOIN Accounts a ON t.account_id = a.account_id
        JOIN Customers c ON a.customer_id = c.customer_id
        WHERE EXTRACT(MONTH FROM t.transaction_date) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM t.transaction_date) = EXTRACT(YEAR FROM SYSDATE);

    v_rec GenerateMonthlyStatements%ROWTYPE;
BEGIN
    OPEN GenerateMonthlyStatements;
    LOOP
        FETCH GenerateMonthlyStatements INTO v_rec;
        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Statement - Customer: ' || v_rec.name ||
                              ', Account: ' || v_rec.account_id ||
                              ', Amount: ' || v_rec.amount ||
                              ', Date: ' || v_rec.transaction_date);
    END LOOP;
    CLOSE GenerateMonthlyStatements;
END;
/


-- Scenario 2: ApplyAnnualFee - explicit cursor deducting a fee from all accounts
DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT account_id, balance FROM Accounts;

    v_rec ApplyAnnualFee%ROWTYPE;
    v_fee CONSTANT NUMBER := 50; -- flat annual maintenance fee
BEGIN
    OPEN ApplyAnnualFee;
    LOOP
        FETCH ApplyAnnualFee INTO v_rec;
        EXIT WHEN ApplyAnnualFee%NOTFOUND;

        UPDATE Accounts
        SET balance = balance - v_fee
        WHERE account_id = v_rec.account_id;

        DBMS_OUTPUT.PUT_LINE('Annual fee deducted from account: ' || v_rec.account_id);
    END LOOP;
    CLOSE ApplyAnnualFee;
    COMMIT;
END;
/


-- Scenario 3: UpdateLoanInterestRates - explicit cursor updating rates based on new policy
DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT loan_id, interest_rate FROM Loans;

    v_rec UpdateLoanInterestRates%ROWTYPE;
    v_new_policy_rate CONSTANT NUMBER := 7.5; -- example new policy rate
BEGIN
    OPEN UpdateLoanInterestRates;
    LOOP
        FETCH UpdateLoanInterestRates INTO v_rec;
        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        UPDATE Loans
        SET interest_rate = v_new_policy_rate
        WHERE loan_id = v_rec.loan_id;

        DBMS_OUTPUT.PUT_LINE('Loan ID ' || v_rec.loan_id || ' updated to new rate: ' || v_new_policy_rate);
    END LOOP;
    CLOSE UpdateLoanInterestRates;
    COMMIT;
END;
/
