# Examen de cambios – Ranking de conductores (RapidExpress)

## Objetivo
Se amplió el módulo de reportes para identificar rápidamente a los conductores con mejor desempeño en entregas dentro de un rango de fechas, mostrando un Top 3 ordenado por cantidad de paquetes entregados.

## Cambios principales
- **Nuevo DTO** `ConductorDesempeno` (`model/entity`): estructura ligera para exponer id, nombre, total de entregas y posición en el ranking.
- **ConductorDAO**: se añadió `obtenerTopConductoresPorEntregas(fechaInicio, fechaFin, limite)` con una consulta agrupada que cuenta paquetes en estado `ENTREGADO` por conductor dentro del rango, ordena de mayor a menor y limita los resultados.
- **ReporteService**: nueva operación `generarTopConductoresPorEntregas` que orquesta la obtención del ranking, arma la salida legible y genera un archivo en `reportes/` con nombre `reporte_top_conductores_<inicio>_a_<fin>.txt`.
- **Interfaz CLI** (`Main`): el menú de reportes incorpora la opción **3. Top conductores por entregas**; solicita fechas de inicio y fin, valida que fin no sea anterior a inicio y delega al servicio.

## Flujo del nuevo reporte
1) El operador ingresa fecha inicio y fin (formato `YYYY-MM-DD`).  
2) El DAO consulta paquetes en estado `ENTREGADO` unidos a sus rutas y conductores, filtrados por la fecha de la hoja de ruta y agrupa por conductor.  
3) El servicio toma los tres primeros (o menos si no hay suficientes), arma el ranking y lo imprime en consola, además de dejar evidencia en `reportes/`.  
4) Si no hay entregas en el periodo, se informa claramente al usuario.

## Consideraciones
- Orden secundario alfabético por nombre para resultados con el mismo volumen de entregas.  
- Se preserva separación de responsabilidades: acceso a datos en DAO, formateo en servicio, captura de entradas en CLI.  
- No se requirieron cambios en el esquema de base de datos.  
- El reporte funciona aunque haya menos de tres conductores con entregas; maneja también el caso sin datos.

