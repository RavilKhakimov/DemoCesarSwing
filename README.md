DemoCesarSwing

Шифр Цезаря.

Это один из самых простых и известных методов шифрования. Назвали его, само собой, в честь императора Гая Юлия Цезаря, который применял его для секретной переписки с генералами.

Шифр Цезаря — это шифр подстановки: в нем каждый символ в открытом тексте заменяется на символ, который находится на некотором постоянном числе позиций левее или правее него в алфавите.

Допустим, мы устанавливаем сдвиг на 3 (ключ = 3). В таком случае А заменится на Г, Б станет Д, и так далее.


Программа, позволяющая шифровать и расшифровывать текст с использованием шифра Цезаря.

Режимы работы:

Шифрование текста:

Функция шифрования, принимающая файл, ключ и записывающая зашифрованный текст в новый файл.

Расшифровка текста:

Функция расшифровки с использованием известного ключа.

Расшифровка методом brute force:

Функция расшифровки методом brute force для перебора всех ключей до успешного расшифрования. Принимает оригинальный текст и зашифрованный, возвращает ключ шифра.

Расшифровка методом статистического анализа:

Метод статистического анализа для автоматической расшифровки без ключа, принимает зашифрованный текс, возвращает ключ шифра.

Ограничения:

Программа использует алфавит а-я, А-Я и знаки пунктуации ('.', ',', '«', '»', '"', ''', ':', ';', '-', '!', '?', ' ').

Ключ может быть только положительным целым числом, не больше размера алфавита.

Программа с графическим пользовательским интерфейсом (GUI) на основе Swing.

В разных режимах необходимо вводить путь к файлу и ключ шифра. При не верном вводе программа выдаст сообщение об ошибке.

Возможности улучшения:
1. Добавить возможность использования других алфавитов и языков.
2. Добавить в GUI больше информации для пользователя (какие есть ограничения, возможности и т.д.)