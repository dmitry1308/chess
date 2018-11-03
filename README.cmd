Задача:

Дано:
Прямоугольное поле произвольного размера. Поле состоит из клеток (как в шахматах).
На поле есть дыры (препятствия).
Есть набор фигур. Каждая фигура может ходить по определенному правилу.

Необходимый набор фигур - шахматные фигуры:
	Пешка (ходит по горизонтали и вертикали на одну клетку в любую сторону)
	Ладья
	Конь
	Слон
	Ферзь
	Король

Из фигур перечисленных выше только Конь может перепрыгивать дыры.

На поле в некоторую клетку (старт) выставляется одна фигура. Задается клетка финиш.
Цель задачи - сказать, существуют ли пути от старта до финиша и если существуют, то вернуть путь с минимальным числом ходов.

Каждая отдельная задача (поле, дыры, фигура, старт и финиш) описывается отдельным текстовым файлом (тестовые примеры прилагаются).

Требуется написать консольную программу, которая получает на вход путь до файла задачи, решает задачу и печатает ответ.

Следует учитывать, что задача может усложняться в будущем. Например появляются новые фигуры, меняются препятствия, ...
