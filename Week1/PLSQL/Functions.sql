-- Scenario 1: CalculateAge - returns age in years from date of birth
CREATE OR REPLACE FUNCTION CalculateAge(
    p_dob IN DATE
) RETURN NUMBER
AS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/


-- Scenario 2: CalculateMonthlyInstallment - EMI calculation for a loan
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount IN NUMBER,
    p_annual_interest_rate IN NUMBER,
    p_years IN NUMBER
) RETURN NUMBER
AS
    v_monthly_rate NUMBER;
    v_num_payments NUMBER;
    v_emi NUMBER;
BEGIN
    v_monthly_rate := (p_annual_interest_rate / 100) / 12;
    v_num_payments := p_years * 12;

    -- Standard EMI formula: P * r * (1+r)^n / ((1+r)^n - 1)
    v_emi := (p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_num_payments))
             / (POWER(1 + v_monthly_rate, v_num_payments) - 1);

    RETURN ROUND(v_emi, 2);
END;
/


-- Scenario 3: HasSufficientBalance - returns TRUE/FALSE if account has enough balance
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER,
    p_amount IN NUMBER
) RETURN BOOLEAN
AS
    v_balance NUMBER;
BEGIN
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_account_id;

    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/


-- Test block to demonstrate all three functions
DECLARE
    v_age NUMBER;
    v_emi NUMBER;
    v_sufficient BOOLEAN;
BEGIN
    v_age := CalculateAge(TO_DATE('1995-06-15', 'YYYY-MM-DD'));
    DBMS_OUTPUT.PUT_LINE('Age: ' || v_age);

    v_emi := CalculateMonthlyInstallment(500000, 8.5, 5);
    DBMS_OUTPUT.PUT_LINE('Monthly Installment: ' || v_emi);

    v_sufficient := HasSufficientBalance(101, 5000);
    IF v_sufficient THEN
        DBMS_OUTPUT.PUT_LINE('Account has sufficient balance');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance');
    END IF;
END;
/
