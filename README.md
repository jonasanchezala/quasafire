# Quasarfire

El ejercicio se desarrollo en Spring Boot y se utilizo la libreria [lemmingapex](https://github.com/lemmingapex/trilateration) para el calculo de la triangulacion.

La aplicacion ha sido desplegada en Heroku con la siguiente ruta https://limitless-cove-99086.herokuapp.com/health y expone los siguientes servicios rest.

Servicio TopSecret.

```bash
Enpoint: https://limitless-cove-99086.herokuapp.com/api/topsecret 
HTTP Method: POST
Body: 
{
  "satellites": [
    {
      "name": "kenobi",
      "distance": 100,
      "message": [
        "este",
        "",
        "",
        "mensaje",
        ""
      ]
    },
    {
      "name": "skywalker",
      "distance": 115.5,
      "message": [
        "",
        "es",
        "",
        "",
        "secreto"
      ]
    },
    {
      "name": "sato",
      "distance": 142.7,
      "message": [
        "este",
        "",
        "un",
        "",
        ""
      ]
    }
  ]
}
Response:
Status Code: 200
{
    "position": {
        "x": -58.315252587138595,
        "y": -69.55141837312165
    },
    "message": "este es un mensaje secreto"
}
```

Servicio POST topsecret_split.

```bash
Enpoint: https://limitless-cove-99086.herokuapp.com/api/topsecret_split/skywalker
HTTP Method: POST
Body: //Tiene un atributo que es una lista de enteros que seran los nodos del arbol, y los dos valores de los nodos 
{
      "distance": 142.7,
      "message": [
        "este",
        "",
        "un",
        "",
        ""
      ]
}
Response: 
Status Code:201 CREATED
```

Servicio GET topsecret_split.

```bash
Enpoint: https://limitless-cove-99086.herokuapp.com/api/topsecret_split
HTTP Method: GET
Response:
Status Code: 200
{
    "position": {
        "x": -58.315252587138595,
        "y": -69.55141837312165
    },
    "message": "este es un mensaje secreto"
}
```

Servicio DELETE topsecret_split. (Este servicio se agrego para reiniciar el servicio de topsecret_split y de esta forma se pueda seguir enviando mensajes )

```bash
Enpoint: https://limitless-cove-99086.herokuapp.com/api/topsecret_split
HTTP Method: DELETE
Body:
Response:
Status Code: 200
```