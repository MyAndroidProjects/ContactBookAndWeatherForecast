# Contact Book And Weather Forecast
Приложение, в котором можно посмотреть прогноз погоды и поработать с контактами.
Контакты:
При первом запуске генерируется база данных контактов со случайными значениями. Можно добавить, редактировать, удалить контакт, а также позвонить на указанный сотовый номер (программно задано, что при попытке набрать номер, кроме одного - тестовый контакт по фамилии Last name с моим номером не получится, надо менять номер с которым будет сравнение).
Контакты отсортированы по первой букве фамилии (если нет фамилии - то кнопка "пробел" "__".

Прогноз погоды запрашивается с сайта meteoservise.ru, и составляет прогноз в Новосибирске на ближайшие сутки. 

Что есть в проекте:
Рабочие данные в res/values/integers, ../strings, ../styles
fragment, dialog fragment
menu в toolbar, который заменяет actionbar
seekbar
recyclerview, listview
cell-animation (заставка на фрагменте - ссылке на погоду)
AnimatorSet (objectAnimator) - анимация свойства масштаб, при нажатии на букву алфавита
layout activity для горизонтального и вертикального отображения, сохранение данных при повороте экрана
Запуск задачи в фоновом потоке.
Работа с базой данных SQLite
Работа с xml
