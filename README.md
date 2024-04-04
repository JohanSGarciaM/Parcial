# Parcial Práctico Segundo Tercio AREP

---

## Johan Sebastian Garcia Martinez

---

### Requerimientos para la implementación del laboratorio completo

- Maven
- Java
- Spark
- Git
- Amazon Web Services

--- 

### Funcionalidades

El objetivo principal de este proyecto es realizar un servicio REST de Operaciones matemáticas, la cual recibe como parámetro un número y entrega el resultado de sus factores o tambien puede entregar como resultado en formato JSON los números primos mejores que el número entregado, este servicio va a ser solicitado por un ServiceProxy de manera balanceada , repartiendo la carga a las instancias existentes dentro del sistema, además de un browser sencillo a modo de formulario que va a capturar la información ingresada por el usuario, este proyecto se verá desplegado en instancias EC2 de AWS

---

## Preparación

### Obtener el código del proyecto
Debemos clonar el repositorio a la máquina local con el siguiente comando:
```bash
git clone https://github.com/JohanSGarciaM/Parcial.git
```

### Ubicar el proyecto
Nos ubicamos en la carpeta /Parcial
```bash
cd Parcial
```

### Compilar el proyecto
Ahora compilamos el proyecto para que se generen los archivos de clase correspondientes con el siguiente comando:
```bash
mvn clean install
```

## Ejecución en Local
Para realizar la ejecución de los servicios desde la linea de comandos debemos apuntar el comando de ejecución a la clase principal de cada servicio, teniendo en cuenta que esto se hace en terminales diferentes para cada instancia, de la siguiente manera:

### Para MathService
```bash
java -cp "target/classes;target/dependency/*" edu.escuelaing.mathservice.MathService
```
### Para ServiceProxy
```bash
java -cp "target/classes;target/dependency/*" edu.escuelaing.mathservice.ServiceProxy
```
**Tener en cuenta que estos códigos son funcionales para windows, en caso de utilizar SO linux, utilizar los siguientes códigos respectivamente**
```bash
java -cp "target/classes:target/dependency/*" edu.escuelaing.mathservice.MathService
```
### Para ServiceProxy
```bash
java -cp "target/classes:target/dependency/*" edu.escuelaing.mathservice.ServiceProxy
```

## Imagen del servidor de servicio MathService corriendo
![](/MathService/demo/resources/runmathservice.png)

## Imagen del servidor de servicio ServiceProxy corriendo
![](/MathService/demo/resources/runserviceproxy.png)

---

Una vez tenemos corriendo los servidores podemos hacer llamados directos al servicio **Math Service** para poder identificar que la ruta especificada entrega la respuesta esperada dado el valor que se ingresa como parámetro, con la siguiente dirección:

### Para probar el servicio de factores

Ingresamos como parámetro en la variable "value" el número que deseamos evaluar: por ejemplo para averiguar los factores del número 100:

```bash
localhost:5001/factors?value=100
```

**Obtendrémos la siguiente respuesta:**
![](/MathService/demo/resources/factors.png)

### Para probar el servicio de primos

Ingresamos como parámetro en la variable "value" el número que deseamos evaluar: por ejemplo para averiguar los números primos menores del número 100:

```bash
localhost:5001/primes?value=100
```

**Obtendrémos la siguiente respuesta:**
![](/MathService/demo/resources/primes.png)

Con esto comprobamos la efectividad de las respuestas del servicio MathService

Ahora una vez tenemos corriendo los servidores podemos hacer llamado al formulario entrando a un browser de preferencia y buscando la siguiente dirección:

```bash
localhost:4567/form.html
```

Obtendremos como respuesta el formulario con el cuál podremos ingresar los valores:

![](/MathService/demo/resources/form.png)


## Ejecución en AWS

## Video

## Autor

Johan Sebastian Garcia Martinez


