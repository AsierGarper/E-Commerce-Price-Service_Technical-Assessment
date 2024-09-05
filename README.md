E-Commerce Price Service - Technical Assessment

Capitole's Technical Assessment for a Backend developer position with Java and Spring Boot.

Instructions:

In the company's e-commerce database we have the PRICES table that reflects the final price (pvp) and the rate that applies to a product of a chain between certain dates. Below is an example of the table with the relevant fields:

PRICES
-------  

BRAND_ID START_DATE END_DATE PRICE_LIST PRODUCT_ID PRIORITY PRICE CURR
----------------------------------------------------------------------------------------------------------------- ----------------------------------------------------------------------------------------------------------------- --------  
1 2020-06-14-00.00.00 2020-12-31-23.59.59 1 35455 0 35.50 EUR  
1 2020-06-14-15.00.00.00 2020-06-14-18.30.00 2 35455 1 25.45 EUR  
1 2020-06-15-00.00.00.00 2020-06-15-11.00.00.00 3 35455 1 30.50 EUR  
1 2020-06-15-16.00.00.00 2020-12-31-23.59.59 4 35455 1 38.95 EUR

Fields:

BRAND_ID: foreign key of the group string (1 = ZARA).  
START_DATE , END_DATE: date range in which the indicated price applies.  PRICE_LIST: Identifier of the applicable price list.  
PRODUCT_ID: Product code identifier.  
PRIORITY: Price application disambiguator. If two prices coincide in a date range, the one with higher priority (higher numerical value) is applied.  
PRICE: final selling price.  
CURR: currency iso.

Request:

Build an application/service in SpringBoot that provides a query end point rest such that:

Accept as input parameters: application date, product identifier, string identifier.  
Return as output data: product identifier, string identifier, rate to apply, application dates and final price to apply.

Use an in-memory database (type h2) and initialize with the data of the example, (you can rename the fields and add new ones if you want, choose the data type you consider appropriate for them).

Develop some tests to the rest endpoint that validate the following requests to the service with the data of the example:

- Test 1: request at 10:00 on day 14 of product 35455 for brand 1 (ZARA) - Test 2: request at 16:00 on day 14 of product 35455 for brand 1 (ZARA) - Test 3: request at 21:00 on day 14 of product 35455 for brand 1 (ZARA) - Test 4: request at 10:00 on day 15 of product 35455 for brand 1 (ZARA) - Test 5: request at 21:00 on day 16 of product 35455 for brand 1 (ZARA).

The following will be assessed:

Design and construction of the service.  
Code quality.  
Correct test results.


//////////////////////////SPANISH VERSION/////////////////////////////
E-Commerce Price Service - Evaluación Técnica

Evaluación Técnica de Capitole para un puesto de desarrollador Backend con Java y Spring Boot.

Instrucciones:
En la base de datos de comercio electrónico de la compañía disponemos de la tabla  PRICES que refleja el precio final (pvp) y la tarifa que aplica a un producto de una cadena  entre unas fechas determinadas. A continuación se muestra un ejemplo de la tabla con  los campos relevantes:

PRICES
-------  

BRAND_ID START_DATE END_DATE PRICE_LIST  PRODUCT_ID PRIORITY PRICE CURR
----------------------------------------------------------------------------------------------------------------- ----------------------------------------------------------------------------------------------------------------- --------  
1 2020-06-14-00.00.00 2020-12-31-23.59.59 1 35455  0 35.50 EUR  
1 2020-06-14-15.00.00 2020-06-14-18.30.00 2 35455  1 25.45 EUR  
1 2020-06-15-00.00.00 2020-06-15-11.00.00 3 35455  1 30.50 EUR  
1 2020-06-15-16.00.00 2020-12-31-23.59.59 4 35455  1 38.95 EUR

Campos:

BRAND_ID: foreign key de la cadena del grupo (1 = ZARA).  
START_DATE , END_DATE: rango de fechas en el que aplica el precio tarifa indicado.  PRICE_LIST: Identificador de la tarifa de precios aplicable.  
PRODUCT_ID: Identificador código de producto.  
PRIORITY: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago  de fechas se aplica la de mayor prioridad (mayor valor numérico).  
PRICE: precio final de venta.  
CURR: iso de la moneda.

Se pide:

Construir una aplicación/servicio en SpringBoot que provea una end point rest de  consulta tal que:

Acepte como parámetros de entrada: fecha de aplicación, identificador de producto,  identificador de cadena.  
Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa  a aplicar, fechas de aplicación y precio final a aplicar.

Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del  ejemplo, (se pueden cambiar el nombre de los campos y añadir otros nuevos si se quiere,  elegir el tipo de dato que se considere adecuado para los mismos).

Desarrollar unos test al endpoint rest que validen las siguientes peticiones al servicio con  los datos del ejemplo:

- Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)  - Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)  - Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)  - Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)  - Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)

Se valorará:

Diseño y construcción del servicio.  
Calidad de Código.  
Resultados correctos en los test. 
