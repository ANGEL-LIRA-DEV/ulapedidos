# ClienteController

## Guardar
- URL: localhost:8082/api/clientes
- Método: POST
- Request:
```json
{
    "nombre": "Ángel",
    "apellido": "Lira",
    "telefono": "222",
    "correo": "ang@mail.com",
    "estado": 1
}
```

-Response:
```json
{
    "success": true,
    "mensaje": "Cliente registrado correctamente",
    "data": {
        "idCliente": 21,
        "nombre": "Ángel",
        "apellido": "Lira",
        "telefono": "222",
        "correo": "ang@mail.com",
        "estado": 1,
        "fechaRegistro": "2026-06-10T13:53:17.0418528"
    }
}
```

## Listar
- URL: localhost:8082/api/clientes
- Método: GET
- Request:

- Response: 
```json
{
    "success": true,
    "mensaje": "Consulta exitosa",
    "data": [
        {
            "idCliente": 1,
            "nombre": "Carlos",
            "apellido": "Sanchez",
            "telefono": "4731305687",
            "correo": "admin@ulamariscos.com",
            "estado": 1,
            "fechaRegistro": "2026-06-09T15:40:38.288742"
        },
        {
            "idCliente": 2,
            "nombre": "Uriel",
            "apellido": "Gonzalez",
            "telefono": "5531305687",
            "correo": "uriel@ulamariscos.com",
            "estado": 1,
            "fechaRegistro": "2026-06-09T15:40:38.43185"
        }
    ]
}
```

## Buscar por Id
- URL: localhost:8082/api/clientes/1
- Método: GET
- Request:

- Response:
```json
{
    "success": true,
    "mensaje": "Consulta exitosa",
    "data": {
        "idCliente": 1,
        "nombre": "Carlos",
        "apellido": "Sanchez",
        "telefono": "4731305687",
        "correo": "admin@ulamariscos.com",
        "estado": 1,
        "fechaRegistro": "2026-06-09T15:40:38.288742"
    }
}
```

## Actualizar
- URL: 
- Método: PUT
- Request:
```json
{
    "nombre": "Ángel",
    "apellido": "Hernández",
    "telefono": "795",
    "correo": "angel_lira@mail.com",
    "estado": 1
}
```

- Response:
```json
{
    "success": true,
    "mensaje": "Cliente actualizado correctamente",
    "data": {
        "idCliente": 21,
        "nombre": "Ángel",
        "apellido": "Hernández",
        "telefono": "795",
        "correo": "angel_lira@mail.com",
        "estado": 1,
        "fechaRegistro": "2026-06-10T13:53:17.041853"
    }
}
```

## Eliminar
- URL: localhost:8082/api/clientes/21
- Método: DELETE
- Request:

- Response:
```json
{
    "success": true,
    "mensaje": "Cliente eliminado correctamente",
    "data": null
}
```