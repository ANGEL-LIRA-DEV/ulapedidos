# ProductoController

## Guardar
- URL: localhost:8082/api/productos
- Método: POST
- Request:
```json
{
    "nombre": "Piña colada",
    "descripcion": "Bebida natural",
    "precio": 45,
    "stock": 50,
    "urlImagen": "https://ejemplo.jpg",
    "estado": 1,
    "categoria": {
        "idCategoria": 2,
        "nombre": "Bebidas",
        "descripcion": "Bebidas preparadas",
        "estado": 1
    }
}
```

-Response:
```json
{
    "success": true,
    "mensaje": "Producto registrado correctamente",
    "data": {
        "idProducto": 21,
        "nombre": "Piña colada",
        "descripcion": "Bebida natural",
        "precio": 45,
        "stock": 50,
        "urlImagen": "https://ejemplo.jpg",
        "estado": 1,
        "categoria": {
            "idCategoria": 2,
            "nombre": "Bebidas",
            "descripcion": "Bebidas preparadas",
            "estado": 1
        }
    }
}
```

## Listar
- URL: localhost:8082/api/productos
- Método: GET
- Request:

- Response: 
```json
{
    "success": true,
    "mensaje": "Consulta exitosa",
    "data": [
        {
            "idProducto": 1,
            "nombre": "Taco Gobernador",
            "descripcion": "Taco de camarón",
            "precio": 95,
            "stock": 50,
            "urlImagen": "https://i.blogs.es/ba0112/tacos-gobernador/650_1200.jpg",
            "estado": 1,
            "categoria": {
                "idCategoria": 1,
                "nombre": "Tacos",
                "descripcion": "Tacos de mariscos",
                "estado": 1
            }
        },
        {
            "idProducto": 2,
            "nombre": "Agua de Horchata",
            "descripcion": "Bebida natural",
            "precio": 35,
            "stock": 100,
            "urlImagen": "https://media.gq.com.mx/photos/673208b90bd4a888d68a1092/1:1/w_2000,h_2000,c_limit/Horchata.jpg",
            "estado": 1,
            "categoria": {
                "idCategoria": 2,
                "nombre": "Bebidas",
                "descripcion": "Bebidas preparadas",
                "estado": 1
            }
        }
    ]
}
```

## Buscar por Id
- URL: localhost:8082/api/productos/21
- Método: GET
- Request:

- Response:
```json
{
    "success": true,
    "mensaje": "Consulta exitosa",
    "data": {
        "idProducto": 21,
        "nombre": "Piña colada",
        "descripcion": "Bebida natural",
        "precio": 45,
        "stock": 50,
        "urlImagen": "https://ejemplo.jpg",
        "estado": 1,
        "categoria": {
            "idCategoria": 2,
            "nombre": "Bebidas",
            "descripcion": "Bebidas preparadas",
            "estado": 1
        }
    }
}
```

## Actualizar
- URL: localhost:8082/api/productos/21
- Método: PUT
- Request:
```json
{
    "nombre": "Jugo de naranja",
    "descripcion": "Bebida natural",
    "precio": 50,
    "stock": 100,
    "urlImagen": "https://naranjada.jpg",
    "estado": 1,
    "categoria": {
        "idCategoria": 2,
        "nombre": "Bebidas",
        "descripcion": "Bebidas preparadas",
        "estado": 1
    }
}
```

- Response:
```json
{
    "success": true,
    "mensaje": "Stock actualizado correctamente",
    "data": {
        "idProducto": 21,
        "nombre": "Jugo de naranja",
        "descripcion": "Bebida natural",
        "precio": 50,
        "stock": 100,
        "urlImagen": "https://naranjada.jpg",
        "estado": 1,
        "categoria": {
            "idCategoria": 2,
            "nombre": "Bebidas",
            "descripcion": "Bebidas preparadas",
            "estado": 1
        }
    }
}
```

## Eliminar
- URL: localhost:8082/api/productos/21
- Método: DELETE
- Request:

- Response:
```json
{
    "success": true,
    "mensaje": "Producto eliminado correctamente",
    "data": null
}
```