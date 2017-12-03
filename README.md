# Mutantes - Humanos.
> <b>Version: 0.0.1</b>

-   Sistema que detecta si un humano es mutante basándose en su secuencia de ADN.

> <b>Indicaciones :</b>

-   Tener instalado: JVM con JDK 1.8
-	Tener maven instalado para instalar dependencias
-   Contar con una instancia a MongoDB (si se quiere ejecutar en forma local modificar archivo application.properties)
 
> <b>Uso:</b>

-   Para iniciar la aplicación, primero se deberan de cumplir con las instrucciones anteriores. 
	Se debera ejecutar la clase principal MutantesApp  y esperar hasta que se inicie la aplicación.

Puede ejecutarlo usando el siguiente comando en la línea de comando:

mvn spring-boot: ejecutar


-   Se crea en mlba una bd mongoDB 

    mongodb://mongoDbmeli:mongomeli@ds119446.mlab.com:19446/mutantsmeli
    
-   Se agrega el complemento Postman a google chrome

        

## API URL

https://meli-mutants.herokuapp.com/


## Datos de prueba

Request: 
- POST https://meli-mutants.herokuapp.com/mutant

Request body:

```javascript
  {"dna":["ATGCGA", "CAGGGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]}
```

Response:

```javascript
  200 OK
```
Request body:

```javascript
  {"dna":["ATGCCA", "CAGGGC", "TTATCT", "AGAAAG", "CCCCTA", "TCACTG"]}
```

Response:

```javascript
  403 Forbidden
```
Request body:

```javascript
  {"dna":["ATGCCA", "CAGGGC", "TTATCT", "AGAAAG", "CCCCTA", "TCACAG"]}
```

Response:

```javascript
  403 Forbidden
```

Request body:

```javascript
  {"dna":["ATGCGA", "CAGGGC", "TTATGT", "AGAAGG", "CCCCTA", "XCACTG"]}
```

Response: (Letter Wrong)

```javascript
  403 Forbidden
```

## Datos de prueba 

Request: 
- GET http://meli-mutants.herokuapp.com/stats

Response: 200 (application/json)

```javascript
{
    "count_mutant_dna": 1,
    "count_human_dna": 2,
    "ratio": 0.5
}

-----

> <b> Tecnologías utilizadas </b>
*   Java
*   Maven
*   Spring boot
*   JUnit
*   MongoDB
*   GitHub

> <b>Consideracion</b>


-   Segun el enunciado se pueden ingresar:  
-   1) Las letras de los Strings: (A,T,C,G), las cuales representa cada base nitrogenada del ADN.	
			En caso de ingresar cualquier letra no considerada del ADN se envia un HTTP 403 - Forbidden y este no es tenido en cuenta
			a la hora de obtener la cantidad de mutantes, humanos y ratio.


   
> <b>Desarrollador</b>
-   Paola Alejandra Cabrera:  paola_a_cabrera@hotmail.com
    

						 					


