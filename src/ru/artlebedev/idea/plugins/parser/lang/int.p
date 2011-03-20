
@CLASS
int

#	Преобразование значения переменной к целому числу
#
#	Метод преобразует значение переменной к целому числу и возвращает это число.
#	Необязательная опция default указывает число, которое будет получено в случае, если проебразование невозможно или строка состоит из пробелов, символов табуляции или перевода стороки. Значение пустой строки считается нулём. Преобразование строки, не являющейся целым числом к целому числу, считается ошибкой, например значение "1.5" - не является целым числом.
#:	parameter default type int optional
@int[default]
$result(1)
###

#	Преобразование значения переменной к вещественному числу
#
#	Метод преобразует значение переменной к вещественному числу и возвращает это число.
#	Необязательная опция default указывает число, которое будет получено в случае, если проебразование невозможно или строка состоит из пробелов, символов табуляции или перевода стороки.
#:	parameter default type double optional
@double[default]
$result(1)
###

#	Увеличение значения переменной
#
#	Метод увеличивает значение переменной на 1 или заданное число.
#:	parameter number type int optional
@inc[number]
$result(1)
###

#	Уменьшение значения переменной
#
#	Метод уменьшает значение переменной на 1 или заданное число.
#:	parameter number type int optional
@dec[number]
$result(1)
###

#	Умножение значения переменной
#
#	Метод умножает значение переменной на заданное число.
#:	parameter number type int
@mul[number]
$result(1)
###

#	Деление значения переменной
#
#	Метод делит значение переменной на заданное число.
#:	parameter number type int
@div[number]
$result(1)
###

#	Остаток от деления
#
#	Метод возвращает остаток от деления значения переменной на заданное число.
#:	parameter number type int
@mod[number]
$result(1)
###

#	Вывод числа в заданном формате
#
#	Метод выводит значение переменной в заданном формате, при этом выполняется автоматическое преобразование строки к числу. В общем случае форматная строка имеет вид %Длина.ТочностьТип
#	Существуют следующие типы:
#	d - десятичное целое число со знаком
#	u - десятичное целое число без знака
#	o - восьмеричное целое число без знака
#	x - шестнадцатиричное целое число без знака; для вывода цифр, больших 9, используются буквы a, b, c, d, e, f
#	X - шестнадцатиричное целое число без знака; для вывода цифр, больших 9, используются буквы A, B, C, D, E, F
#	f - действительное число
#:	parameter options type string
@format[options]
$result(1)
###