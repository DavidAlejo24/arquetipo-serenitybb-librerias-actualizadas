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
    #Entonces valida que se vea la pantalla de token
    #When el go to the Prometheus website
    #Then el validate that the browser is opened and the website is loaded

  @userIncorrecto
  Escenario: Intentar acceder a Produnet con usuario incorrecto
    Dado que el Cliente abre la Produnet web
    Cuando ingresa su usuario incorrecto
    Entonces valida se muestre un mensaje de error de usuario


  @contrasenaIncorrecta
  Escenario: Intentar acceder a Produnet con contraseña incorrecta
    Dado que el Cliente abre la Produnet web
    Cuando ingresa su contraseña incorrecta
    Entonces valida se muestre un mensaje de error de usuario
