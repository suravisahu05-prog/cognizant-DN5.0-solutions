-- ================================
-- Package 1: CustomerManagement
-- ================================

-- Package Specification
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddNewCustomer(p_customer_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
    PROCEDURE UpdateCustomerDetails(p_customer_id NUMBER, p_name VARCHAR2, p_balance NUMBER);
    FUNCTION GetCustomerBalance(p_customer_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddNewCustomer(p_customer_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_customer_id);
    END AddNewCustomer;

    PROCEDURE UpdateCustomerDetails(p_customer_id NUMBER, p_name VARCHAR2, p_balance NUMBER) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            Balance = p_balance,
            LastModified = SYSDATE
        WHERE CustomerID = p_customer_id;

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Customer updated: ' || p_customer_id);
    END UpdateCustomerDetails;

    FUNCTION GetCustomerBalance(p_customer_id NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Customers
        WHERE CustomerID = p_customer_id;

        RETURN v_balance;
    END GetCustomerBalance;

END CustomerManagement;
/


-- ================================
-- Package 2: EmployeeManagement
-- ================================

-- Package Specification
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireNewEmployee(p_employee_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2);
    PROCEDURE UpdateEmployeeDetails(p_employee_id NUMBER, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2);
    FUNCTION CalculateAnnualSalary(p_employee_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireNewEmployee(p_employee_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_employee_id, p_name, p_position, p_salary, p_department, SYSDATE);

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_employee_id);
    END HireNewEmployee;

    PROCEDURE UpdateEmployeeDetails(p_employee_id NUMBER, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2) IS
    BEGIN
        UPDATE Employees
        SET Position = p_position,
            Salary = p_salary,
            Department = p_department
        WHERE EmployeeID = p_employee_id;

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Employee updated: ' || p_employee_id);
    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary(p_employee_id NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_employee_id;

        RETURN v_salary * 12;
    END CalculateAnnualSalary;

END EmployeeManagement;
/


-- ================================
-- Package 3: AccountOperations
-- ================================

-- Package Specification
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenNewAccount(p_account_id NUMBER, p_customer_id NUMBER, p_account_type VARCHAR2, p_balance NUMBER);
    PROCEDURE CloseAccount(p_account_id NUMBER);
    FUNCTION GetTotalBalanceAcrossAccounts(p_customer_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenNewAccount(p_account_id NUMBER, p_customer_id NUMBER, p_account_type VARCHAR2, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_account_id, p_customer_id, p_account_type, p_balance, SYSDATE);

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Account opened: ' || p_account_id);
    END OpenNewAccount;

    PROCEDURE CloseAccount(p_account_id NUMBER) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_account_id;

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Account closed: ' || p_account_id);
    END CloseAccount;

    FUNCTION GetTotalBalanceAcrossAccounts(p_customer_id NUMBER) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT NVL(SUM(Balance), 0) INTO v_total
        FROM Accounts
        WHERE CustomerID = p_customer_id;

        RETURN v_total;
    END GetTotalBalanceAcrossAccounts;

END AccountOperations;
/
