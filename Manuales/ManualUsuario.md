![imagen](https://github.com/DFacundoPerezN/-OLC1-Proyecto1_202106538/assets/98927736/ec778987-c3b8-4261-ae47-12cbdb70187c)# Manual de Usuario
### Descripción
Este proyecto tiene los propósitos de generación de reportes estadísticos y traducción de código de StatPy a Python. Para lograr esto, se utilizarán dos analizadores diferentes: uno para analizar archivos JSON y otro para traducir el código StatPy y generar reportes estadísticos

## Funcionamiento

Al momento de abrir el programa saldra una interfaz la cual estar conformada por 1 Area de manejo de Archivos, 1 seleccion del analizador 3 botones, 1 entrada de texto y 2 Areas de Texto.
![imagen](https://github.com/DFacundoPerezN/-OLC1-Proyecto1_202106538/assets/98927736/172b8587-922d-4351-9929-827a9f4c072b)



## Opciones de Guardado y Edición de Archivo
Primeramente, se deberá llenar la entrada de texto de arriba con la ubicación y nombre del archivo que deseemos abrir, esto se puede hacer manualmente o automáticamente con el botón de “Abrir" en la seccion de "Archivo” el cual abrirá el explorador de archivos.
![imagen](https://github.com/DFacundoPerezN/-OLC1-Proyecto1_202106538/assets/98927736/0b05f505-68bd-4a72-8ec0-8ba4cbdcb99c)
Al darle en “Abrir” copiara la ruta del archivo en la entrada en la entrada de texto. 
A su vez imprimiria la informacion del archivo en el Area de Texto de la izquierda.
![imagen](https://github.com/DFacundoPerezN/-OLC1-Proyecto1_202106538/assets/98927736/71dda02c-0d2a-4e91-b8af-97c994656a36)


Para guardar el archivo que se esta editando en el área de texto del lado izquierdo se cuentan con los botones de “Guardar Archivo” y “Guardar Como:”  
![imagen](https://github.com/DFacundoPerezN/-OLC1-Proyecto1_202106538/assets/98927736/c6244a9d-6cc0-43d4-a5d6-731496b11573)
La diferencia es que el botón de “Guardar Archivo” guarda la información reescribiendo el archivo que se abrió mientras que “Guardar  Como: ” usa la barra de texto a su derecha para darle nombre al archivo que se guardara.

## Edición del Archivo
Se puede editar solo en el área de texto de la izquierda.
![imagen](https://github.com/DFacundoPerezN/-OLC1-Proyecto1_202106538/assets/98927736/2df5b266-d8ee-407d-b01c-b9f708e721e7)


## Reportes
Con el botón de “Reportes” se generarán dos archivos HTML los cuales son tablas de los lexemas que se leen del archivo asi como sus errores lexicos. 
Pero antes se tiene que selecionar el tipo de archivo que se esta analizando.
![imagen](https://github.com/DFacundoPerezN/-OLC1-Proyecto1_202106538/assets/98927736/5b823126-1744-46c0-85f7-541a69c60680)

### Tabla de Tokens/Lexemas
En esta table en HTML se mostraran la tabla de lexemas. 

![imagen](https://github.com/DFacundoPerezN/-OLC1-Proyecto1_202106538/assets/98927736/c7eb77cf-8359-4255-ba66-add528aed100)


### Mostrar Errores
En esta table en HTML se mostraran los errores léxicos. 

![imagen](https://github.com/DFacundoPerezN/-OLC1-Proyecto1_202106538/assets/98927736/f4b12f74-7d2a-495e-8574-073624867ba5)


## Generar Codigo Python
Con el botón "Traducir" se genrara un codigo en python equivalente al codigo en el area de texto de la derecha de StatPy ingresado en el Area de texto de la izquierda.
![imagen](https://github.com/DFacundoPerezN/-OLC1-Proyecto1_202106538/assets/98927736/ff650ddd-a7d5-4ee4-8e1c-1fcca4ec70c5)

En caso de que haya un error en el archivo este mostrara el mensaje de “#Error" en la linea del archivo donde ocurrio el error.

## Generar Graficas
Cuando es presionado el botono "Ejecutar" se abre una ventana en la cual se debe elegir cual boton presionar para que salga una grafica de barras y/o una grafica de Pie.
![imagen](https://github.com/DFacundoPerezN/-OLC1-Proyecto1_202106538/assets/98927736/cbfa2310-9df5-4355-a93d-d82ffea67e1c)
