CREATE OR REPLACE PACKAGE BODY PC_Venta IS
    PROCEDURE AD_VENTA (newRevisionNumber IN INT,newDueDate IN DATE,newShipDate IN DATE,
                        newStatus IN INT,newOnlineOrderFlag IN VARCHAR2,newSalessOrderNumber IN VARCHAR2,
                        newPurchaseOrder IN VARCHAR2,newAccountNumber IN VARCHAR2,newCustomerID IN INT,
                        newShipMethod IN VARCHAR2,newCreditCardApprovalCode IN VARCHAR2,newFreight IN NUMBER,
                        newCommnt IN VARCHAR2) IS
        BEGIN
            INSERT INTO SalesOrderHeader VALUES (newRevisionNumber,newDueDate,newShipDate,
                        newStatus,newOnlineOrderFlag,newSalessOrderNumber,
                        newPurchaseOrder,newAccountNumber,newCustomerID,
                        newShipMethod,newCreditCardApprovalCode,newFreight,
                        newCommnt);
            COMMIT;
            EXCEPTION
            WHEN OTHERS THEN
                ROLLBACK;
                RAISE_APPLICATION_ERROR(-200001, 'Error al insertar venta');
        END; 
        
    PROCEDURE EL_VENTA(newSalesOrderHeaderID IN INT) IS
        BEGIN
            DELETE FROM SalesOrderHeader WHERE (newSalesOrderHeaderID = SalesOrderHeaderID);
            COMMIT;
            EXCEPTION
            WHEN OTHERS THEN
                ROLLBACK;
                RAISE_APPLICATION_ERROR (-20002,'Error al eliminar la venta');
        END;
        
     FUNCTION CO_VENTA RETURN XMLTYPE IS CO_XML XMLTYPE;
        BEGIN
            CO_XML := dbms_xmlgen.getxmltype(
                'SELECT * FROM SalesOrderHeader'
            );
            RETURN CO_XML;
        END; 
        
    CREATE OR ALTER FUNCTION CO_PRODUCTO RETURN SYS_REFCURSOR IS Product SYS_REFCURSOR;
        BEGIN
            OPEN Product FOR
                SELECT Product.Name, SUM(SalesOrderDetail.OrderQty*SalesOrderDetail.UnitPrice) AS Total_Sale_Value
                FROM Product x JOIN SalesOrderDetail y ON(x.ProductID = y.PrdocutID)
                GROUP BY Product.Name
                ORDER BY Total_Sale_Value DESC
            RETURN Product;
        END;
        
    CREATE OR ALTER FUNCTION CO_MODELO RETURN SYS_REFCURSOR IS ProductModel SYS_REFCURSOR;
        BEGIN
            OPEN ProductModell FOR
                SELECT P.nombre,EXTRACT(Detalle,'/Detalle/Colores/Color') FROM ProductModel
            RETURN ProductModel;
        END;
        
    CREATE OR ALTER FUNCTION CO_EVALUACION RETURN SYS_REFCURSOR IS ProductModel SYS_REFCURSOR;
        BEGIN
            OPEN ProductModell FOR
                SELECT P.Nombre,EXTRACT(Detalle,'/Detalle/evaluaciones[@año = "19" and @calificacion = "5"]') 
                FROM ProductModel P
            RETURN ProductModel;
        END;
END PC_VENTA;

CREATE OR REPLACE PACKAGE BODY PC_MODELO IS
    PROCEDURE AD_MODELO(newName IN VARCHAR2,newCatalogDescription IN VARCHAR2) IS
        BEGIN
            INSERT INTO ProductModel VALUES (newName,newCatalogDescription);
            COMMIT;
            EXCEPTION
            WHEN OTHERS THEN
                ROLLBACK;
                RAISE_APPLICATION_ERROR(-200001, 'Error al insertar el modelo');
        END; 
        
    PROCEDURE MO_MODELO (newProductModelID IN INT, newName IN VARCHAR2, newCatalogDescription IN VARCHAR2) IS
        BEGIN
            UPDATE ProductModel SET CatalogDescription = newCatalogDescription,Name = newName WHERE ProductModelID = newProductModelID;
            COMMIT;
            EXCEPTION
            WHEN OTHERS THEN
                ROLLBACK;
                RAISE_APPLICATION_ERROR (-20003,'Error al modificar el modelo.');
        END;
        
    FUNCTION CO_MODELO RETURN XMLTYPE IS CO_XML XMLTYPE;
        BEGIN
            CO_XML := dbms_xmlgen.getxmltype(
                'SELECT * FROM ProductModel'
            );
            RETURN CO_XML;
        END;
    
    CREATE OR ALTER FUNCTION CO_DESCRIPCION RETURN SYS_REFCURSOR IS ProductModel SYS_REFCURSOR;
        BEGIN
            OPEN ProductModel FOR
                SELECT Description FROM ProductDescription x JOIN
                    ProductModelProductDescription y ON(x.ProductDescriptionID = y.ProductDescriptionID)
                    JOIN ProductModel z ON(y.ProductModelID = z.ProductModelID) JOIN Product w 
                    ON(z.ProductModelID = w.ProductModelID)
                    WHERE ProductID = 736
            RETURN ProductModel;
        END;
    
    CREATE OR ALTER FUNCTION CO_EVALUACION RETURN SYS_REFCURSOR IS ProductModel SYS_REFCURSOR;
        BEGIN
            OPEN ProductModel FOR
                SELECT P.Nombre,EXTRACT(Detalle,'/Detalle/evaluaciones[@año = "19" and @calificacion = "5"]') 
                FROM ProductModel P
            RETURN ProductModel;
        END;
END PC_MODELO;
        
        
        
        
        
        
        
        
        