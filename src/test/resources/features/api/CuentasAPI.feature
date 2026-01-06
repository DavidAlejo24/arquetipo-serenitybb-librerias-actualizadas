# language: es
@all
Característica: API de Cuentas de un Cliente

  @cuentasClienteAPI
  Escenario: Revisar todas las cuentas de un cliente
    Dado que hago una consulta a la API de Cuentas de un Cliente
    Cuando obtengo el resultado
    Entonces debe existir por lo menos una cuenta asociada al cliente