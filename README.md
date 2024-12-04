``` json
//location
{
    "locations": [
    { 
        "name": "town",
        "events": [
            {}
        ]
    }  
    ]
}
```
``` json
//event
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
            "result": {
                "success": {
                    "reputation": 2
                },
                "unsuccess": {
                    "reputation": -1,
                    "gold": -10
                }
            }
        },
        {
            "name": "Заплатить",
            "requirement": {
                "gold": 10
            },
            "result": {
                "success": {
                    "reputation": 2,
                    "gold": -10
                },
                "unsuccess": {}
                }
            },
        {
            "name": "Убежать",
            "exam": {
                "dexterity": 3
            },
            "result": {
                "success": {
                    "reputation": -1
                },
                "unsuccess": {
                    "reputation": -2,
                    "gold": -10,
                    "hp": -2
                }
            }
        }
    ]
}
```