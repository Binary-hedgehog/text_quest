``` json
//location
{
    "locations": [
    { 
        "name": "town",
        "events": ["first", "sceond"]
    }  
    ]
}
```
``` json
//event  тут на самом деле еще "events": {[ ... ]}
{
    "name": "Обвинение в воровстве",
    "description": "Бла-бла вас обвинили в воровстве",
    "requirement": {
        "reputation": {
            "value": -2,
            "comparison": "less"
        },
        "title": "Thief"
    },
    "chosen": [
        {
            "name": "Отрицать",
            "requirement": {
                "reputation": {
                "value": -4,
                "comparison": "more"    
                }
            },
            "exam": {
                "charisma": 5
            },         
            "success": {
                "reputation": 2
            },
            "failure": {
                "reputation": -1,
                "gold": -10
            }

        },
        {
            "name": "Заплатить",
            "requirement": {
                "gold": 10
            },
            "success": {
                "reputation": 2,
                "gold": -10
            },
            "failure": {}
        },       
        {
            "name": "Убежать",
            "exam": {
                "dexterity": 3
            },
            "success": {
                "reputation": -1
            },
            "failure": {
                "reputation": -2,
                "gold": -10,
                "hp": -2
            }
        }
    ]
}
```