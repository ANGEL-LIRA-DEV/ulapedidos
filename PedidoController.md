# PedidoController

## Generar pedido
- URL: localhost:8082/api/pedidos
- Método: POST
- Request:
```json
{
  "idCliente": 1,
  "productos": [
    {
      "idProducto": 1,
      "cantidad": 2
    },
    {
      "idProducto": 2,
      "cantidad": 1
    }
  ]
}
```

-Response:
```json
{
    "success": true,
    "mensaje": "Pedido generado correctamente",
    "data": {
        "idPedido": 2,
        "cliente": {
            "idCliente": 1,
            "nombre": "Carlos",
            "apellido": "Sanchez",
            "telefono": "4731305687",
            "correo": "admin@ulamariscos.com",
            "estado": 1,
            "fechaRegistro": "2026-06-09T15:40:38.288742"
        },
        "fechaPedido": "2026-06-10T16:16:30.1054045",
        "total": 225,
        "estadoPedido": "GENERADO",
        "estado": 1,
        "fechaCancelacion": null,
        "detalles": null
    }
}
```

## Cancelar pedido
- URL: localhost:8082/api/pedidos/2
- Método: DELETE
- Request:

- Response: 
```json
{
    "success": true,
    "mensaje": "Pedido cancelado correctamente",
    "data": null
}
```

## Listar por cliente
- URL: localhost:8082/api/pedidos/cliente/1
- Método: GET
- Request:

- Response:
```json
{
    "success": true,
    "mensaje": "Consulta exitosa",
    "data": []
}
```

## Listar todos
- URL: localhost:8082/api/pedidos
- Método: GET
- Request:

- Response:
```json
{
    "success": true,
    "mensaje": "Consulta exitosa",
    "data": []
}
```

## Listar por estado
- URL: localhost:8082/api/pedidos/estado/1
- Método: GET
- Request:

- Response:
```json
{
    "success": true,
    "mensaje": "Consulta exitosa",
    "data": [
        {
            "idPedido": 2,
            "idCliente": 1,
            "fechaPedido": "2026-06-10T16:16:30.105405",
            "total": 225,
            "estadoPedido": "GENERADO",
            "estado": 1,
            "detalles": [
                {
                    "idDetalle": 2,
                    "idProducto": 1,
                    "nombreProducto": "Taco Gobernador",
                    "cantidad": 2,
                    "precioUnitario": 95,
                    "subtotal": 190
                },
                {
                    "idDetalle": 3,
                    "idProducto": 2,
                    "nombreProducto": "Agua de Horchata",
                    "cantidad": 1,
                    "precioUnitario": 35,
                    "subtotal": 35
                }
            ]
        }
    ]
}
```