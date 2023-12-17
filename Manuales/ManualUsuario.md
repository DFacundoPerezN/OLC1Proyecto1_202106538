# Manual de Usuario
### Descripción
Este proyecto tiene los propósitos de generación de reportes estadísticos y traducción de código de StatPy a Python. Para lograr esto, se utilizarán dos analizadores diferentes: uno para analizar archivos JSON y otro para traducir el código StatPy y generar reportes estadísticos

## Funcionamiento

Al momento de abrir el programa saldra una interfaz la cual estar conformada por 1 Area de manejo de Archivos, 1 seleccion del analizador 3 botones, 1 entrada de texto y 2 Areas de Texto.

![imagen](https://github.com/DFacundoPerezN/OLC1Proyecto1_202106538/assets/98927736/614e19fa-0f19-46f7-b0a3-9384b67e3058)


## Opciones de Guardado y Edición de Archivo
Primeramente, se deberá llenar la entrada de texto de arriba con la ubicación y nombre del archivo que deseemos abrir, esto se puede hacer manualmente o automáticamente con el botón de “Abrir" en la seccion de "Archivo” el cual abrirá el explorador de archivos.

Al darle en “Abrir” copiara la ruta del archivo en la entrada en la entrada de texto. 
A su vez imprimiria la informacion del archivo en el Area de Texto de la izquierda.


Para guardar el archivo que se esta editando en el área de texto del lado izquierdo se cuentan con los botones de “Guardar Archivo”

## Edición del Archivo
Se puede editar solo en el área de texto de la izquierda.


## Reportes
Con el botón de “Reportes” se generarán dos archivos HTML los cuales son tablas de los lexemas que se leen del archivo asi como sus errores lexicos. 
Pero antes se tiene que selecionar el tipo de archivo que se esta analizando.


### Tabla de Tokens/Lexemas
En esta table en HTML se mostraran la tabla de lexemas. 

![imagen](https://github.com/DFacundoPerezN/-OLC1-Proyecto1_202106538/assets/98927736/c7eb77cf-8359-4255-ba66-add528aed100)


### Mostrar Errores
En esta table en HTML se mostraran los errores léxicos. 

![imagen](https://github.com/DFacundoPerezN/-OLC1-Proyecto1_202106538/assets/98927736/f4b12f74-7d2a-495e-8574-073624867ba5)


## Generar Grafos (Generar Automatas)
en la carpeta de reportes hay una carpeta de Thompson y otra de AFD en la cual se encuentran las imagenes de los Automates de cada metodo
![imagen](https://github.com/DFacundoPerezN/OLC1Proyecto1_202106538/assets/98927736/a3649fa2-7c3e-4ddc-8dd5-bd4cf3b8646c)



## Generar Graficas
Cuando es presionado el botono "Ejecutar" se abre una ventana en la cual se debe elegir cual boton presionar para que salga una grafica de barras y/o una grafica de Pie.
![imagen](https://github.com/DFacundoPerezN/-OLC1-Proyecto1_202106538/assets/98927736/cbfa2310-9df5-4355-a93d-d82ffea67e1c)
