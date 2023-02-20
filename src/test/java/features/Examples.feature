Feature: Examples Functional Testing

  @Test1 @All-Local
  Scenario: Iniciar sesión en HerokuApp
    Given Cargo el sitio web HerokuApp
    When Escribo el usuario y password
    Then Valido login exitoso

  @Test2 @All-Local
  Scenario: Busqueda simple en Google
    Given Cargo el sitio web Google
    When Escribo en el input de busqueda
    Then Valido el resultado de la busqueda
