# Satander Dev Week 

## Diagrama de Classes


```mermaid
classDiagram
    class Usuario {
        +String nome
        +Account conta
        +List~Feature~ servicos
        +Card cartao
        +List~News~ noticias
    }

    class Conta {
        +String numero
        +String agencia
        +Float balance
        +Float limit
    }

    class Servicos {
        +String icone
        +String descricao
    }

    class Cartao {
        +String icone
        +Float limite
    }

    class Noticias {
        +String icone
        +String descricao
    }

    Usuario --> Conta
    Usuario --> servicos
    Usuario --> Cartao
    Usuario --> Noticias
```