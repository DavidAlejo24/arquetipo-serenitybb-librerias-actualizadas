# language: es
@all
Característica: Login - Produnet
  Como cliente de Produnet
  Quiero ingresar a la banca web
  Para gestionar mis productos financieros


  @loginCorrecto
  Escenario: Acceder a Produnet correctamente
    Dado que el Cliente abre la Produnet web
    Cuando ingresa su usuario y contrasenia correctas
    Entonces valida que se vea la pantalla de token

  @restAssuredEj
  Escenario: Probar servicio REST con Rest Assured
      Cuando consulta las habilidades de pokemon con limite y offset
      Entonces el servicio responde exitosamente


  @userIncorrecto
  Escenario: Intentar acceder a Produnet con usuario incorrecto
    Dado que el Cliente abre la Produnet web
    Cuando ingresa su usuario incorrecto
    #Entonces valida se muestre un mensaje de error de usuario


  @contrasenaIncorrecta
  Escenario: Intentar acceder a Produnet con contraseña incorrecta
    Dado que el Cliente abre la Produnet web
    Cuando ingresa su contrasenia incorrecta
    #Entonces valida que se muestre un mensaje de error de contrasenia
