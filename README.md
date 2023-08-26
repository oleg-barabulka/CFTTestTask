# CFTTestTask
Тестовое задание - программа для сортировки слиянием нескольких файлов

# Параметры программы
1) Режим сортровки
- -a для сортировки по возрастанию
- -d для сортировки по убыванию
2) Тип данных
- -i для целых чисел
- -s для строк
3) Имя выходного файла
4) Имена входных файлов(не мение одного)

# Запуск
Необходимо 
- Java 17
- Apache Maven 3.8.6
- 
    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.26</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>
- Команда для запуска: mvn compile exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="Параметры запуска"
# Примечания
Ошибочные данные пропускаются, числа не влезающие в int считаются ошибочными и также пропускаются.
