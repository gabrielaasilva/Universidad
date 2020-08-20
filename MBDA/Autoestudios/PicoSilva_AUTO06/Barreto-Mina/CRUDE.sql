CREATE OR REPLACE PACKAGE PC_Venta IS
    PROCEDURE Ad_Venta (xRevisionNumber IN INT,xDueDate IN DATE,xShipDate IN DATE,
                        xStatus IN INT,xOnlineOrderFlag IN VARCHAR2,xSalessOrderNumber IN VARCHAR2,
                        xPurchaseOrder IN VARCHAR2,xAccountNumber IN VARCHAR2,xCustomerID IN INT,
                        xShipMethod IN VARCHAR2,xCreditCardApprovalCode IN VARCHAR2,xFreight IN NUMBER,
                        xCommnt IN VARCHAR2);
    PROCEDURE El_Venta (xSalesOrderHeaderID IN INT);
    FUNCTION Co_Venta RETURN XMLTYPE;
END PC_Venta;

CREATE OR REPLACE PACKAGE PC_Modelo IS
    PROCEDURE Ad_Modelo (xName IN VARCHAR2,xCatalogDescription IN VARCHAR2);
    PROCEDURE El_Modelo (xProductModelID IN INT);
    PROCEDURE Mo_Modelo (xProductModelID IN INT, xName IN VARCHAR2, xCatalogDescription IN VARCHAR2);
    FUNCTION Co_Modelo RETURN XMLTYPE;
END PC_Modelo;