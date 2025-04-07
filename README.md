Tienda Tecnologica - Sistema de gestion de dispositivos electronicos.
Proyecto de Jose Luis Calfueque
1)Descripción:
Este programa simula un sistema de gestión de dispositivos electrónicos en una tienda, permitiendo:
°Registrar clientes con sus datos personales.
°Agregar dispositivos tecnológicos como computadores, computadoras de escritorio y tablets.
°Realizar compras descontando stock de los dispositivos.
°Buscar dispositivos por marca, modelo o tipo.
°Cambiar dirección de la tienda.
2)Funcionalidades:
°Clientes: Registro y almacenamiento de clientes.
°Dispositivos: Agregar, mostrar y buscar dispositivos por diferentes criterios.
°Compras: Realizar compras y gestionar el carrito de compras.
°Persistencia de datos: Los datos se guardan y cargan desde archivos JSON (clientes.json, dispositivos.json, compras.json).
3)Dependencias
°Gson: Utilizado para la gestión de datos en formato JSON.
°Descargar: Gson JAR
4)Estructura de Archivos
°Main.java: Contiene la lógica principal del programa.
°Tienda.java: Clase que maneja clientes, dispositivos y compras.
°GestorArchivos.java: Clase que maneja la carga y guardado de datos desde archivos JSON.