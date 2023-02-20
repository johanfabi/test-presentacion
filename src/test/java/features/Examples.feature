Feature: Búsqueda simple en Google

  Background:
    Given Iniciar sitio web Google

  @Test1 @All-Local
  Scenario: Busqueda simple en Google
    When Escribo en el input de busqueda
    Then Mostrar el resultado de la busqueda