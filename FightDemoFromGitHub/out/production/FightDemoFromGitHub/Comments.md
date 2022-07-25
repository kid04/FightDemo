1. Методы ability, ai, name, speed модифицированы и перенесены в класс Fighter
2. Тело метода fight перенесено внутрь метода main
3. Очень похоже на сортировку, поэтому исключено из текста программы в связи с использованием TreeSet в классе Team:
    ```java
    for(int i = 0; i < 7; i++)
            for(int j = 0; j < 6; j++)
                if(speed(acthero[j][0]) < speed(acthero[j+1][0])) {
                    int[] t = acthero[j];
                    acthero[j] = acthero[j+1];
                    acthero[j+1] = t;
                }
    ```