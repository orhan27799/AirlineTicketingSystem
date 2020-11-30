# AirlineTicketingSystem

Havaalanı Ekleme

http://localhost:8080/airlineticketsystem/airport/add (POST)

  Request ->  {
  "iataCode": "ih",
  "name": "İstanbul Hava Havaalanı",
  "countryIsoCode": "TR"
}
Response -> success

  Request ->  {
  "iataCode": "sgh",
  "name": "Sabiha Gökçen Hava Havaalanı",
  "countryIsoCode":"TR"
  
}

response->success
-------------------------------------------------------------------------

Havaalanı Ada Göre Arama 
http://localhost:8080/airlineticketsystem/airport/search?name=Sabiha (GET)

Response ->
[
  {
    "id": 1,
    "iataCode": "sgh",
    "name": "Sabiha Gökçen Hava Havaalanı",
    "countryIsoCode": "TR"
  }
]

----------------------------------------------------------

Havayolu Şirketi Ekleme
http://localhost:8080/airlineticketsystem/airline/add (POST)
 Request -> {
  "owner": "Orhan",
  "name": "Türk Hava Yolları",

  "airports" : [
    {
        "id" : 1
        
    }
]
}

response :success


-----------------------------------------------------------

Havayolu şirketi ada göre Arama  
 
http://localhost:8080/airlineticketsystem/airline/search?name=Türk Hava Yolları (GET))

Response->
[
  {
    "id": 3,
    "name": "Türk Hava Yolları",
    "owner": "Orhan",
    "airports": [
      {
        "id": 1,
        "iataCode": "sgh",
        "name": "Sabiha Gökçen Hava Havaalanı",
        "countryIsoCode": "TR"
      }
    ]
  }
]


---------------------------------------------------------------------------



Rota Ekleme

http://localhost:8080/airlineticketsystem/route/add (POST)


Request- > {
  "name": "Rota1",
  "airline": {
    "id": 3
  },
  "departureAirport": {
    "id": 1
  },
  "destinationAirport": {
    "id": 2
  }
}
Response :success

Request- >  {
  "name": "Rota2",
  "airline": {
    "id": 3
  },
  "departureAirport": {
    "id": 1
  },
  "destinationAirport": {
    "id": 2
  }
}

response:success
-------------------------------------------------------------------
Rota Arama ada göre arama
http://localhost:8080/airlineticketsystem/route/search?name=Rota (GET)

Response -> [
  {
    "id": 5,
    "name": "Rota1",
    "airline": {
      "id": 3,
      "name": "Türk Hava Yolları",
      "owner": "Orhan",
      "airports": [
        {
          "id": 1,
          "iataCode": "sgh",
          "name": "Sabiha Gökçen Hava Havaalanı",
          "countryIsoCode": "TR"
        }
      ]
    },
    "departureAirport": {
      "id": 1,
      "iataCode": "sgh",
      "name": "Sabiha Gökçen Hava Havaalanı",
      "countryIsoCode": "TR"
    },
    "destinationAirport": {
      "id": 2,
      "iataCode": "ih",
      "name": "İstanbul Hava Havaalanı",
      "countryIsoCode": "TR"
    }
  },
  {
    "id": 6,
    "name": "Rota2",
    "airline": {
      "id": 3,
      "name": "Türk Hava Yolları",
      "owner": "Orhan",
      "airports": [
        {
          "id": 1,
          "iataCode": "sgh",
          "name": "Sabiha Gökçen Hava Havaalanı",
          "countryIsoCode": "TR"
        }
      ]
    },
    "departureAirport": {
      "id": 1,
      "iataCode": "sgh",
      "name": "Sabiha Gökçen Hava Havaalanı",
      "countryIsoCode": "TR"
    },
    "destinationAirport": {
      "id": 2,
      "iataCode": "ih",
      "name": "İstanbul Hava Havaalanı",
      "countryIsoCode": "TR"
    }
  }
]

---------------------------------------------------------------
Uçuş Ekleme

http://localhost:8080/airlineticketsystem/flight/add (post)

Request- > {
  "name": "flight1",
  "capacity": 60,
  "price": 10,
  "flightNumber": "AXFSDA",
  "departureDate": "2020-06-05",
  "arrivalDate": "2020-06-07",
  "departureTime": "2020-06-07",
  "airline": {
    "id": 3
  },
  "route": {
    "id": 5
  }
}

response :success

--------------------------------------------------------------------
Uçuş arama ada göre
http://localhost:8080/airlineticketsystem/flight/search?name=flight1 (GET)

Response- > [
  {
    "id": 7,
    "name": "flight1",
    "capacity": 60,
    "price": 10,
    "flightNumber": "AXFSDA",
    "departureDate": "2020-06-05",
    "arrivalDate": "2020-06-07",
    "departureTime": "2020-06-07",
    "airline": {
      "id": 3,
      "name": "Türk Hava Yolları",
      "owner": "Orhan",
      "airports": [
        {
          "id": 1,
          "iataCode": "sgh",
          "name": "Sabiha Gökçen Hava Havaalanı",
          "countryIsoCode": "TR"
        }
      ]
    },
    "route": {
      "id": 5,
      "name": "Rota1",
      "airline": {
        "id": 3,
        "name": "Türk Hava Yolları",
        "owner": "Orhan",
        "airports": [
          {
            "id": 1,
            "iataCode": "sgh",
            "name": "Sabiha Gökçen Hava Havaalanı",
            "countryIsoCode": "TR"
          }
        ]
      },
      "departureAirport": {
        "id": 1,
        "iataCode": "sgh",
        "name": "Sabiha Gökçen Hava Havaalanı",
        "countryIsoCode": "TR"
      },
      "destinationAirport": {
        "id": 2,
        "iataCode": "ih",
        "name": "İstanbul Hava Havaalanı",
        "countryIsoCode": "TR"
      }
    }
  }
]
------------------------------------------------------------------
Mevcut uçuşların biletlerini getirir ve  Uçuş kontenjanın her %10 artışında, bilet fiyatı da %10 artırılır

http://localhost:8080/airlineticketsystem/ticket/available(get)

Response -> [
  {
    "id": null,
    "price": 10,
    "number": 71573,
    "creditCardNumber": null,
    "bankName": null,
    "fullName": null,
    "expirationMonth": null,
    "expirationYear": null,
    "flight": {
      "id": 7,
      "name": "flight1",
      "capacity": 60,
      "price": 10,
      "flightNumber": "AXFSDA",
      "departureDate": "2020-06-05",
      "arrivalDate": "2020-06-07",
      "departureTime": "2020-06-07",
      "airline": {
        "id": 3,
        "name": "Türk Hava Yolları",
        "owner": "Orhan",
        "airports": [
          {
            "id": 1,
            "iataCode": "sgh",
            "name": "Sabiha Gökçen Hava Havaalanı",
            "countryIsoCode": "TR"
          }
        ]
      },
      "route": {
        "id": 5,
        "name": "Rota1",
        "airline": {
          "id": 3,
          "name": "Türk Hava Yolları",
          "owner": "Orhan",
          "airports": [
            {
              "id": 1,
              "iataCode": "sgh",
              "name": "Sabiha Gökçen Hava Havaalanı",
              "countryIsoCode": "TR"
            }
          ]
        },
        "departureAirport": {
          "id": 1,
          "iataCode": "sgh",
          "name": "Sabiha Gökçen Hava Havaalanı",
          "countryIsoCode": "TR"
        },
        "destinationAirport": {
          "id": 2,
          "iataCode": "ih",
          "name": "İstanbul Hava Havaalanı",
          "countryIsoCode": "TR"
        }
      }
    }
  },
  {
    "id": null,
    "price": 20,
    "number": 34611,
    "creditCardNumber": null,
    "bankName": null,
    "fullName": null,
    "expirationMonth": null,
    "expirationYear": null,
    "flight": {
      "id": 8,
      "name": "flight2",
      "capacity": 50,
      "price": 20,
      "flightNumber": "AXFSDA",
      "departureDate": "2020-06-05",
      "arrivalDate": "2020-06-07",
      "departureTime": "2020-06-07",
      "airline": {
        "id": 3,
        "name": "Türk Hava Yolları",
        "owner": "Orhan",
        "airports": [
          {
            "id": 1,
            "iataCode": "sgh",
            "name": "Sabiha Gökçen Hava Havaalanı",
            "countryIsoCode": "TR"
          }
        ]
      },
      "route": {
        "id": 5,
        "name": "Rota1",
        "airline": {
          "id": 3,
          "name": "Türk Hava Yolları",
          "owner": "Orhan",
          "airports": [
            {
              "id": 1,
              "iataCode": "sgh",
              "name": "Sabiha Gökçen Hava Havaalanı",
              "countryIsoCode": "TR"
            }
          ]
        },
        "departureAirport": {
          "id": 1,
          "iataCode": "sgh",
          "name": "Sabiha Gökçen Hava Havaalanı",
          "countryIsoCode": "TR"
        },
        "destinationAirport": {
          "id": 2,
          "iataCode": "ih",
          "name": "İstanbul Hava Havaalanı",
          "countryIsoCode": "TR"
        }
      }
    }
  },
  {
    "id": null,
    "price": 10,
    "number": 79557,
    "creditCardNumber": null,
    "bankName": null,
    "fullName": null,
    "expirationMonth": null,
    "expirationYear": null,
    "flight": {
      "id": 9,
      "name": "flight3",
      "capacity": 40,
      "price": 10,
      "flightNumber": "AXFSDA",
      "departureDate": "2020-06-05",
      "arrivalDate": "2020-06-07",
      "departureTime": "2020-06-07",
      "airline": {
        "id": 3,
        "name": "Türk Hava Yolları",
        "owner": "Orhan",
        "airports": [
          {
            "id": 1,
            "iataCode": "sgh",
            "name": "Sabiha Gökçen Hava Havaalanı",
            "countryIsoCode": "TR"
          }
        ]
      },
      "route": {
        "id": 5,
        "name": "Rota1",
        "airline": {
          "id": 3,
          "name": "Türk Hava Yolları",
          "owner": "Orhan",
          "airports": [
            {
              "id": 1,
              "iataCode": "sgh",
              "name": "Sabiha Gökçen Hava Havaalanı",
              "countryIsoCode": "TR"
            }
          ]
        },
        "departureAirport": {
          "id": 1,
          "iataCode": "sgh",
          "name": "Sabiha Gökçen Hava Havaalanı",
          "countryIsoCode": "TR"
        },
        "destinationAirport": {
          "id": 2,
          "iataCode": "ih",
          "name": "İstanbul Hava Havaalanı",
          "countryIsoCode": "TR"
        }
      }
    }
  },
  {
    "id": null,
    "price": 10,
    "number": 97390,
    "creditCardNumber": null,
    "bankName": null,
    "fullName": null,
    "expirationMonth": null,
    "expirationYear": null,
    "flight": {
      "id": 10,
      "name": "flight4",
      "capacity": 40,
      "price": 10,
      "flightNumber": "AXFSDA",
      "departureDate": "2020-06-05",
      "arrivalDate": "2020-06-07",
      "departureTime": "2020-06-07",
      "airline": {
        "id": 3,
        "name": "Türk Hava Yolları",
        "owner": "Orhan",
        "airports": [
          {
            "id": 1,
            "iataCode": "sgh",
            "name": "Sabiha Gökçen Hava Havaalanı",
            "countryIsoCode": "TR"
          }
        ]
      },
      "route": {
        "id": 5,
        "name": "Rota1",
        "airline": {
          "id": 3,
          "name": "Türk Hava Yolları",
          "owner": "Orhan",
          "airports": [
            {
              "id": 1,
              "iataCode": "sgh",
              "name": "Sabiha Gökçen Hava Havaalanı",
              "countryIsoCode": "TR"
            }
          ]
        },
        "departureAirport": {
          "id": 1,
          "iataCode": "sgh",
          "name": "Sabiha Gökçen Hava Havaalanı",
          "countryIsoCode": "TR"
        },
        "destinationAirport": {
          "id": 2,
          "iataCode": "ih",
          "name": "İstanbul Hava Havaalanı",
          "countryIsoCode": "TR"
        }
      }
    }
  },
  {
    "id": null,
    "price": 10,
    "number": 55947,
    "creditCardNumber": null,
    "bankName": null,
    "fullName": null,
    "expirationMonth": null,
    "expirationYear": null,
    "flight": {
      "id": 11,
      "name": "flight5",
      "capacity": 40,
      "price": 10,
      "flightNumber": "ACFDFGSS",
      "departureDate": "2020-06-05",
      "arrivalDate": "2020-06-07",
      "departureTime": "2020-06-07",
      "airline": {
        "id": 3,
        "name": "Türk Hava Yolları",
        "owner": "Orhan",
        "airports": [
          {
            "id": 1,
            "iataCode": "sgh",
            "name": "Sabiha Gökçen Hava Havaalanı",
            "countryIsoCode": "TR"
          }
        ]
      },
      "route": {
        "id": 5,
        "name": "Rota1",
        "airline": {
          "id": 3,
          "name": "Türk Hava Yolları",
          "owner": "Orhan",
          "airports": [
            {
              "id": 1,
              "iataCode": "sgh",
              "name": "Sabiha Gökçen Hava Havaalanı",
              "countryIsoCode": "TR"
            }
          ]
        },
        "departureAirport": {
          "id": 1,
          "iataCode": "sgh",
          "name": "Sabiha Gökçen Hava Havaalanı",
          "countryIsoCode": "TR"
        },
        "destinationAirport": {
          "id": 2,
          "iataCode": "ih",
          "name": "İstanbul Hava Havaalanı",
          "countryIsoCode": "TR"
        }
      }
    }
  }
]
--------------------------------------------------
Bilet Alma
http://localhost:8080/airlineticketsystem/ticket/add(POST)

Request -> {
  "price": 10,
  "number": 12288,
  "creditCardNumber": "4221161122330005",
  "bankName": "Garanti Bankası",
  "fullName": "Orhan Arslan",
  "expirationMonth": "06",
  "expirationYear": "2021",
  "flight": {
    "id": 7,
    "name": "flight1",
    "capacity": 60,
    "price": 10,
    "flightNumber": "AXFSDA",
    "departureDate": "2020-06-05",
    "arrivalDate": "2020-06-07",
    "departureTime": "2020-06-07"
  }
}

Response :success


Request-> {
  "price": 10,
  "number": 47496,
  "creditCardNumber": "4221-1611-2233-0005",
  "bankName": "Halkbank Bankası",
  "fullName": "Orhan Arslan",
  "expirationMonth": "06",
  "expirationYear": "2021",
  "flight": {
    "id": 9,
    "name": "flight3",
    "capacity": 60,
    "price": 10,
    "flightNumber": "AXFSDA",
    "departureDate": "2020-06-05",
    "arrivalDate": "2020-06-07",
    "departureTime": "2020-06-07"
  }
}
Response :success
-----------------------------------------------------------------------
Alınan Bilet Listesi

http://localhost:8080/airlineticketsystem/ticket/list(GET)
Response -> [
  {
    "id": 12,
    "price": 10,
    "number": 12288,
    "creditCardNumber": "4221********0005",
    "bankName": "Garanti Bankası",
    "fullName": "Orhan Arslan",
    "expirationMonth": "06",
    "expirationYear": "2021",
    "flight": {
      "id": 7,
      "name": "flight1",
      "capacity": 60,
      "price": 10,
      "flightNumber": "AXFSDA",
      "departureDate": "2020-06-05",
      "arrivalDate": "2020-06-07",
      "departureTime": "2020-06-07",
      "airline": {
        "id": 3,
        "name": "Türk Hava Yolları",
        "owner": "Orhan",
        "airports": [
          {
            "id": 1,
            "iataCode": "sgh",
            "name": "Sabiha Gökçen Hava Havaalanı",
            "countryIsoCode": "TR"
          }
        ]
      },
      "route": {
        "id": 5,
        "name": "Rota1",
        "airline": {
          "id": 3,
          "name": "Türk Hava Yolları",
          "owner": "Orhan",
          "airports": [
            {
              "id": 1,
              "iataCode": "sgh",
              "name": "Sabiha Gökçen Hava Havaalanı",
              "countryIsoCode": "TR"
            }
          ]
        },
        "departureAirport": {
          "id": 1,
          "iataCode": "sgh",
          "name": "Sabiha Gökçen Hava Havaalanı",
          "countryIsoCode": "TR"
        },
        "destinationAirport": {
          "id": 2,
          "iataCode": "ih",
          "name": "İstanbul Hava Havaalanı",
          "countryIsoCode": "TR"
        }
      }
    }
  },
  {
    "id": 13,
    "price": 10,
    "number": 47496,
    "creditCardNumber": "4221***********0005",
    "bankName": "Halkbank Bankası",
    "fullName": "Orhan Arslan",
    "expirationMonth": "06",
    "expirationYear": "2021",
    "flight": {
      "id": 9,
      "name": "flight3",
      "capacity": 40,
      "price": 10,
      "flightNumber": "AXFSDA",
      "departureDate": "2020-06-05",
      "arrivalDate": "2020-06-07",
      "departureTime": "2020-06-07",
      "airline": {
        "id": 3,
        "name": "Türk Hava Yolları",
        "owner": "Orhan",
        "airports": [
          {
            "id": 1,
            "iataCode": "sgh",
            "name": "Sabiha Gökçen Hava Havaalanı",
            "countryIsoCode": "TR"
          }
        ]
      },
      "route": {
        "id": 5,
        "name": "Rota1",
        "airline": {
          "id": 3,
          "name": "Türk Hava Yolları",
          "owner": "Orhan",
          "airports": [
            {
              "id": 1,
              "iataCode": "sgh",
              "name": "Sabiha Gökçen Hava Havaalanı",
              "countryIsoCode": "TR"
            }
          ]
        },
        "departureAirport": {
          "id": 1,
          "iataCode": "sgh",
          "name": "Sabiha Gökçen Hava Havaalanı",
          "countryIsoCode": "TR"
        },
        "destinationAirport": {
          "id": 2,
          "iataCode": "ih",
          "name": "İstanbul Hava Havaalanı",
          "countryIsoCode": "TR"
        }
      }
    }
  }
]


-------------------------------------------------------------------

Bilet numarasına arama 
 http://localhost:8080/airlineticketsystem/ticket/search?number=47496 (GET)

Response -> 
[
  {
    "id": 13,
    "price": 10,
    "number": 47496,
    "creditCardNumber": "4221***********0005",
    "bankName": "Halkbank Bankası",
    "fullName": "Orhan Arslan",
    "expirationMonth": "06",
    "expirationYear": "2021",
    "flight": {
      "id": 9,
      "name": "flight3",
      "capacity": 40,
      "price": 10,
      "flightNumber": "AXFSDA",
      "departureDate": "2020-06-05",
      "arrivalDate": "2020-06-07",
      "departureTime": "2020-06-07",
      "airline": {
        "id": 3,
        "name": "Türk Hava Yolları",
        "owner": "Orhan",
        "airports": [
          {
            "id": 1,
            "iataCode": "sgh",
            "name": "Sabiha Gökçen Hava Havaalanı",
            "countryIsoCode": "TR"
          }
        ]
      },
      "route": {
        "id": 5,
        "name": "Rota1",
        "airline": {
          "id": 3,
          "name": "Türk Hava Yolları",
          "owner": "Orhan",
          "airports": [
            {
              "id": 1,
              "iataCode": "sgh",
              "name": "Sabiha Gökçen Hava Havaalanı",
              "countryIsoCode": "TR"
            }
          ]
        },
        "departureAirport": {
          "id": 1,
          "iataCode": "sgh",
          "name": "Sabiha Gökçen Hava Havaalanı",
          "countryIsoCode": "TR"
        },
        "destinationAirport": {
          "id": 2,
          "iataCode": "ih",
          "name": "İstanbul Hava Havaalanı",
          "countryIsoCode": "TR"
        }
      }
    }
  }
]

---------------------------------------------------------------
Bilet iptal etme
http://localhost:8080/airlineticketsystem/ticket/cancel?ticketId=13
Response ->
response : ticket canceled
