# ReporteController

## Listar los más vendidos
- URL: localhost:8082/api/reportes/top-vendidos
- Método: GET
- Request:

- Response: 
```json
{
    "success": true,
    "mensaje": "Consulta exitosa",
    "data": [
        {
            "nombreProducto": "Taco Gobernador",
            "totalVendido": 2
        },
        {
            "nombreProducto": "Agua de Horchata",
            "totalVendido": 1
        }
    ]
}
```