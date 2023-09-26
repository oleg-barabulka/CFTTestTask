# CFTTestTask
Тестовое задание - программа для сортировки слиянием нескольких файлов

# Запуск
Необходимо: 
- Java version: 17.0.4.1
- Apache Maven 3.8.6
- Команда для запуска: mvn compile exec:java -Dexec.mainClass="ru.ctf.shiftLab.cherkasov.backend.BackEndApplication"

# Входные данные
Формат входных данных: 
- digits: [[число, число], ... , [число, число]], числа - int
- letters: [["буква", "буква"], ... , ["буква","буква"]], буква - английский буква в кодировке кодировке utf-8

# Примечания
- если начало интервала превышает его конец, такой интервал считается ошибочным и пропускается.
- если в базе лежат несколько вложенных минимальных относительно остальных интервалов, то GET выдаст самый внутренний.
