CREATE OR REPLACE PACKAGE BODY PC_Venta IS
    PROCEDURE Ad_Venta (xRevisionNumber IN INT,xDueDate IN DATE,xShipDate IN DATE,
                        xStatus IN INT,xOnlineOrderFlag IN VARCHAR2,xSalessOrderNumber IN VARCHAR2,
                        xPurchaseOrder IN VARCHAR2,xAccountNumber IN VARCHAR2,xCustomerID IN INT,
                        xShipMethod IN VARCHAR2,xCreditCardApprovalCode IN VARCHAR2,xFreight IN NUMBER,
                        xCommnt IN VARCHAR2) IS
        BEGIN
            INSERT INTO SalesOrderHeader(RevisionNumber,DueDate,ShipDate,Status,OnlineOrderFlag,SalessOrderNumber,
                                    xPurchaseOrder,AccountNumber,CustomerID,ShipMethod,CreditCardApprovalCode,
                                    Freight,Commnt) VALUES (xRevisionNumber,xDueDate,xShipDate,xStatus,xOnlineOrderFlag,
                                    xSalessOrderNumber,xPurchaseOrder,xAccountNumber,xCustomerID,xShipMethod,
                                    xCreditCardApprovalCode,xFreight,xCommnt);
            COMMIT;
            EXCEPTION
            WHEN OTHERS THEN
                ROLLBACK;
                RAISE_APPLICATION_ERROR(-200001, 'Error al insertar venta');
        END Ad_Venta; 
        
    PROCEDURE El_Venta (xSalesOrderHeaderID IN INT) IS
        BEGIN
            DELETE FROM SalesOrderHeader WHERE (xSalesOrderHeaderID = SalesOrderHeaderID);
            COMMIT;
            EXCEPTION
            WHEN OTHERS THEN
                ROLLBACK;
                RAISE_APPLICATION_ERROR (-20002,'Error al eliminar la venta');
        END El_Venta;
    
      FUNCTION Co_Venta RETURN XMLTYPE IS Co_XML XMLTYPE;
        BEGIN
            Co_XML := dbms_xmlgen.getxmltype(
                'SELECT * FROM SalesOrderHeader'
            );
            RETURN Co_XML;
        END Co_Venta;
END PC_Venta;

CREATE OR REPLACE PACKAGE BODY PC_Modelo IS
    PROCEDURE Ad_Modelo(xName IN VARCHAR2,xCatalogDescription IN VARCHAR2) IS
        BEGIN
            INSERT INTO ProductModel(Name,CatalogDescription) VALUES (xName,xCatalogDescription);
            COMMIT;
            EXCEPTION
            WHEN OTHERS THEN
                ROLLBACK;
                RAISE_APPLICATION_ERROR(-200001, 'Error al insertar el modelo');
        END Ad_Modelo; 
        
    PROCEDURE El_Modelo (xProductModelID IN INT) IS
        BEGIN
            DELETE FROM ProductModel WHERE (xProductModelID = ProductModelID);
            COMMIT;
            EXCEPTION
            WHEN OTHERS THEN
                ROLLBACK;
                RAISE_APPLICATION_ERROR (-20002,'Error al eliminar el modelo');
        END El_Venta;


    PROCEDURE Mo_Modelo (xProductModelID IN INT, xName IN VARCHAR2, xCatalogDescription IN VARCHAR2) IS
        BEGIN
            UPDATE ProductModel SET CatalogDescription = xCatalogDescription,Name = xName WHERE ProductModelID = xProductModelID;
            COMMIT;
            EXCEPTION
            WHEN OTHERS THEN
                ROLLBACK;
                RAISE_APPLICATION_ERROR (-20003,'Error al modificar el modelo.');
        END Mo_Modelo;
        
     FUNCTION Co_Modelo RETURN XMLTYPE IS Co_XML XMLTYPE;
        BEGIN
            Co_XML := dbms_xmlgen.getxmltype(
                'SELECT * FROM ProductModel'
            );
            RETURN Co_XML;
        END Co_Modelo;
END PC_Modelo;
        
        
        
        
        
        
        
        
        
        
        
        
        