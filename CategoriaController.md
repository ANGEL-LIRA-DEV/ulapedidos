# CategoriaController

## Guardar
- URL: localhost:8082/api/categorias
- Método: POST
- Request:
```json
{
    "nombre": "Sushi",
    "descripcion": "Pescado cortado estilo Japonés",
    "estado": 1
}
```

-Response:
```json
{
    "success": true,
    "mensaje": "Categoria registrada correctamente",
    "data": {
        "idCategoria": 21,
        "nombre": "Sushi",
        "descripcion": "Pescado cortado estilo Japonés",
        "estado": 1
    }
}
```

## Listar
- URL: localhost:8082/api/categorias
- Método: GET
- Request:

- Response: 
```json
{
    "success": true,
    "mensaje": "Consulta exitosa",
    "data": [
        {
            "idCategoria": 1,
            "nombre": "Tacos",
            "descripcion": "Tacos de mariscos",
            "estado": 1
        },
        {
            "idCategoria": 2,
            "nombre": "Bebidas",
            "descripcion": "Bebidas preparadas",
            "estado": 1
        }
    ]
}
```

## Buscar por Id
- URL: localhost:8082/api/categorias/2
- Método: GET
- Request:

- Response:
```json
{
    "success": true,
    "mensaje": "Consulta exitosa",
    "data": {
        "idCategoria": 2,
        "nombre": "Bebidas",
        "descripcion": "Bebidas preparadas",
        "estado": 1
    }
}
```

## Actualizar
- URL: localhost:8082/api/categorias/21
- Método: PUT
- Request:
```json
{
    "nombre": "Botanas",
    "descripcion": "Botanas de pescado",
    "estado": 1
}
```

- Response:
```json
{
    "success": true,
    "mensaje": "Categoria actualizada correctamente",
    "data": {
        "idCategoria": 21,
        "nombre": "Botanas",
        "descripcion": "Botanas de pescado",
        "estado": 1
    }
}
```

## Eliminar
- URL:localhost:8082/api/categorias/21
- Método:DELETE
- Request:

- Response:
```json
{
    "success": true,
    "mensaje": "Categoria eliminada correctamente",
    "data": null
}
```